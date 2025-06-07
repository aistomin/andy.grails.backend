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
package com.github.aistomin.andy.grails.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.ZonedDateTime;

/**
 * Video entity.
 *
 * @since 0.3
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString()
@Data
public final class Video {

    /**
     * Video ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Video's title.
     */
    private String title;

    /**
     * Description.
     */
    private String description;

    /**
     * Video URL.
     */
    private String url;

    /**
     * Video's ID on the YouTube platform.
     */
    private String youtubeId;

    /**
     * YouTube channel's ID, that contains the video.
     */
    private String youtubeChannelId;

    /**
     * The date when the video was created.
     */
    private ZonedDateTime createdAt;

    /**
     * The date when the video was published.
     */
    private ZonedDateTime publishedAt;
}
