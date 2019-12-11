package org.crossasia.collections.minguo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetFilesRecursive {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("/data3/solr/minguo/Minguo_Nachlieferung.json"));
        Path start = Paths.get("/data3/solr/Minguo_Nachlieferung/");
        String quote = "\u005c\u0022";
        try (Stream<Path> stream = Files.walk(start, Integer.MAX_VALUE)) {
            List<String> collect = stream
                    .map(String::valueOf)
                    .sorted()
                    .collect(Collectors.toList());
            ListIterator<String> iterator = collect.listIterator();
            StringBuilder sb2 = new StringBuilder();
            for (ListIterator<String> it = iterator; it.hasNext(); ) {
                File file = new File(it.next());
                String encoding = "UTF-8";
                if (file.toString().contains(".txt")) {
                    Reader reader = new BufferedReader(new InputStreamReader(
                            new FileInputStream(file), encoding));
                    BufferedReader br = new BufferedReader(reader);

                    try {
                        StringBuilder sb = new StringBuilder();
                        String line = br.readLine();

                        while (line != null) {
                            sb.append(line);
                            //sb.append(System.lineSeparator());
                            line = br.readLine();
                        }
                        String everything = sb.toString().replaceAll("\\r\\n","");
                        String textReplace =  everything.replaceAll("\r\n"," ").replaceAll("\"","")
                                .replaceAll("\\\\","");
                        String fileName = file.toString().replace("/data3/solr/Minguo_Nachlieferung/","").replace(".txt","");
                        String [] spliter = fileName.split(Pattern.quote(File.separator));
                        String book_id = spliter[0];
                        String id = spliter[1];
                        int position = Integer.parseInt(id);

                        out.println("{"
                                + quote + "book_id" + quote + ":" + quote + book_id + quote + "," +  '\n'
                                + quote + "id" + quote + ":" + quote + id + quote + "," +  '\n'
                                + quote + "position" + quote + ":" + quote + position + quote + "," +  '\n'
                                + quote + "hasModel" + quote + ":" + quote + "Page" + quote + "," +  '\n'
                                + quote + "text" + quote + ":" + quote + textReplace + quote + "," + '\n'
                                + quote + "collection" + quote + ":" + quote + "Early Twentieth Century Chinese Books (1912-1949)" + quote + "" +  '\n'

                                +"},"
                        );

                    } finally {
                        br.close();
                    }
                }


            }

            /*while (iterator.hasNext()){
                String s = iterator.next();
                String t = s.replace("F:\\TXT\\","").replace(".txt","");

                iterator.set(t);
            }*/
            //collect.forEach(out::println);
        }


    }
}
