/*
 * ***********************************************************************
 * Angular App CONFIDENTIAL
 * ___________________
 *
 * Copyright 2022 Angular App.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains the property
 * of Angular App and its suppliers, if any. The intellectual and
 * technical concepts contained herein are proprietary to Angular App
 * and its suppliers and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Angular App.
 * ***********************************************************************
 */

package com.angularapp.core.models.impl;

import com.adobe.acs.commons.models.injectors.annotation.ChildResourceFromRequest;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.Image;
import com.angularapp.core.models.MultifieldImageModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
    MultifieldImageModel.class,
    ComponentExporter.class
})
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class MultifieldImageModelImpl
    implements MultifieldImageModel
{

    @ChildResourceFromRequest(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Image myImageSrc;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String myImageAlt;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String myClass;
    @SlingObject
    private Resource resource;

    @Override
    @JsonProperty("myImageSrc")
    public Image getMyImageSrc() {
        return myImageSrc;
    }

    @Override
    @JsonProperty("myImageAlt")
    public String getMyImageAlt() {
        return myImageAlt;
    }

    @Override
    @JsonProperty("myClass")
    public String getMyClass() {
        return myClass;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
