package org.crossasia.collections.airiti_teps;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Journal {
    public static void main( String[] args ) throws Exception {

        File dir = new File("D:\\SOLR-COLLECTIONS\\Data\\MetaFile\\all\\Articles\\Journals\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\Data\\MetaFile\\all\\Articles\\Journals.json"));
        String bookName = "";
        String page = "";
        String text = "";
        String quote = "\u005c\u0022";
        String line_="\\";
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
                String fileName = file.toString();

                StringBuffer sbf = new StringBuffer();
                StringBuffer sbf2 = new StringBuffer();
                StringBuffer sbf3 = new StringBuffer();
                StringBuffer sbf4 = new StringBuffer();
                StringBuffer sbf5 = new StringBuffer();

                JSONObject jsonObject = XML.toJSONObject(new String( Files.readAllBytes( Paths.get(fileName))));
                //JSONObject jsonObject = XML.toJSONObject(everything);
                //if(line!=null && line.length()>0)
                JSONObject documents = (JSONObject) jsonObject.get( "Documents" );
                JSONObject publication = (JSONObject) documents.get( "Publication" );
                JSONObject docMetas = (JSONObject) documents.get( "DocMetas" );
                JSONObject docMeta = (JSONObject) docMetas.get( "DocMeta" );
                JSONObject document = (JSONObject) jsonObject.get( "Documents" );

                String journal_title = (String) publication.get("PublicationName");
                String journal_title2 = (String) publication.get("PublicationEName");

                String publication_name = (String) publication.get("PublisherName");

                String issn = (String) publication.get("ISSN").toString();
                String volume_number = (String) publication.get("IssueName").toString();
                String date = (String) publication.get("IssueDate").toString();
                String years = date.substring(0,4);
                String monats = date.substring(4,6);
                String days="";
                int len = date.length();
                if (date.length()<7){
                    days="00";
                }else {
                    days = date.substring(6,8);
                }

                String subject = (String) publication.get("DocSubject");
                String [] subject2 = subject.split( "\\|" );

                if (subject2.length>0) {
                    sbf3.append( subject2 [0]);
                    for (int key=1; key<subject2.length; key ++) {
                        sbf3.append("\","+quote).append(subject2[key] ).append("");
                    }
                }

                String source = (String) docMeta.get("SourceDB");
                String id = (String) docMeta.get("DocID");

                String title = (String) docMeta.get("DocName").toString().replaceAll(quote,"'");
                String alternative ="";
                if ((String) docMeta.get("DocEName")!=""){
                    alternative = (String) docMeta.get("DocEName");
                }


                // Add table and types
                String language = (String) docMeta.get("DocLanguage");
                String lang="";
                if (language.equals("繁體中文")) {
                    lang="chi";
                }
                else if (language.equals("簡體中文")) {
                    lang="chi";
                }
                else if (language.equals("英文")) {
                    lang="eng";
                }
                else if (language.equals("日文")) {
                    lang="jpn";
                }
                else if (language.equals("法文")) {
                    lang="fra";
                }
                else if (language.equals("西班牙文")) {
                    lang="spa";
                }
                else if (language.equals("德文")) {
                    lang="deu";
                }
                else if (language.equals("俄文")) {
                    lang="rus";
                }
                else if (language.equals("其他")) {
                    lang="zho";
                }
                else if (language.equals("日文;英文")) {
                    lang="jpn;eng";
                }
                else if (language.equals("繁體中文;英文")) {
                    lang="zho;eng";
                }
                else if (language.equals("繁體中文;日文")) {
                    lang="zho;jpn";
                }
                else if (language.equals("台文")) {
                    lang="fox";
                }
                else if (language.equals("台文;英文")) {
                    lang="fox;eng";
                }
                else {
                    lang="pipez  "+language;
                }
                String [] languages = lang.split( ";" );
                if (languages.length>0) {
                    sbf5.append( languages [0]);
                    for (int key=1; key<languages.length; key ++) {
                        sbf5.append("\","+quote).append(languages[key] ).append("");
                    }
                }

                String extent = docMeta.get("PageCount").toString();
                String DOI_identifier = (String) docMeta.get("DocDOI").toString();

                String electronic_url = (String) docMeta.get("DocURL");
                String author = (String) docMeta.get("Author").toString();
                String author_EN = (String) docMeta.get("AuthorEn").toString();
                String pageFrom="";
                String pageTo="";
                if (docMeta.get("PageFrom")=="") {
                    pageFrom="";
                }else {
                    pageFrom = docMeta.get("PageFrom").toString();
                }
                if (docMeta.get("PageTo")=="") {
                    pageTo="";
                }else {
                    pageTo = docMeta.get("PageTo").toString();
                }


                String page_range = pageFrom+"-"+pageTo;

                String authors = author + ";" +author_EN;
                String [] authors2 = authors.split( ";" );
                if (authors2.length>0) {
                    sbf2.append( authors2 [0]);
                    for (int key=1; key<authors2.length; key ++) {
                        sbf2.append("\","+quote).append(authors2[key] ).append("");
                    }
                }

                String subject_En = (String) docMeta.get("KeywordsEn").toString().replaceAll("\"","'").replaceAll(quote,"'");
                String subject_Ch ="";
                if (docMeta.get("KeywordsCh")==null) {
                    subject_Ch ="";
                } else {
                    subject_Ch = (String) docMeta.get("KeywordsCh").toString().replaceAll("\"","'").replaceAll(quote,"'");
                }

                String subjects = subject_En + ";" +subject_Ch;
                String [] subjects2 = subjects.split( ";" );
                if (subjects2.length>0) {
                    sbf.append( subjects2 [0]);
                    for (int key=1; key<subjects2.length; key ++) {
                        sbf.append("\","+quote).append(subjects2[key] ).append("");
                    }
                }

                String description_En = (String) docMeta.get("AbstractEn").toString().replaceAll("\"","'").replaceAll(quote,"'").replaceAll(quote,"\"");
                String description_Ch ="";
                if (docMeta.get("AbstractCh")==null) {
                    description_Ch ="";
                } else {
                    description_Ch = (String) docMeta.get("AbstractCh").toString().replaceAll("\"","'").replaceAll(quote,"'").replaceAll(quote,"\"");
                }

                String description = description_En+" !!!! "+description_Ch;
                //String desc = (String) docMeta.get("Degree");


                //String advisors_Ch = (String) docMeta.get("AdvisorsCh").toString().replaceAll(quote,"\"");
                //String advisors_En = (String) docMeta.get("AdvisorsEn").toString().replaceAll(quote,"\"");
                //String advisor = "advisor: "+ advisors_Ch+" ("+advisors_En+")";
                //advisor.replaceAll(";",",");
                //String description2 = advisors_Ch.replaceAll(";",",")+" ("+advisors_En.replaceAll(";",",")+")";
                //String college = (String) docMeta.get("college").toString().replaceAll(quote,"\"");
                //String college_c = (String) docMeta.get("college_c").toString().replaceAll(quote,"\"");
                //String department = (String) docMeta.get("department").toString().replaceAll(quote,"\"");
                //String department_c = (String) docMeta.get("department_c").toString().replaceAll(quote,"\"");
                //String description3 = "department: "+department_c +" ("+department+"), "+college_c+" ("+college+")";


                //String  descriptions = description_En+";"+description_Ch+";"+";"+description2+";"+";"+description3;
                //descriptions.replaceAll("\"","'").replaceAll(quote,"'");
                //String [] descriptions2 = descriptions.split(";");

                /*if (descriptions2.length>0) {
                    sbf4.append( descriptions2 [0]);
                    for (int key=1; key<descriptions2.length; key ++) {
                        sbf4.append("\","+quote).append(descriptions2[key] ).append("");
                    }
                }*/

                String record_timestamp = (String) docMeta.get("last_modified");
                String record = record_timestamp.replaceAll("/","-");
                String years2 = record.substring(0,4);
                String monats2 = record.substring(4,6);
                String days2 = record.substring(6,9);
                String record_timestamp2 = years2+monats2+days2+"T00:00:00Z";
                String timestamp= record_timestamp2.replace(" T00:00:00Z","T00:00:00Z");


                out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                        + quote + "collection" + quote + ":" +   quote +"airiti TEPS (臺灣電子期刊)" +  quote + "," + '\n'
                        + quote + "hasModel" + quote + ":" +   quote +"Article" +  quote + "," + '\n'
                        + quote + "medium" + quote + ":" +   quote +"article" +  quote + "," + '\n'
                        + quote + "journal-title" + quote + ":" +   quote +journal_title + " : " + journal_title2+ quote + "," + '\n'
                        + quote + "publication-name" + quote + ":" +   quote +publication_name +  quote + "," + '\n'
                        + quote + "volume-number" + quote + ":" +   quote +volume_number +  quote + "," + '\n'
                        + quote + "date" + quote + ":" +quote+years+"-"+monats+"-"+days+ quote+","+'\n'
                        + quote + "title" + quote + ":" +   quote +title.replaceAll("[\r\n]+", " ") +  quote + "," + '\n'
                        + quote + "page-range" + quote + ":" +   quote +page_range +  quote + "," + '\n'
                        + quote + "alternative" + quote + ":" +   quote +alternative +  quote + "," + '\n'
                        + quote + "language" + quote + ":" +   "["+  quote +sbf5.toString().replaceAll( " \" ","" ) +  quote +"]" + "," + '\n'
                        + quote + "extent" + quote + ":" +   quote +extent + "pp"+  quote + "," + '\n'
                        + quote + "DOI_identifier" + quote + ":" +   quote +DOI_identifier +  quote + "," + '\n'
                        + quote + "electronic-url" + quote + ":" +   quote +electronic_url +  quote + "," + '\n'
                        + quote + "author" + quote + ":" +   "["+  quote +sbf2.toString().replaceAll( " \" ","" ) +  quote +"]" + "," + '\n'
                        + quote + "subject" + quote + ":" +   "["+  quote +sbf.toString().replaceAll( " \" ","" ).replaceAll("[\r\n]+", " ") +  sbf3.toString().replaceAll( " \" ","" ).replaceAll("[\r\n]+", " ") +  quote +"]" + "," + '\n'
                        + quote + "description" + quote + ":" +   "["+  quote +description.replaceAll("[\r\n]+", " ").replaceAll(quote,"\"")+quote + "]" +"," + '\n'
                        + quote + "record_timestamp" + quote + ":" +   quote + timestamp +  quote + "" + '\n'
                        +"},"
                );


            } finally {
                br.close();
            }
        }

    }
}
