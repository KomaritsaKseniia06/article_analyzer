package com.reader.article_analyzer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ArticleCategoryAnalyzer {
    private final String[] excludedWordsArray;

    public ArticleCategoryAnalyzer(@Value("${excluded.words}") String excludedWords) {
        this.excludedWordsArray = excludedWords.split(", ");
    }

    public Set<String> analyzeContent(String content) {
        String[] wordsArray = content.split(" ");
        HashSet<String> categories = new HashSet<>();
        int maxCount = 0;

        for (int i = 0; i < wordsArray.length; i++) {
            int count = 0;
            boolean skipWord = false;

            for (String excludedWord : excludedWordsArray) {
                if (wordsArray[i].equalsIgnoreCase(excludedWord)) {
                    skipWord = true;
                    break;
                }
            }

            if (skipWord) {
                continue;
            }

            for (int j = i + 1; j < wordsArray.length; j++) {
                if (wordsArray[j].equalsIgnoreCase(wordsArray[i])) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                categories.clear();
                categories.add(wordsArray[i]);
            } else if (count == maxCount) {
                categories.add(wordsArray[i]);
            }
        }

        return categories;
    }
}
