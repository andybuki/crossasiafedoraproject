package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraPagesModify.jsonObjPage;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class UploadedFileId {
    public static StringBuilder addUploadedFileId() throws FileNotFoundException {
        String uploaded_file_id = "";
        StringBuilder uploadedFileIdBuilder = new StringBuilder();

        if (jsonObjPage.has("uploaded_file_id")) {
            uploaded_file_id = (String) jsonObjPage.get("uploaded_file_id").toString();
        }
        if (uploaded_file_id!= "") {
            uploadedFileIdBuilder.append(QUOTE + "schema:identifier" + QUOTE + ":" + QUOTE + uploaded_file_id + QUOTE + "," + '\n');
            return uploadedFileIdBuilder;
        } else {
            return new StringBuilder();
        }
    }
}
