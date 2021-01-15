package org.crossasia.collections.brill_jpco;
import java.io.*;

public class ConvertTextToJson {
    public static void main( String[] args ) throws Exception {

        File dir = new File("/data/solr/OLD/ajax-brill-jpco/txt/");
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/OLD/ajax-brill-jpco/txt/page.json"));
        String bookName = "";
        String page = "";
        String text = "";
        String quote = "\u005c\u0022";
        int year = 0;
        String title= "";
        String author= "";
        String date= "";
        String wholeDate= "";
        String edition= "";
        String edition_name= "";
        String column= "";
        String textChina= "";


        for (File file : dir.listFiles()) {
            String encoding = "UTF-8";
            Reader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), encoding));
            BufferedReader br = new BufferedReader(reader);

            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                String textReplace =  everything.
                        replaceAll("\r\n"," ").
                        replace("\f","").
                        replace("\"","").
                        replaceAll("\"","").
                        replaceAll("\r*\n*","").
                        replaceAll("  "," ").
                        replaceAll("\\s+"," ");
                String fileName = file.toString();
                String fileName1 = fileName.replace("/data/solr/OLD/ajax-brill-jpco/txt/", "");
                String fileName2 = fileName1.replace(".txt", "");
                String parts = fileName2.split("/")[fileName2.split("/").length-1];

                //String pageNumber = parts[0];
                //year = Integer.parseInt(pageNumber);
                //bookName = parts[2];

                // String [] splitter = everything.split("\\r\n");

                out.println("{" + quote + "id" + quote + ":" + quote + parts + quote + "," + '\n'
                        + quote + "text" + quote + ":" + quote + textReplace + quote  + '\n'+"},"
                );


            } finally {
                br.close();
            }
        }

    }
}
