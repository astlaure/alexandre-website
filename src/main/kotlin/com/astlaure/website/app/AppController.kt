package com.astlaure.website.app

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AppController {
    @GetMapping
    fun index(): String {
        return "index"
    }
}
