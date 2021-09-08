package org.crossasia.dlntm;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

import static org.crossasia.dlntm.fedora.FedoraFooterPage.addFedoraFooter;
import static org.crossasia.dlntm.fedora.FedoraHeader.addFedoraHeader;
import static org.crossasia.dlntm.fedora.OriginalFileName.addOriginalFileName;
import static org.crossasia.dlntm.fedora.Position.addPosition;
import static org.crossasia.dlntm.fedora.UploadedFileId.addUploadedFileId;
import static org.crossasia.dlntm.fedora.constants.Constants.ABSOLUTE_PATH_PAGES;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class DlntmFedoraPagesModify {
    public static JSONObject jsonObjPage;
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException , IOException {
        File dir = new File(String.valueOf(ABSOLUTE_PATH_PAGES));
        File[] filesInDir = dir.listFiles();
        for (File file : filesInDir) {
            StringBuilder sb = new StringBuilder();
            jsonObjPage = new JSONObject(new JSONTokener(new FileInputStream(file)));

            String id = "";
            String file_name = "";

            if (jsonObjPage.has("id")) {
                id = (String) jsonObjPage.get("id").toString();
            }

            if (jsonObjPage.has("uploaded_file_id")) {
                file_name = (String) jsonObjPage.get("uploaded_file_id").toString();
            }

            sb.append(addFedoraHeader());
            System.out.println(id);

            sb.append(QUOTE + "id" + QUOTE + ":" +QUOTE+ "dlntm_0000"+ id +"_" + file_name + QUOTE+"," + '\n');
            sb.append(addPosition());
            sb.append(addUploadedFileId());
            sb.append(addOriginalFileName());

            sb.append(addFedoraFooter());

            sb.deleteCharAt(sb.length() - 1);
            PrintStream out = new PrintStream(new FileOutputStream("/data/dlmnt/fedora/pages/"+id+"_"+file_name+".json"));
            out.println("["+sb.toString()+"}]");
        }
    }
}







