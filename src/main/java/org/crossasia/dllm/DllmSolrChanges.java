package org.crossasia.dllm;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class DllmSolrChanges {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String books = "/data1/dllm/solr/dllm_solr_last.json";
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        PrintStream out = new PrintStream(new FileOutputStream("/data1/dllm/solr/dllm_solr_last2.json"));
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            String id = "";
            String code_number ="";
            String roll = "";
            String date_written ="";
            int date_written_right =0;
            int number_of_fascicles=0;
            int number_of_folios=0;
            String has_colophon_str ="";
            String has_colophon="";
            String is_illustrated="";
            String is_illustrated_str ="";
            String bundle_id="";
            int position_in_bundle=0;
            int pages_count=0;
            String private_remarks_en="";
            String private_remarks_lo ="";
            String is_color="";
            String is_color_str ="";
            String is_complete="";
            String is_complete_str="";
            String materials ="";
            String materials_lao="";
            int locations_id=0;
            String locations_parent_id="";
            String name_location="";
            String name_location_lao="";

            String full_location_name="";
            String parent_name="";
            String parent_parent_name="";
            String parent_name_lao="";
            String parent_parent_name_lao="";
            String full_name_lao="";
            String location_place ="";
            String location_place_lao="";
            int location_lft=0;
            int location_rgt=0;
            int location_code=0;

            String location_lat="";
            String location_lon="";
            int location_documents_count=0;
            String legibilities = "";
            String legibilities_lao = "";
            String conditions = "";
            String conditions_lao ="";

            String preferred_date_systems = "";
            String preferred_date_systems_lao = "";

            String temporal_date ="";
            String temporal_date_lao ="";


            String public_remarks_en = "";
            String public_remarks_lo ="";

            String location ="";


            String additional_date_infos_roman = "";
            String additional_date_infos_lao = "";



            JSONArray languages = null;
            JSONArray languages_lao = null;

            JSONArray remark_lao = null;
            JSONArray remark_english = null;

            JSONArray term_roman = null;
            JSONArray term_leo = null;

            JSONArray categories = null;
            JSONArray categories_lao = null;

            JSONArray scripts = null;
            JSONArray scripts_lao = null;

            JSONArray titles = null;
            JSONArray titles_lao = null;

            JSONArray title_search_roman = null;
            JSONArray title_search_lao = null;

            JSONArray plmp_title_lao = null;

            JSONObject jsonObj = (JSONObject) booksObject.get(i);


            if (jsonObj.has("id")) {
                id = (String) jsonObj.get("id").toString();
            }
            if (jsonObj.has("code_number"))
                code_number = (String) jsonObj.get("code_number").toString();

            if (jsonObj.has("roll"))
                roll = (String) jsonObj.get("roll").toString();

            if (jsonObj.has("date_written")) {
                date_written = (String) jsonObj.get("date_written").toString();
                String[] spl = date_written.split("-");
                date_written_right = Integer.parseInt(spl[0]);
            }

            if (jsonObj.has("parent_name"))
                parent_name = (String) jsonObj.get("parent_name").toString();

            if (jsonObj.has("parent_parent_name"))
                parent_parent_name = (String) jsonObj.get("parent_parent_name").toString();

            if (jsonObj.has("parent_name_lao"))
                parent_name_lao = (String) jsonObj.get("parent_name_lao").toString();

            if (jsonObj.has("parent_parent_name_lao"))
                parent_parent_name_lao = (String) jsonObj.get("parent_parent_name_lao").toString();

            if (jsonObj.has("name_location"))
                name_location = (String) jsonObj.get("name_location").toString();

            if (jsonObj.has("name_location_lao"))
                name_location_lao = (String) jsonObj.get("name_location_lao").toString();

            if (jsonObj.has("number_of_fascicles"))
                number_of_fascicles = (int) jsonObj.get("number_of_fascicles");

            if (jsonObj.has("number_of_folios"))
                number_of_folios = (int) jsonObj.get("number_of_folios");

            if (jsonObj.has("has_colophon")) {
                has_colophon = (String) jsonObj.get("has_colophon");
            }

            if (jsonObj.has("is_illustrated")) {
                is_illustrated = (String) jsonObj.get("is_illustrated");
            }

            if (jsonObj.has("locations_id"))
                locations_id = (int) jsonObj.get("locations_id");

            if (jsonObj.has("locations_parent_id"))
                locations_parent_id = (String) jsonObj.get("locations_parent_id");

            if (jsonObj.has("is_complete")) {
                is_complete = (String) jsonObj.get("is_complete");
            }

            if (jsonObj.has("bundle_id"))
                bundle_id = (String) jsonObj.get("bundle_id").toString();

            if (jsonObj.has("position_in_bundle"))
                position_in_bundle = (int) jsonObj.get("position_in_bundle");

            if (jsonObj.has("pages_count"))
                pages_count = (int) jsonObj.get("pages_count");

            if (jsonObj.has("public_remarks_en"))
                public_remarks_en = (String) jsonObj.get("public_remarks_en").toString();

            if (jsonObj.has("public_remarks_lo"))
                public_remarks_lo = (String) jsonObj.get("public_remarks_lo").toString();

            if (jsonObj.has("private_remarks_en"))
                private_remarks_en = (String) jsonObj.get("private_remarks_en").toString();

            if (jsonObj.has("private_remarks_lo"))
                private_remarks_lo = (String) jsonObj.get("private_remarks_lo").toString();

            if (jsonObj.has("is_color")) {
                is_color = (String) jsonObj.get("is_color");
            }

            if (jsonObj.has("materials"))
                materials = (String) jsonObj.get("materials").toString();

            if (jsonObj.has("materials_lao"))
                materials_lao = (String) jsonObj.get("materials_lao").toString();

            if (jsonObj.has("location"))
                location = (String) jsonObj.get("location").toString();

            if (jsonObj.has("location_place"))
                location_place = (String) jsonObj.get("location_place").toString();

            if (jsonObj.has("location_place_lao"))
                location_place_lao = (String) jsonObj.get("location_place_lao").toString();

            if (jsonObj.has("location_lft"))
                location_lft = (int) jsonObj.get("location_lft");

            if (jsonObj.has("location_rgt"))
                location_rgt = (int) jsonObj.get("location_rgt");

            if (jsonObj.has("location_code"))
                location_code = (int) jsonObj.get("location_code");

            if (jsonObj.has("location_lat"))
                location_lat = (String) jsonObj.get("location_lat");

            if (jsonObj.has("location_lon"))
                location_lon = (String) jsonObj.get("location_lon");

            if (jsonObj.has("location_documents_count"))
                location_documents_count = (int) jsonObj.get("location_documents_count");

            if (jsonObj.has("legibilities"))
                legibilities = (String) jsonObj.get("legibilities").toString();

            if (jsonObj.has("legibilities_lao"))
                legibilities_lao = (String) jsonObj.get("legibilities_lao").toString();

            if (jsonObj.has("additional_date_infos_roman"))
                additional_date_infos_roman = (String) jsonObj.get("additional_date_infos_roman").toString();

            if (jsonObj.has("additional_date_infos_lao"))
                additional_date_infos_lao = (String) jsonObj.get("additional_date_infos_lao").toString();

            if (jsonObj.has("conditions"))
                conditions = (String) jsonObj.get("conditions").toString();

            if (jsonObj.has("full_location_name"))
                full_location_name = (String) jsonObj.get("full_location_name").toString();

            if (jsonObj.has("full_name_lao"))
                full_name_lao = (String) jsonObj.get("full_name_lao").toString();


            if (jsonObj.has("conditions_lao"))
                conditions_lao = (String) jsonObj.get("conditions_lao").toString();

            if (jsonObj.has("preferred_date_systems")) {
                preferred_date_systems = (String) jsonObj.get("preferred_date_systems").toString();

                /*if (preferred_date_systems.equals("Buddhist Era (BE)")) {
                    date_written_right = date_written_right+ 543;
                    temporal_date = date_written_right+" (Buddhist Era)";
                    temporal_date_lao = date_written_right+" (ພຸດທະສັກກະລາດ (ພສ))";

                } else if (preferred_date_systems.equals("Cunlasakkalat (CS)")) {
                    date_written_right = date_written_right- 638;
                    temporal_date = date_written_right+" (Cunlasakkalat)";
                    temporal_date_lao = date_written_right+" (ບໍ່ປາກົດປີລິດຈະນາ)";

                } else if (preferred_date_systems.equals("Undated")) {
                    temporal_date = "(Undated)";
                    temporal_date_lao = "(ບໍ່ປາກົດປີລິດຈະນາ)";
                } else {
                    temporal_date = date_written_right+" (Christian Era)";
                    temporal_date_lao = date_written_right+" (ຄິດຕະສັກກະລາດ (ຄສ))";
                }*/
            }


            if (jsonObj.has("preferred_date_systems_lao"))
                preferred_date_systems_lao = (String) jsonObj.get("preferred_date_systems_lao").toString();

            if (jsonObj.has("languages")) {
                languages = (JSONArray) jsonObj.get("languages");
            }

            if (jsonObj.has("languages_lao")) {
                languages_lao = (JSONArray) jsonObj.get("languages_lao");
            }

            if (jsonObj.has("categories")) {
                categories = (JSONArray) jsonObj.get("categories");
            }

            if (jsonObj.has("categories_lao")) {
                categories_lao = (JSONArray) jsonObj.get("categories_lao");
            }

            if (jsonObj.has("scripts")) {
                scripts = (JSONArray) jsonObj.get("scripts");
            }

            if (jsonObj.has("scripts_lao")) {
                scripts_lao = (JSONArray) jsonObj.get("scripts_lao");
            }

            if (jsonObj.has("titles_lao")) {
                titles_lao = (JSONArray) jsonObj.get("titles_lao");
            }

            if (jsonObj.has("titles")) {
                titles = (JSONArray) jsonObj.get("titles");
            }

            if (jsonObj.has("title_search_lao")) {
                title_search_lao = (JSONArray) jsonObj.get("title_search_lao");
            }

            if (jsonObj.has("title_search_roman")) {
                title_search_roman = (JSONArray) jsonObj.get("title_search_roman");
            }

            if (jsonObj.has("plmp_title_lao")) {
                plmp_title_lao = (JSONArray) jsonObj.get("plmp_title_lao");
            }

            if (jsonObj.has("remark_english")) {
                remark_english = (JSONArray) jsonObj.get("remark_english");
            }

            if (jsonObj.has("remark_lao")) {
                remark_lao = (JSONArray) jsonObj.get("remark_lao");
            }

            if (jsonObj.has("term_roman")) {
                term_roman = (JSONArray) jsonObj.get("term_roman");
            }

            if (jsonObj.has("term_leo")) {
                term_leo = (JSONArray) jsonObj.get("term_leo");
            }




            sb.append("{"+ '\n');

            if (id!= "")
                sb.append(quote + "id" + quote + ":" +quote+ "dllm000" +id  + quote+"," + '\n');

            if (code_number!= "")
                sb.append(quote + "code_number" + quote + ":" + quote+ code_number +quote + "," + '\n');

            if (roll!= "")
                sb.append(quote + "roll" + quote + ":" + quote+ roll +quote + "," + '\n');

            if (number_of_fascicles!=0)
                sb.append(quote + "number_of_fascicles" + quote + ":" + number_of_fascicles + "," + '\n');

            if (number_of_folios!=0)
                sb.append(quote + "number_of_folios" + quote + ":" + number_of_folios + "," + '\n');


            if (has_colophon != "")
                sb.append(quote + "has_colophon" + quote + ":"  + quote+ has_colophon+ quote + "," + '\n');

            if (is_illustrated != "")
                sb.append(quote + "is_illustrated" + quote + ":" + quote+ is_illustrated +quote + "," + '\n');


            if (bundle_id != "")
                sb.append(quote + "bundle_id" + quote + ":" + quote + bundle_id + quote + "," + '\n');

            if (position_in_bundle != 0)
                sb.append(quote + "position_in_bundle" + quote + ":" + position_in_bundle + "," + '\n');

            if (pages_count != 0)
                sb.append(quote + "pages_count" + quote + ":" + pages_count + "," + '\n');

            if (private_remarks_en != "")
                sb.append(quote + "private_remarks_en" + quote + ":" + quote + private_remarks_en + quote + "," + '\n');

            if (private_remarks_lo != "")
                sb.append(quote + "private_remarks_lo" + quote + ":" + quote + private_remarks_lo + quote + "," + '\n');


            if (is_color != "")
                sb.append(quote + "is_color" + quote + ":" + quote+is_color+quote + "," + '\n');

            if (is_complete != "")
                sb.append(quote + "is_complete" + quote + ":" + quote+ is_complete+quote + "," + '\n');


            if (materials != "" )
                sb.append(quote + "materials" + quote + ":" + quote + materials + quote +  "," + '\n');

            if (materials_lao != "" )
                sb.append(quote + "materials_lao" + quote + ":" + quote + materials_lao + quote +  "," + '\n');


            if (locations_id != 0)
                sb.append(quote + "locations_id" + quote + ":" + locations_id + "," + '\n');

            if (locations_parent_id != "")
                sb.append(quote + "locations_parent_id" + quote + ":" + locations_parent_id + "," + '\n');

            if (name_location != "")
                sb.append(quote + "name_location" + quote + ":" + quote + name_location + quote + "," + '\n');

            if (name_location_lao != "")
                sb.append(quote + "name_location_lao" + quote + ":" + quote + name_location_lao + quote + "," + '\n');


            if (full_location_name != "")
                sb.append(quote + "full_location_name" + quote + ":" + quote + full_location_name + quote + "," + '\n');

            if (full_name_lao != "")
                sb.append(quote + "full_name_lao" + quote + ":" + quote + full_name_lao + quote + "," + '\n');


            if (parent_name != "")
                sb.append(quote + "parent_name" + quote + ":" + quote + parent_name + quote + "," + '\n');

            if (parent_name_lao != "")
                sb.append(quote + "parent_name_lao" + quote + ":" + quote + parent_name_lao + quote + "," + '\n');

            if (parent_parent_name != "")
                sb.append(quote + "parent_parent_name" + quote + ":" + quote + parent_parent_name + quote + "," + '\n');

            if (parent_parent_name_lao != "")
                sb.append(quote + "parent_parent_name_lao" + quote + ":" + quote + parent_parent_name_lao + quote + "," + '\n');

            if (location_place != "")
                sb.append(quote + "location_place" + quote + ":" + quote + location_place + quote + "," + '\n');

            if (location_place_lao != "")
                sb.append(quote + "location_place_lao" + quote + ":" + quote + location_place_lao + quote + "," + '\n');

            if (location_lft != 0)
                sb.append(quote + "location_lft" + quote + ":" + location_lft + "," + '\n');

            if (location_rgt != 0)
                sb.append(quote + "location_rgt" + quote + ":" + location_rgt + "," + '\n');

            if (location_code != 0)
                sb.append(quote + "location_code" + quote + ":" + location_code + "," + '\n');

            if (location_lat != "")
                sb.append(quote + "latitude" + quote + ":" + quote+location_lat+quote + "," + '\n');

            if (location_lon != "")
                sb.append(quote + "longitude" + quote + ":" + quote+location_lon +quote+ "," + '\n');

            if (location_documents_count != 0)
                sb.append(quote + "location_documents_count" + quote + ":" + location_documents_count + "," + '\n');

            if (legibilities != "")
                sb.append(quote + "legibilities" + quote + ":" + quote + legibilities + quote + "," + '\n');

            if (legibilities_lao != "")
                sb.append(quote + "legibilities_lao" + quote + ":" + quote + legibilities_lao + quote + "," + '\n');

            if (conditions != "")
                sb.append(quote + "conditions" + quote + ":" + quote + conditions + quote + "," + '\n');

            if (conditions_lao != "")
                sb.append(quote + "conditions_lao" + quote + ":" + quote + conditions_lao + quote + "," + '\n');

            if (preferred_date_systems != "")
                sb.append(quote + "preferred_date_systems" + quote + ":" + quote + preferred_date_systems + quote + "," + '\n');

            if (preferred_date_systems_lao != "")
                sb.append(quote + "preferred_date_systems_lao" + quote + ":" + quote + preferred_date_systems_lao + quote + "," + '\n');

            if (term_roman != null)
                sb.append(quote + "term_roman" + quote + ":" +  term_roman +  "," + '\n');

            if (term_leo!=null)
                sb.append(quote + "term_leo" + quote + ":"  + term_leo+  "," + '\n');

            if (remark_english != null)
                sb.append(quote + "remark_english" + quote + ":" +  remark_english +  "," + '\n');

            if (remark_lao!=null)
                sb.append(quote + "remark_lao" + quote + ":" +  remark_lao+  "," + '\n');

            if (categories!=null)
                sb.append(quote + "categories" + quote + ":" +  categories+  "," + '\n');

            if (categories_lao!=null)
                sb.append(quote + "categories_lao" + quote + ":" +  categories_lao+  "," + '\n');

            if (languages!=null)
                sb.append(quote + "languages" + quote + ":" +  languages+  "," + '\n');

            if (languages_lao!=null)
                sb.append(quote + "languages_lao" + quote + ":" +  languages_lao+  "," + '\n');

            if (scripts != null)
                sb.append(quote + "scripts" + quote + ":"  + scripts +  "," + '\n');

            if (scripts_lao!=null)
                sb.append(quote + "scripts_lao" + quote + ":"   + scripts_lao+  "," + '\n');

            if (title_search_roman!=null)
                sb.append(quote + "title_search_roman" + quote + ":"   + title_search_roman+  "," + '\n');

            if (title_search_lao!=null)
                sb.append(quote + "title_search_lao" + quote + ":"   + title_search_lao+  "," + '\n');

            if (plmp_title_lao!=null)
                sb.append(quote + "plmp_title_lao" + quote + ":"   + plmp_title_lao+  "," + '\n');

            if ( titles_lao!=null)
                sb.append(quote + "titles_lao" + quote + ":"  + titles_lao+  "," + '\n');

            if (titles != null )
                sb.append(quote + "titles" + quote + ":" +  titles +  "," + '\n');

            if (number_of_fascicles!=0 || number_of_folios!=0)
                sb.append(quote + "extent" + quote + ":" + quote+ number_of_fascicles + " fascicle(s), " + number_of_folios+" folio(s)"+quote+"," + '\n');

            if (date_written != "")
                sb.append(quote + "date" + quote + ":" + quote + date_written_right + quote + "," + '\n');

            if (conditions != null || conditions_lao !=null || legibilities !="" || legibilities_lao !="")
                sb.append(quote + "description" + quote + ":"+quote + "Conditions: "+ conditions +" ("+ conditions_lao+
                        "), "+"Legibility: "+ legibilities +" ("+ legibilities_lao+ "), " + "Complete:"+is_complete+
                        ", Colophone:"+has_colophon+ ", " +"Scan:"+ is_color +   ", " +"Illustrated:"+is_illustrated +quote+ ","+
                        '\n');


            /*if (date_written_right != 0 || additional_date_infos_roman != "" ||  additional_date_infos_lao!="" ||  preferred_date_systems !="" || preferred_date_systems_lao!="")
                sb.append(quote + "temporal" + quote + ":" +"["+ quote + temporal_date + quote +
                        ","+ quote +temporal_date_lao+ quote +
                        ","+ quote+ additional_date_infos_roman+ quote +
                        ","+ quote+ additional_date_infos_lao+ quote +
                        ","+ quote+ preferred_date_systems+ quote +
                        ","+ quote+ preferred_date_systems_lao+ quote +
                        "]"+"," + '\n');*/



            if (name_location != "" && parent_name!="" &&  parent_parent_name!="")
                sb.append(quote + "locations" + quote + ":" +"["+ quote + name_location +quote+","+quote +parent_name+quote+","+quote+ parent_parent_name+ quote + "]"+ "," + '\n');
            else if (name_location != "" && parent_name!="" )
                sb.append(quote + "locations" + quote + ":" +"["+ quote + name_location +quote+"," +quote+parent_name+quote+ quote + "]"+ "," + '\n');
            else
                sb.append(quote + "locations" + quote + ":" +"["+ quote + name_location + quote + "]"+ "," + '\n');



            if (name_location_lao != "" && parent_name_lao!="" &&  parent_parent_name_lao!="")
                sb.append(quote + "locations_lao" + quote + ":" +"["+ quote + name_location_lao +quote+"," +quote+parent_name_lao+quote+","+quote+ parent_parent_name_lao+ quote + "]"+ "," + '\n');
            else if (name_location_lao != "" && parent_name_lao!="" )
                sb.append(quote + "locations_lao" + quote + ":" +"["+ quote + name_location_lao +quote+","+quote +parent_name_lao+ quote + "]"+ "," + '\n');
            else
                sb.append(quote + "locations_lao" + quote + ":" +"["+ quote + name_location_lao + quote + "]"+ "," + '\n');





                /*i //sb.append(quote + "solr" + quote + ":" + quote + solr + quote + "," + '\n');

            /*if (position != "")
                sb.append(quote + "position" + quote + ":" + quote + position + quote + "," + '\n');


            if (book_id != "")
                sb.append(quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n');

            if (text != "") {
                sb.append(quote + "text" + quote + ":" + quote + text + quote + "," + '\n');
            }

            if (value != "") {
                sb.append(quote + "value" + quote + ":" + quote + value + quote + "," + '\n');
            }

            if (note != "") {
                sb.append(quote + "mods:note" + quote + ":" + quote + note.replace("type=\"statement of responsibility\" ","") + quote + "," + '\n');
            }


            if (extent != "") {
                sb.append(quote + "extent" + quote + ":" + quote + extent + quote + "," + '\n');
            }*/

            /*if (isPartOf != "")
                sb.append(quote + "isPartOf" + quote + ":" + quote + isPartOf + quote + "," + '\n');

            if (image != "")
                sb.append(quote + "image" + quote + ":" + quote + image + quote + "," + '\n');*/

            /*if (url != "")
                sb.append(quote + "url" + quote + ":" + quote + url + quote + "," + '\n');

            if (edition != "")
                sb.append(quote + "edition" + quote + ":" + quote +edition + quote +"," + '\n');*/

            /*if (chapter != null)
                sb.append(quote + "seriesTitle" + quote + ":" + chapter + "," + '\n');

            if (seriesTitle != "")
                sb.append(quote + "seriesTitle" + quote + ":" + quote+ seriesTitle + quote+ "," + '\n');

            if (responsibility != null)
                sb.append(quote + "mods:responsibility" + quote + ":" +  quote +responsibility + quote +"," + '\n');

            if (author != null)
                sb.append(quote + "creator" + quote + ":" + author + "," + '\n');

            if (description != null)
                sb.append(quote + "description" + quote + ":" + description +"," + '\n');

            if (publisher != null)
                sb.append(quote + "publisher" + quote + ":" + quote +publisher + quote + "," + '\n');*/

            /*if (titleTranscription != null)
                sb.append(quote + "titleTranscription" + quote + ":" + titleTranscription + "," + '\n');

            if (citation != null)
                sb.append(quote + "citation" + quote + ":" + citation + "," + '\n');

            if (spatial != "")
                sb.append(quote + "spatial" + quote + ":" + quote+spatial +quote + "," + '\n');

            if (medium != null)
                sb.append(quote + "medium" + quote + ":" + medium + "," + '\n');

            if (lizenz != "")
                sb.append(quote + "CrossAsia_Lizenz" + quote + ":" + quote + lizenz.replace("type=\"CrossAsia Lizenz\" ","") + quote + "," + '\n');*/
            sb.append(quote + "source" + quote + ":" + quote + "Digital Library of Lao Manuscripts" + quote + "," + '\n');
            sb.append(quote + "hasModel" + quote + ":" + quote + "Book" + quote + "" + '\n');

            sb.append("},");


            sb.deleteCharAt(sb.length() - 1);

            //PrintStream out = new PrintStream(new FileOutputStream(file));
            //out.write("/data1/fedora/ajax-minguo/test2/"+book_id+".json");
            //PrintStream out = new PrintStream(new FileOutputStream("/data1/dllm/books/"+id+".json"));
            //out = new FileWriter("/data1/fedora/ajax-minguo/test2/"+book_id+".json");
            //out.println("["+sb.toString()+"]");






        }sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");

    }
}
