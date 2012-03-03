/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.webbeans.decorator.xml;

import org.apache.webbeans.component.AbstractInjectionTargetBean;
import org.apache.webbeans.decorator.WebBeansDecorator;
import org.apache.webbeans.inject.xml.XMLInjectionPointModel;

public class WebBeansXMLDecorator<T> extends WebBeansDecorator<T>
{
    private XMLInjectionPointModel decoratesModel = null;

    public WebBeansXMLDecorator(AbstractInjectionTargetBean<T> delegateComponent, XMLInjectionPointModel model)
    {
        super(delegateComponent);
        this.decoratesModel = model;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initDelegate()
    {
        this.delegateType = decoratesModel.getInjectionClassType();
        this.delegateBindings = decoratesModel.getBindingTypes();
    }

}