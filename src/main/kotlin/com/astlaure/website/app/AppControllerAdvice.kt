package com.astlaure.website.app

import com.astlaure.website.app.exceptions.NotFoundException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class AppControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(): String {
        return "errors/404"
    }
}
