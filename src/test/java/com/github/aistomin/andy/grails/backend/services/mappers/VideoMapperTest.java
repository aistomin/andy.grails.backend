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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.ZonedDateTime;
import java.util.Random;

/**
 * Test for {@link VideoMapper}.
 *
 * @since 0.3
 */
@SpringBootTest
class VideoMapperTest {

    /**
     * Video mapper to test.
     */
    @Autowired
    private VideoMapper mapper;

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
            "Description %d", rand.nextLong());
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
        Assertions.assertEquals(id, dto.id());
        Assertions.assertEquals(title, dto.title());
        Assertions.assertEquals(description, dto.description());
        Assertions.assertEquals(url, dto.url());
        Assertions.assertEquals(youtubeId, dto.youtubeId());
        Assertions.assertEquals(channelId, dto.youtubeChannelId());
        Assertions.assertEquals(createdAt, dto.createdAt());
        Assertions.assertEquals(publishedAt, dto.publishedAt());
    }

    /**
     * Check that we can correctly convert DTO to entity using the mapper.
     */
    @Test
    void testToEntity() {
        Assertions.assertNull(mapper.toEntity(null));
        final var dto = new VideoDto(
            rand.nextLong(),
            String.format("Title %d", rand.nextLong()),
            String.format(
                "Description %d", rand.nextLong()),
            String.format("https://%d.com", rand.nextLong()),
            Long.valueOf(rand.nextLong()).toString(),
            Long.valueOf(rand.nextLong()).toString(),
            ZonedDateTime.now(),
            ZonedDateTime.now()
        );
        final var video = mapper.toEntity(dto);
        Assertions.assertEquals(dto.id(), video.getId());
        Assertions.assertEquals(dto.title(), video.getTitle());
        Assertions.assertEquals(dto.description(), video.getDescription());
        Assertions.assertEquals(dto.url(), video.getUrl());
        Assertions.assertEquals(dto.youtubeId(), video.getYoutubeId());
        Assertions.assertEquals(
            dto.youtubeChannelId(), video.getYoutubeChannelId()
        );
        Assertions.assertEquals(dto.createdAt(), video.getCreatedAt());
        Assertions.assertEquals(dto.publishedAt(), video.getPublishedAt());
    }
}
