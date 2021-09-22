package org.crossasia.solr.collections.reminrebao;
import java.io.*;

public class ConvertJsonToJsonLd {
    public static void main( String[] args ) throws Exception {

        File dir = new File("D:\\RAW-COLLECTIONS\\REMIN_REBAO\\json\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\RAW-COLLECTIONS\\REMIN_REBAO\\jsonDone\\1946-1950.json"));
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
                String textReplace =  everything.replace("\r\n"," ").replace("\f","");
                String fileName = file.toString();
                String fileName1 = fileName.replace("D:\\RAW-COLLECTIONS\\REMIN_REBAO\\json\\", "");
                String fileName2 = fileName1.replace(".json", "");
                String[] parts = fileName2.split("_");
                String pageNumber = parts[0];
                //year = Integer.parseInt(pageNumber);
                //bookName = parts[2];

                String [] splitter = everything.split("\\r\n");


                out.println(" \"@context\": {\n" +
                        "        \"fedora\": \"http://fedora.info/definitions/v4/2016/10/18/repository#\",\n" +
                        "        \"pcdm\": \"http://pcdm.org/models#\",\n" +
                        "        \"book_id\": \"http://schema.org/dc:identifier\",\n" +
                        "        \"position\": \"http://schema.org/position\",\n" +
                        "        \"text\": \"http://schema.org/text\",\n" +
                        "        \"dc\": \"http://purl.org/dc/elements/1.1/\",\n" +
                        "        \"dcndl\":\"http://ndl.go.jp/dcndl/terms\",\n" +
                        "        \"schema\":\"http://schema.org/\",\n" +
                        "        \"dcterms\":\"http://purl.org/dc/terms/\"\n" +
                        "\n" +
                        "    }," +
                        "{" + quote + "id" + quote + ":" + quote + fileName2+"_rmrb" + quote + "," + '\n'
                        + quote + "title" + quote + ":" + quote + title + quote + "," + '\n'
                        + quote + "author" + quote + ":" + quote + author + quote + "," + '\n'
                        + quote + "hasModel" + quote + ":" +   quote +"Article" +  quote + "," + '\n'
                        + quote + "collection" + quote + ":" +   quote +"Renmin Ribao" +  quote + "," + '\n'
                        + quote + "wholeDate" + quote + ":" +quote + wholeDate+"T00:00:00Z" +  quote+ "," + '\n'
                        //+ quote + "date" + quote + ":" +quote + wholeDate.substring(0,4) +  quote+ "," + '\n'
                        + quote + "description" + quote + ":" +  "["+ quote +column +  quote + "," + quote +edition_name +  quote +"],"+ '\n'
                        + quote + "page" + quote + ":"  + edition +  "," + '\n'
                        + quote + "medium" + quote + ":" +  "["+ quote +"article" +  quote + "," + quote +"electronic" +  quote +"],"+ '\n'
                        + quote + "language" + quote + ":" +   quote +"chi" +  quote + "," + '\n'+"},"
                        //+ quote + "text" + quote + ":" + quote + fullText + quote  + '\n'+"},"
                );


            } finally {
                br.close();
            }
        }

    }
}
