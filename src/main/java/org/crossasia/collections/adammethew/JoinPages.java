package org.crossasia.collections.adammethew;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class JoinPages {
    public static void main(String[] args) throws FileNotFoundException {
        String filePathFolder = "D:\\SOLR-COLLECTIONS\\adm\\FINAL\\page\\";
        String directoryPath = "D:\\SOLR-COLLECTIONS\\adm\\FINAL\\page";
        String quote = "\u005c\u0022";
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\adm\\FINAL\\pages1.json"));

        StringBuilder sb = new StringBuilder();
        File folder = new File(filePathFolder);
        folder.mkdir();
        String absolutePath = filePathFolder;
        File dir = new File(directoryPath);
        FileFilter filter = (File file) -> file.isFile() && file.getName().endsWith(".json");
        File[] paths = dir.listFiles(filter);
        String filePath = "";


        for (File path : paths) {
            JSONArray pagesArrays = new JSONArray(new JSONTokener(new FileInputStream(path)));
            String id = "";
            String position = "";
            String text = "";
            String book_id = "";
            String image_file = "";
            String image_url = "";
            for (int i=0; i<pagesArrays.length(); i++){

                JSONObject pagesObject = (JSONObject) pagesArrays.get(i);
                id = (String) pagesObject.get("id");
                image_file  = (String) pagesObject.get("image_file");
                image_url  = (String) pagesObject.get("image_url");
                book_id  = (String) pagesObject.get("book_id");
                position  = (String) pagesObject.get("position").toString();
                if (pagesObject.has("text"))
                    text  = (String) pagesObject.get("text").toString().
                        replaceAll("\\\"", "").
                            replaceAll("]\"","\"]").
                            replaceAll("�","").
                            replaceAll("\"\",","").
                            replaceAll("\"subject\":[\"\"],","").
                            replaceAll(",\"\"","").
                            replaceAll("","").
                            replaceAll(",\" ",",\"");

                sb.append("{"+ '\n');
                sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
                sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );
                sb.append(  quote + "position" + quote + ":" + quote+ position+ quote + "," + '\n' );
                sb.append(  quote + "hasModel" + quote + ":" + quote+ "Page"+ quote + "," + '\n' );
                sb.append(  quote + "language" + quote + ":" + quote+ "eng"+ quote + "," + '\n' );
                sb.append(  quote + "collection" + quote + ":" + quote+ "Adam Matthew - Foreign Office Files China & Japan"+ quote + "," + '\n' );
                sb.append(  quote + "image_file" + quote + ":" + quote+ image_file+ quote + "," + '\n' );
                sb.append(  quote + "image_url" + quote + ":" + quote+ image_url+ quote + "," + '\n' );
                sb.append(  quote + "text" + quote + ":" + quote+ text+ quote + "" + '\n' );
                sb.append("},");
            }
            System.out.println(book_id);
        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}
