package org.crossasia.dlntm;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ManuscriptsTransformation3 {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        //String pages = "data/dlmnt/dlmt_options.json";
        String manuscripts = "/data/dlmnt/properties.json";
        StringBuilder sb = new StringBuilder();
        JSONArray jsonArrayManuscripts = new JSONArray(new JSONTokener(new FileInputStream(manuscripts)));
        //JSONArray jsonArrayPages = new JSONArray(new JSONTokener(new FileInputStream(pages)));
        PrintStream out = new PrintStream(new FileOutputStream("/data/dlmnt/propertiesNEW_LAST.json"));

        int manuscript_id=0;

        String category ="";
        String language ="";
        String author ="";
        String material ="";
        String script ="";
        String ancillary_term ="";

        String category_th ="";
        String language_th ="";
        String author_th ="";
        String material_th ="";
        String script_th ="";
        String ancillary_term_th ="";

        for (int j=0; j<jsonArrayManuscripts.length(); j++) {

            JSONObject jsonObjManuscripts = (JSONObject) jsonArrayManuscripts.get(j);

            if (jsonObjManuscripts.has("manuscript_id")) {
                try {
                    manuscript_id = (int) jsonObjManuscripts.get("manuscript_id");
                } catch (Exception e) {
                    System.out.printf("ISSUE: ->"+manuscript_id);
                }
            }
            JSONArray jsonProperties = jsonObjManuscripts.getJSONArray("properties");

            if (jsonProperties.length()>6)
                System.out.println("O NO ->" + manuscript_id);


            List<String> categoryList = new ArrayList<>();
            List<String> languageList = new ArrayList<>();
            List<String> materialList = new ArrayList<>();
            List<String> scriptList = new ArrayList<>();
            List<String> ancillary_termList = new ArrayList<>();
            List<String> authorList = new ArrayList<>();

            for (int i = 0; i<jsonProperties.length()   ; i++) {
                JSONObject jsonObjProperties = (JSONObject) jsonProperties.get(i);

                if (jsonObjProperties.has("Language")) {
                    language = (String) jsonObjProperties.get("Language");
                    languageList.add(quote+language+quote);
                }

                if (jsonObjProperties.has("Category")) {
                    category = (String) jsonObjProperties.get("Category");
                    categoryList.add(quote+category+quote);
                }

                if (jsonObjProperties.has("Material")) {
                    material = (String) jsonObjProperties.get("Material");
                    materialList.add(quote+material+quote);
                }

                if (jsonObjProperties.has("Script")) {
                    script = (String) jsonObjProperties.get("Script");
                    scriptList.add(quote+script+quote);
                }

                if (jsonObjProperties.has("Ancillary term")) {
                    ancillary_term = (String) jsonObjProperties.get("Ancillary term");
                    ancillary_termList.add(quote+ancillary_term+quote);
                }

                if (jsonObjProperties.has("Author")) {
                    author = (String) jsonObjProperties.get("Author");
                    authorList.add(quote+author+quote);
                }

            }
            JSONArray jsonProperties_TH = jsonObjManuscripts.getJSONArray("properties_th");

            List<String> categoryList_TH = new ArrayList<>();
            List<String> languageList_TH = new ArrayList<>();
            List<String> materialList_TH = new ArrayList<>();
            List<String> scriptList_TH = new ArrayList<>();
            List<String> ancillary_termList_TH = new ArrayList<>();
            List<String> authorList_TH = new ArrayList<>();

            for (int k = 0; k<jsonProperties_TH.length()   ; k++) {
                JSONObject jsonObjProperties_TH = (JSONObject) jsonProperties_TH.get(k);
                if (jsonObjProperties_TH.has("ภาษา")) {
                    language_th = (String) jsonObjProperties_TH.get("ภาษา");
                    languageList_TH.add(quote+language_th+quote);
                }

                if (jsonObjProperties_TH.has("หมวด")) {
                    category_th = (String) jsonObjProperties_TH.get("หมวด");
                    categoryList_TH.add(quote+category_th+quote);
                }

                if (jsonObjProperties_TH.has("ลักษณะเอกสาร")) {
                    material_th = (String) jsonObjProperties_TH.get("ลักษณะเอกสาร");
                    materialList_TH.add(quote+material_th+quote);
                }

                if (jsonObjProperties_TH.has("อักษร")) {
                    script_th = (String) jsonObjProperties_TH.get("อักษร");
                    scriptList_TH.add(quote+script_th+quote);
                }

                if (jsonObjProperties_TH.has("คำศัพท์ประกอบชื่อเรื่อง")) {
                    ancillary_term_th = (String) jsonObjProperties_TH.get("คำศัพท์ประกอบชื่อเรื่อง");
                    ancillary_termList_TH.add(quote+ancillary_term_th+quote);
                }

                if (jsonObjProperties_TH.has("ผู้แต่ง")) {
                    author_th = (String) jsonObjProperties_TH.get("ผู้แต่ง");
                    authorList_TH.add(quote+author_th+quote);
                }
            }

            sb.append("{" + '\n');
            if (manuscript_id != 0)
                sb.append(quote + "id" + quote + ":" + manuscript_id + "," + '\n');

            if (category != null)
                sb.append(quote + "category" + quote + ":" +  categoryList  + "," + '\n');

            if (language != null)
                sb.append(quote + "language" + quote + ":" +  languageList  + "," + '\n');

            if (script != null)
                sb.append(quote + "script" + quote + ":" +  scriptList  + "," + '\n');

            if (author != null)
                sb.append(quote + "author" + quote + ":" +  authorList  + "," + '\n');

            if (ancillary_term != null)
                sb.append(quote + "ancillary_term" + quote + ":" +  ancillary_termList + "," + '\n');

            if (material != null)
                sb.append(quote + "material" + quote + ":" + materialList  + "," + '\n');

            if (category_th != null)
                sb.append(quote + "category_th" + quote + ":" +  categoryList_TH  + "," + '\n');

            if (language_th != null)
                sb.append(quote + "language_th" + quote + ":" +  languageList_TH + "," + '\n');

            if (script_th != null)
                sb.append(quote + "script_th" + quote + ":" + scriptList_TH + "," + '\n');

            if (author_th != null)
                sb.append(quote + "author_th" + quote + ":" + authorList_TH + "," + '\n');

            if (ancillary_term_th != null)
                sb.append(quote + "ancillary_term_th" + quote + ":" + ancillary_termList_TH + "," + '\n');

            if (material_th != null)
                sb.append(quote + "material_th" + quote + ":" + materialList_TH + "" + '\n');

            sb.append("},");


        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}
