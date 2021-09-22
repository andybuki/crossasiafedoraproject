package org.crossasia.solr.collections.chinaamericapacific;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConvertXmlToJsonBook {
    public static void main( String[] args ) throws Exception {

        File dir = new File("D:\\RAW-COLLECTIONS\\ChinaAmericaPacific\\xml2\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\RAW-COLLECTIONS\\ChinaAmericaPacific\\fedora_books.json"));
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
                String title = (String) document.get( "Title" ).toString().replaceAll( "\"","'" );
                String author = (String) document.get( "AuthorCreator" ).toString();
                String date = (String) document.get( "Date" ).toString();
                String publication_place = (String) document.get( "PlaceofPublication" ).toString();
                String publication_name = (String) document.get( "Publisher" ).toString();
                String reference = (String) document.get( "Reference" ).toString().replaceAll( "\"","'" );
                String library = (String) document.get( "Library" ).toString().replaceAll( "\"","'" );

                String company = (String) document.get( "Company" ).toString();
                String ships = (String) document.get( "Ships" ).toString();
                String ports = (String) document.get( "Ports" ).toString();
                String description = (String) document.get( "Description" ).toString().replaceAll( "<p>","" )
                        .replaceAll("</p>",""  )
                        .replaceAll( "<em>","" )
                        .replaceAll( "</em>","" )
                        .replaceAll( "<b>","" )
                        .replaceAll( "</b>","" )
                        .replaceAll( "\"","'" );
                String additionalInformation = (String) document.get( "AdditionalInformation" ).toString()
                        .replaceAll( "<p>","" )
                        .replaceAll("</p>",""  )
                        .replaceAll( "<em>","" )
                        .replaceAll( "</em>","" )
                        .replaceAll( "<b>","" )
                        .replaceAll( "</b>","" )
                        .replaceAll( "\"","'" );

                String medium = (String) document.get( "DocumentType" ).toString();

                String country= (String) document.get( "Countries" );
                String [] countries = country.split( ";" );
                StringBuffer sbf = new StringBuffer();
                StringBuffer sbf2 = new StringBuffer();
                StringBuffer sbf3 = new StringBuffer();
                StringBuffer sbf4 = new StringBuffer();
                StringBuffer sbf5 = new StringBuffer();
                StringBuffer sbf6 = new StringBuffer();

                if (countries.length>0) {
                    sbf.append(countries[0]);
                    for (int con =1;con<countries.length; con++ ) {
                        sbf.append(" \","+quote).append(countries[con]).append( "" );
                    }
                }


                String theme = (String) document.get( "Theme" ).toString();
                String [] themes = theme.split( ";" );
                if (themes.length>0) {
                    sbf2.append( themes [0]);
                    for (int the=1; the<themes.length; the ++) {
                        sbf2.append( " \","+quote).append(themes[the] ).append( "" );
                    }
                }

                String keyword = (String) document.get( "Keywords" ).toString();
                String [] keywords = keyword.split( "," );
                if (keywords.length>0) {
                    sbf3.append( keywords [0]);
                    for (int key=1; key<keywords.length; key ++) {
                        sbf3.append("\","+quote).append(keywords[key] ).append("");
                    }
                }
                String source = (String) document.get( "Copyright" ).toString();

                String spatial = (String) document.get( "Places" ).toString();
                String [] spatials = spatial.split( ";" );
                if (spatials.length>0) {
                    sbf4.append( spatials [0]);
                    for (int sp=1; sp<spatials.length; sp ++) {
                        sbf4.append("\","+quote).append(spatials[sp] ).append( "" );
                    }
                }

                String person = (String) document.get( "People" ).toString();
                String [] persons = person.split( ";" );
                if (persons.length>0) {
                    sbf5.append( persons [0]);
                    for (int per=1; per<persons.length; per ++) {
                        sbf5.append( " \","+quote).append(persons[per] ).append( "" );
                    }
                }
                String series_title = (String) document.get( "Collection" ).toString();
                //String publisher = (String) document.get( "Office" ).toString();

                String language = (String) document.get( "Language" ).toString()
                        .replace( "French","fra" )
                        .replace( "English","eng" )
                        .replace( "Swedish","swe" )
                        .replace( "Dutch","dut" )
                        .replace( "Spanish","spa" )
                        .replace( "Chinese","chi" )
                        .replace( "Portuguese","pot" )
                        .replace( "Hawaiian","haw" )
                        .replace( "Russian","rus" )
                        .replace( "German","ger" );;//.replace( "","eng" );
                if (language==""){
                    language="eng";
                }

                String [] languages = language.split( "," );
                if (languages.length>0) {
                    sbf6.append( languages [0]);
                    for (int lang=1; lang<languages.length; lang ++) {
                        sbf6.append( " \","+quote).append(languages[lang] ).append( "" );
                    }
                }

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
                        + quote + "publication_place" + quote + ":" +   quote +publication_place +  quote + "," + '\n'
                        + quote + "edition" + quote + ":"  +"["+ quote +reference+ quote +"," + quote +library+ quote +"]"  + "," + '\n'
                        + quote + "description" + quote + ":" +  "["+ quote +"Company: " + company +  quote+ "," + quote +"Ships: " + ships +  quote+"," + quote +"Ports: " + ports +  quote+"," + quote +description+ quote +"," + quote +additionalInformation+ quote +"]" + "," + '\n'
                        + quote + "medium" + quote + ":"  +"["+ quote +"text"+ quote +"," + quote +"Records (Documents)"+ quote +"," + quote +medium+ quote+"]"  + "," + '\n'
                        + quote + "subject" + quote + ":"  +"["+ quote +sbf.toString().replaceAll( " \" ","" )+ quote +"," + quote +sbf2.toString().replaceAll( " ","" )+ quote +"]"  + "," + '\n'
                        + quote + "keywords" + quote + ":" + "["+  quote +sbf3.toString().replaceAll( " \" ","" ) +  quote +"]" +"," + '\n'
                        + quote + "collection" + quote + ":" +   quote +"Adam Matthew - China America Pacific" +  quote + "," + '\n'
                        + quote + "source" + quote + ":" +   quote +source +  quote + "," + '\n'
                        + quote + "spatial" + quote + ":" + "["+  quote +sbf4.toString().replaceAll( " \" ","" ) +  quote +"]"+ "," + '\n'
                        + quote + "person" + quote + ":" + "["+  quote +sbf5.toString().replaceAll( " \" ","" ) +  quote +"]"+ "," + '\n'
                        + quote + "series_title" + quote + ":" +   quote +series_title +  quote + "," + '\n'
                        //+ quote + "publisher" + quote + ":" +   quote +publisher +  quote + "," + '\n'
                        + quote + "language" + quote + ":" + "["+  quote +sbf6.toString().replaceAll( " \" ","" ) +  quote +"]"+ "," + '\n'
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
