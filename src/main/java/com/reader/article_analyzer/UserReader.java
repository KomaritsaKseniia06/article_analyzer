package com.reader.article_analyzer;

import com.reader.article_analyzer.Model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserReader {
    private final JsonFileService jsonFileService;

    public UserReader(JsonFileService jsonFileService) {
        this.jsonFileService = jsonFileService;
    }

    public List<User> userReader(){
        return jsonFileService.readJsonFile("users.json", User.class);
    }
}
