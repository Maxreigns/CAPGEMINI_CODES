package com.cms;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileListProvider {

    private final String dirToSearch;
    private final String fileFilter;

    public FileListProvider(@Qualifier("dirToSearch") String dirToSearch,
                            @Qualifier("fileFilter") String fileFilter) {
        this.dirToSearch = dirToSearch;
        this.fileFilter = fileFilter;
    }

    public List<Path> getFiles() {
        List<Path> files = new ArrayList<>();
        Path folderPath = Paths.get(dirToSearch);

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(folderPath, fileFilter)) {
            for (Path path : stream) {
                if (Files.isRegularFile(path)) {
                    files.add(path);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to read files from folder: " + dirToSearch, e);
        }

        return files;
    }
}
