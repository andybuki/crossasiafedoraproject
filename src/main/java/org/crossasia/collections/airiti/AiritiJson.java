package org.crossasia.collections.airiti;

import java.io.*;

public class AiritiJson {

    public static void main( String[] args ) throws Exception {

        File dir = new File("H:\\airiti\\books\\");
        PrintStream out = new PrintStream(new FileOutputStream("H:\\airiti\\airiti6.json"));
        String bookName = "";
        String page = "";
        String text = "";
        String quote = "\u005c\u0022";

        for (File file : dir.listFiles()) {
            String encoding = "UTF-8";
            Reader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), encoding));
            BufferedReader br = new BufferedReader(new FileReader(file));

            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                String textReplace =  everything.replace("\r\n"," ").replace("\f","");
                String fileName = file.toString();
                String fileName1 = fileName.replace("H:\\airiti\\books\\", "");
                String fileName2 = fileName1.replace(".txt", "");
                String[] parts = fileName2.split("_");
                String pageNumber = parts[0];
                bookName = parts[2];
                //String str[] = new String[sb2.length];

                /*out.println("{" + quote + "id" + quote + ":" + quote + pageNumber + "_" + bookName + quote + "," + '\n'
                        + quote + "book_id" + quote + ":" + quote + bookName + quote + "," + '\n'
                        + quote + "position" + quote + ":" + pageNumber + "," + '\n' + quote + "text" + quote + ":" + "["
                );*/

                out.println("{" + quote + "id" + quote + ":" + quote + pageNumber + "_" + bookName + quote + "," + '\n'
                        + quote + "book_id" + quote + ":" + quote + bookName + quote + "," + '\n'
                        + quote + "position" + quote + ":" + pageNumber + "," + '\n' + quote + "text" + quote + ":" + quote + textReplace + quote + "},"
                );


                /*for (int i = 0; i < sb2.length; i++) {
                    str[i] = sb2[i].toString();
                    out.println(
                            "" + quote + str[i] + quote + ",");
                }*/


            } finally {
                br.close();
            }
        }
    }

}
