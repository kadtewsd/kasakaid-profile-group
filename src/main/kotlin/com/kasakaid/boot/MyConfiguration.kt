package com.kasakaid.boot

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment

//@Component
//@ConfigurationProperties
//@PropertySource("classpath:/application.properties")
@Configuration
class MyConfiguration {
    @Bean
    fun check(env: Environment): String? {
        val validate = fun(value: String?) {
            if (env.activeProfiles.any { it == "development" }) {
                require(!value.isNullOrBlank()) { "間接的なインクルードができていません" }
            } else {
                require(value == null) { "development のプロファイルではない場合は、include1.development, include2.development は null です。"}
            }
        }
        val result1 = env.getProperty("include1.development")
        validate(result1)
        val result2 = env.getProperty("include2.development")
        validate(result2)
        return result1 + result2
    }

    //    @Value("${key}")
    var url: String? = null

}
