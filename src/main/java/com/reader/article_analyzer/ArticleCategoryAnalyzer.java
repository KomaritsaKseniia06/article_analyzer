package com.reader.article_analyzer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ArticleCategoryAnalyzer {
    private final String[] excludedWordsArray;

    public ArticleCategoryAnalyzer(@Value("${excluded.words}") String excludedWords) {
        this.excludedWordsArray = excludedWords.split(", ");
    }

    public Set<String> analyzeContent(String content) {
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
