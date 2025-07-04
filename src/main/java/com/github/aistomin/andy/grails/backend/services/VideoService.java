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

import com.github.aistomin.andy.grails.backend.model.Video;
import java.util.List;

/**
 * Video's service.
 *
 * @since 0.1
 */
public interface VideoService {

    /**
     * Find all the existing videos.
     *
     * @return Videos.
     */
    List<Video> findAll();

    /**
     * Find video by ID.
     *
     * @param id The ID.
     * @return Found video.
     */
    Video findById(long id);

    /**
     * Save video.
     *
     * @param video Video that needs to be saved.
     * @return Saved video.
     */
    Video save(Video video);
}
