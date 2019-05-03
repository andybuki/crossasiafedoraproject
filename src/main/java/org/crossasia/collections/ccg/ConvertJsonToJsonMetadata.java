package org.crossasia.collections.ccg;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class ConvertJsonToJsonMetadata {

    public static void main(String[] args) {

        try {

            String journal = "D:\\SOLR-COLLECTIONS\\CCG\\books\\ccg4.json";
            PrintStream out = new PrintStream(new FileOutputStream( "D:\\SOLR-COLLECTIONS\\CCG\\books\\books3.json"));
            String quote = "\u005c\u0022";
            JSONArray jsonArray = new JSONArray(new JSONTokener(new FileInputStream(journal)));

            for (int k=0; k<jsonArray.length();k++) {
                JSONObject book = (JSONObject) jsonArray.get(k);

                String id = (String) book.get("id").toString();

                if (id.equals("2242") ||
                        id.equals("2918") ||
                        id.equals("5037") ||
                        id.equals("5059") ||
                        id.equals("5068") ||
                        id.equals("5089") ||
                        id.equals("5100") ||
                        id.equals("5122") ||
                        id.equals("5268") ||
                        id.equals("5347") ||
                        id.equals("5404") ||
                        id.equals("5410") ||
                        id.equals("5420") ||
                        id.equals("5426") ||
                        id.equals("5440") ||
                        id.equals("5442") ||
                        id.equals("5453") ||
                        id.equals("5460") ||
                        id.equals("5468") ||
                        id.equals("5490") ||
                        id.equals("5509") ||
                        id.equals("5515") ||
                        id.equals("5528") ||
                        id.equals("5566") ||
                        id.equals("5605") ||
                        id.equals("5626") ||
                        id.equals("5674") ||
                        id.equals("5686") ||
                        id.equals("5689") ||
                        id.equals("5690") ||
                        id.equals("5694") ||
                        id.equals("5709") ||
                        id.equals("5719") ||
                        id.equals("5724") ||
                        id.equals("5725") ||
                        id.equals("5727") ||
                        id.equals("5981") ||
                        id.equals("5968") ||
                        id.equals("5967") ||
                        id.equals("5959") ||
                        id.equals("5950") ||
                        id.equals("5945") ||
                        id.equals("5935") ||
                        id.equals("5933") ||
                        id.equals("5930") ||
                        id.equals("5925") ||
                        id.equals("5917") ||
                        id.equals("5914") ||
                        id.equals("5908") ||
                        id.equals("5904") ||
                        id.equals("5752") ||
                        id.equals("5762") ||
                        id.equals("5770") ||
                        id.equals("5781") ||
                        id.equals("5782") ||
                        id.equals("5785") ||
                        id.equals("5790") ||
                        id.equals("5790") ||
                        id.equals("5819") ||
                        id.equals("5820") ||
                        id.equals("5823") ||
                        id.equals("5836") ||
                        id.equals("5844") ||
                        id.equals("5851") ||
                        id.equals("5860") ||
                        id.equals("5867") ||
                        id.equals("5879") ||
                        id.equals("5890") ||
                        id.equals("5893") ||
                        id.equals("5894") ||
                        id.equals("5895") ||
                        id.equals("5903")
                ){
                    System.out.println("xa");
                } else {

                    String title = (String) book.get("title").toString();
                    String identifier
                            = (String) book.get("identifier").toString();

                    String bibliographicCitation ="";
                    bibliographicCitation
                            = (String) book.get("bibliographicCitation").toString();

                    String collection
                            = (String) book.get("collection").toString();

                    String responsibility ="";
                    if (book.has("responsibility")) {
                        responsibility = (String) book.get("responsibility").toString();
                    }

                    String creator ="";
                    String creator2 ="";
                    String creator3 ="";
                    String creator4 ="";
                    String creator5 ="";
                    String creator6 ="";


                    if (book.has("creator")) {
                        creator = (String) book.get("creator").toString();
                    }
                    if (book.has("creator2")) {
                        creator2 = (String) book.get("creator2").toString();
                    }
                    if (book.has("creator3")) {
                        creator3 = (String) book.get("creator3").toString();
                    }
                    if (book.has("creator4")) {
                        creator4 = (String) book.get("creator4").toString();
                    }
                    if (book.has("creator5")) {
                        creator5 = (String) book.get("creator5").toString();
                    }
                    if (book.has("creator6")) {
                        creator6 = (String) book.get("creator6").toString();
                    }


                    String date ="";
                    if (book.has("date")) {
                        date = (String) book.get("date").toString();
                    }


                    String edition="";

                    if (book.has("edition")) {
                        edition = (String) book.get("edition").toString();
                    }


                    String subject ="";
                    String subject2 ="";
                    String subject3 ="";

                    if (book.has("subject")) {
                        subject = (String) book.get("subject").toString();
                    }
                    if (book.has("subject2")) {
                        subject2 = (String) book.get("subject2").toString();
                    }
                    if (book.has("subject3")) {
                        subject3 = (String) book.get("subject3").toString();
                    }

                    String temporal ="";
                    String temporal2 ="";
                    String temporal3 ="";
                    if (book.has("temporal")) {
                        temporal = (String) book.get("temporal").toString();
                    }
                    if (book.has("temporal2")) {
                        temporal2 = (String) book.get("temporal2").toString();
                    }
                    if (book.has("temporal3")) {
                        temporal3 = (String) book.get("temporal3").toString();
                    }

                    String spatial ="";

                    if (book.has("spatial")) {
                        spatial = (String) book.get("spatial").toString();
                    }

                    String extent ="";
                    if (book.has("extent")) {
                        extent = (String) book.get("extent").toString();
                    }


                    String format = (String) book.get("format").toString();
                    String schema_url ="";
                    String schema_url2 ="";
                    if (book.has("schema_url")) {
                        schema_url = (String) book.get("schema_url").toString();
                    }
                    if (book.has("schema_url2")) {
                        schema_url2 = (String) book.get("schema_url2").toString();
                    }


                    out.println("{" + quote + "id" + quote + ":" + quote+ id+"_book"+ quote + "," + '\n'
                            + quote + "title" + quote + ":" + quote+ title+ quote + "," + '\n'
                            + quote + "book_id" + quote + ":" + quote+ id+ quote + "," + '\n'
                            + quote + "identifier" + quote + ":" + quote+ identifier+ quote + "," + '\n'
                            + quote + "bibliographicCitation" + quote + ":" + quote+ bibliographicCitation+ quote + "," + '\n'
                            + quote + "collection" + quote + ":" + quote+ collection+ quote + "," + '\n'
                            + quote + "responsibility" + quote + ":" + quote+ responsibility+ quote + "," + '\n'
                            + quote + "author" + quote + ":" +  "["+ quote +creator+ quote +"," + quote +creator2+ quote +","  + quote +creator3+ quote +"," + quote +creator4+ quote+","  + quote +creator5+ quote +"," + quote +creator6+ quote +"]" + "," + '\n'
                            + quote + "date" + quote + ":" + quote+ date+ quote + "," + '\n'
                            + quote + "edition" + quote + ":" + quote+ edition+ quote + "," + '\n'
                            + quote + "subject" + quote + ":" +  "["+ quote +subject+ quote +"," + quote +subject2+ quote +"," + quote +subject3+ quote +"]" + "," + '\n'
                            + quote + "language" + quote + ":" + quote+ "chi"+ quote + "," + '\n'
                            + quote + "temporal" + quote + ":" +  "["+ quote +temporal+ quote +"," + quote +temporal2+ quote+"," + quote +temporal3+ quote +"]" + "," + '\n'
                            + quote + "spatial" + quote + ":" + quote+ spatial+ quote + "," + '\n'
                            + quote + "extent" + quote + ":" + quote+ extent+ quote + "," + '\n'
                            + quote + "format" + quote + ":" + quote+ format+ quote + "," + '\n'
                            + quote + "url" + quote + ":" +  "["+ quote +schema_url+ quote +"," + quote +schema_url2+ quote +"]" + "," + '\n'
                            + quote + "hasModel" + quote + ":" + quote + "Book"  + quote  + '\n'
                            +"},"
                    );

                }


            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}