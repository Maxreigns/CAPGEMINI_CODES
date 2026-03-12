package com.cms;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class WordCounter {

    private final String wordToSearch;
    private final FileListProvider fileListProvider;

    public WordCounter(@Qualifier("wordToSearch") String wordToSearch, FileListProvider fileListProvider) {
        this.wordToSearch = wordToSearch;
        this.fileListProvider = fileListProvider;
    }

    public Map<String, Integer> createMapResult() {
        Map<String, Integer> result = new LinkedHashMap<>();
        List<Path> files = fileListProvider.getFiles();

        for (Path file : files) {
            result.put(file.getFileName().toString(), countWordInFile(file));
        }

        return result;
    }

    private int countWordInFile(Path file) {
        try {
            String content = Files.readString(file);
            return countOccurrences(content, wordToSearch);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file: " + file, e);
        }
    }

    private int countOccurrences(String content, String word) {
        int count = 0;
        int index = 0;

        while ((index = content.indexOf(word, index)) != -1) {
            count++;
            index = index + word.length();
        }

        return count;
    }
}
