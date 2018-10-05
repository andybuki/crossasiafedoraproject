package org.crossasia.collections.airiti_teps;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class JournalAddName2 {

    public static void main(String[] args) {
        try {
            String quote = "\u005c\u0022";
            JSONObject jsonObject;
            String thesis = "D:\\SOLR-COLLECTIONS\\Journal\\Journal_Result.json";
            //String thesis_name = "D:\\SOLR-COLLECTIONS\\Journal\\Journal_Name.json";
            PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\Journal\\Journal_Result2.json"));
            JSONArray thesisObject = new JSONArray(new JSONTokener(new FileInputStream(thesis)));
            //JSONArray thesisNameObject = new JSONArray(new JSONTokener(new FileInputStream(thesis_name)));

            String id="";
            String name="";
            String title="";
            String id_name="";
            String journal_title ="";
            String publication_name ="";
            String volume_number="";
            String date ="";
            String language ="";
            String extent ="";

            String electronic_url ="";

            String author ="";
            String subject ="";
            String description ="";
            String record_timestamp ="";
            String page_range="";
            String DOI_identifier ="";

            for (int i=0; i<thesisObject.length(); i++) {
                JSONObject numerObj = (JSONObject) thesisObject.get(i);
                id = (String) numerObj.get("id").toString();
                title = (String) numerObj.get("title").toString();
                journal_title =(String) numerObj.get("journal-title").toString();
                publication_name=(String) numerObj.get("publication-name").toString();
                volume_number=(String) numerObj.get("volume-number").toString();
                date =(String) numerObj.get("date").toString();
                language =(String) numerObj.get("language").toString();
                page_range =(String) numerObj.get("page-range").toString();
                String [] languages = language.split( ";" );

                StringBuffer sbf = new StringBuffer();
                StringBuffer sbf2 = new StringBuffer();
                StringBuffer sbf3 = new StringBuffer();
                StringBuffer sbf4 = new StringBuffer();
                StringBuffer sbf5 = new StringBuffer();


                if (languages.length>0) {
                    sbf5.append( languages [0]);
                    for (int key=1; key<languages.length; key ++) {
                        sbf5.append("\","+quote).append(languages[key] ).append("");
                    }
                }

                extent =(String) numerObj.get("extent").toString();
                //DOI_identifier = (String) numerObj.get("DOI_identifier").toString();
                if (numerObj.get("DOI_identifier").toString()!=""){
                    DOI_identifier =(String) numerObj.get("DOI_identifier").toString();
                } else {
                    DOI_identifier ="".toString();
                }

                electronic_url =(String) numerObj.get("electronic-url").toString();

                author =(String) numerObj.get("author").toString();
                String [] authors = author.split( ";" );
                if (authors.length>0) {
                    sbf2.append( authors [0]);
                    for (int key=1; key<authors.length; key ++) {
                        sbf2.append("\","+quote).append(authors[key] ).append("");
                    }
                }

                subject =(String) numerObj.get("subject").toString();
                String [] subjects = subject.split( ";" );
                if (subjects.length>0) {
                    sbf.append( subjects [0]);
                    for (int key=1; key<subjects.length; key ++) {
                        sbf.append("\","+quote).append(subjects[key] ).append("");
                    }
                }


                description =(String) numerObj.get("description").toString();
                String [] descriptions = description.split( ";" );
                if (descriptions.length>0) {
                    sbf4.append( descriptions [0]);
                    for (int key=1; key<descriptions.length; key ++) {
                        sbf4.append("\","+quote).append(descriptions[key] ).append("");
                    }
                }

                record_timestamp =(String) numerObj.get("record_timestamp").toString();


                        out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                                + quote + "collection" + quote + ":" +   quote +"airiti TEPS (臺灣電子期刊)" +  quote + "," + '\n'
                                + quote + "hasModel" + quote + ":" +   quote +"Article" +  quote + "," + '\n'
                                + quote + "medium" + quote + ":" +   quote +"article" +  quote + "," + '\n'
                                + quote + "journal-title" + quote + ":" +   quote +journal_title + quote + "," + '\n'
                                + quote + "publication-name" + quote + ":" +   quote +publication_name +  quote + "," + '\n'
                                + quote + "volume-number" + quote + ":" +   quote +volume_number +  quote + "," + '\n'
                                + quote + "date" + quote + ":" +quote+date+ quote+","+'\n'
                                + quote + "title" + quote + ":" +   quote +title+" : "+ name +  quote + "," + '\n'
                                + quote + "language" + quote + ":" +    sbf5.toString().replaceAll( " \" ","" )  + "," + '\n'
                                + quote + "page-range" + quote + ":" +   quote +page_range +  quote + "," + '\n'
                                + quote + "extent" + quote + ":" +   quote +extent +   quote + "," + '\n'
                                + quote + "DOI_identifier" + quote + ":" +   quote +DOI_identifier +  quote + "," + '\n'
                                + quote + "electronic-url" + quote + ":" +   quote +electronic_url +  quote + "," + '\n'
                                + quote + "author" + quote + ":" +   sbf2.toString().replaceAll( " \" ","" )  + "," + '\n'
                                + quote + "subject" + quote + ":" +    sbf.toString().replaceAll( " \" ","" ) + "," + '\n'
                                + quote + "description" + quote + ":" +    sbf4.toString().replaceAll( " \" ","" ).replaceAll("[\r\n]+", " ").replaceAll(quote+","+quote,"")+ "," + '\n'
                                + quote + "record_timestamp" + quote + ":" +   quote + record_timestamp +  quote + "" + '\n'
                                +"},"
                        );

                }


        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
