package com.astlaure.website.auth

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class AuthConfig {
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { it
                .requestMatchers("/admin/**").authenticated()
                .anyRequest().permitAll()
            }
            .sessionManagement { it
                .invalidSessionUrl("/")
            }
            .formLogin { it
                .successForwardUrl("/login/success")
                .loginPage("/login")
                .permitAll()
            }
            .logout { it
                .logoutSuccessUrl("/")
                .permitAll()
            }
        return http.build()
    }
}
