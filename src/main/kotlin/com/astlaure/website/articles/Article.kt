package com.astlaure.website.articles

import com.astlaure.website.articles.enums.ArticleStatus
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "articles")
class Article(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var title: String,

    @Column(nullable = false, unique = true)
    var uri: String,

    @Enumerated(EnumType.STRING)
    var status: ArticleStatus = ArticleStatus.DRAFT,

    var content: String,

    @CreationTimestamp
    var createdAt: LocalDateTime? = null,

    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null,
) {
}
