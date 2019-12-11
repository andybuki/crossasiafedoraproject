package org.crossasia.collections.chinaamericapacific;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertXmlToJsonPage {
    public static void main( String[] args ) throws Exception {

        File dir = new File("D:\\RAW-COLLECTIONS\\ChinaAmericaPacific\\xml2\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\RAW-COLLECTIONS\\ChinaAmericaPacific\\pages.json"));
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
                JSONObject images = (JSONObject) document.get( "images" );
                JSONObject imageObject;
                JSONArray imageArray;
                Object image = images.get("image");
                String id="";
                String imageUrl="";
                String imageFile="";
                int position =0;
                String book_id;
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


                    out.println("[{"
                            + quote + "id" + quote + ":" + quote+ id+"page_"+imageUrl.replace("http://www.cap.amdigital.co.uk/Documents/Images/", "").split("/")[0] + quote + "," + '\n'
                            + quote + "position" + quote + ":" +   quote +position +  quote + "," + '\n'
                            + quote + "hasModel" + quote + ":" +   quote +"Page" +  quote + "," + '\n'
                            + quote + "collection" + quote + ":" +   quote +"Adam Matthew - China America Pacific" +  quote + "," + '\n'
                            + quote + "image_file" + quote + ":" +   quote +imageFile +  quote + "," + '\n'
                            + quote + "image_url" + quote + ":" +   quote +imageUrl +  quote + "," + '\n'
                            + quote + "book_id" + quote + ":" + quote+ imageUrl.replace("http://www.cap.amdigital.co.uk/Documents/Images/", "").split("/")[0] + quote + "," + '\n'
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


                        out.println("[{"
                                + quote + "id" + quote + ":" + quote+ id+"page_"+imageUrl.replace("http://www.cap.amdigital.co.uk/Documents/Images/", "").split("/")[0] + quote + "," + '\n'
                                + quote + "position" + quote + ":" +   quote +position +  quote + "," + '\n'
                                + quote + "hasModel" + quote + ":" +   quote +"Page" +  quote + "," + '\n'
                                + quote + "collection" + quote + ":" +   quote +"Adam Matthew - China America Pacific" +  quote + "," + '\n'
                                + quote + "image_file" + quote + ":" +   quote +imageFile +  quote + "," + '\n'
                                + quote + "image_url" + quote + ":" +   quote +imageUrl +  quote + "," + '\n'
                                + quote + "book_id" + quote + ":" + quote+ imageUrl.replace("http://www.cap.amdigital.co.uk/Documents/Images/", "").split("/")[0] + quote + "," + '\n'
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
