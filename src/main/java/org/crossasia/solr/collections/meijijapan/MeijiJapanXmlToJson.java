package org.crossasia.solr.collections.meijijapan;

import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MeijiJapanXmlToJson {
    public static void main(String[] args) throws Exception {
        try {
            String filePathFolder = "D:\\RAW-COLLECTIONS\\ChinaAmericaPacific\\JSON_NEW\\";
            String directoryPath = "D:\\RAW-COLLECTIONS\\ChinaAmericaPacific\\xml2";
            File folder = new File(filePathFolder);
            folder.mkdir();
            String absolutePath = filePathFolder;
            File dir = new File(directoryPath);
            FileFilter filter = (File file) -> file.isFile() && file.getName().endsWith(".xml");

            File[] paths = dir.listFiles(filter);
            String filePath = "";
            for (File path : paths) {
                filePath = path.toString();
                JSONObject jsonObject = XML.toJSONObject(new String(Files.readAllBytes(Paths.get(filePath))));
                String fileName = filePath.replace(directoryPath, "").replace(".xml", "");
                //out = new BufferedWriter(new FileWriter(folder+"\\"+fileName+".json"));
                String jsonString = jsonObject.toString().replace(" ","_");
                //String jsonString = jsonObject.toString().replace(",\"name\":\"CH\"", "");
                //out.write(jsonString);

                FileWriter fileWriter = new FileWriter(folder + "\\" + fileName + ".json");
                try {
                    fileWriter.write(jsonString);
                } catch (IOException e) {
                    e.printStackTrace();

                } finally {
                    fileWriter.flush();
                    fileWriter.close();
                    //out.close();
                }

            }
        }   catch (IOException e) {
            e.printStackTrace();

        }
    }
}
