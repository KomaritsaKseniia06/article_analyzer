package com.reader.article_analyzer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

@Service
public class JsonFileService {
    private final Gson gson;
    public JsonFileService(Gson gson) {
        this.gson = gson;
    }

    public <T> List<T> readJsonFile(String filePath, Class<T> classOfT) {
        try {
            Resource resource = new ClassPathResource(filePath);
            InputStreamReader reader = new InputStreamReader(resource.getInputStream());
            Type type = TypeToken.getParameterized(List.class, classOfT).getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> void writeJsonFile(List<Set<String>> list) {
        String gsonString = gson.toJson(list);
        try (FileWriter fileWriter = new FileWriter("categories.json")) {
            fileWriter.write(gsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
