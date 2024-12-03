package com.sesori.null4u.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CorsConfig {
    @Bean
    fun corsConfigurationSource(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**") // 모든 엔드포인트 허용
                    .allowedOrigins("http://localhost:5173") // 프론트엔드 도메인
                    .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용 HTTP 메서드
                    .allowCredentials(true) // 쿠키 전송 허용
            }
        }
    }
}