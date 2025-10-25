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
package de.andy.grails.model;

import org.springframework.data.repository.Repository;
import java.util.List;

/**
 * Web link repository.
 *
 * @since 0.3
 */
public interface WebLinkRepository
    extends Repository<WebLink, Long> {

    /**
     * Find all the stored web links.
     *
     * @return The list of the stored web links.
     */
    List<WebLink> findAll();

    /**
     * Web media link.
     *
     * @param link The web link that needs to be saved.
     * @return Saved web link.
     */
    WebLink save(WebLink link);
}
