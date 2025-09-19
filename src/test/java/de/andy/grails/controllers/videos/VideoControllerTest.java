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
package de.andy.grails.controllers.videos;

import de.andy.grails.utils.IntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Map;

/**
 * Test for {@link VideoController}.
 *
 * @since 0.1
 */
class VideoControllerTest extends IntegrationTest {

    /**
     * Count of the videos that we store for test.
     */
    public static final int EXPECTED_VIDEOS_COUNT = 9;

    /**
     * Test that we correctly render videos over the API.
     */
    @Test
    void testListVideos() {
        final var response = template().exchange(
            "/videos",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<VideoDto>>() { }
        );
        final var videos = response.getBody();
        Assertions.assertEquals(EXPECTED_VIDEOS_COUNT, videos.size());
        Assertions.assertEquals(
            "Klaus Schindler - Zeit für Träume // Andrej Istomin",
            videos.get(0).title()
        );
    }

    /**
     * Test that we correctly render the video that is found by ID.
     */
    @Test
    void testFindById() {
        final var six = 6;
        final var response = template().exchange(
            String.format("/videos/%d", six),
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<VideoDto>() { }
        );
        final var video = response.getBody();
        Assertions.assertEquals(six, video.id());
        Assertions.assertEquals(
            "Greensleeves(English traditional) // Andrej Istomin",
            video.title()
        );
    }

    /**
     * Test that we return 404 when video is not found.
     */
    @Test
    void testFindByIdNotFound() {
        final var response = template().exchange(
            String.format("/videos/%d", Integer.MAX_VALUE),
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Map>() {
            }
        );
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        final var message = response.getBody();
        Assertions.assertEquals(
            HttpStatus.NOT_FOUND.value(), message.get("status")
        );
        Assertions.assertEquals("Video not found", message.get("message"));
    }
}
