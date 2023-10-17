package com.reader.article_analyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import java.io.IOException;
import java.util.Set;

@SpringBootApplication
public class ArticleAnalyzerApplication {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(ArticleAnalyzerApplication.class, args);

		ArticleCategoryAnalyzer analyzer = context.getBean(ArticleCategoryAnalyzer.class);
		ArticleCategorySaver saver = context.getBean(ArticleCategorySaver.class);

		analyzer.analyzeArticleContent("articles.json", 0);
		analyzer.analyzeArticleContent("articles.json", 1);
		analyzer.analyzeArticleContent("articles.json", 2);

		saver.JsonSaver();



	}
}
