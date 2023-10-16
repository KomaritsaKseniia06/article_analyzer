//package com.reader.article_analyzer;
//
//import com.google.gson.Gson;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Set;
//
//@Component
//public class CategoryResultSaver {
//    ArticleCategoryAnalyzer analyzer;
//    @Autowired
//    public CategoryResultSaver(ArticleCategoryAnalyzer analyzer) {
//        this.analyzer = analyzer;
//    }
//    @Value("${categories.json.path}")
//    private String categoriesJsonPath;
//
//    public void saveCategoriesToJson(Set<String> uniqueCategories) {
//        try (FileWriter fileWriter = new FileWriter(categoriesJsonPath)) {
//            // Create a Gson instance
//            Gson gson = new Gson();
//            // Convert the set of unique categories to JSON
//            String json = gson.toJson(uniqueCategories);
//            // Write the JSON to the file
//            fileWriter.write(json);
//        } catch (IOException e) {
//            e.printStackTrace(); // Handle IO exceptions
//        }
//    }
//}
