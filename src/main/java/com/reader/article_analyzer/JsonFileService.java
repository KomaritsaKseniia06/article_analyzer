package com.reader.article_analyzer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

@Service
public class JsonFileService {

    public JsonFileService(ArticleCategoryAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    @Autowired
    ArticleCategoryAnalyzer analyzer;
    public <T> List<T> readJsonFile(String filePath, Class<T> classOfT) {
        try {
            Resource resource = new ClassPathResource(filePath); // Convert filePath to a string
            InputStreamReader reader = new InputStreamReader(resource.getInputStream());
            Type type = TypeToken.getParameterized(List.class, classOfT).getType();
            return new Gson().fromJson(reader, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> void writeJsonFile( Set<T> list) {
        Gson gson = new Gson();
        String gsonString = gson.toJson(list);
        try (FileWriter fileWriter = new FileWriter("categories.json")) {
          fileWriter.write(gsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
