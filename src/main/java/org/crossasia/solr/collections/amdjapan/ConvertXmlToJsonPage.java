package org.crossasia.solr.collections.amdjapan;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertXmlToJsonPage {
    public static void main( String[] args ) throws Exception {

        File dir = new File("/data/solr/ajax_amd_as_china_sea/");
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/ajax_amd_as_china_sea_pages2.json"));
        String bookName = "";
        String page = "";

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
                String book_id = (String) document.get( "ImageDirectory" ).toString();
                String title = (String) document.get( "Title" ).toString().replace("\"", "");
                String author = (String) document.get( "Author" ).toString();
                String collection = (String) document.get( "Collection" ).toString();
                String url = (String) document.get( "Url" ).toString();
                String date = (String) document.get( "Date" ).toString();
                JSONObject images = (JSONObject) document.get( "images" );
                JSONObject imageObject;
                JSONArray imageArray;
                Object image = images.get("image");
                String id="";
                String imageUrl="";
                String imageFile="";
                int position =0;

                String text="";



                if (image instanceof JSONObject) {
                    imageObject = (JSONObject) image;
                    id = (String) imageObject.get( "id" ).toString();
                    position = (int) imageObject.get( "id" );
                    imageUrl = (String) imageObject.get( "imageUrl" ).toString();
                    imageFile = (String) imageObject.get( "imageFile" ).toString();
                    if (imageObject.has("imageText")) {
                        text = (String) imageObject.get("imageText").toString().replaceAll("_" ,"").replaceAll("\"","").replaceAll("\\r\\n"," ");
                    }


                    out.println("{"
                            + quote + "id" + quote + ":" + quote+ imageFile.replace(".jpg", "") + quote + "," + '\n'
                            + quote + "position" + quote + ":" +   quote +position +  quote + "," + '\n'
                            + quote + "hasModel" + quote + ":" +   quote +"Page" +  quote + "," + '\n'
                            + quote + "collection" + quote + ":" +   quote + "Area Studies: China and Southeast Asia" +  quote + "," + '\n'
                            + quote + "image_file" + quote + ":" +   quote +imageFile +  quote + "," + '\n'
                            + quote + "title" + quote + ":" +   quote +title +  quote + "," + '\n'
                            + quote + "author" + quote + ":" +   quote +author +  quote + "," + '\n'
                            + quote + "erflink" + quote + ":" +   quote + "http://erf.sbb.spk-berlin.de/han/amdaschinasea/"+imageUrl.replace("http://","") +  quote + "," + '\n'
                            + quote + "series_title" + quote + ":" +   quote +collection +  quote + "," + '\n'
                            + quote + "date" + quote + ":" +   quote +date +  quote + "," + '\n'
                            + quote + "url" + quote + ":" +   quote +imageUrl +  quote + "," + '\n'
                            + quote + "book_id" + quote + ":" + quote+ book_id + quote + "," + '\n'
                            + quote + "text" + quote + ":" +   quote +text.replaceAll("_"," ").replaceAll("\"","").replaceAll("\\r\\n"," ") +  quote + "" + '\n'
                            +"},"
                    );

                } else {
                    imageArray = (JSONArray) image;
                    for (int arr=0; arr<imageArray.length();arr++){
                        JSONObject smallImage = imageArray.getJSONObject(arr);
                        id = (String) smallImage.get( "id" ).toString();
                        position = (int) smallImage.get( "id" );
                        imageUrl = (String) smallImage.get( "imageUrl" ).toString();
                        imageFile = (String) smallImage.get( "imageFile" ).toString();
                        if (smallImage.has("imageText")){
                            text = (String) smallImage.get("imageText").toString().replaceAll("_" ,"").replaceAll("\"","").replaceAll("\\r\\n"," ");
                        }


                        out.println("{"
                                + quote + "id" + quote + ":" + quote+ imageFile.replace(".jpg", "") + quote + "," + '\n'
                                + quote + "position" + quote + ":" +   quote +position +  quote + "," + '\n'
                                + quote + "hasModel" + quote + ":" +   quote +"Page" +  quote + "," + '\n'
                                + quote + "collection" + quote + ":" +   quote + "Area Studies: China and Southeast Asia" +  quote + "," + '\n'
                                + quote + "image_file" + quote + ":" +   quote +imageFile +  quote + "," + '\n'
                                + quote + "title" + quote + ":" +   quote +title +  quote + "," + '\n'
                                + quote + "author" + quote + ":" +   quote +author +  quote + "," + '\n'
                                + quote + "erflink" + quote + ":" +   quote + "http://erf.sbb.spk-berlin.de/han/amdaschinasea/"+imageUrl.replace("http://","") +  quote + "," + '\n'
                                + quote + "series_title" + quote + ":" +   quote +collection +  quote + "," + '\n'
                                + quote + "date" + quote + ":" +   quote +date +  quote + "," + '\n'
                                + quote + "url" + quote + ":" +   quote +imageUrl +  quote + "," + '\n'
                                + quote + "book_id" + quote + ":" + quote+ book_id + quote + "," + '\n'
                                + quote + "text" + quote + ":" +   quote +text.replaceAll("_"," ").replaceAll("\"","").replaceAll("\\r\\n"," ") +  quote + "" + '\n'
                                +"},"

                        );

                    }

                }

            } finally {
                br.close();
            }
        }

    }
}
