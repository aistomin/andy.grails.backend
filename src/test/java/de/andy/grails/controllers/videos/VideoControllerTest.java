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
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException.NotFound;
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
    public static final int EXPECTED_VIDEOS_COUNT = 4;

    /**
     * Test that we correctly render videos over the API.
     */
    @Test
    void testListVideos() {
        final var videos = restClient().get()
            .uri("/videos")
            .retrieve()
            .body(new ParameterizedTypeReference<List<VideoDto>>() { });
        Assertions.assertEquals(EXPECTED_VIDEOS_COUNT, videos.size());
        Assertions.assertEquals(
            "Greensleeves(English traditional) // Andrej Istomin",
            videos.get(0).title()
        );
    }

    /**
     * Test that we correctly render the video that is found by ID.
     */
    @Test
    void testFindById() {
        final var two = 2;
        final var video = restClient().get()
            .uri(String.format("/videos/%d", two))
            .retrieve()
            .body(new ParameterizedTypeReference<VideoDto>() { });
        Assertions.assertEquals(two, video.id());
        Assertions.assertEquals(
            "Ferdinando Carulli - Andantino // Andrej Istomin",
            video.title()
        );
    }

    /**
     * Test that we return 404 when the video is not found.
     */
    @Test
    void testFindByIdNotFound() {
        final var exception = Assertions.assertThrows(
            NotFound.class,
            () -> restClient().get()
                .uri(String.format("/videos/%d", Integer.MAX_VALUE))
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String, Object>>() {
                })
        );
        Assertions.assertEquals(
            HttpStatus.NOT_FOUND, exception.getStatusCode()
        );
        final var message = exception.getResponseBodyAs(
            new ParameterizedTypeReference<Map<String, Object>>() {
            }
        );
        Assertions.assertNotNull(message);
        Assertions.assertEquals(
            HttpStatus.NOT_FOUND.value(), message.get("status")
        );
        Assertions.assertEquals("Video not found", message.get("message"));
    }
}
