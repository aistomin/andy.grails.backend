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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import java.util.List;
import java.util.Map;

/**
 * Test for {@link VideosController}.
 *
 * @since 0.1
 */
@SuppressWarnings({
    "checkstyle:MagicNumber",
})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VideosControllerTest {

    /**
     * Test REST template.
     */
    @Autowired
    private TestRestTemplate template;

    /**
     * Test that we correctly render videos over the API.
     */
    @Test
    void testListVideos() {
        final var videos = (List<Map>) this.template
            .getForEntity("/videos", List.class).getBody();
        Assertions.assertEquals(9, videos.size());
        Assertions.assertEquals(
            "Klaus Schindler - Zeit für Träume // Andrej Istomin",
            videos.get(0).get("title")
        );
    }
}
