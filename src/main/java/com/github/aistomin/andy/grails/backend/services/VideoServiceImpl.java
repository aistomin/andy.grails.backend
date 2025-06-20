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

import com.github.aistomin.andy.grails.backend.controllers.videos.VideoDto;
import com.github.aistomin.andy.grails.backend.model.VideoRepository;
import com.github.aistomin.andy.grails.backend.services.mappers.VideoMapper;
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
public final class VideoServiceImpl implements VideoService {

    /**
     * Videos repository.
     */
    private final VideoRepository videos;

    /**
     * Video mapper.
     */
    private final VideoMapper mapper;

    /**
     * Ctor.
     *
     * @param repo Videos repository.
     * @param map Video mapper.
     */
    public VideoServiceImpl(
        final VideoRepository repo, final VideoMapper map
    ) {
        this.videos = repo;
        this.mapper = map;
    }

    @Override
    public List<VideoDto> findAll() {
        log.debug(
            "VideoServiceImpl.findAll is called ....."
        );
        final var result = videos.findAll()
            .stream()
            .map(mapper::toDto)
            .toList();
        log.debug(
            "VideoServiceImpl.findAll returns {} videos.", result.size()
        );
        return result;
    }

    @Override
    public VideoDto findById(final long id) {
        log.debug(
            "VideoServiceImpl.findById is called with ID = {} .....", id
        );
        final var result = videos.findById(id).map(mapper::toDto).orElse(null);
        log.debug(
            "VideoServiceImpl.findById result: {}.", result
        );
        return result;
    }

    @Override
    public VideoDto save(final VideoDto video) {
        log.debug(
            "VideoServiceImpl.save is called {} .....",
            video
        );
        final var result = mapper.toDto(videos.save(mapper.toEntity(video)));
        log.debug(
            "VideoServiceImpl.save saved: {}.",
            result
        );
        return result;
    }
}
