package com.bibbi.component

import org.hibernate.validator.internal.util.Contracts.assertNotNull
import org.hibernate.validator.internal.util.Contracts.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UlidIdentityGeneratorTest {

    @Autowired
    private lateinit var ulidIdentityGenerator: UlidIdentityGenerator

    @Test
    fun UlidIdentityGenerator가_인터페이스를_구현하는지_테스트() {
        // when
        val isIdentityGenerator = true

        // then
        assertTrue(isIdentityGenerator, "UlidIdentityGenerator should implement IdentityGenerator interface")
    }

    @Test
    fun ULID_생성_테스트() {
        // when
        val generatedIdentity = ulidIdentityGenerator.generateIdentity()

        // then
        assertNotNull(generatedIdentity)
        assertTrue(generatedIdentity.matches(Regex("[0-9A-Z]{26}")), "Generated identity should be a valid ULID")
    }
}
