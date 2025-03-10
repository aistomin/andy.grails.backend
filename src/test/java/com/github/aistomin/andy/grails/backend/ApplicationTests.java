package com.github.aistomin.andy.grails.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Tests for {@link Application}.
 */
@SpringBootTest
class ApplicationTests {

    /**
     * Dummy test.
     */
    @Test
    void contextLoads() {
        Assertions.assertEquals(2, 1 + 1);
    }
}
