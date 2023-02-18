package com.astlaure.website.articles

import com.astlaure.website.app.exceptions.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articleRepository: ArticleRepository,
) {
    fun retrieveArticlePage(page: Int): Page<Article> {
        return articleRepository.findAll(PageRequest.of(page, 20))
    }

    fun retrieveArticleById(id: Long): Article {
        return articleRepository.findById(id)
            .orElseThrow { NotFoundException("Article not found") }
    }

    fun createArticle() {}
}
