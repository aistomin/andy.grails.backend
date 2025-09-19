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
package de.andy.grails.services.mappers;

import de.andy.grails.controllers.configuration.SocialMediaLinkDto;
import de.andy.grails.model.SocialMediaLink;
import org.mapstruct.Mapper;

/**
 * Social media link mapper using MapStruct.
 *
 * @since 0.3
 */
@Mapper(componentModel = "spring")
public interface SocialMediaLinkMapper {

    /**
     * Convert social media link entity to DTO.
     *
     * @param link The social media link entity that needs to be converted.
     * @return Social media link DTO.
     */
    SocialMediaLinkDto toDto(SocialMediaLink link);

    /**
     * Convert social media link DTO to the entity.
     *
     * @param dto The link DTO that needs to be converted to entity.
     * @return Social media link entity.
     */
    SocialMediaLink toEntity(SocialMediaLinkDto dto);
}
