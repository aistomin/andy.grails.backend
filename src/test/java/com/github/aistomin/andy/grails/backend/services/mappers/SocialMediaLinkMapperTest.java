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

import com.github.aistomin.andy.grails.backend.controllers.configuration.SocialMediaLinkDto;
import com.github.aistomin.andy.grails.backend.model.SocialMedia;
import com.github.aistomin.andy.grails.backend.model.SocialMediaLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Random;

/**
 * Test for {@link SocialMediaLinkMapper}.
 *
 * @since 0.3
 */
@SpringBootTest
class SocialMediaLinkMapperTest {

    /**
     * Social media link mapper to test.
     */
    @Autowired
    private SocialMediaLinkMapper mapper;

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
        final var link = new SocialMediaLink();
        link.setId(rand.nextLong());
        link.setSocialMedia(SocialMedia.YOUTUBE);
        link.setUrl(String.format("https://%d.com", rand.nextLong()));
        final var dto = mapper.toDto(link);
        Assertions.assertEquals(link.getId(), dto.id());
        Assertions.assertEquals(link.getSocialMedia(), dto.socialMedia());
        Assertions.assertEquals(link.getUrl(), dto.url());
    }

    /**
     * Check that we can correctly convert DTO to entity using the mapper.
     */
    @Test
    void testToEntity() {
        Assertions.assertNull(mapper.toEntity(null));
        final var dto = new SocialMediaLinkDto(
            rand.nextLong(),
            SocialMedia.INSTAGRAM,
            String.format("https://%d.com", rand.nextLong())
        );
        final var link = mapper.toEntity(dto);
        Assertions.assertEquals(dto.id(), link.getId());
        Assertions.assertEquals(dto.socialMedia(), link.getSocialMedia());
        Assertions.assertEquals(dto.url(), link.getUrl());
    }
}
