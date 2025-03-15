/*
 * Copyright (c) 2025 Istomin Andrej
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

import com.github.aistomin.andy.grails.backend.services.VideosService;
import org.springframework.web.bind.annotation.GetMapping;
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
public final class VideosController {

    /**
     * Video service.
     */
    private final VideosService videos;

    /**
     * Ctor.
     *
     * @param service Video service.
     */
    public VideosController(final VideosService service) {
        this.videos = service;
    }

    /**
     * Load videos.
     *
     * @return Videos.
     */
    @GetMapping
    public List<VideoDto> list() {
        return this.videos.list();
    }
}
