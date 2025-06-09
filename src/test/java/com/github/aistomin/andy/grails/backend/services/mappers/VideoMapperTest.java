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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.ZonedDateTime;
import java.util.Random;

/**
 * Test for {@link VideoMapper}.
 *
 * @since 0.3
 */
class VideoMapperTest {

    /**
     * video mapper to test.
     */
    private final VideoMapper mapper = new VideoMapper();

    /**
     * Randomiser.
     */
    private final Random rand = new Random();

    /**
     * Check that we can correctly convert entity to DTO using the mapper.
     */
    @Test
    void testToDto() {
        Assertions.assertNull(mapper.toDto(null));
        final var video = new Video();
        final var id = rand.nextLong();
        video.setId(id);
        final var title = String.format("Title %d", rand.nextLong());
        video.setTitle(title);
        final var description = String.format(
            "Description %d", rand.nextLong()
        );
        video.setDescription(description);
        final var url = String.format("https://%d.com", rand.nextLong());
        video.setUrl(url);
        final var youtubeId = Long.valueOf(rand.nextLong()).toString();
        video.setYoutubeId(youtubeId);
        final var channelId = Long.valueOf(rand.nextLong()).toString();
        video.setYoutubeChannelId(channelId);
        final var createdAt = ZonedDateTime.now();
        video.setCreatedAt(createdAt);
        final var publishedAt = ZonedDateTime.now();
        video.setPublishedAt(publishedAt);
        final var dto = mapper.toDto(video);
        Assertions.assertEquals(id, dto.getId());
        Assertions.assertEquals(title, dto.getTitle());
        Assertions.assertEquals(description, dto.getDescription());
        Assertions.assertEquals(url, dto.getUrl());
        Assertions.assertEquals(youtubeId, dto.getYoutubeId());
        Assertions.assertEquals(channelId, dto.getYoutubeChannelId());
        Assertions.assertEquals(createdAt, dto.getCreatedAt());
        Assertions.assertEquals(publishedAt, dto.getPublishedAt());
    }

    /**
     * Check that we can correctly convert DTO to entity using the mapper.
     */
    @Test
    void testToEntity() {
        Assertions.assertNull(mapper.toEntity(null));
        final var dto = new VideoDto();
        final var id = rand.nextLong();
        dto.setId(id);
        final var title = String.format("Title %d", rand.nextLong());
        dto.setTitle(title);
        final var description = String.format(
            "Description %d", rand.nextLong()
        );
        dto.setDescription(description);
        final var url = String.format("https://%d.com", rand.nextLong());
        dto.setUrl(url);
        final var youtubeId = Long.valueOf(rand.nextLong()).toString();
        dto.setYoutubeId(youtubeId);
        final var channelId = Long.valueOf(rand.nextLong()).toString();
        dto.setYoutubeChannelId(channelId);
        final var createdAt = ZonedDateTime.now();
        dto.setCreatedAt(createdAt);
        final var publishedAt = ZonedDateTime.now();
        dto.setPublishedAt(publishedAt);
        final var video = mapper.toEntity(dto);
        Assertions.assertEquals(id, video.getId());
        Assertions.assertEquals(title, video.getTitle());
        Assertions.assertEquals(description, video.getDescription());
        Assertions.assertEquals(url, video.getUrl());
        Assertions.assertEquals(youtubeId, video.getYoutubeId());
        Assertions.assertEquals(channelId, video.getYoutubeChannelId());
        Assertions.assertEquals(createdAt, video.getCreatedAt());
        Assertions.assertEquals(publishedAt, video.getPublishedAt());
    }
}
