package com.astlaure.website.articles

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ArticleController(
    private val articleService: ArticleService,
) {
    @GetMapping("/admin/articles")
    fun getArticles(model: Model, @RequestParam(defaultValue = "0") page: Int): String {
        model.addAttribute("articlesPage", articleService.retrieveArticlePage(page))
        return "admin/articles/index"
    }

    @GetMapping("/admin/articles/create")
    fun createArticle(): String {
        return "admin/articles/create"
    }

    @PostMapping("/admin/articles/create")
    fun postArticle() {}
}
