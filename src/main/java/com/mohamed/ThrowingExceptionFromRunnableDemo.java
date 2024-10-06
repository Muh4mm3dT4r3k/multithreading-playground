package com.mohamed;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ThrowingExceptionFromRunnableDemo {
    public static void main(String[] args) {
        var t1 = new Thread(() -> {
            try {
                Files.readString(Paths.get("none-existing-path"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
    }

}
