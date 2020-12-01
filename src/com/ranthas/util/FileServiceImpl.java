package com.ranthas.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileServiceImpl implements FileService {

    @Override
    public List<String> readAllLines(String filePath) {

        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            System.err.println("Unhandled error trying to read all lines from " + filePath);
            e.printStackTrace();
        }

        return null;
    }
}
