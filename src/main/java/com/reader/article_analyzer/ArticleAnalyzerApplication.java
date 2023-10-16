package com.reader.article_analyzer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import java.io.IOException;
import java.util.Set;

@SpringBootApplication
public class ArticleAnalyzerApplication {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(ArticleAnalyzerApplication.class, args);

		ArticleReaderFromJSON articleReaderFromJSON = context.getBean(ArticleReaderFromJSON.class);
		String content = articleReaderFromJSON.getArticles().get(2).getContent();

		ArticleCategoryAnalyzer analyzer = context.getBean(ArticleCategoryAnalyzer.class);
		Set<String> categories = analyzer.analyzeContent(content);

//		CategoryResultSaver saver = context.getBean(CategoryResultSaver.class);
//		saver.saveCategoriesToJson(categories);

	}
}
