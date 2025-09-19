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

import de.andy.grails.model.Video;
import de.andy.grails.model.VideoRepository;
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
     * Ctor.
     *
     * @param repo Videos repository.
     */
    public VideoServiceImpl(final VideoRepository repo) {
        this.videos = repo;
    }

    @Override
    public List<Video> findAll() {
        log.debug(
            "VideoServiceImpl.findAll is called ....."
        );
        final var result = videos.findAll()
            .stream()
            .toList();
        log.debug(
            "VideoServiceImpl.findAll returns {} videos.", result.size()
        );
        return result;
    }

    @Override
    public Video findById(final long id) {
        log.debug(
            "VideoServiceImpl.findById is called with ID = {} .....", id
        );
        final var result = videos.findById(id).orElse(null);
        log.debug(
            "VideoServiceImpl.findById result: {}.", result
        );
        return result;
    }

    @Override
    public Video save(final Video video) {
        log.debug(
            "VideoServiceImpl.save is called {} .....",
            video
        );
        final var result = videos.save(video);
        log.debug(
            "VideoServiceImpl.save saved: {}.",
            result
        );
        return result;
    }
}
