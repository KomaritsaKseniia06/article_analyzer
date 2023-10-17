package com.reader.article_analyzer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


import java.io.IOException;
import java.util.List;
import java.util.Set;

@SpringBootApplication
//@Configuration
public class ArticleAnalyzerApplication {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(ArticleAnalyzerApplication.class, args);
		JsonFileService jsonFileService = context.getBean(JsonFileService.class);
		String content = jsonFileService.readJsonFile("articles.json", Article.class).get(2).getContent();
//
//		ArticleReaderFromJSON articleReaderFromJSON = context.getBean(ArticleReaderFromJSON.class);
//		String content = articleReaderFromJSON.getArticles().get(1).getContent();

		ArticleCategoryAnalyzer analyzer = context.getBean(ArticleCategoryAnalyzer.class);
		Set<String> categories = analyzer.analyzeContent(content);

		jsonFileService.writeJsonFile(categories);

	}
}
