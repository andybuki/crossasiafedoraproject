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

public class ManuscriptsTransformation2 {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String pages = "/data/iiif/manuscript_title_searches2.json";
        String manuscripts = "/data/iiif/manuscripts2.json";
        StringBuilder sb = new StringBuilder();
        JSONArray jsonArrayBooks = new JSONArray(new JSONTokener(new FileInputStream(manuscripts)));
        JSONArray jsonArrayPages = new JSONArray(new JSONTokener(new FileInputStream(pages)));
        PrintStream out = new PrintStream(new FileOutputStream("/data/iiif/manuscripts_NEW.json"));

        List<Integer> title_search_term_ids =new ArrayList<>();
        int manuscript_id=0;
        int title_search_term_id = 0;
        for (int j=0; j<jsonArrayPages.length(); j++) {

            JSONObject jsonObjPages = (JSONObject) jsonArrayPages.get(j);


            if (jsonObjPages.has("manuscript_id")) {
                manuscript_id = (int) jsonObjPages.get("manuscript_id");
            }


            if (jsonObjPages.has("title_search_term_id")) {
                title_search_term_id = (int) jsonObjPages.get("title_search_term_id");


            }



        for (int i=0; i<jsonArrayBooks.length();i++){

            int id =0;
            String code_number ="";
            String microfilm_roll_number ="";
            int number_of_fascicles =0;
            int number_of_digital_images =0;
            boolean  complete =false;
            boolean  has_colophon =false;
            boolean  illustrated =false;
            boolean  directly_digitised =false;
            String  legibility ="";
            String condition ="";
            String publication_volume ="";
            int location_id =0;
            int pntmp_title_id =0;

            String date_system ="";
            int year =0;
            String thai_remarks ="";
            int ce_year =0;
            boolean  in_private_collection =false;

            JSONObject jsonObjBooks = (JSONObject) jsonArrayBooks.get(i);

            if (jsonObjBooks.has("id")) {
                id = (int) jsonObjBooks.get("id");
            }

            if (jsonObjBooks.has("code_number")) {
                code_number = (String) jsonObjBooks.get("code_number").toString();
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

            if (jsonObjBooks.has("ce_year")) {
                ce_year = (int) jsonObjBooks.get("ce_year");
            }

            if (jsonObjBooks.has("in_private_collection")) {
                in_private_collection = (Boolean) jsonObjBooks.get("in_private_collection");
            }


                if (id == manuscript_id) {
                    //title_search_term_ids.add(title_search_term_id);
                    sb.append("{" + '\n');
                    if (id != 0)
                        sb.append(quote + "id" + quote + ":" + id + "," + '\n');
                    if (code_number != "")
                        sb.append(quote + "code_number" + quote + ":" + quote + code_number + quote + "," + '\n');

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
                    if (year != 0)
                        sb.append(quote + "year" + quote + ":" + year + "," + '\n');
                    if (thai_remarks != "")
                        sb.append(quote + "thai_remarks" + quote + ":" + quote + thai_remarks + quote + "," + '\n');
                    if (ce_year != 0)
                        sb.append(quote + "ce_year" + quote + ":" + ce_year + "," + '\n');

                    sb.append(quote + "in_private_collection" + quote + ":" + in_private_collection + "," + '\n');
                    sb.append(quote + "title_search_term_id" + quote + ":" + title_search_term_id + "" + '\n');

                    sb.append("},");
                } else {
                    System.out.println("No" + id);
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}
