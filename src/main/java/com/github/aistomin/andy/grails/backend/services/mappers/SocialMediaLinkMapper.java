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
package com.github.aistomin.andy.grails.backend.services.mappers;

import com.github.aistomin.andy.grails.backend.controllers.configuration.SocialMediaLinkDto;
import com.github.aistomin.andy.grails.backend.model.SocialMediaLink;
import org.springframework.stereotype.Component;

/**
 * Social media link mapper.
 *
 * @since 0.3
 */
@Component
public class SocialMediaLinkMapper {

    /**
     * Convert social media link entity to DTO.
     *
     * @param link The social media link entity that needs to be converted.
     * @return Social media link DTO.
     */
    public SocialMediaLinkDto toDto(final SocialMediaLink link) {
        if (link == null) {
            return null;
        }
        return new SocialMediaLinkDto(
            link.getId(),
            link.getSocialMedia(),
            link.getUrl()
        );
    }

    /**
     * Convert social media link DTO to the entity.
     *
     * @param dto The link DTO that needs to be converted to entity.
     * @return Social media link entity.
     */
    public SocialMediaLink toEntity(final SocialMediaLinkDto dto) {
        if (dto == null) {
            return null;
        }
        return new SocialMediaLink(
            dto.id(),
            dto.socialMedia(),
            dto.url()
        );
    }
}
