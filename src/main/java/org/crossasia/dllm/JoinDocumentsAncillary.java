package org.crossasia.dllm;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class JoinDocumentsAncillary {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String documents = "/data1/dllm/documents_full_new.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/dllm/documents_final_new2.json"));

        JSONArray documentsObject = new JSONArray(new JSONTokener(new FileInputStream(documents)));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<documentsObject.length(); i++) {

            int id ;
            String code_number ="";
            String roll = "";
            String date_written ="";
            int number_of_fascicles=0;
            int number_of_folios=0;
            int has_colophon=0;
            int is_illustrated=0;
            String bundle_id="";
            int position_in_bundle=0;
            int pages_count=0;
            int locations_id=0;
            int locations_parent_id=0;

            String public_remarks_en = "";
            String public_remarks_lo ="";

            String private_remarks_en="";
            String private_remarks_lo ="";

            int is_color=0;


            int is_complete=0;

            String materials ="";
            String materials_lao="";

            String name_location="";
            String name_location_lao="";

            String location ="";
            String location_place ="";
            String location_place_lao="";
            int location_lft=0;
            int location_rgt=0;
            int location_code=0;
            double location_lat=0.0;
            double location_lon=0.0;
            int location_documents_count=0;
            String legibilities ="";
            String legibilities_lao ="";
            String additional_date_infos_roman ="";
            String additional_date_infos_lao ="";
            String conditions ="";
            String conditions_lao ="";
            String preferred_date_systems ="";
            String preferred_date_systems_lao ="";

            JSONArray term_roman=null;
            JSONArray term_lao=null;
            LinkedHashSet<String> term_roman_new = null;
            LinkedHashSet<String> term_lao_new = null;

            JSONArray languages = null;
            JSONArray languages_lao = null;
            LinkedHashSet<String> languages_new = null;
            LinkedHashSet<String> languages_lao_new = null;

            JSONArray remark_english = null;
            JSONArray remark_lao = null;
            LinkedHashSet<String> remark_english_new = null;
            LinkedHashSet<String> remark_lao_new = null;

            JSONArray categories = null;
            JSONArray categories_lao = null;
            LinkedHashSet<String> categories_new = null;
            LinkedHashSet<String> categories_lao_new = null;

            JSONArray scripts = null;
            JSONArray scripts_lao = null;
            LinkedHashSet<String> scripts_new = null;
            LinkedHashSet<String> scripts_lao_new = null;

            JSONArray title_search_roman = null;
            JSONArray title_search_lao = null;
            LinkedHashSet<String> title_search_roman_new = null;
            LinkedHashSet<String> title_search_lao_new = null;

            JSONArray title_roman = null;
            JSONArray title_lao = null;
            LinkedHashSet<String> title_roman_new = null;
            LinkedHashSet<String> title_lao_new = null;

            JSONArray plmp_title_lao = null;
            LinkedHashSet<String> plmp_title_lao_new = null;
            
            

            JSONObject documentsObj = (JSONObject) documentsObject.get(i);


            id = (int) documentsObj.get("id");

            if (documentsObj.has("term_roman")) {
                term_roman = (JSONArray) documentsObj.get("term_roman");
                List <String> list= new ArrayList<>();
                for (int k = 0; k<term_roman.length(); k++)  {
                    list.add(quote+term_roman.get(k).toString()+quote);
                }
                term_roman_new = new LinkedHashSet<String>((list));
            }

            if (documentsObj.has("term_lao")) {
                term_lao = (JSONArray) documentsObj.get("term_lao");
                List <String> list= new ArrayList<>();
                for (int k = 0; k<term_lao.length(); k++)  {
                    list.add(quote+term_lao.get(k).toString()+quote);
                }
                term_lao_new = new LinkedHashSet<String>((list));
            }

            if (documentsObj.has("remark_english")) {
                remark_english = (JSONArray) documentsObj.get("remark_english");
                List <String> list= new ArrayList<>();
                for (int k = 0; k<remark_english.length(); k++)  {
                    list.add(quote+remark_english.get(k).toString()+quote);
                }
                remark_english_new = new LinkedHashSet<String>((list));
            }

            if (documentsObj.has("remark_lao")) {
                remark_lao = (JSONArray) documentsObj.get("remark_lao");
                List <String> list= new ArrayList<>();
                for (int k = 0; k<remark_lao.length(); k++)  {
                    list.add(quote+remark_lao.get(k).toString()+quote);
                }
                remark_lao_new = new LinkedHashSet<String>((list));
            }

            if (documentsObj.has("titles")) {
                title_roman = (JSONArray) documentsObj.get("titles");
                List <String> list= new ArrayList<>();
                for (int k = 0; k<title_roman.length(); k++)  {
                    list.add(quote+title_roman.get(k).toString()+quote);
                }
                title_roman_new = new LinkedHashSet<String>((list));
            }

            if (documentsObj.has("titles_lao")) {
                title_lao = (JSONArray) documentsObj.get("titles_lao");

                List <String> list= new ArrayList<>();
                for (int k = 0; k<title_lao.length(); k++)  {
                    list.add(quote+title_lao.get(k).toString()+quote);
                }
                title_lao_new = new LinkedHashSet<String>((list));
            }

            if (documentsObj.has("plmp_titles_lao")) {
                plmp_title_lao = (JSONArray) documentsObj.get("plmp_titles_lao");

                List <String> list= new ArrayList<>();
                for (int k = 0; k<plmp_title_lao.length(); k++)  {
                    list.add(quote+plmp_title_lao.get(k).toString()+quote);
                }
                plmp_title_lao_new = new LinkedHashSet<String>((list));
            }

            if (documentsObj.has("title_search_roman")) {
                title_search_roman = (JSONArray) documentsObj.get("title_search_roman");
                List <String> list= new ArrayList<>();
                for (int k = 0; k<title_search_roman.length(); k++)  {
                    list.add(quote+title_search_roman.get(k).toString()+quote);
                }
                title_search_roman_new = new LinkedHashSet<String>((list));

            }

            if (documentsObj.has("title_search_lao")) {
                title_search_lao = (JSONArray) documentsObj.get("title_search_lao");

                List <String> list= new ArrayList<>();
                for (int k = 0; k<title_search_lao.length(); k++)  {
                    list.add(quote+title_search_lao.get(k).toString()+quote);
                }
                title_search_lao_new = new LinkedHashSet<String>((list));

            }

            if (documentsObj.has("scripts")) {
                scripts = (JSONArray) documentsObj.get("scripts");
                List <String> list= new ArrayList<>();
                for (int k = 0; k<scripts.length(); k++)  {
                    list.add(quote+scripts.get(k).toString()+quote);
                }
                scripts_new = new LinkedHashSet<String>((list));
            }

            if (documentsObj.has("scripts_lao")) {
                scripts_lao = (JSONArray) documentsObj.get("scripts_lao");

                List <String> list= new ArrayList<>();
                for (int k = 0; k<scripts_lao.length(); k++)  {
                    list.add(quote+scripts_lao.get(k).toString()+quote);
                }
                scripts_lao_new = new LinkedHashSet<String>((list));

            }


            if (documentsObj.has("languages")) {
                languages = (JSONArray) documentsObj.get("languages");
                List <String> list= new ArrayList<>();
                for (int k = 0; k<languages.length(); k++)  {
                    list.add(quote+languages.get(k).toString()+quote);
                }
                languages_new = new LinkedHashSet<String>((list));
            }

            if (documentsObj.has("languages_lao")) {
                languages_lao = (JSONArray) documentsObj.get("languages_lao");

                List <String> list= new ArrayList<>();
                for (int k = 0; k<languages_lao.length(); k++)  {
                    list.add(quote+languages_lao.get(k).toString()+quote);
                }
                languages_lao_new = new LinkedHashSet<String>((list));

            }

            if (documentsObj.has("categories")) {
                categories = (JSONArray) documentsObj.get("categories");
                List <String> list= new ArrayList<>();
                for (int k = 0; k<categories.length(); k++)  {
                    list.add(quote+categories.get(k).toString()+quote);
                }
                categories_new = new LinkedHashSet<String>((list));


            }

            if (documentsObj.has("categories_lao")) {
                categories_lao = (JSONArray) documentsObj.get("categories_lao");

                List <String> list= new ArrayList<>();
                for (int k = 0; k<categories_lao.length(); k++)  {
                    list.add(quote+categories_lao.get(k).toString()+quote);
                }
                categories_lao_new = new LinkedHashSet<String>((list));

            }

            if (documentsObj.has("code_number"))
                code_number = (String) documentsObj.get("code_number").toString();

            if (documentsObj.has("roll"))
                roll = (String) documentsObj.get("roll").toString();

            if (documentsObj.has("date_written"))
                date_written = (String) documentsObj.get("date_written").toString();

            if (documentsObj.has("name_location"))
                name_location = (String) documentsObj.get("name_location").toString();

            if (documentsObj.has("name_location_lao"))
                name_location_lao = (String) documentsObj.get("name_location_lao").toString();

            if (documentsObj.has("number_of_fascicles"))
                number_of_fascicles = (int) documentsObj.get("number_of_fascicles");

            if (documentsObj.has("number_of_folios"))
                number_of_folios = (int) documentsObj.get("number_of_folios");

            if (documentsObj.has("has_colophon"))
                has_colophon = (int) documentsObj.get("has_colophon");

            if (documentsObj.has("is_illustrated"))
                is_illustrated = (int) documentsObj.get("is_illustrated");

            if (documentsObj.has("locations_id"))
                locations_id = (int) documentsObj.get("locations_id");

            if (documentsObj.has("locations_parent_id"))
                locations_parent_id = (int) documentsObj.get("locations_parent_id");

            if (documentsObj.has("is_complete"))
                is_complete = (int) documentsObj.get("is_complete");

            if (documentsObj.has("bundle_id"))
                bundle_id = (String) documentsObj.get("bundle_id").toString();

            if (documentsObj.has("position_in_bundle"))
                position_in_bundle = (int) documentsObj.get("position_in_bundle");

            if (documentsObj.has("pages_count"))
                pages_count = (int) documentsObj.get("pages_count");

            if (documentsObj.has("public_remarks_en"))
                public_remarks_en = (String) documentsObj.get("public_remarks_en").toString();

            if (documentsObj.has("public_remarks_lo"))
                public_remarks_lo = (String) documentsObj.get("public_remarks_lo").toString();

            if (documentsObj.has("private_remarks_en"))
                private_remarks_en = (String) documentsObj.get("private_remarks_en").toString();

            if (documentsObj.has("private_remarks_lo"))
                private_remarks_lo = (String) documentsObj.get("private_remarks_lo").toString();

            if (documentsObj.has("is_color"))
                is_color = (int) documentsObj.get("is_color");

            if (documentsObj.has("materials"))
                materials = (String) documentsObj.get("materials").toString();

            if (documentsObj.has("materials_lao"))
                materials_lao = (String) documentsObj.get("materials_lao").toString();

            if (documentsObj.has("location"))
                location = (String) documentsObj.get("location").toString();

            if (documentsObj.has("location_place"))
                location_place = (String) documentsObj.get("location_place").toString();

            if (documentsObj.has("location_place_lao"))
                location_place_lao = (String) documentsObj.get("location_place_lao").toString();

            if (documentsObj.has("location_lft"))
                location_lft = (int) documentsObj.get("location_lft");

            if (documentsObj.has("location_rgt"))
                location_rgt = (int) documentsObj.get("location_rgt");

            if (documentsObj.has("location_code"))
                location_code = (int) documentsObj.get("location_code");

            if (documentsObj.has("location_lat"))
                location_lat = (double) documentsObj.get("location_lat");

            if (documentsObj.has("location_lon"))
                location_lon = (double) documentsObj.get("location_lon");

            if (documentsObj.has("location_documents_count"))
                location_documents_count = (int) documentsObj.get("location_documents_count");

            if (documentsObj.has("legibilities"))
                legibilities = (String) documentsObj.get("legibilities").toString();

            if (documentsObj.has("legibilities_lao"))
                legibilities_lao = (String) documentsObj.get("legibilities_lao").toString();

            if (documentsObj.has("additional_date_infos_roman"))
                additional_date_infos_roman = (String) documentsObj.get("additional_date_infos_roman").toString();

            if (documentsObj.has("additional_date_infos_lao"))
                additional_date_infos_lao = (String) documentsObj.get("additional_date_infos_lao").toString();

            if (documentsObj.has("conditions"))
                conditions = (String) documentsObj.get("conditions").toString();

            if (documentsObj.has("conditions_lao"))
                conditions_lao = (String) documentsObj.get("conditions_lao").toString();

            if (documentsObj.has("preferred_date_systems"))
                preferred_date_systems = (String) documentsObj.get("preferred_date_systems").toString();

            if (documentsObj.has("preferred_date_systems_lao"))
                preferred_date_systems_lao = (String) documentsObj.get("preferred_date_systems_lao").toString();


                    sb.append("{"+ '\n');
                    sb.append(  quote + "id" + quote + ":" +  id+  "," + '\n' );

                    if (code_number!="") {
                        sb.append(quote + "code_number" + quote + ":" + quote+ code_number + quote  + "," + '\n');
                    }

                    if (roll!="") {
                        sb.append(quote + "roll" + quote + ":" + quote+ roll + quote  + "," + '\n');
                    }

                    if (date_written!="") {
                        sb.append(quote + "date_written" + quote + ":" + quote+ date_written + quote  + "," + '\n');
                    }

                    //if (number_of_fascicles!=0) {
                        sb.append(quote + "number_of_fascicles" + quote + ":" + number_of_fascicles   + "," + '\n');
                    //}

                    //if (number_of_folios!=0) {
                        sb.append(quote + "number_of_folios" + quote + ":" + number_of_folios   + "," + '\n');
                    //}

                    //if (has_colophon!=0) {
                        sb.append(quote + "has_colophon" + quote + ":" + has_colophon   + "," + '\n');
                    //}

                    //if (is_illustrated!=0) {
                        sb.append(quote + "is_illustrated" + quote + ":" + is_illustrated   + "," + '\n');
                    //}

                    //if (is_color!=0) {
                        sb.append(quote + "is_color" + quote + ":" + is_color   + "," + '\n');
                    //}

                    if (bundle_id!="") {
                        sb.append(quote + "bundle_id" + quote + ":" + quote+ bundle_id+ quote  + "," + '\n');
                    }

                    //if (locations_id!=0) {
                        sb.append(quote + "locations_id" + quote + ":" +  locations_id  + "," + '\n');
                    //}

                    //if (locations_parent_id!=0) {
                                sb.append(quote + "locations_parent_id" + quote + ":" +  locations_parent_id  + "," + '\n');
                    //}

                    //if (position_in_bundle!=0) {
                                sb.append(quote + "position_in_bundle" + quote + ":" + position_in_bundle   + "," + '\n');
                    //}

                    //if (is_complete!=0) {
                        sb.append(quote + "is_complete" + quote + ":" + is_complete   + "," + '\n');
                    //}

                    //if (pages_count!=0) {
                        sb.append(quote + "pages_count" + quote + ":" + pages_count   + "," + '\n');
                    //}

                    if (materials!="") {
                        sb.append(quote + "materials" + quote + ":" + quote+ materials + quote  + "," + '\n');
                    }

                    if (materials_lao!="") {
                        sb.append(quote + "materials_lao" + quote + ":" + quote+ materials_lao + quote  + "," + '\n');
                    }

                    if (public_remarks_en!="") {
                        sb.append(quote + "public_remarks_en" + quote + ":" + quote+ public_remarks_en + quote  + "," + '\n');
                    }

                    if (public_remarks_lo!="") {
                        sb.append(quote + "public_remarks_lo" + quote + ":" + quote+ public_remarks_lo + quote  + "," + '\n');
                    }

                    if (private_remarks_en!="") {
                        sb.append(quote + "private_remarks_en" + quote + ":" + quote+ private_remarks_en + quote  + "," + '\n');
                    }

                    if (private_remarks_lo!="") {
                        sb.append(quote + "private_remarks_lo" + quote + ":" + quote+ private_remarks_lo + quote  + "," + '\n');
                    }

                    if (location!="") {
                        sb.append(quote + "location" + quote + ":" + quote+ location + quote  + "," + '\n');
                    }

                    if (location_place!="") {
                        sb.append(quote + "location_place" + quote + ":" + quote+ location_place + quote  + "," + '\n');
                    }

                    if (name_location!="") {
                        sb.append(quote + "name_location" + quote + ":" + quote+ name_location + quote  + "," + '\n');
                    }

                    if (name_location_lao!="") {
                        sb.append(quote + "name_location_lao" + quote + ":" + quote+ name_location_lao + quote  + "," + '\n');
                    }

                    if (location_place_lao!="") {
                        sb.append(quote + "location_place_lao" + quote + ":" + quote+ location_place_lao + quote  + "," + '\n');
                    }

                    //if (location_lft!=0) {
                        sb.append(quote + "location_lft" + quote + ":" + location_lft   + "," + '\n');
                    //}

                    //if (location_rgt!=0) {
                        sb.append(quote + "location_rgt" + quote + ":" + location_rgt   + "," + '\n');
                    //}

                    //if (location_code!=0) {
                        sb.append(quote + "location_code" + quote + ":" + location_code   + "," + '\n');
                    //}

                    if (location_lat!=0.0) {
                        sb.append(quote + "location_lat" + quote + ":" + location_lat   + "," + '\n');
                    }

                    if (location_lon!=0.0) {
                        sb.append(quote + "location_lon" + quote + ":" + location_lon   + "," + '\n');
                    }

                    if (term_roman_new != null)
                        sb.append(quote + "term_roman" + quote + ":" +  term_roman_new + "," + '\n');

                    if (term_lao_new != null)
                        sb.append(quote + "term_lao" + quote + ":" +  term_lao_new + "," + '\n');

                    if (remark_english_new != null)
                        sb.append(quote + "remark_english" + quote + ":" +  remark_english_new + "," + '\n');

                    if (remark_lao_new != null)
                        sb.append(quote + "remark_lao" + quote + ":" +  remark_lao_new + "," + '\n');

                    if (categories_new != null)
                        sb.append(quote + "categories" + quote + ":" +  categories_new + "," + '\n');

                    if (categories_lao_new != null)
                        sb.append(quote + "categories_lao" + quote + ":" +  categories_lao_new + "," + '\n');

                    if (languages_new != null)
                        sb.append(quote + "languages" + quote + ":" +  languages_new + "," + '\n');

                    if (languages_lao_new != null)
                        sb.append(quote + "languages_lao" + quote + ":" +  languages_lao_new + "," + '\n');

                    if (scripts_new != null)
                        sb.append(quote + "scripts" + quote + ":" +  scripts_new + "," + '\n');

                    if (scripts_lao_new != null)
                        sb.append(quote + "scripts_lao" + quote + ":" +  scripts_lao_new + "," + '\n');

                    if (title_search_roman_new != null)
                        sb.append(quote + "title_search_roman" + quote + ":" +  title_search_roman_new + "," + '\n');

                    if (title_search_lao_new != null)
                        sb.append(quote + "title_search_lao" + quote + ":" +  title_search_lao_new + "," + '\n');

                    if (title_roman_new != null)
                        sb.append(quote + "title_roman" + quote + ":" +  title_roman_new + "," + '\n');

                    if (title_lao_new != null)
                        sb.append(quote + "title_lao" + quote + ":" +  title_lao_new + "," + '\n');

                    if (plmp_title_lao_new != null)
                        sb.append(quote + "plmp_title_lao" + quote + ":" +  plmp_title_lao_new + "," + '\n');


                    //if (location_documents_count!=0) {
                        sb.append(quote + "location_documents_count" + quote + ":" + location_documents_count   + "," + '\n');
                    //}


                    if (legibilities!="") {
                        sb.append(quote + "legibilities" + quote + ":" + quote+ legibilities + quote  + "," + '\n');
                    }

                    if (legibilities_lao!="") {
                        sb.append(quote + "legibilities_lao" + quote + ":" + quote+ legibilities_lao + quote  + "," + '\n');
                    }

                    if (additional_date_infos_roman!="") {
                        sb.append(quote + "additional_date_infos_roman" + quote + ":" + quote+ additional_date_infos_roman + quote  + "," + '\n');
                    }

                    if (additional_date_infos_lao!="") {
                        sb.append(quote + "additional_date_infos_lao" + quote + ":" + quote+ additional_date_infos_lao + quote  + "," + '\n');
                    }

                    if (conditions!="") {
                        sb.append(quote + "conditions" + quote + ":" + quote+ conditions + quote  + "," + '\n');
                    }

                    if (conditions_lao!="") {
                        sb.append(quote + "conditions_lao" + quote + ":" + quote+ conditions_lao + quote  + "," + '\n');
                    }

                    if (preferred_date_systems!="") {
                        sb.append(quote + "preferred_date_systems" + quote + ":" + quote+ preferred_date_systems + quote  + "," + '\n');
                    }

                    if (preferred_date_systems_lao!="") {
                        sb.append(quote + "preferred_date_systems_lao" + quote + ":" + quote+ preferred_date_systems_lao + quote  + "," + '\n');
                    }

                    sb.append(  quote + "hasModel" + quote + ":" + quote+ "Document"+ quote + "," + '\n' );
                    sb.append(  quote + "collection" + quote + ":" + quote+ "Dllm"+ quote + "" + '\n' );

                    sb.append("},");

            }


        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}
