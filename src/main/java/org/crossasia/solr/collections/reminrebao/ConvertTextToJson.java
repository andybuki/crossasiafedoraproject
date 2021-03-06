package org.crossasia.solr.collections.reminrebao;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConvertTextToJson {
    public static void main( String[] args ) throws Exception {

        File dir = new File("D:\\RAW-COLLECTIONS\\REMIN_REBAO\\rem\\rem.tar\\REM_REB\\new\\2007-2009NEW\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\RAW-COLLECTIONS\\REMIN_REBAO\\json\\2007-2009.json"));
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
                String fileName1 = fileName.replace("D:\\RAW-COLLECTIONS\\REMIN_REBAO\\rem\\rem.tar\\REM_REB\\new\\2007-2009NEW\\", "");
                String fileName2 = fileName1.replace(".txt", "");
                String[] parts = fileName2.split("_");
                String pageNumber = parts[0];
                year = Integer.parseInt(pageNumber);
                //bookName = parts[2];

                String [] splitter = everything.split("\\r\n");

                String t =splitter[1];
                if (t!="") {
                    title = t.replaceAll("?????????", "");
                }
                String a =splitter[2];
                if (a!="") {
                    author = a.replaceAll("?????????", "");
                }
                String d =splitter[3];
                if (d!="") {
                    date = d.replaceAll("?????????", "");
                    //String [] partsDate = date.split(".");
                    //year = Integer.parseInt(partsDate[2]);
                    wholeDate = d.replaceAll("?????????", "").replace(".","-");
                }
                String e =splitter[4];
                if (e!=""){
                    edition = e.replaceAll("?????????", "");
                }
                String em =splitter[5];
                if (em!="") {
                    edition_name = em.replaceAll("?????????", "");
                }
                String c =splitter[6];
                if (c!=""){
                    column = c.replaceAll("?????????", "");
                }

                String te =  splitter[7];
                List<String> list = new ArrayList<String>(Arrays.asList(splitter));

                for (Iterator<String> iter = list.listIterator(); iter.hasNext(); ) {
                    String listString = iter.next();
                    if (listString.contains("?????????")||
                            listString.contains("?????????")||
                                listString.contains("?????????") ||
                                    listString.contains("?????????")||
                                        listString.contains("?????????")||
                                            listString.contains("?????????")

                            )
                    {
                        iter.remove();
                    }
                }



                /*list.remove("?????????");
                list.remove("?????????");
                list.remove("?????????");
                list.remove("?????????");
                list.remove("?????????");
                list.remove("?????????");
                list.remove(6);
                splitter = list.toArray(new String[0]);*/


                String fullText = String.join("",list );
                if (te!=""){

                    fullText = fullText.replaceAll("?????????", "");
                }

                out.println("{" + quote + "id" + quote + ":" + quote + fileName2+"_rmrb" + quote + "," + '\n'
                        + quote + "title" + quote + ":" + quote + title + quote + "," + '\n'
                        + quote + "author" + quote + ":" + quote + author + quote + "," + '\n'
                        + quote + "hasModel" + quote + ":" +   quote +"Article" +  quote + "," + '\n'
                        + quote + "collection" + quote + ":" +   quote +"Renmin Ribao" +  quote + "," + '\n'
                        + quote + "wholeDate" + quote + ":" +quote + wholeDate+"T00:00:00Z" +  quote+ "," + '\n'
                        + quote + "date" + quote + ":" +quote + wholeDate.substring(0,4) +  quote+ "," + '\n'
                        + quote + "description" + quote + ":" +  "["+ quote +column +  quote + "," + quote +edition_name +  quote +"],"+ '\n'
                        + quote + "page" + quote + ":"  + edition +  "," + '\n'
                        + quote + "medium" + quote + ":" +  "["+ quote +"article" +  quote + "," + quote +"electronic" +  quote +"],"+ '\n'
                        + quote + "language" + quote + ":" +   quote +"chi" +  quote + "," + '\n'
                        + quote + "text" + quote + ":" + quote + fullText + quote  + '\n'+"},"
                );


            } finally {
                br.close();
            }
        }

    }
}
