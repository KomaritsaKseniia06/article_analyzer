package com.reader.article_analyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;


@SpringBootApplication
public class ArticleAnalyzerApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(ArticleAnalyzerApplication.class, args);

        Analyzer analyzer = context.getBean(Analyzer.class);
        analyzer.analyze();

    }
}
