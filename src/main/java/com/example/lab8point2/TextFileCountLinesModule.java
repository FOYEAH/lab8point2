package com.example.lab8point2;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

@Component
public class TextFileCountLinesModule implements IModuleFile {

    @Override
    public boolean isSupported(String path) {
        return path != null && path.endsWith("txt");
    }

    @Override
    public String getDescription() {
        return "Считает количество строк в файле";
    }

    @Override
    public void execute(String path, PrintStream stream) {
        try {
            if(!isSupported(path)) {
                throw new UnsupportedOperationException();
            }

            Stream<String> stringStream = Files.lines(Paths.get(path));
            Scanner scanner = new Scanner(new File(path));

            int lines = 0;
            while(scanner.hasNextLine() && (scanner.nextLine() != null)) {
                lines++;
            }

            stream.println("Файл содержит " + lines + " строк");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}