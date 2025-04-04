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
package com.github.aistomin.andy.grails.backend.services;

import com.github.aistomin.andy.grails.backend.controllers.videos.VideoDto;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Temporary implementation of the {@link VideosService}. For now, we just work
 * with some hardcoded values that we store in the static variable.
 *
 * @since 0.1
 */
@SuppressWarnings({
    "checkstyle:MagicNumber",
    "checkstyle:LineLength",
    "checkstyle:MethodLength"
})
@Service
public final class VideosServiceInMemory implements VideosService {

    /**
     * Storage.
     */
    private static final List<VideoDto> STORAGE = new ArrayList<>();

    static {
        final var zone = ZoneId.systemDefault();
        STORAGE.add(new VideoDto(
            null,
            "Klaus Schindler - Zeit für Träume // Andrej Istomin",
            "The photos in this video were taken by my wife(checkout her channel, by the way:  https://www.youtube.com/channel/UC810...) in Landkreis Dachau(mostly in Schwabhausen and Altomünster). The lovely place where I live.",
            "https://www.youtube.com/watch?v=lLe-HB1WLO4",
            "lLe-HB1WLO4",
            ZonedDateTime.of(
                LocalDateTime.of(2017,  Month.AUGUST, 20, 10, 5),
                zone
            ),
            ZonedDateTime.of(
                LocalDateTime.of(2017,  Month.AUGUST, 20, 12, 45),
                zone
            )
        ));
        STORAGE.add(new VideoDto(
            null,
            "Andrej Istomin - Jenny",
            "The melody composed and performed by Andrej Istomin except those telephone sounds.",
            "https://www.youtube.com/watch?v=j_Ve3uiVsaA",
            "j_Ve3uiVsaA",
            ZonedDateTime.of(
                LocalDateTime.of(2017,  Month.AUGUST, 21, 15, 35),
                zone
            ),
            ZonedDateTime.of(
                LocalDateTime.of(2017,  Month.AUGUST, 21, 18, 12),
                zone
            )
        ));
        STORAGE.add(new VideoDto(
            null,
            "Mauro Giuliani - Sonatina op. 71 no. 1 // Andrej Istomin",
            "A little bit of an autumn mood :) Music piece is composed by Mauro Giuliani, called \"Sonatina op71 n°1\". The pictures in slide-show are the reproductions of different Russian painters.",
            "https://www.youtube.com/watch?v=DIEBQxqY1yU",
            "DIEBQxqY1yU",
            ZonedDateTime.of(
                LocalDateTime.of(2017,  Month.NOVEMBER, 11, 9, 28),
                zone
            ),
            ZonedDateTime.of(
                LocalDateTime.of(2017,  Month.NOVEMBER, 11, 18, 30),
                zone
            )
        ));
        STORAGE.add(new VideoDto(
            null,
            "Blackmore's Night - Minstrel Hall // Andrej Istomin",
            "The piece is composed by Ritchie Blackmore.",
            "https://www.youtube.com/watch?v=iTVHH1vMIcI",
            "iTVHH1vMIcI",
            ZonedDateTime.of(
                LocalDateTime.of(2017,  Month.NOVEMBER, 13, 12, 14),
                zone
            ),
            ZonedDateTime.of(
                LocalDateTime.of(2017,  Month.NOVEMBER, 13, 15, 56),
                zone
            )
        ));
        STORAGE.add(new VideoDto(
            null,
            "Fernando Sor - Andante // Andrej Istomin",
            "This time I'm playing \"Andante\" by Fernando Sor. It is the very first time when I try to create a real video instead of slide show which I did for my previous videos. I hope you like it :)",
            "https://www.youtube.com/watch?v=kbd7a7j0VOE",
            "kbd7a7j0VOE",
            ZonedDateTime.of(
                LocalDateTime.of(2017,  Month.DECEMBER, 15, 10, 33),
                zone
            ),
            ZonedDateTime.of(
                LocalDateTime.of(2017,  Month.DECEMBER, 15, 16, 42),
                zone
            )
        ));
        STORAGE.add(new VideoDto(
            null,
            "Greensleeves(English traditional) // Andrej Istomin",
            "Today I'd like to show you my attempt to play instrumental version of the traditional English song \"Greensleeves\".",
            "https://www.youtube.com/watch?v=DDt7N5KxXrM",
            "DDt7N5KxXrM",
            ZonedDateTime.of(
                LocalDateTime.of(2019,  Month.MAY, 28, 10, 33),
                zone
            ),
            ZonedDateTime.of(
                LocalDateTime.of(2019,  Month.MAY, 31, 16, 42),
                zone
            )
        ));
        STORAGE.add(new VideoDto(
            null,
            "Ferdinando Carulli - Andantino // Andrej Istomin",
            "This summer is really hot here in Germany. I decided to create this small summer video where I'm trying to play nice light piece called \"Andantino\" by Ferdinando Carulli (1770-1841).",
            "https://www.youtube.com/watch?v=Hd05dNHYqAw",
            "Hd05dNHYqAw",
            ZonedDateTime.of(
                LocalDateTime.of(2019,  Month.JULY, 7, 11, 33),
                zone
            ),
            ZonedDateTime.of(
                LocalDateTime.of(2019,  Month.JULY, 9, 16, 22),
                zone
            )
        ));
        STORAGE.add(new VideoDto(
            null,
            "Johann Pachelbel - Sarabande (Guitar + Recorder) // Andrej Istomin",
            "This summer is really hot here in Germany. I decided to create this small summer video where I'm trying to play nice light piece called \"Andantino\" by Ferdinando Carulli (1770-1841).",
            "https://www.youtube.com/watch?v=hRvXB_gnR84",
            "hRvXB_gnR84",
            ZonedDateTime.of(
                LocalDateTime.of(2020,  Month.JUNE, 13, 11, 33),
                zone
            ),
            ZonedDateTime.of(
                LocalDateTime.of(2020,  Month.JUNE, 13, 16, 22),
                zone
            )
        ));
        STORAGE.add(new VideoDto(
            null,
            "J. S. Bach - Bourrée // Andrej Istomin",
            "Thanks for watching this video. If you like it, please subscribe to my channel, comment the videos, \"like\" them and share with your friends.",
            "https://www.youtube.com/watch?v=AjQBAQ1jzwc",
            "AjQBAQ1jzwc",
            ZonedDateTime.of(
                LocalDateTime.of(2020,  Month.APRIL, 9, 0, 1),
                zone
            ),
            ZonedDateTime.of(
                LocalDateTime.of(2020,  Month.APRIL, 9, 11, 5),
                zone
            )
        ));
    }

    @Override
    public List<VideoDto> list() {
        return STORAGE;
    }
}
