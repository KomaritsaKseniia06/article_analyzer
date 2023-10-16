package com.reader.article_analyzer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import java.util.Set;

@SpringBootApplication
public class ArticleAnalyzerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ArticleAnalyzerApplication.class, args);

		ArticleReaderFromJSON articleReaderFromJSON = context.getBean(ArticleReaderFromJSON.class);
		String content = articleReaderFromJSON.getArticles().get(1).getContent();

		ArticleCategoryAnalyzer analyzer = context.getBean(ArticleCategoryAnalyzer.class);
		Set<String> categories = analyzer.analyzeContent(content);
		categories.stream().forEach(category -> System.out.println(category));

		// Now you can work with the 'categories' result from the analyzer
	}
}
