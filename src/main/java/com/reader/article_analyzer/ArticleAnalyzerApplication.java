package com.reader.article_analyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ArticleAnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleAnalyzerApplication.class, args);
		System.out.println(new ArticleReaderFromJSON().getArticles().get(1).getContent().toString());
	}

}
