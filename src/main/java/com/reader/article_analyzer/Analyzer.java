package com.reader.article_analyzer;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Analyzer {
    private final ArticleCategoryAnalyzer articleCategoryAnalyzer;
    private final ArticleCategorySaver articleCategorySaver;
    private final UserNotifier userNotifier;


    public Analyzer(ArticleCategoryAnalyzer articleCategoryAnalyzer, ArticleCategorySaver articleCategorySaver, UserNotifier userNotifier) {
        this.articleCategoryAnalyzer = articleCategoryAnalyzer;
        this.articleCategorySaver = articleCategorySaver;
        this.userNotifier = userNotifier;
    }

    public void analyze() throws IOException {
        articleCategoryAnalyzer.analyzeArticleContent("articles.json");
        articleCategorySaver.JsonSaver();
        userNotifier.notifyUsersAboutCategoryChanges();
    }
}
