package org.crossasia.collections.adammethew;

import org.json.simple.parser.JSONParser;

import java.io.*;

public class ConvertJsonToJsonBooks {


    public static void main(String[] args) throws Exception{

        File dir = new File("D:\\SOLR-COLLECTIONS\\adm\\bookNew\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\adm\\books.json"));
        String bookName = "";
        String page = "";
        String text = "";
        String quote = "\u005c\u0022";
        int i;
        FileWriter fw = null;
        BufferedWriter bw = null;
        BufferedWriter bw2 = null;


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
                Object obj = parser.parse(new FileReader(file));
                org.json.simple.JSONArray object = (org.json.simple.JSONArray) obj;

                for (int k=0; k<object.size();k++) {
                    org.json.simple.JSONObject book = (org.json.simple.JSONObject) object.get(k);

                    String id = (String) book.get("id").toString();
                    String hasModel = (String) book.get("hasModel");
                    String nodeid = (String) book.get("nodeId").toString();
                    String book_id = (String) book.get("book_id");
                    String identifier = (String) book.get("identifier");
                    String title = (String) book.get("title").toString().replaceAll(quote,"").replaceAll(",","; ");
                    String date = (String) book.get("date").toString();
                    String publication_name ="";
                    if (book.containsKey("publication_name")) {
                         publication_name = (String) book.get("publication_name").toString();
                    }
                    String edition = (String) book.get("edition").toString();
                    String description ="";
                    if (book.containsKey("description")) {
                        description = (String) book.get("description").toString();
                    }
                    String medium = (String) book.get("medium").toString();
                    String subject ="";
                    if (book.containsKey("subject")) {
                        subject = (String) book.get("subject").toString();
                    }
                    String organization = (String) book.get("organization");
                    String keywords ="";
                    if (book.containsKey("keywords")) {
                        keywords = (String) book.get("keywords").toString();
                    }
                    String source = (String) book.get("source").toString();
                    String spatial ="";
                    if (book.containsKey("spatial")) {
                        spatial = (String) book.get("spatial").toString();
                    }
                    String person ="";
                    if (book.containsKey("person")) {
                        person = (String) book.get("person").toString();
                    }
                    String series_title = (String) book.get("series_title").toString();
                    String publisher = (String) book.get("publisher");

                    out.println("{" + quote + "id" + quote + ":" + quote+ book_id+ quote + "," + '\n'
                            + quote + "hasModel" + quote + ":" +  quote+  hasModel  +  quote+"," + '\n'
                            + quote + "nodeId" + quote + ":" +  quote+  nodeid + quote+ "," + '\n'
                            + quote + "book_id" + quote + ":" + quote +  book_id  + quote + "," + '\n'
                            + quote + "collection" + quote + ":" + quote+  "Adam Matthew – FO Japan"  + quote+ "," + '\n'
                            + quote + "identifier" + quote + ":" +   quote+ identifier  + quote+ "," + '\n'
                            + quote + "language" + quote + ":" +  quote+ "eng"  +quote+ "," + '\n'
                            + quote + "title" + quote + ":" +   quote+ title + quote+ "," + '\n'
                            + quote + "date" + quote + ":" +   quote+ date + quote + "," + '\n'
                            + quote + "publication_name" + quote + ":" +   publication_name  + "," + '\n'
                            + quote + "edition" + quote + ":" +   edition  + "," + '\n'
                            + quote + "description" + quote + ":" +   description  + "," + '\n'
                            + quote + "medium" + quote + ":" +   medium  + "," + '\n'
                            + quote + "subject" + quote + ":" +   subject  + "," + '\n'
                            + quote + "organization" + quote + ":" +  quote +  organization + quote + "," + '\n'
                            + quote + "keywords" + quote + ":" +   keywords  + "," + '\n'
                            + quote + "source" + quote + ":" +  quote + source  + quote +"," + '\n'
                            + quote + "spatial" + quote + ":" +   spatial  + "," + '\n'
                            + quote + "person" + quote + ":" +   person  + "," + '\n'
                            + quote + "series_title" + quote + ":" +   series_title  + "," + '\n'
                            + quote + "publisher" + quote + ":" +  quote +  publisher  + quote + "" + '\n'
                            +"},"
                    );
                }

                /*try {

                    String content = FileUtils.readFileToString(new File("D:\\SOLR-COLLECTIONS\\AMD-JAPAN\\books3.json"), "UTF-8");
                    bw = new BufferedWriter(new FileWriter("D:\\SOLR-COLLECTIONS\\AMD-JAPAN\\books4.json", true));
                    bw.write("]");

                    File tempFile = new File("D:\\SOLR-COLLECTIONS\\AMD-JAPAN\\books4.json");
                    FileUtils.writeStringToFile(tempFile, content, "UTF-8");
                    String result = "";
                    String line2 = "";
                    while( (line = br.readLine()) != null){
                        result = result + line2;
                    }

                    String ch = "\u005C\u0022";
                    content = content.replaceAll(quote +"description"+ quote+":\\[\"\""+",\"\""+"\\],","").
                            replaceAll(quote +"publication_name"+ quote+":\\[\"\""+",\"\""+"\\],","").
                            replaceAll(quote +"person"+ quote+":\\[\"\""+"\\],","").
                            replaceAll(quote +"keywords"+ quote+":\\[\"\""+"\\],","").
                            replaceAll(quote +"spatial"+ quote+":\\[\"\""+"\\],","").
                            replaceAll(quote +"organization"+ quote+":\"\",","").
                            replace("\\\"", "").
                            replace("\\", "").
                            replace("\"[","[\"").
                            replace("]\"","\"]").
                            replace("�","").
                            replace("\"\",","").
                            replace("\"subject\":[\"\"],","").
                            replace(",\"\"","").
                            replace(",\" ",",\"");
                    result = "[" + content;
                    result = result.substring(0, result.length()-3);

                    FileOutputStream fos = new FileOutputStream(tempFile);
                    fos.write(result.getBytes());

                    fos.flush();
                    bw.flush();

                } catch (IOException e) {
                    throw new RuntimeException("Generating file failed", e);
                }*/
            } finally {
                br.close();
                if (bw != null) try {
                    bw.close();
                }catch (IOException ioe2) {
                    // just ignore it
                }
            }
        }

    }


}
