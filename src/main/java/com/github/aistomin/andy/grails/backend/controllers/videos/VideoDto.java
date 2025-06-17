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
package com.github.aistomin.andy.grails.backend.controllers.videos;

import java.time.ZonedDateTime;

/**
 * Video DTO.
 *
 * @param id Video ID.
 * @param title Video's title.
 * @param description Video's description.
 * @param url Video URL.
 * @param youtubeId Video's ID on the YouTube platform.
 * @param youtubeChannelId YouTube channel's ID, that contains the video.
 * @param createdAt The date when the video was created.
 * @param publishedAt The date when the video was published.
 * @since 0.1
 */
public record VideoDto(
    Long id,
    String title,
    String description,
    String url,
    String youtubeId,
    String youtubeChannelId,
    ZonedDateTime createdAt,
    ZonedDateTime publishedAt
) {
}
