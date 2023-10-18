package com.reader.article_analyzer;

import org.springframework.stereotype.Component;

@Component
public class ArticleCategorySaver {
    private final ArticleCategoryAnalyzer articleCategoryAnalyzer;
    private final JsonFileService jsonFileService;

    public ArticleCategorySaver(ArticleCategoryAnalyzer articleCategoryAnalyzer, JsonFileService jsonFileService) {
        this.articleCategoryAnalyzer = articleCategoryAnalyzer;
        this.jsonFileService = jsonFileService;
    }

    public void JsonSaver() {
        jsonFileService.writeJsonFile(articleCategoryAnalyzer.getAllCategories());
    }
}
