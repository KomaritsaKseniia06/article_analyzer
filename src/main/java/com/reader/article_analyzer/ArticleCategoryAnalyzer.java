package com.reader.article_analyzer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

@Component
public class ArticleCategoryAnalyzer {
    private final String[] excludedWordsArray;

    public ArticleCategoryAnalyzer(@Value("${excluded.words}") String excludedWords) {
        this.excludedWordsArray = excludedWords.split(", ");
    }

    public Set<String> analyzeContent(String content) throws IOException {
        String[] wordsArray = content.split(" ");
        Map<String, Integer> wordCounts = new HashMap<>();


        for (String word : wordsArray) {
            word = word.toLowerCase();
            if (!isExcludedWord(word)) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }


        Set<String> categories = new HashSet<>();
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() >= 2) {
                categories.add(entry.getKey());

                //saving set of unique categories into categories.json file

                Gson gson = new Gson();
                String gsonString = gson.toJson(categories);
                try (FileWriter fileWriter = new FileWriter("categories.json")) {
                    fileWriter.write(gsonString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return categories;
    }

    private boolean isExcludedWord(String word) {
        for (String excludedWord : excludedWordsArray) {
            if (excludedWord.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }
}
