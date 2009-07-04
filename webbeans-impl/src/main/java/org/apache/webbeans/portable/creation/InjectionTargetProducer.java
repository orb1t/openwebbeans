/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.apache.webbeans.portable.creation;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.InjectionTarget;

import org.apache.webbeans.component.AbstractInjectionTargetBean;
import org.apache.webbeans.component.InjectionTargetBean;

/**
 * InjectionTargetProducer implementation.
 * 
 * @version $Rev$ $Date$
 *
 * @param <T> bean type info
 */
public class InjectionTargetProducer<T> extends AbstractProducer<T> implements InjectionTarget<T>
{
    public InjectionTargetProducer(AbstractInjectionTargetBean<T> bean)
    {
        super(bean);
    }
    
    @Override
    public void inject(T instance, CreationalContext<T> ctx)
    {
        @SuppressWarnings("unchecked")
        InjectionTargetBean<T> bean = getBean(InjectionTargetBean.class);
        
        bean.injectResources(instance, ctx);
        bean.injectFields(instance, ctx);
        bean.injectMethods(instance, ctx);
    }

    @Override
    public void postConstruct(T instance)
    {
        @SuppressWarnings("unchecked")
        InjectionTargetBean<T> bean = getBean(InjectionTargetBean.class);
        
        bean.postConstruct(instance);
    }

    @Override
    public void preDestroy(T instance)
    {
        @SuppressWarnings("unchecked")
        InjectionTargetBean<T> bean = getBean(InjectionTargetBean.class);
        
        bean.preDestroy(instance);
    }

}