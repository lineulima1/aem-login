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

package com.angularapp.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.wcm.core.components.models.Image;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.osgi.annotation.versioning.ConsumerType;


/**
 * Defines the {@code MultifieldInputModel} Sling Model used for the multifield in {@code angularapp/components/login-component} component.
 * 
 */
@ConsumerType
public interface MultifieldInputModel
    extends ComponentExporter
{


    @JsonProperty("placeholder")
    String getPlaceholder();

    @JsonProperty("type")
    String getType();

    @JsonProperty("name")
    String getName();

    @JsonProperty("imageSrc")
    Image getImageSrc();

    @JsonProperty("imageAlt")
    String getImageAlt();

}
