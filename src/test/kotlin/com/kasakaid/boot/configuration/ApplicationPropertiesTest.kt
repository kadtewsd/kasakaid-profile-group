package com.kasakaid.boot.configuration

import com.kasakaid.boot.AbstractBaseTest
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment

class ApplicationPropertiesTest : AbstractBaseTest() {

    @Autowired
    lateinit var env: Environment

    @Test
    fun applicationPropertiesの読み込み() {
        assertThat(env.getProperty("common.key"), `is`("this_is_common"))
    }

    @Test
    fun テストのみのキーのテスト() {
        assertThat(env.getProperty("test.key"), `is`("this_is_test_key"))
    }

    @Test
    fun developmentのキーはnullになる() {
        assertThat(env.getProperty("include1.development"), `is`(nullValue()))
        assertThat(env.getProperty("include2.development"), `is`(nullValue()))
    }

    //    @Test(expected = IllegalArgumentException.class)
    @Test
    fun 開発環境のキーは取得できないテスト() {
        assertThat(env.getProperty("development.key"), nullValue())
    }
}