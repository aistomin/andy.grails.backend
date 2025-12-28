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
package de.andy.grails.model;

import de.andy.grails.services.ConfigurationService;
import de.andy.grails.services.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Video repository.
 *
 * @since 0.3
 */
@Component
@Slf4j
@SuppressWarnings({
    "checkstyle:MagicNumber",
    "checkstyle:MethodLength"
})
public final class DataGenerator {

    /**
     * Video service.
     */
    private final VideoService videos;

    /**
     * Configuration service.
     */
    private final ConfigurationService configuration;

    /**
     * Ctor.
     *
     * @param vids Video service.
     * @param conf Configuration service.
     */
    public DataGenerator(
        final VideoService vids,
        final ConfigurationService conf
    ) {
        this.videos = vids;
        this.configuration = conf;
    }

    /**
     * Generate initial set of videos if necessary.
     *
     * @return The number of generated videos.
     */
    public Integer generateVideosIfNecessary() {
        log.debug("Generating videos if necessary .....");
        if (videos.findAll().isEmpty()) {
            log.debug("No videos found. Let's generate them .....");
            final var zone = ZoneId.systemDefault();
            videos.save(new Video(
                null,
                "Greensleeves(English traditional) // Andrej Istomin",
                readFile("videos/greensleeves.txt"),
                "https://www.youtube.com/watch?v=DDt7N5KxXrM",
                "DDt7N5KxXrM",
                "UC_Xbh9rT4YiFL4U84oalEjQ",
                ZonedDateTime.of(
                    LocalDateTime.of(2019, Month.MAY, 28, 10, 33),
                    zone
                ),
                ZonedDateTime.of(
                    LocalDateTime.of(2019, Month.MAY, 31, 16, 42),
                    zone
                )
            ));
            videos.save(new Video(
                null,
                "Ferdinando Carulli - Andantino // Andrej Istomin",
                readFile("videos/andantino.txt"),
                "https://www.youtube.com/watch?v=Hd05dNHYqAw",
                "Hd05dNHYqAw",
                "UC_Xbh9rT4YiFL4U84oalEjQ",
                ZonedDateTime.of(
                    LocalDateTime.of(2019, Month.JULY, 7, 11, 33),
                    zone
                ),
                ZonedDateTime.of(
                    LocalDateTime.of(2019, Month.JULY, 9, 16, 22),
                    zone
                )
            ));
            videos.save(new Video(
                null,
                "Johann Pachelbel - Sarabande // Andrej Istomin",
                readFile("videos/sarabande.txt"),
                "https://www.youtube.com/watch?v=hRvXB_gnR84",
                "hRvXB_gnR84",
                "UC_Xbh9rT4YiFL4U84oalEjQ",
                ZonedDateTime.of(
                    LocalDateTime.of(2020, Month.JUNE, 13, 11, 33),
                    zone
                ),
                null
            ));
            videos.save(new Video(
                null,
                "J. S. Bach - Bourrée // Andrej Istomin",
                readFile("videos/bourree.txt"),
                "https://www.youtube.com/watch?v=AjQBAQ1jzwc",
                "AjQBAQ1jzwc",
                "UC_Xbh9rT4YiFL4U84oalEjQ",
                ZonedDateTime.of(
                    LocalDateTime.of(2020, Month.APRIL, 9, 0, 1),
                    zone
                ),
                null
            ));
            log.debug("Videos were created.");
            return videos.findAll().size();
        } else {
            log.debug("Videos already exists.");
            return 0;
        }
    }

    /**
     * Generate initial configuration if necessary.
     *
     * @return The number of generated entities.
     */
    public Integer generateConfigurationIfNecessary() {
        log.debug("Generating web links if necessary .....");
        if (configuration.findAllWebLinks().isEmpty()) {
            log.debug("No web links found. Let's generate them .....");
            configuration.saveWebLink(
                new WebLink(
                    null,
                    WebLinkType.YOUTUBE,
                    "https://www.youtube.com/@andygrails"
                )
            );
            configuration.saveWebLink(
                new WebLink(
                    null,
                    WebLinkType.INSTAGRAM,
                    "https://www.instagram.com/andy.grails/"
                )
            );
            configuration.saveWebLink(
                new WebLink(
                    null,
                    WebLinkType.FACEBOOK,
                    "https://www.facebook.com/profile.php?id=100074082643728"
                )
            );
            configuration.saveWebLink(
                new WebLink(
                    null,
                    WebLinkType.ISSUE_TRACKER,
                    "https://github.com/aistomin/andy.grails/issues/new/choose"
                )
            );
            configuration.saveWebLink(
                new WebLink(
                    null,
                    WebLinkType.DEVELOPER_WEBSITE,
                    "https://aistomin.com"
                )
            );
            log.debug("Web links were created.");
            return configuration.findAllWebLinks().size();
        } else {
            log.debug("Web links already exists.");
            return 0;
        }
    }

    /**
     * Read text file from classpath.
     *
     * @param path File path.
     * @return File content.
     */
    private String readFile(final String path) {
        try {
            return FileUtils.readFileToString(
                new File(
                    getClass().getClassLoader().getResource(path).getFile()
                ),
                "UTF-8"
            );
        } catch (final IOException error) {
            throw new RuntimeException(error);
        }
    }
}
