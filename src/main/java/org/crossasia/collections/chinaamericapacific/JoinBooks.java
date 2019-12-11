package org.crossasia.collections.chinaamericapacific;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class JoinBooks {
    public static void main(String[] args) throws FileNotFoundException {
        String filePathFolder = "/data1/solr/ChinaAmericaPacific/books/";
        String directoryPath = "/data1/solr/ChinaAmericaPacific/books/";
        String quote = "\u005c\u0022";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ChinaAmericaPacific/books.json"));

        StringBuilder sb = new StringBuilder();
        File folder = new File(filePathFolder);
        folder.mkdir();
        String absolutePath = filePathFolder;
        File dir = new File(directoryPath);
        FileFilter filter = (File file) -> file.isFile() && file.getName().endsWith(".json");
        File[] paths = dir.listFiles(filter);
        String filePath = "";

        for (File path : paths) {
            JSONArray booksArrays = new JSONArray(new JSONTokener(new FileInputStream(path)));

            String date = "";
            String identifier = "";
            String book_id = "";
            String source = "";
            String title = "";

            String id = "";
            String issued = "";
            String nodeId = "";
            String erflink="http://erf.sbb.spk-berlin.de/han/ChinaAmericaPacific/";
            //String series_title = "";
            JSONArray description = null;
            JSONArray medium = null;
            JSONArray subject = null;
            JSONArray language = null;
            JSONArray series_title = null;
            JSONArray person = null;
            JSONArray spatial = null;

            for (int i=0; i<booksArrays.length(); i++){
                JSONObject booksObject = (JSONObject) booksArrays.get(i);
                id = (String) booksObject.get("id");
                identifier  = (String) booksObject.get("identifier");
                String identifier2 = identifier.replace("http://","");
                erflink = erflink+identifier2;

                book_id  = (String) booksObject.get("book_id");
                if (booksObject.has("issued")) {
                    issued = (String) booksObject.get("issued").toString();
                }
                title  = (String) booksObject.get("title").toString().replaceAll("\\r\\n"," ").replaceAll("\"","");
                source  = (String) booksObject.get("source");
                if (booksObject.has("date")) {
                    date = (String) booksObject.get("date").toString();
                }

                JSONArray keywords  = (JSONArray) booksObject.get("keywords");
                JSONArray edition  = (JSONArray) booksObject.get("edition");

                if (booksObject.has("description")) {
                     description  = (JSONArray) booksObject.get("description");
                }

                if (booksObject.has("nodeId")) {
                    nodeId  = (String) booksObject.get("nodeId").toString();
                }

                if (booksObject.has("spatial")) {
                    spatial  = (JSONArray) booksObject.get("spatial");
                }

                if (booksObject.has("person")) {
                    person  = (JSONArray) booksObject.get("person");
                }

                if (booksObject.has("series_title")) {
                    series_title  = (JSONArray) booksObject.get("series_title");
                }

                if (booksObject.has("medium")) {
                    medium  = (JSONArray) booksObject.get("medium");
                }

                if (booksObject.has("subject")) {
                    subject  = (JSONArray) booksObject.get("subject");
                }
                if (booksObject.has("language")) {
                    language  = (JSONArray) booksObject.get("language");
                }
                    
                sb.append("{"+ '\n');
                sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
                sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );
                sb.append(  quote + "issued" + quote + ":" + quote+ issued+ quote + "," + '\n' );

                if (identifier!=null)
                    sb.append(  quote + "url" + quote + ":" + quote+ identifier+ quote + "," + '\n');

                if (erflink!=null)
                    sb.append(  quote + "erflink" + quote + ":" + quote+ erflink+ quote + "," + '\n');
                if (nodeId!=null)
                    sb.append(  quote + "nodeId" + quote + ":" + quote+ nodeId+ quote + "," + '\n');
                if (date!=null)
                    sb.append(  quote + "date" + quote + ":" + quote+ date+ quote + "," + '\n');
                if (keywords!=null)
                    sb.append(  quote + "keywords" + quote + ":" +  keywords+  "," + '\n');
                if (title!=null)
                    sb.append(  quote + "title" + quote + ":" + quote+ title+ quote+ "," + '\n');
                if (spatial!=null)
                    sb.append(  quote + "spatial" + quote + ":" +  spatial+ "," + '\n');
                if (edition!=null)
                    sb.append(  quote + "edition" + quote + ":" +  edition+  "," + '\n');
                if (person!=null)
                    sb.append(  quote + "person" + quote + ":" +  person+  "," + '\n');
                if (description!=null)
                    sb.append(  quote + "description" + quote + ":" +  description+  "," + '\n');
                if (medium!=null)
                    sb.append(  quote + "medium" + quote + ":" +  medium+  "," + '\n');
                if (subject!=null)
                    sb.append(  quote + "subject" + quote + ":" +  subject+  "," + '\n');
                if (series_title!=null)
                    sb.append(  quote + "series_title" + quote + ":" +  series_title+  "," + '\n');
                if (language!=null)
                    sb.append(  quote + "language" + quote + ":" +  language+  "," + '\n');

                sb.append(  quote + "hasModel" + quote + ":" + quote+ "Book"+ quote + "," + '\n' );
                sb.append(  quote + "collection" + quote + ":" + quote+ "Adam Matthew - China America Pacific"+ quote + "," + '\n' );
                sb.append(  quote + "source" + quote + ":" + quote+ source+ quote + "" + '\n' );
                sb.append("},");

            }

            System.out.println(booksArrays);
        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}
