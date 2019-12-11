package org.crossasia.collections.chinatrade;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertXmlToJsonBook {
    public static void main( String[] args ) throws Exception {

        File dir = new File("D:\\RAW-COLLECTIONS\\ChinaTrade&Politics\\NEW_XML\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\RAW-COLLECTIONS\\ChinaTrade&Politics\\books.json"));
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

            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                //String textReplace =  everything.replace("\r\n"," ").replace("\f","");
                String fileName = file.toString();
                //String fileName1 = fileName.replace("/Users/andreybuchmann/Downloads/JOBIK/xml2/", "");

                JSONObject jsonObject = XML.toJSONObject(new String( Files.readAllBytes( Paths.get(fileName))));
                JSONObject dataExport = (JSONObject) jsonObject.get( "dataExport" );
                JSONObject document = (JSONObject) dataExport.get( "document" );

                String id = (String) document.get( "ImageDirectory" ).toString();
                String book_id = (String) document.get( "ImageDirectory" ).toString();
                String identifier = (String) document.get( "Url" ).toString();
                String nodeId = (String) document.get("nodeId").toString();
                StringBuffer sbf5 = new StringBuffer();
                StringBuffer sbf3 = new StringBuffer();
                StringBuffer sbf4 = new StringBuffer();
                String title = (String) document.get( "metatitle" ).toString().replaceAll( "\"","'" );
                String author = (String) document.get( "metaauthor" ).toString();
                String date = (String) document.get( "metadate" ).toString();
                String publication_place = (String) document.get( "metaplaceofpublication" ).toString();
                String publication_name = (String) document.get( "metapublisher" ).toString();
                String description = (String) document.get( "metaadditionalInformation" ).toString().replaceAll( "<p>","" )
                        .replaceAll("</p>",""  )
                        .replaceAll( "<em>","" )
                        .replaceAll( "</em>","" )
                        .replaceAll( "<b>","" )
                        .replaceAll( "</b>","" )
                        .replaceAll( "\"","'" );

                String description2 = (String) document.get( "metadescription" ).toString();
                String medium = (String) document.get( "metadocumenttype" ).toString();
                String keyword = (String) document.get( "metatopics" ).toString();
                String [] keywords = keyword.split( "," );
                if (keywords.length>0) {
                    sbf3.append( keywords [0]);
                    for (int key=1; key<keywords.length; key ++) {
                        sbf3.append("\","+quote).append(keywords[key] ).append("");
                    }
                }
                String source = (String) document.get( "metacopyright" ).toString();
                String source2 = (String) document.get( "metalibrary" ).toString();
                String source3 ="";
                if (source.equals(source2)) {
                    source3 = (String) document.get( "metalibrary" ).toString();
                } else {
                    source3 = source + ","+source2;
                }

                String metageographicalArea = (String) document.get( "metageographicalArea" ).toString();

                String spatial = (String) document.get( "metaplaces" ).toString();
                String [] spatials = spatial.split( "," );
                if (spatials.length>0) {
                    sbf4.append( spatials [0]);
                    for (int sp=1; sp<spatials.length; sp ++) {
                        sbf4.append("\","+quote).append(spatials[sp] ).append( "" );
                    }
                }

                String person = (String) document.get( "metanames" ).toString();
                String [] persons = person.split( "," );
                if (persons.length>0) {
                    sbf5.append( persons [0]);
                    for (int per=1; per<persons.length; per ++) {
                        sbf5.append( " \","+quote).append(persons[per] ).append( "" );
                    }
                }


                out.println("{" + quote + "id" + quote + ":" + quote+ nodeId+"book" + quote + "," + '\n'
                        + quote + "hasModel" + quote + ":" +   quote +"Book" +  quote + "," + '\n'
                        + quote + "nodeId" + quote + ":" +   quote +nodeId +  quote + "," + '\n'
                        + quote + "book_id" + quote + ":" +   quote +book_id.replaceAll(" ", "_") +  quote + "," + '\n'
                        + quote + "identifier" + quote + ":" +   quote +identifier +  quote + "," + '\n'
                        + quote + "title" + quote + ":" +   quote +title +  quote + "," + '\n'
                        + quote + "author" + quote + ":" +   quote +author +  quote + "," + '\n'
                        + quote + "date" + quote + ":" +   quote +date +  quote + "," + '\n'
                        + quote + "publication_place" + quote + ":" +   quote +publication_place +  quote + "," + '\n'
                        + quote + "publication_name" + quote + ":" +   quote +publication_name +  quote + "," + '\n'
                     //   + quote + "edition" + quote + ":"  +"["+ quote +reference+ quote +"," + quote +library+ quote +"]"  + "," + '\n'
                        + quote + "description" + quote + ":" +  "["+ quote +description+ quote +"," + quote +description2+ quote +"]" + "," + '\n'
                        + quote + "medium" + quote + ":"  +"["+ quote +"text"+ quote +"," + quote +"Records (Documents)"+ quote +"," + quote +medium+ quote+"]"  + "," + '\n'
                      //  + quote + "subject" + quote + ":"  +"["+ quote +sbf.toString().replaceAll( " \" ","" )+ quote +"," + quote +sbf2.toString().replaceAll( " ","" )+ quote +"]"  + "," + '\n'
                        + quote + "keywords" + quote + ":" + "["+  quote +sbf3.toString().replaceAll( " \" ","" ) +  quote +"]" +"," + '\n'
                        + quote + "collection" + quote + ":" +   quote +"Adam Matthew - China Trade & Politics" +  quote + "," + '\n'
                        + quote + "source" + quote + ":" +     "["+ quote +source3+ quote +"]" + "," + '\n'
                        + quote + "spatial" + quote + ":" + "["+  quote +sbf4.toString().replaceAll( " \" ","" ) +  quote +"," + quote +metageographicalArea+ quote+"]"+ "," + '\n'
                        + quote + "person" + quote + ":" + "["+  quote +sbf5.toString().replaceAll( " \" ","" )+quote +"]"+ "," + '\n'
                       // + quote + "series_title" + quote + ":" +   quote +series_title +  quote + "," + '\n'
                        //+ quote + "publisher" + quote + ":" +   quote +publisher +  quote + "," + '\n'
                       // + quote + "language" + quote + ":" + "["+  quote +sbf6.toString().replaceAll( " \" ","" ) +  quote +"]"+ "," + '\n'
                       // + quote + "issued" + quote + ":" +   quote +issued +  quote + "" + '\n'
                        //+ quote + "volume_number" + quote + ":" +   quote +volume_number +  quote + "" + '\n'

                        //'\n'
                                +"},"
                );


            } finally {
                br.close();
            }
        }

    }
}
