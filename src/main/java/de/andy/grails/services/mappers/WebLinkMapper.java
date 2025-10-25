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

import de.andy.grails.controllers.configuration.WebLinkDto;
import de.andy.grails.model.WebLink;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

/**
 * Web link mapper using MapStruct.
 *
 * @since 0.3
 */
@Mapper(
    componentModel = "spring",
    builder = @Builder()
)
public interface WebLinkMapper {

    /**
     * Web link entity to DTO.
     *
     * @param link The web link entity that needs to be converted.
     * @return Web link DTO.
     */
    WebLinkDto toDto(WebLink link);

    /**
     * CWeb link DTO to the entity.
     *
     * @param dto The web link DTO that needs to be converted to entity.
     * @return Web link entity.
     */
    WebLink toEntity(WebLinkDto dto);
}
