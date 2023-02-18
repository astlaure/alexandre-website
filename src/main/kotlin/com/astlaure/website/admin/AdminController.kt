package com.astlaure.website.admin

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminController {

    @GetMapping("/admin")
    fun admin(): String {
        return "admin/index"
    }
}
