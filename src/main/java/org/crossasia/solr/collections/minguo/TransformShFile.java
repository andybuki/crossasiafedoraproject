package org.crossasia.solr.collections.minguo;

import java.io.*;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.stream.Stream;

public class TransformShFile {
    public static void main(String[] args) throws IOException {
        File file = new File("/data1/fedora/ajax-minguo/file.sh");
        PrintStream out = new PrintStream(new FileOutputStream("/data1/fedora/ajax-minguo/file2.sh"));

        try (Stream<String> stream = Files.lines(Paths.get("/data1/fedora/ajax-minguo/file.sh"))){
            stream.forEach(System.out::println);
        }

    }
}
