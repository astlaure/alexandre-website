package com.astlaure.website.auth

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class AuthController {
    @GetMapping("/login")
    fun login(): String {
        return "auth/login"
    }

    @PostMapping("/login/success")
    fun loginSuccess(): String {
        return "redirect:/admin"
    }
}
