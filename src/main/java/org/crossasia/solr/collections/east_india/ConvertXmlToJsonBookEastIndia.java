package org.crossasia.solr.collections.east_india;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertXmlToJsonBookEastIndia {
    public static void main( String[] args ) throws Exception {

        File dir = new File("/data/solr/ajax_amd_as_japan/");
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/ajax_amd_as_japan.json"));
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

                String id = (String) document.get( "nodeId" ).toString();
                String book_id = (String) document.get( "ImageDirectory" ).toString();
                String identifier = (String) document.get( "Url" ).toString();
                String title = (String) document.get( "Title" ).toString().replace("\"", "");
                String copyright = (String) document.get( "Copyright" ).toString();
                String author = (String) document.get( "Author" ).toString();
                String date = (String) document.get( "Date" ).toString();
                String publication_place = (String) document.get( "PlaceofPublication" ).toString();
                String publication_name = (String) document.get( "Publisher" ).toString();
                String reference = (String) document.get( "Reference" ).toString();
                //String library = (String) document.get( "Library" ).toString();

                String searchableDate = (String) document.get( "SearchableDate" ).toString();

                String publisher = (String) document.get( "Publisher" ).toString();
                String source = (String) document.get( "Source" ).toString();
                String notes = (String) document.get( "Notes" ).toString().replace("\"", "");;

                String duration = (String) document.get( "Duration" ).toString();
                String places = (String) document.get( "Places" ).toString();
                String topics = (String) document.get( "Topics" ).toString();
                String subject = (String) document.get( "Themes" ).toString();


                String firstLine = (String) document.get( "FirstLine" ).toString();
                String issueNumber = (String) document.get( "IssueNumber" ).toString();
                String volumeNumber = (String) document.get( "VolumeNumber" ).toString();
                String printedBy = (String) document.get( "PrintedBy" ).toString();
                String language = (String) document.get( "Language" ).toString();
                String physicalCharacteristics = (String) document.get( "PhysicalCharacteristics" ).toString();
                String organisations = (String) document.get( "Organisations" ).toString();
                String people = (String) document.get( "People" ).toString();

                String description = (String) document.get( "Description" ).toString();


                String medium = (String) document.get( "DocumentType" ).toString();





                String series_title = (String) document.get( "Collection" ).toString();
                //String publisher = (String) document.get( "Office" ).toString();



                String issued = (String) document.get( "SearchableDate" ).toString();
                //String volume_number = (String) document.get( "IssueNumber" ).toString();



                out.println("{" + quote + "id" + quote + ":" + quote+ id+"book" + quote + "," + '\n'
                        + quote + "hasModel" + quote + ":" +   quote +"Book" +  quote + "," + '\n'
                        + quote + "nodeId" + quote + ":" +   quote +id +  quote + "," + '\n'
                        + quote + "book_id" + quote + ":" +   quote +book_id +  quote + "," + '\n'
                        + quote + "identifier" + quote + ":" +   quote +identifier +  quote + "," + '\n'
                        + quote + "title" + quote + ":" +   quote +title +  quote + "," + '\n'
                        + quote + "author" + quote + ":" +   quote +author +  quote + "," + '\n'
                        + quote + "date" + quote + ":" +   quote +date +  quote + "," + '\n'
                        + quote + "description" + quote + ":" +   quote +notes +  quote + "," + '\n'
                        + quote + "publication_place" + quote + ":" +   quote +publication_place +  quote + "," + '\n'
                        + quote + "medium" + quote + ":" +   quote +medium +  quote + "," + '\n'
                        + quote + "subject" + quote + ":" +   quote +subject +  quote + "," + '\n'
                        + quote + "edition" + quote + ":" +   quote +reference +  quote + "," + '\n'
                        //+ quote + "edition" + quote + ":"  +"["+ quote +reference+ quote +"," + quote +library+ quote +"]"  + "," + '\n'
                        //+ quote + "description" + quote + ":" +  "["+ quote +"Company: " + company +  quote+ "," + quote +"Ships: " + ships +  quote+"," + quote +"Ports: " + ports +  quote+"," + quote +description+ quote +"," + quote +additionalInformation+ quote +"]" + "," + '\n'
                        //+ quote + "medium" + quote + ":"  +"["+ quote +"text"+ quote +"," + quote +"Records (Documents)"+ quote +"," + quote +medium+ quote+"]"  + "," + '\n'
                        //+ quote + "subject" + quote + ":"  +"["+ quote +sbf.toString().replaceAll( " \" ","" )+ quote +"," + quote +sbf2.toString().replaceAll( " ","" )+ quote +"]"  + "," + '\n'
                        //+ quote + "keywords" + quote + ":" + "["+  quote +sbf3.toString().replaceAll( " \" ","" ) +  quote +"]" +"," + '\n'
                        + quote + "collection" + quote + ":" +   quote +"East India" +  quote + "," + '\n'
                        + quote + "source" + quote + ":" +   quote +copyright +  quote + "," + '\n'
                        + quote + "keywords" + quote + ":" +   quote +topics +  quote + "," + '\n'
                        + quote + "person" + quote + ":" +   quote +people +  quote + "," + '\n'
                        + quote + "spatial" + quote + ":" +   quote +places +  quote + "," + '\n'
                        //+ quote + "spatial" + quote + ":" + "["+  quote +sbf4.toString().replaceAll( " \" ","" ) +  quote +"]"+ "," + '\n'
                        //+ quote + "person" + quote + ":" + "["+  quote +sbf5.toString().replaceAll( " \" ","" ) +  quote +"]"+ "," + '\n'
                        + quote + "series_title" + quote + ":" +   quote +series_title +  quote + "," + '\n'
                        + quote + "publication_name" + quote + ":" +   quote +publisher +  quote + "," + '\n'
                        //+ quote + "language" + quote + ":" + "["+  quote +sbf6.toString().replaceAll( " \" ","" ) +  quote +"]"+ "," + '\n'
                        + quote + "issued" + quote + ":" +   quote +issued +  quote + "" + '\n'
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
