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
package com.github.aistomin.andy.grails.backend.services.mappers;

import com.github.aistomin.andy.grails.backend.controllers.videos.VideoDto;
import com.github.aistomin.andy.grails.backend.model.Video;
import org.springframework.stereotype.Component;

/**
 * Video mapper.
 *
 * @since 0.3
 */
@Component
public class VideoMapper {

    /**
     * Ctor.
     */
    public VideoMapper() {
    }

    /**
     * Convert video entity to DTO.
     *
     * @param video The video entity that needs to be converted.
     * @return Video DTO.
     */
    public VideoDto toDto(final Video video) {
        if (video == null) {
            return null;
        }
        return new VideoDto(
            video.getId(),
            video.getTitle(),
            video.getDescription(),
            video.getUrl(),
            video.getYoutubeId(),
            video.getYoutubeChannelId(),
            video.getCreatedAt(),
            video.getPublishedAt()
        );
    }

    /**
     * Convert video DTO to the entity.
     *
     * @param dto The video DTO that needs to be converted to entity.
     * @return Video entity.
     */
    public Video toEntity(final VideoDto dto) {
        if (dto == null) {
            return null;
        }
        return new Video(
            dto.id(),
            dto.title(),
            dto.description(),
            dto.url(),
            dto.youtubeId(),
            dto.youtubeChannelId(),
            dto.createdAt(),
            dto.publishedAt()
        );
    }
}
