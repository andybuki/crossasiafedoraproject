package org.crossasia.dlntm;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ManuscriptsTransformation4 {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String manuscripts = "/data/dlmnt/manuscripts.json";
        String pages = "/data/dlmnt/folios.json";

        StringBuilder sb = new StringBuilder();
        JSONArray jsonArrayBooks = new JSONArray(new JSONTokener(new FileInputStream(manuscripts)));
        JSONArray jsonArrayPages = new JSONArray(new JSONTokener(new FileInputStream(pages)));
        PrintStream out = new PrintStream(new FileOutputStream("/data/dlmnt/manuscripts_FULL.json"));

        for (int i=0; i<jsonArrayBooks.length();i++){

            int id =0;
            String code_number ="";
            String state ="";
            String microfilm_roll_number ="";
            int number_of_fascicles =0;
            int number_of_digital_images =0;
            boolean  complete =false;
            boolean  has_colophon =false;
            boolean  illustrated =false;
            boolean  directly_digitised =false;
            String  legibility ="";
            String condition ="";
            String in_collection ="";
            String publication_volume ="";
            int location_id =0;
            int pntmp_title_id =0;

            //JSONArray uploaded_file_id =null;
            //JSONArray position =null;

            JSONArray code =null;
            JSONArray province_th =null;
            JSONArray province_ro =null;
            JSONArray district_th =null;
            JSONArray district_ro =null;
            JSONArray address_th =null;
            JSONArray address_ro =null;
            JSONArray latitude =null;
            JSONArray longitude =null;

            JSONArray exact =null;
            JSONArray website =null;
            JSONArray manuscripts_count =null;
            JSONArray dlntm_title_id =null;
            JSONArray dlntm_label_th =null;
            JSONArray dlntm_label_ro =null;
            JSONArray alternative_title_id =null;
            JSONArray alternative_label_th =null;
            JSONArray alternative_label_ro =null;

            JSONArray label =null;
            JSONArray label_ro =null;
            JSONArray pntmp_label =null;

            String date_system ="";
            int year =0;
            String thai_remarks ="";
            String remarks ="";
            int ce_year =0;
            boolean  in_private_collection =false;

            JSONArray category = null;
            JSONArray  language = null;
            JSONArray material = null;
            JSONArray script = null;
            JSONArray ancillary_term = null;
            JSONArray author = null;
            JSONArray jsonUploaded_Name = null;

            JSONArray category_th = null;
            JSONArray language_th = null;
            JSONArray material_th = null;
            JSONArray script_th = null;
            JSONArray ancillary_term_th = null;
            JSONArray author_th = null;

            String uploaded_file_id ="";
            String position ="";
            String original_file_name ="";


            JSONObject jsonObjBooks = (JSONObject) jsonArrayBooks.get(i);

            if (jsonObjBooks.has("id")) {
                id = (int) jsonObjBooks.get("id");
            }

            if (jsonObjBooks.has("state")) {
                state = (String) jsonObjBooks.get("state");
            }

            if (jsonObjBooks.has("latitude")) {
                latitude = (JSONArray) jsonObjBooks.get("latitude");
            }

            if (jsonObjBooks.has("longitude")) {
                longitude = (JSONArray) jsonObjBooks.get("longitude");
            }

            if (jsonObjBooks.has("exact")) {
                exact = (JSONArray) jsonObjBooks.get("exact");
            }

            if (jsonObjBooks.has("website")) {
                website = (JSONArray) jsonObjBooks.get("website");
            }

            if (jsonObjBooks.has("manuscripts_count")) {
                manuscripts_count = (JSONArray) jsonObjBooks.get("manuscripts_count");
            }

            if (jsonObjBooks.has("dlntm_title_id")) {
                dlntm_title_id = (JSONArray) jsonObjBooks.get("dlntm_title_id");
            }

            if (jsonObjBooks.has("dlntm_label_th")) {
                dlntm_label_th = (JSONArray) jsonObjBooks.get("dlntm_label_th");
            }

            if (jsonObjBooks.has("dlntm_label_ro")) {
                dlntm_label_ro = (JSONArray) jsonObjBooks.get("dlntm_label_ro");
            }

            if (jsonObjBooks.has("alternative_title_id")) {
                alternative_title_id = (JSONArray) jsonObjBooks.get("alternative_title_id");
            }

            if (jsonObjBooks.has("alternative_label_th")) {
                alternative_label_th = (JSONArray) jsonObjBooks.get("alternative_label_th");
            }

            if (jsonObjBooks.has("alternative_label_ro")) {
                alternative_label_ro = (JSONArray) jsonObjBooks.get("alternative_label_ro");
            }

            if (jsonObjBooks.has("label")) {
                label = (JSONArray) jsonObjBooks.get("label");
            }

            if (jsonObjBooks.has("upload")) {
                jsonUploaded_Name = (JSONArray) jsonObjBooks.get("upload");
            }

            if (jsonObjBooks.has("label_ro")) {
                label_ro = (JSONArray) jsonObjBooks.get("label_ro");
            }

            if (jsonObjBooks.has("pntmp_label")) {
                pntmp_label = (JSONArray) jsonObjBooks.get("pntmp_label");
            }

            /*if (jsonObjBooks.has("uploaded_file_id")) {
                uploaded_file_id = (JSONArray) jsonObjBooks.get("uploaded_file_id");
            }*/

            /*if (jsonObjBooks.has("position")) {
                position = (JSONArray) jsonObjBooks.get("position");
            }*/

            if (jsonObjBooks.has("code")) {
                code = (JSONArray) jsonObjBooks.get("code");
            }

            if (jsonObjBooks.has("province_th")) {
                province_th = (JSONArray) jsonObjBooks.get("province_th");
            }

            if (jsonObjBooks.has("province_ro")) {
                province_ro = (JSONArray) jsonObjBooks.get("province_ro");
            }

            if (jsonObjBooks.has("district_th")) {
                district_th = (JSONArray) jsonObjBooks.get("district_th");
            }

            if (jsonObjBooks.has("district_ro")) {
                district_ro = (JSONArray) jsonObjBooks.get("district_ro");
            }

            if (jsonObjBooks.has("address_th")) {
                address_th = (JSONArray) jsonObjBooks.get("address_th");
            }

            if (jsonObjBooks.has("address_ro")) {
                address_ro = (JSONArray) jsonObjBooks.get("address_ro");
            }

            if (jsonObjBooks.has("code_number")) {
                code_number = (String) jsonObjBooks.get("code_number").toString();
            }

            if (jsonObjBooks.has("in_collection")) {
                in_collection = (String) jsonObjBooks.get("in_collection").toString();
            }

            if (jsonObjBooks.has("microfilm_roll_number")) {
                microfilm_roll_number = (String) jsonObjBooks.get("microfilm_roll_number").toString();
            }

            if (jsonObjBooks.has("number_of_fascicles")) {
                number_of_fascicles = (int) jsonObjBooks.get("number_of_fascicles");
            }

            if (jsonObjBooks.has("number_of_digital_images")) {
                number_of_digital_images = (int) jsonObjBooks.get("number_of_digital_images");
            }

            if (jsonObjBooks.has("complete")) {
                complete = (Boolean) jsonObjBooks.get("complete");
            }

            if (jsonObjBooks.has("has_colophon")) {
                has_colophon = (Boolean) jsonObjBooks.get("has_colophon");
            }

            if (jsonObjBooks.has("illustrated")) {
                illustrated = (Boolean) jsonObjBooks.get("illustrated");
            }

            if (jsonObjBooks.has("directly_digitised")) {
                directly_digitised = (Boolean) jsonObjBooks.get("directly_digitised");
            }

            if (jsonObjBooks.has("legibility")) {
                legibility = (String) jsonObjBooks.get("legibility").toString();
            }

            if (jsonObjBooks.has("condition")) {
                condition = (String) jsonObjBooks.get("condition").toString();
            }

            if (jsonObjBooks.has("publication_volume")) {
                publication_volume = (String) jsonObjBooks.get("publication_volume").toString();
            }

            if (jsonObjBooks.has("location_id")) {
                location_id = (int) jsonObjBooks.get("location_id");
            }

            if (jsonObjBooks.has("pntmp_title_id")) {
                pntmp_title_id = (int) jsonObjBooks.get("pntmp_title_id");
            }
            if (jsonObjBooks.has("date_system")) {
                date_system = (String) jsonObjBooks.get("date_system").toString();
            }

            if (jsonObjBooks.has("year")) {
                year = (int) jsonObjBooks.get("year");
            }

            if (jsonObjBooks.has("thai_remarks")) {
                thai_remarks = (String) jsonObjBooks.get("thai_remarks").toString();
            }

            if (jsonObjBooks.has("remarks")) {
                remarks = (String) jsonObjBooks.get("remarks").toString();
            }

            if (jsonObjBooks.has("ce_year")) {
                ce_year = (int) jsonObjBooks.get("ce_year");
            }

            if (jsonObjBooks.has("in_private_collection")) {
                in_private_collection = (Boolean) jsonObjBooks.get("in_private_collection");
            }

            if (jsonObjBooks.has("category")) {
                category = (JSONArray) jsonObjBooks.get("category");
            }
            if (jsonObjBooks.has("language")) {
                language = (JSONArray) jsonObjBooks.get("language");
            }
            if (jsonObjBooks.has("material")) {
                material = (JSONArray) jsonObjBooks.get("material");
            }
            if (jsonObjBooks.has("script")) {
                script = (JSONArray) jsonObjBooks.get("script");
            }
            if (jsonObjBooks.has("ancillary_term")) {
                ancillary_term = (JSONArray) jsonObjBooks.get("ancillary_term");
            }
            if (jsonObjBooks.has("author")) {
                author = (JSONArray) jsonObjBooks.get("author");
            }



            if (jsonObjBooks.has("category_th")) {
                category_th = (JSONArray) jsonObjBooks.get("category_th");
            }
            if (jsonObjBooks.has("language_th")) {
                language_th = (JSONArray) jsonObjBooks.get("language_th");
            }
            if (jsonObjBooks.has("material_th")) {
                material_th = (JSONArray) jsonObjBooks.get("material_th");
            }
            if (jsonObjBooks.has("script_th")) {
                script_th = (JSONArray) jsonObjBooks.get("script_th");
            }
            if (jsonObjBooks.has("ancillary_term_th")) {
                ancillary_term_th = (JSONArray) jsonObjBooks.get("ancillary_term_th");
            }
            if (jsonObjBooks.has("author_th")) {
                author_th = (JSONArray) jsonObjBooks.get("author_th");
            }

            if (jsonObjBooks.has("uploaded_file_id")) {
                uploaded_file_id = (String) jsonObjBooks.get("uploaded_file_id");
            }

            if (jsonObjBooks.has("position")) {
                position = (String) jsonObjBooks.get("position");
            }
            if (jsonObjBooks.has("original_file_name")) {
                original_file_name = (String) jsonObjBooks.get("original_file_name");
            }


///////////////////////////////////////////////////////////////



            for (int j=0; j<jsonArrayPages.length(); j++) {
                int manuscript_id=0;

                JSONObject jsonObjPages = (JSONObject) jsonArrayPages.get(j);
                int number_of_folios =0;
                if (jsonObjPages.has("id")) {
                    manuscript_id = (int) jsonObjPages.get("id");
                }

                if (jsonObjPages.has("number_of_folios")) {
                    number_of_folios = (int) jsonObjPages.get("number_of_folios");
                }

                if (id == manuscript_id) {

                    sb.append("{" + '\n');
                    if (id != 0)
                        sb.append(quote + "id" + quote + ":" + id + "," + '\n');
                    if (code_number != "")
                        sb.append(quote + "code_number" + quote + ":" + quote + code_number + quote + "," + '\n');
                    if (state != "")
                        sb.append(quote + "state" + quote + ":" + quote + state + quote + "," + '\n');
                    if (in_collection != "")
                        sb.append(quote + "in_collection" + quote + ":" + quote + in_collection + quote + "," + '\n');

                    if (microfilm_roll_number != "")
                        sb.append(quote + "microfilm_roll_number" + quote + ":" + quote + microfilm_roll_number + quote + "," + '\n');
                    if (number_of_fascicles != 0)
                        sb.append(quote + "number_of_fascicles" + quote + ":" + number_of_fascicles + "," + '\n');
                    if (number_of_digital_images != 0)
                        sb.append(quote + "number_of_digital_images" + quote + ":" + number_of_digital_images + "," + '\n');

                    sb.append(quote + "complete" + quote + ":" + complete + "," + '\n');

                    sb.append(quote + "has_colophon" + quote + ":" + has_colophon + "," + '\n');

                    sb.append(quote + "illustrated" + quote + ":" + illustrated + "," + '\n');

                    sb.append(quote + "directly_digitised" + quote + ":" + directly_digitised + "," + '\n');

                    if (legibility != "")
                        sb.append(quote + "legibility" + quote + ":" + quote + legibility + quote + "," + '\n');
                    if (condition != "")
                        sb.append(quote + "condition" + quote + ":" + quote + condition + quote + "," + '\n');
                    if (publication_volume != "")
                        sb.append(quote + "publication_volume" + quote + ":" + quote + publication_volume + quote + "," + '\n');
                    if (location_id != 0)
                        sb.append(quote + "location_id" + quote + ":" + location_id + "," + '\n');
                    if (pntmp_title_id != 0)
                        sb.append(quote + "pntmp_title_id" + quote + ":" + pntmp_title_id + "," + '\n');
                    if (date_system != "")
                        sb.append(quote + "date_system" + quote + ":" + quote + date_system + quote + "," + '\n');
                    if (number_of_folios != 0)
                        sb.append(quote + "number_of_folios" + quote + ":" +  number_of_folios  + "," + '\n');

                    if (year != 0)
                        sb.append(quote + "year" + quote + ":" + year + "," + '\n');

                    /*if (uploaded_file_id != null)
                        sb.append(quote + "uploaded_file_id" + quote + ":" + uploaded_file_id + "," + '\n');

                    if (position != null)
                        sb.append(quote + "position" + quote + ":" + position + "," + '\n');*/

                    sb.append(quote + "upload" + quote + ":" + jsonUploaded_Name + "," + '\n');

                    if (code != null)
                        sb.append(quote + "code" + quote + ":" + code + "," + '\n');

                    if (province_th != null)
                        sb.append(quote + "province_th" + quote + ":" + province_th + "," + '\n');
                    if (province_ro != null)
                        sb.append(quote + "province_ro" + quote + ":" + province_ro + "," + '\n');
                    if (district_th != null)
                        sb.append(quote + "district_th" + quote + ":" + district_th + "," + '\n');
                    if (district_ro != null)
                        sb.append(quote + "district_ro" + quote + ":" + district_ro + "," + '\n');
                    if (address_th != null)
                        sb.append(quote + "address_th" + quote + ":" + address_th + "," + '\n');
                    if (address_ro != null)
                        sb.append(quote + "address_ro" + quote + ":" + address_ro + "," + '\n');
                    if (latitude != null)
                        sb.append(quote + "latitude" + quote + ":" + latitude + "," + '\n');
                    if (longitude!= null)
                        sb.append(quote + "longitude" + quote + ":" + longitude + "," + '\n');

                        sb.append(quote + "exact" + quote + ":" + exact + "," + '\n');
                    if (website != null)
                        sb.append(quote + "website" + quote + ":" + website + "," + '\n');
                    if (manuscripts_count != null)
                        sb.append(quote + "manuscripts_count" + quote + ":" + manuscripts_count + "," + '\n');
                    if (dlntm_title_id != null)
                        sb.append(quote + "dlntm_title_id" + quote + ":" + dlntm_title_id + "," + '\n');
                    if (dlntm_label_th != null)
                        sb.append(quote + "dlntm_label_th" + quote + ":" + dlntm_label_th + "," + '\n');
                    if (dlntm_label_ro != null)
                        sb.append(quote + "dlntm_label_ro" + quote + ":" + dlntm_label_ro + "," + '\n');
                    if (alternative_title_id != null)
                        sb.append(quote + "alternative_title_id" + quote + ":" + alternative_title_id + "," + '\n');
                    if (alternative_label_th != null)
                        sb.append(quote + "alternative_label_th" + quote + ":" + alternative_label_th + "," + '\n');
                    if (alternative_label_ro != null)
                        sb.append(quote + "alternative_label_ro" + quote + ":" + alternative_label_ro + "," + '\n');
                    if (label != null)
                        sb.append(quote + "label" + quote + ":" + label + "," + '\n');
                    if (label_ro != null)
                        sb.append(quote + "label_ro" + quote + ":" + label_ro + "," + '\n');
                    if (pntmp_label != null)
                        sb.append(quote + "pntmp_label" + quote + ":" + pntmp_label + "," + '\n');

                    if (thai_remarks != "")
                        sb.append(quote + "thai_remarks" + quote + ":" + quote + thai_remarks + quote + "," + '\n');
                    if (remarks != "")
                        sb.append(quote + "remarks" + quote + ":" + quote + remarks + quote + "," + '\n');
                    if (ce_year != 0)
                        sb.append(quote + "ce_year" + quote + ":" + ce_year + "," + '\n');

                    sb.append(quote + "in_private_collection" + quote + ":" + in_private_collection + "," + '\n');
                    if (category != null)
                        sb.append(quote + "category" + quote + ":" + category + "," + '\n');
                    if (language != null)
                        sb.append(quote + "language" + quote + ":" + language + "," + '\n');
                    if (material != null)
                        sb.append(quote + "material" + quote + ":" + material + "," + '\n');
                    if (script != null)
                        sb.append(quote + "script" + quote + ":" + script + "," + '\n');
                    if (ancillary_term != null)
                        sb.append(quote + "ancillary_term" + quote + ":" + ancillary_term + "," + '\n');
                    if (author != null)
                        sb.append(quote + "author" + quote + ":" + author + "," + '\n');
                    if (category_th != null)
                        sb.append(quote + "category_th" + quote + ":" + category_th + "," + '\n');
                    if (language_th != null)
                        sb.append(quote + "language_th" + quote + ":" + language_th + "," + '\n');
                    if (material_th != null)
                        sb.append(quote + "material_th" + quote + ":" + material_th + "," + '\n');

                    if (script_th != null)
                        sb.append(quote + "script_th" + quote + ":" + script_th + "," + '\n');
                    if (ancillary_term_th != null)
                        sb.append(quote + "ancillary_term_th" + quote + ":" + ancillary_term_th + "," + '\n');
                    if (author_th != null)
                        sb.append(quote + "author_th" + quote + ":" + author_th + "" + '\n');
                    sb.append("},");
                } else {
                    System.out.println("No" + id);
                }
            }
        }
        //sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}
