package com.example.lab8point2;

import java.io.PrintStream;

public interface IModuleFile {
    boolean isSupported(String path);
    String getDescription();
    void execute(String path, PrintStream stream);
}