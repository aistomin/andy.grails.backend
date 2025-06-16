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
package com.github.aistomin.andy.grails.backend.controllers.configuration;

/**
 * The link to the social media profile or channel.
 *
 * @param id Link ID.
 * @param socialMedia A type of the social media.
 * @param url Social media channel or profile URL.
 *
 * @since 0.3
 */
public record SocialMediaLinkDto(
    Long id, SocialMedia socialMedia, String url
) {
}
