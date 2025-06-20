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
import com.github.aistomin.andy.grails.backend.model.SocialMediaLinkRepository;
import com.github.aistomin.andy.grails.backend.services.mappers.SocialMediaLinkMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Temporary implementation of the {@link VideoService}. For now, we just work
 * with some hardcoded values that we store in the static variable.
 *
 * @since 0.1
 */
@Service
@Slf4j
public final class ConfigurationServiceImpl implements ConfigurationService {

    /**
     * Social media links repo.
     */
    private final SocialMediaLinkRepository links;

    /**
     * Entity to DTO mapper.
     */
    private final SocialMediaLinkMapper mapper;

    /**
     * Ctor.
     *
     * @param repo Social media links repo.
     * @param map Entity to DTO mapper.
     */
    public ConfigurationServiceImpl(
        final SocialMediaLinkRepository repo,
        final SocialMediaLinkMapper map
    ) {
        this.links = repo;
        this.mapper = map;
    }

    @Override
    public List<SocialMediaLinkDto> findAllSocialMediaLinks() {
        log.debug(
            "ConfigurationServiceImpl.findAllSocialMediaLinks is called ....."
        );
        final var result = this.links.findAll()
            .stream()
            .map(mapper::toDto)
            .toList();
        log.debug(
            "ConfigurationServiceImpl.findAllSocialMediaLinks got {} links.",
            result.size()
        );
        return result;
    }

    @Override
    public SocialMediaLinkDto saveSocialMediaLink(
        final SocialMediaLinkDto link
    ) {
        log.debug(
            "ConfigurationServiceImpl.saveSocialMediaLink is called {} .....",
            link
        );
        final var result = mapper.toDto(links.save(mapper.toEntity(link)));
        log.debug(
            "ConfigurationServiceImpl.saveSocialMediaLink saved: {}.",
            result
        );
        return result;
    }
}
