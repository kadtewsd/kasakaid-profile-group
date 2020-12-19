package com.kasakaid.boot

import org.springframework.boot.test.context.SpringBootTest
import com.kasakaid.boot.KasakaidBootApplication
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.ActiveProfiles
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext

@SpringBootTest(classes = [KasakaidBootApplication::class])
@ExtendWith(SpringExtension::class)
@ActiveProfiles("test")
@Slf4j
abstract class AbstractBaseTest {
    @Autowired
    protected var context: ApplicationContext? = null
}