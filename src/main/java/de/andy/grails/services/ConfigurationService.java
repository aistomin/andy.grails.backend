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
import java.util.List;

/**
 * Configuration's service.
 *
 * @since 0.3
 */
public interface ConfigurationService {

    /**
     * Find all the existing web links.
     *
     * @return Web links.
     */
    List<WebLink> findAllWebLinks();

    /**
     * Save web link.
     *
     * @param link Web link that needs to be saved.
     * @return Saved web link.
     */
    WebLink saveWebLink(WebLink link);
}
