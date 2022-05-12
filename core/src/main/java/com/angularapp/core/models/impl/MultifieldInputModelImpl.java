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
import com.angularapp.core.models.MultifieldInputModel;
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
    MultifieldInputModel.class,
    ComponentExporter.class
})
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class MultifieldInputModelImpl
    implements MultifieldInputModel
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String placeholder;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String type;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String name;
    @ChildResourceFromRequest(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Image imageSrc;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String imageAlt;
    @SlingObject
    private Resource resource;

    @Override
    @JsonProperty("placeholder")
    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @Override
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @Override
    @JsonProperty("imageSrc")
    public Image getImageSrc() {
        return imageSrc;
    }

    @Override
    @JsonProperty("imageAlt")
    public String getImageAlt() {
        return imageAlt;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
