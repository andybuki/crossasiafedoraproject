package org.crossasia.collections.cndi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class ConvertXmlToJsonBook {
    public static void main( String[] args ) throws Exception {

        File dir = new File("D:\\SOLR-COLLECTIONS\\CNDI\\solr\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CNDI\\solr\\solr_books.json"));
        String bookName = "";
        String page = "";
        String text = "";
        String quote = "\u005c\u0022";
        int year = 0;
        int i;


        for (File file : dir.listFiles()) {
            String encoding = "UTF-8";
            Reader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), encoding));
            BufferedReader br = new BufferedReader(reader);
            JSONParser parser = new JSONParser();

            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();

                String fileName = file.toString();

                Object obj = parser.parse(everything);
                JSONArray object = (JSONArray) obj;

                for (int k=0; k<object.size();k++) {
                    JSONObject book = (JSONObject) object.get(k);

                    String id = (String) book.get("identifier").toString()+"cnki";
                    String identifier = (String) book.get("identifier").toString();
                    String identifier2 = (String) book.get("identifier2").toString();
                    String title = (String) book.get("title");
                    String subject = (String) book.get("subject");
                    String subject2 = (String) book.get("subject2").toString();

                    String titleTranscription="";
                    String titleTranscription2="";
                    String titleTranscription3="";
                    String titleTranscription4="";
                    String titleTranscription5="";

                    if (book.containsKey("titleTranscription")) { titleTranscription = (String) book.get("titleTranscription").toString();}
                    if (book.containsKey("titleTranscription2")) { titleTranscription2 = (String) book.get("titleTranscription2").toString();}
                    if (book.containsKey("titleTranscription3")) { titleTranscription3 = (String) book.get("titleTranscription3").toString();}
                    if (book.containsKey("titleTranscription4")) { titleTranscription4 = (String) book.get("titleTranscription4").toString();}
                    if (book.containsKey("titleTranscription5")) { titleTranscription5 = (String) book.get("titleTranscription5").toString();}

                    String alternative ="";
                    String alternative2 ="";
                    String alternative3 ="";
                    if (book.containsKey("alternative")) { alternative = (String) book.get("alternative").toString();}
                    if (book.containsKey("alternative2")) { alternative2 = (String) book.get("alternative2").toString();}
                    if (book.containsKey("alternative3")) { alternative3 = (String) book.get("alternative3").toString();}

                    String ISBN ="";
                    if (book.containsKey("ISBN")) { ISBN = (String) book.get("ISBN").toString();}

                    String responsibility ="";
                    if (book.containsKey("responsibility")) { responsibility = (String) book.get("responsibility").toString();}

                    String creator="";
                    String creator2="";
                    String creator3="";
                    String creator4="";

                    if (book.containsKey("creator")) { creator = (String) book.get("creator").toString();}
                    if (book.containsKey("creator2")) { creator2 = (String) book.get("creator2").toString();}
                    if (book.containsKey("creator3")) { creator3 = (String) book.get("creator3").toString();}
                    if (book.containsKey("creator4")) { creator4 = (String) book.get("creator4").toString();}

                    String creatorTranscription="";
                    String creatorTranscription2="";
                    String creatorTranscription3="";
                    String creatorTranscription4="";
                    String creatorTranscription5="";
                    String creatorTranscription6="";
                    String creatorTranscription7="";
                    String creatorTranscription8="";

                    if (book.containsKey("creatorTranscription")) { creatorTranscription = (String) book.get("creatorTranscription").toString();}
                    if (book.containsKey("creatorTranscription2")) { creatorTranscription2 = (String) book.get("creatorTranscription2").toString();}
                    if (book.containsKey("creatorTranscription3")) { creatorTranscription3 = (String) book.get("creatorTranscription3").toString();}
                    if (book.containsKey("creatorTranscription4")) { creatorTranscription4 = (String) book.get("creatorTranscription4").toString();}
                    if (book.containsKey("creatorTranscription5")) { creatorTranscription5 = (String) book.get("creatorTranscription5").toString();}
                    if (book.containsKey("creatorTranscription6")) { creatorTranscription6 = (String) book.get("creatorTranscription6").toString();}
                    if (book.containsKey("creatorTranscription7")) { creatorTranscription7 = (String) book.get("creatorTranscription7").toString();}
                    if (book.containsKey("creatorTranscription8")) { creatorTranscription8 = (String) book.get("creatorTranscription8").toString();}

                    String publisher="";
                    if (book.containsKey("publisher")) { publisher = (String) book.get("publisher").toString();}

                    String issued="";
                    if (book.containsKey("issued")) { issued = (String) book.get("issued").toString();}

                    String date="";
                    if (book.containsKey("issued")) { date = (String) book.get("issued").toString().substring(0,4);}

                    String language="";
                    if (book.containsKey("language")) { language = (String) book.get("language").toString();}

                    String genre="";
                    if (book.containsKey("genre")) { genre = (String) book.get("genre").toString();}

                    String physicalDescription="";
                    if (book.containsKey("physicalDescription")) { physicalDescription = (String) book.get("physicalDescription").toString();}

                    String seriesTitle="";
                    if (book.containsKey("seriesTitle")) { seriesTitle = (String) book.get("seriesTitle").toString();}

                    String seriesTitleTranscription="";
                    String seriesTitleTranscription2="";
                    if (book.containsKey("seriesTitleTranscription")) { seriesTitleTranscription = (String) book.get("seriesTitleTranscription").toString();}
                    if (book.containsKey("seriesTitleTranscription2")) { seriesTitleTranscription2 = (String) book.get("seriesTitleTranscription2").toString();}

                out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                        + quote + "hasModel" + quote + ":" + quote + "Book"  + quote + "," + '\n'
                        + quote + "book_id" + quote + ":" +  quote + identifier +  quote + "," + '\n'
                        + quote + "title" + quote + ":" +  quote + title  + quote +"," + '\n'
                        + quote + "subject" + quote + ":" +"["+   quote +  subject + quote  + ","+ quote +subject2 + quote  +"]"+ "," +'\n'
                        + quote + "title_transcription" + quote + ":" +"["+   quote +  titleTranscription + quote  + ","+ quote +titleTranscription2 + quote  + ","+ quote +titleTranscription3 + quote  + ","+ quote +titleTranscription4 + quote  + ","+ quote +titleTranscription5 + quote  +","+ quote +alternative3 + quote  +"]"+ "," +'\n'
                        + quote + "alternative" + quote + ":" +"["+   quote +  alternative + quote  + ","+ quote +alternative2 + quote +"]"+ "," +'\n'
                        + quote + "isbn" + quote + ":" +  quote + ISBN  + quote +"," + '\n'
                        + quote + "responsibility" + quote + ":" +  quote + responsibility  + quote +"," + '\n'
                        + quote + "creator" + quote + ":" +"["+   quote +  creator + quote  + ","+ quote +creator2 + quote  + ","+ quote +creator3 + quote  + ","+ quote +creator4 + quote    +"]"+ "," +'\n'
                        + quote + "creator_transcription" + quote + ":" +"["+   quote +  creatorTranscription + quote  + ","+ quote +creatorTranscription2 + quote  + ","+ quote +creatorTranscription3 + quote  + ","+ quote +creatorTranscription4 + quote  + ","+ quote +creatorTranscription5 + quote  + ","+ quote +creatorTranscription6 + quote + ","+ quote +creatorTranscription7 + quote  + ","+ quote +creatorTranscription8 + quote  + "]"+ "," +'\n'
                        + quote + "publisher" + quote + ":" +  quote + publisher  + quote +"," + '\n'
                        + quote + "issued" + quote + ":" +  quote + issued  + quote +"," + '\n'
                        + quote + "language" + quote + ":" +  quote + language  + quote +"," + '\n'
                        + quote + "physical_description" + quote + ":" +  quote + physicalDescription  + quote +"," + '\n'
                        + quote + "date" + quote + ":" +  quote + date  + quote +"," + '\n'
                        + quote + "series_title" + quote + ":" +  quote + seriesTitle  + quote +"," + '\n'
                        + quote + "series_title_transcription" + quote + ":" +"["+   quote +  seriesTitleTranscription + quote  + ","+ quote +seriesTitleTranscription2 + quote  +"]"+ "," +'\n'
                        + quote + "identifier" + quote + ":" +"["+   quote +  identifier + quote  + ","+ quote +identifier2 + quote  +"]"+ "," + '\n'
                        + quote + "collection" + quote + ":" + quote+  "CNKI_eBooks"  + quote+ "," + '\n'
                        /*

                        + quote + "edition" + quote + ":" +   edition  + "," + '\n'
                        + quote + "note" + quote + ":" +   note  + "," + '\n'
                        + quote + "medium" + quote + ":" +   medium  + "," + '\n'
                        + quote + "spatial" + quote + ":" +   spatial  + "," + '\n'
                        + quote + "thumbnail_path" + quote + ":" +   quote+ thumbnail_path + quote + "," + '\n'*/


                                +"},"
                );
                }

            } finally {
                br.close();
            }
        }

    }
}
