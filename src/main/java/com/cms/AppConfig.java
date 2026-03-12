package com.cms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    String dirToSearch(@Value("${app.dir-to-search}") String dirToSearch) {
        return dirToSearch;
    }

    @Bean
    String fileFilter(@Value("${app.file-filter}") String fileFilter) {
        return fileFilter;
    }

    @Bean
    String wordToSearch(@Value("${app.word-to-search}") String wordToSearch) {
        return wordToSearch;
    }
}
