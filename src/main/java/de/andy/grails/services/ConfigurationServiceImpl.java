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

import de.andy.grails.model.WebLink;
import de.andy.grails.model.WebLinkRepository;
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
     * Web links repo.
     */
    private final WebLinkRepository links;

    /**
     * Ctor.
     *
     * @param repo Web links repo.
     */
    public ConfigurationServiceImpl(
        final WebLinkRepository repo
    ) {
        this.links = repo;
    }

    @Override
    public List<WebLink> findAllWebLinks() {
        log.debug(
            "ConfigurationServiceImpl.findAllWebLinks is called ....."
        );
        final var result = this.links.findAll()
            .stream()
            .toList();
        log.debug(
            "ConfigurationServiceImpl.findAllWebLinks got {} links.",
            result.size()
        );
        return result;
    }

    @Override
    public WebLink saveWebLink(
        final WebLink link
    ) {
        log.debug(
            "ConfigurationServiceImpl.saveWebLink is called {} .....",
            link
        );
        final var result = links.save(link);
        log.debug(
            "ConfigurationServiceImpl.saveWebLink saved: {}.",
            result
        );
        return result;
    }
}
