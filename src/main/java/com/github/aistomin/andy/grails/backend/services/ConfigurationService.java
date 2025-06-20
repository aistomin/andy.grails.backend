/*
 * Copyright (c) 2025 Andrej Istomin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.aistomin.andy.grails.backend.services;

import com.github.aistomin.andy.grails.backend.controllers.configuration.SocialMediaLinkDto;
import java.util.List;

/**
 * Configuration's service.
 *
 * @since 0.3
 */
public interface ConfigurationService {

    /**
     * Find all the existing social media links.
     *
     * @return Social media links.
     */
    List<SocialMediaLinkDto> findAllSocialMediaLinks();

    /**
     * Save social media link.
     *
     * @param link Social media link that needs to be saved.
     * @return Saved social media link.
     */
    SocialMediaLinkDto saveSocialMediaLink(SocialMediaLinkDto link);
}
