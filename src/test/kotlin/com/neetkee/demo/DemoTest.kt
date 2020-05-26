package com.neetkee.demo

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DemoTest(
    @Autowired private val demoService: DemoService
) {

    @Test
    fun `should append saved to name`() {
        val name = "test"
        val expectedSavedName = "test_saved"
        demoService.addDemo(name).shouldBe(expectedSavedName)
    }
}

