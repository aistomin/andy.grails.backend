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
package de.andy.grails.services;

import de.andy.grails.model.SocialMediaLink;
import de.andy.grails.model.SocialMediaLinkRepository;
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
     * Ctor.
     *
     * @param repo Social media links repo.
     */
    public ConfigurationServiceImpl(
        final SocialMediaLinkRepository repo
    ) {
        this.links = repo;
    }

    @Override
    public List<SocialMediaLink> findAllSocialMediaLinks() {
        log.debug(
            "ConfigurationServiceImpl.findAllSocialMediaLinks is called ....."
        );
        final var result = this.links.findAll()
            .stream()
            .toList();
        log.debug(
            "ConfigurationServiceImpl.findAllSocialMediaLinks got {} links.",
            result.size()
        );
        return result;
    }

    @Override
    public SocialMediaLink saveSocialMediaLink(
        final SocialMediaLink link
    ) {
        log.debug(
            "ConfigurationServiceImpl.saveSocialMediaLink is called {} .....",
            link
        );
        final var result = links.save(link);
        log.debug(
            "ConfigurationServiceImpl.saveSocialMediaLink saved: {}.",
            result
        );
        return result;
    }
}
