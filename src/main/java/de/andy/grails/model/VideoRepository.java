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
import java.util.Optional;

/**
 * Video repository.
 *
 * @since 0.3
 */
public interface VideoRepository extends Repository<Video, Long> {

    /**
     * Find all the stored videos.
     *
     * @return The list of the stored videos.
     */
    List<Video> findAll();

    /**
     * Save video.
     *
     * @param video The video that needs to be saved.
     * @return Saved video.
     */
    Video save(Video video);

    /**
     * Find video by ID.
     *
     * @param id Video ID.
     * @return Found video.
     */
    Optional<Video> findById(long id);
}
