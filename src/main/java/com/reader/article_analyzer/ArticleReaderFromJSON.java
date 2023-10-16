package com.reader.article_analyzer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

@RestController
public class ArticleReaderFromJSON {

    @GetMapping("/articles.json")
    public List<Article> getArticles() {
        try{
            Resource resource = new ClassPathResource("articles.json");
            InputStreamReader reader = new InputStreamReader(resource.getInputStream());
            Type articleListType = new TypeToken<List<Article>>() {}.getType();
            return new Gson().fromJson(reader, articleListType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
