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
package com.github.aistomin.andy.grails.backend.controllers.videos;

import com.github.aistomin.andy.grails.backend.services.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Video controller.
 *
 * @since 0.1
 */
@RestController
@RequestMapping("/videos")
@Slf4j
public class VideoController {

    /**
     * Video service.
     */
    private final VideoService videos;

    /**
     * Ctor.
     *
     * @param service Video service.
     */
    public VideoController(final VideoService service) {
        this.videos = service;
    }

    /**
     * Load videos.
     *
     * @return Videos.
     */
    @GetMapping
    public List<VideoDto> list() {
        log.debug("VideoController.list is called .....");
        final var result = this.videos.findAll();
        log.debug("VideoController.list returns {} videos", result.size());
        return result;
    }

    /**
     * Find video by ID.
     *
     * @param id The ID.
     * @return Found video.
     */
    @GetMapping("/{id}")
    public VideoDto findById(final @PathVariable long id) {
        log.debug("VideoController.findById is called with ID  = {} .....", id);
        final var video = this.videos.findById(id);
        log.debug("VideoController.findById returns {}", video);
        return video;
    }
}
