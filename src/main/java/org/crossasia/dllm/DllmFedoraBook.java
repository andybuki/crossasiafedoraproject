package org.crossasia.dllm;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class DllmFedoraBook {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException , IOException {
        File absolutePath = new File("/data/dlmnt/fedora/books_raw/");
        String quote = "\u005c\u0022";
        String encoding = "UTF-8";

            File dir = new File(String.valueOf(absolutePath));
            File[] filesInDir = dir.listFiles();

            for (File file : filesInDir) {
                StringBuilder sb = new StringBuilder();
                JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));

                String id = "";
                String code_number ="";
                String roll = "";
                String date_written ="";
                int date_written_right =0;
                String temporal_date ="";
                String temporal_date_lao ="";

                int number_of_fascicles=0;
                int number_of_folios=0;
                int has_colophon=0;
                String has_colophon_str ="";
                int is_illustrated=0;
                String is_illustrated_str ="";

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
                String is_color_str ="";
                int is_complete=0;
                String is_complete_str="";

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

                String legibilities = "";
                String legibilities_lao = "";
                String additional_date_infos_roman = "";
                String additional_date_infos_lao = "";
                String conditions = "";
                String conditions_lao ="";
                String preferred_date_systems = "";
                String preferred_date_systems_lao = "";

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

                JSONArray title_roman = null;
                JSONArray title_lao = null;

                JSONArray title_search_roman = null;
                JSONArray title_search_lao = null;

                JSONArray plmp_title_lao = null;
                
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

                if (jsonObj.has("name_location"))
                    name_location = (String) jsonObj.get("name_location").toString();

                if (jsonObj.has("name_location_lao"))
                    name_location_lao = (String) jsonObj.get("name_location_lao").toString();

                if (jsonObj.has("number_of_fascicles"))
                    number_of_fascicles = (int) jsonObj.get("number_of_fascicles");

                if (jsonObj.has("number_of_folios"))
                    number_of_folios = (int) jsonObj.get("number_of_folios");

                if (jsonObj.has("has_colophon")) {
                    has_colophon = (int) jsonObj.get("has_colophon");
                    if (has_colophon==0) {
                        has_colophon_str="No";
                    }else {
                        has_colophon_str="Yes";
                    }
                }

                if (jsonObj.has("is_illustrated")) {
                    is_illustrated = (int) jsonObj.get("is_illustrated");
                    if (is_illustrated==0) {
                        is_illustrated_str="No";
                    }else {
                        is_illustrated_str="Yes";
                    }
                }

                if (jsonObj.has("locations_id"))
                    locations_id = (int) jsonObj.get("locations_id");

                if (jsonObj.has("locations_parent_id"))
                    locations_parent_id = (int) jsonObj.get("locations_parent_id");

                if (jsonObj.has("is_complete")) {
                    is_complete = (int) jsonObj.get("is_complete");
                    if (is_complete==0){
                        is_complete_str="No";
                    }else{
                        is_complete_str="Yes";
                    }
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
                    is_color = (int) jsonObj.get("is_color");
                    if (is_color==0) {
                        is_color_str="From Microfilm";
                    } else {
                        is_color_str="From Original";
                    }
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
                    location_lat = (double) jsonObj.get("location_lat");

                if (jsonObj.has("location_lon"))
                    location_lon = (double) jsonObj.get("location_lon");

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

                if (jsonObj.has("conditions_lao"))
                    conditions_lao = (String) jsonObj.get("conditions_lao").toString();

                if (jsonObj.has("preferred_date_systems")) {
                    preferred_date_systems = (String) jsonObj.get("preferred_date_systems").toString();

                    if (preferred_date_systems.equals("Buddhist Era (BE)")) {
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
                    }
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

                if (jsonObj.has("title_lao")) {
                    title_lao = (JSONArray) jsonObj.get("title_lao");
                }

                if (jsonObj.has("title_roman")) {
                    title_roman = (JSONArray) jsonObj.get("title_roman");
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


                sb.append("{\n");
                sb.append("  \"@context\": {\n");
                sb.append("    \"fedora\": \"https://fedora.info/definitions/v4/2016/10/18/repository#\",\n");
                sb.append("    \"crossasia\": \"http://crossasia.org/schema/v1#\",\n");
                sb.append("    \"pcdm\": \"http://pcdm.org/models#\",\n");
                sb.append("    \"mods\": \"http://www.loc.gov/mods/modsrdf/v1#\",\n");
                sb.append("    \"book_id\": \"http://schema.org/identifier\",\n");
                sb.append("    \"dcndl\": \"http://ndl.go.jp/dcndl/\",\n");

                sb.append("    \"dc\": \"http://purl.org/dc/elements/1.1/\",\n");
                sb.append("    \"seriesTitle\": \"http://ndl.go.jp/dcndl/terms/seriesTitle\",\n");
                sb.append("    \"schema\": \"http://schema.org/\",\n");
                sb.append("    \"person\": \"http://schema.org/Person\",\t\n");
                sb.append("    \"dcterms\": \"http://purl.org/dc/terms/\",\n");

                sb.append("    \"dllm\": \"http://dllm.org/schema/v1#\",\n");

                sb.append("    \"CHGIS\": {\n");
                sb.append("      \"@id\": \"http://crossasia.org/schema/v1#CHGIS\",\n");
                sb.append("      \"@type\": \"@id\"\n");
                sb.append("    },\n");

                sb.append("    \"TGAZ API\": {\n");
                sb.append("      \"@id\": \"http://crossasia.org/schema/v1#TGAZ_API\",\n");
                sb.append("      \"@type\": \"@id\"\n");
                sb.append("    },\n");


                sb.append("    \"CrossAsia_Lizenz\": {\n");
                sb.append("      \"@id\": \"http://crossasia.org/schema/v1#CrossAsia_Lizenz\",\n");
                sb.append("      \"@type\": \"@id\"\n");
                sb.append("    },\n");

                sb.append("    \"uri\": {\n");
                sb.append("      \"@id\": \"http://purl.org/dc/terms/uri\",\n");
                sb.append("      \"@type\": \"@id\"\n");
                sb.append("    },\n");

                sb.append("    \"url\": {\n");
                sb.append("      \"@id\": \"http://schema.org/url\",\n");
                sb.append("      \"@type\": \"@id\"\n");
                sb.append("    },\n");

                sb.append("    \"solr\": {\n");
                sb.append("      \"@id\": \"http://crossasia.org/schema/v1#solr\",\n");
                sb.append("      \"@type\": \"@id\"\n");
                sb.append("   }\n\t");
                sb.append(" },\n\n");
                sb.append("\"@id\": \"urn:x-arq:DefaultGraphNode\",\n");

                sb.append("\"@graph\": [" + '\n');

                sb.append("{" + '\n');

                sb.append("\"@type\": \"pcdm:Object\",\n");
                sb.append("\"@id\": \"\",\n");


                if (id!= "")
                    sb.append(quote + "id" + quote + ":" +quote+ "dllm_0000"+ id  + quote+"," + '\n');

                if (code_number!= "")
                    sb.append(quote + "schema:identifier" + quote + ":" + quote+ code_number +quote + "," + '\n');

                if (roll!= "")
                    sb.append(quote + "dllm:roll" + quote + ":" + quote+ roll +quote + "," + '\n');

                if (date_written_right != 0 || additional_date_infos_roman != "" ||  additional_date_infos_lao!="" ||  preferred_date_systems !="" || preferred_date_systems_lao!="")
                    sb.append(quote + "dcterms:temporal" + quote + ":" +"["+ quote + temporal_date + quote +
                            ","+ quote +temporal_date_lao+ quote +
                            ","+ quote+ additional_date_infos_roman+ quote +
                            ","+ quote+ additional_date_infos_lao+ quote +
                            ","+ quote+ preferred_date_systems+ quote +
                            ","+ quote+ preferred_date_systems_lao+ quote +
                            "]"+"," + '\n');

                if (additional_date_infos_roman != "")
                    //sb.append(quote + "dcterms:temporal" + quote + ":" + quote + additional_date_infos_roman + quote + "," + '\n');

                if (additional_date_infos_lao != "")
                    //sb.append(quote + "dcterms:temporal" + quote + ":" + quote + additional_date_infos_lao + quote + "," + '\n');

                if (preferred_date_systems !="" || preferred_date_systems_lao!="")
                    //sb.append(quote + "dcterms:temporal" + quote + ":" + "["+quote + preferred_date_systems + quote +","+ quote+preferred_date_systems_lao +quote+ "]"+  "," + '\n');


                if (date_written != "")
                    sb.append(quote + "dc:date" + quote + ":" + quote + date_written + quote + "," + '\n');

                if (number_of_fascicles!=0 || number_of_folios!=0)
                    sb.append(quote + "dcterms:extent" + quote + ":" + quote+ number_of_fascicles + " fascicle(s), " + number_of_folios+" folio(s)"+quote+"," + '\n');

                if (has_colophon != 0)
                    sb.append(quote + "dllm:has_colophon" + quote + ":" + has_colophon + "," + '\n');

                if (is_illustrated != 0)
                    sb.append(quote + "dllm:is_illustrated" + quote + ":" + is_illustrated + "," + '\n');

                if (bundle_id != "")
                    sb.append(quote + "dllm:bundle_id" + quote + ":" + quote + bundle_id + quote + "," + '\n');

                if (position_in_bundle != 0)
                    sb.append(quote + "dllm:position_in_bundle" + quote + ":" + position_in_bundle + "," + '\n');

                if (pages_count != 0)
                    sb.append(quote + "dllm:image_count" + quote + ":" + pages_count + "," + '\n');

                if (locations_id != 0)
                    sb.append(quote + "dllm:locations_id" + quote + ":" + locations_id + "," + '\n');

                if (locations_parent_id != 0)
                    sb.append(quote + "dllm:locations_parent_id" + quote + ":" + locations_parent_id + "," + '\n');

                if (private_remarks_en != "")
                    sb.append(quote + "dllm:private_remarks_en" + quote + ":" + quote + private_remarks_en + quote + "," + '\n');

                if (private_remarks_lo != "")
                    sb.append(quote + "dllm:private_remarks_lo" + quote + ":" + quote + private_remarks_lo + quote + "," + '\n');

                if (is_color != 0)
                    sb.append(quote + "dllm:is_color" + quote + ":" + is_color + "," + '\n');

                if (is_complete != 0)
                    sb.append(quote + "dllm:is_complete" + quote + ":" + is_complete + "," + '\n');

                if (materials != "" || materials_lao!="")
                    sb.append(quote + "dc:medium" + quote + ":" + "["+quote + materials + quote +","+ quote+materials_lao +quote+ "]"+  "," + '\n');

                if (materials != "" || materials_lao!="")
                    //sb.append(quote + "mods:physicalDescription" + quote + ":" + "["+quote + materials + quote +","+ quote+materials_lao +quote+ "]"+  "," + '\n');

                if (name_location != "")
                    sb.append(quote + "dllm:name_location" + quote + ":" + quote + name_location + quote + "," + '\n');

                if (name_location_lao != "")
                    sb.append(quote + "dllm:name_location_lao" + quote + ":" + quote + name_location_lao + quote + "," + '\n');

                if (name_location !="" || name_location_lao!="") {
                    sb.append(quote + "dcterms:spatial" + quote + ":" + "[" + quote + name_location + quote + "," + quote + name_location_lao + quote + "]" + "," + '\n');
                    sb.append(quote + "dcndl:publicationPlace" + quote + ":" +  quote + name_location  + " (" + name_location_lao +  ") " +quote+ "," + '\n');
                }

                if (location_place != "")
                    sb.append(quote + "dllm:location_place" + quote + ":" + quote + location_place + quote + "," + '\n');

                if (location_place_lao != "")
                    sb.append(quote + "dllm:location_place_lao" + quote + ":" + quote + location_place_lao + quote + "," + '\n');

                if (location_lft != 0)
                    sb.append(quote + "dllm:location_lft" + quote + ":" + location_lft + "," + '\n');

                if (location_rgt != 0)
                    sb.append(quote + "dllm:location_rgt" + quote + ":" + location_rgt + "," + '\n');

                if (location_code != 0)
                    sb.append(quote + "dllm:location_code" + quote + ":" + location_code + "," + '\n');

                if (location_lat != 0.0)
                    sb.append(quote + "schema:latitude" + quote + ":" + location_lat + "," + '\n');

                if (location_lon != 0.0)
                    sb.append(quote + "schema:longitude" + quote + ":" + location_lon + "," + '\n');

                if (location_documents_count != 0)
                    sb.append(quote + "dllm:location_documents_count" + quote + ":" + location_documents_count + "," + '\n');

                if (legibilities != "")
                    sb.append(quote + "dllm:legibilities" + quote + ":" + quote + legibilities + quote + "," + '\n');

                if (legibilities_lao != "")
                    sb.append(quote + "dllm:legibilities_lao" + quote + ":" + quote + legibilities_lao + quote + "," + '\n');


                if (conditions != "")
                    sb.append(quote + "dllm:conditions" + quote + ":" + quote + conditions + quote + "," + '\n');

                if (conditions_lao != "")
                    sb.append(quote + "dllm:conditions_lao" + quote + ":" + quote + conditions_lao + quote + "," + '\n');

                if (preferred_date_systems != "")
                    sb.append(quote + "dllm:preferred_date_systems" + quote + ":" + quote + preferred_date_systems + quote + "," + '\n');

                if (preferred_date_systems_lao != "")
                    sb.append(quote + "dllm:preferred_date_systems_lao" + quote + ":" + quote + preferred_date_systems_lao + quote + "," + '\n');

                if (languages != null || languages_lao!=null )
                    sb.append(quote + "dc:language" + quote + ":" +  languages  + languages_lao+ "," + '\n');

                if (categories != null || categories_lao!=null)
                    sb.append(quote + "dc:subject" + quote + ":" +  categories + categories_lao+  "," + '\n');

                if (scripts != null)
                    sb.append(quote + "crossasia:script" + quote + ":"  + scripts +  "," + '\n');

                if (scripts_lao!=null)
                    sb.append(quote + "dllm:scripts_lao" + quote + ":"   + scripts_lao+  "," + '\n');

                if ( title_lao!=null)
                    sb.append(quote + "dc:title" + quote + ":"  + title_lao+  "," + '\n');

                if (title_roman != null )
                    sb.append(quote + "dcndl:titleTranscription" + quote + ":" +  title_roman +  "," + '\n');

                if (title_search_roman != null  ||  title_search_lao!=null  || plmp_title_lao!=null)
                    sb.append(quote + "dllm:title_search" + quote + ":" +  title_search_roman + title_search_lao + plmp_title_lao+ "," + '\n');


                if (term_roman != null || term_leo!=null)
                    sb.append(quote + "schema:keywords" + quote + ":" +  term_roman + term_leo+  "," + '\n');


                if (remark_english != null || remark_lao!=null)
                    sb.append(quote + "schema:comment" + quote + ":" +  remark_english + remark_lao+  "," + '\n');


                if (conditions != null || conditions_lao !=null || legibilities !="" || legibilities_lao !="")
                    sb.append(quote + "dc:description" + quote + ":"+quote + "Conditions: "+ conditions +" ( "+ conditions_lao+
                            "), "+"Legibility: "+ legibilities +" ("+ legibilities_lao+ "), " + "Complete:"+is_complete_str+
                            ", Colophone:"+has_colophon_str+ ", " +"Scan:"+ is_color_str +   ", " +"Illustrated:"+ is_illustrated_str +quote+ ","+
                            '\n');



                /*i //sb.append(quote + "solr" + quote + ":" + quote + solr + quote + "," + '\n');

            /*if (position != "")
                sb.append(quote + "schema:position" + quote + ":" + quote + position + quote + "," + '\n');


            if (book_id != "")
                sb.append(quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n');

            if (text != "") {
                sb.append(quote + "schema:text" + quote + ":" + quote + text + quote + "," + '\n');
            }

            if (value != "") {
                sb.append(quote + "schema:value" + quote + ":" + quote + value + quote + "," + '\n');
            }

            if (note != "") {
                sb.append(quote + "mods:note" + quote + ":" + quote + note.replace("type=\"statement of responsibility\" ","") + quote + "," + '\n');
            }


            if (extent != "") {
                sb.append(quote + "dcterms:extent" + quote + ":" + quote + extent + quote + "," + '\n');
            }*/

            /*if (isPartOf != "")
                sb.append(quote + "schema:isPartOf" + quote + ":" + quote + isPartOf + quote + "," + '\n');

            if (image != "")
                sb.append(quote + "schema:image" + quote + ":" + quote + image + quote + "," + '\n');*/

            /*if (url != "")
                sb.append(quote + "url" + quote + ":" + quote + url + quote + "," + '\n');

            if (edition != "")
                sb.append(quote + "dc:edition" + quote + ":" + quote +edition + quote +"," + '\n');*/

            /*if (chapter != null)
                sb.append(quote + "dcndl:seriesTitle" + quote + ":" + chapter + "," + '\n');

            if (seriesTitle != "")
                sb.append(quote + "dcndl:seriesTitle" + quote + ":" + quote+ seriesTitle + quote+ "," + '\n');

            if (responsibility != null)
                sb.append(quote + "mods:responsibility" + quote + ":" +  quote +responsibility + quote +"," + '\n');

            if (author != null)
                sb.append(quote + "dc:creator" + quote + ":" + author + "," + '\n');

            if (description != null)
                sb.append(quote + "dc:description" + quote + ":" + description +"," + '\n');

            if (publisher != null)
                sb.append(quote + "dc:publisher" + quote + ":" + quote +publisher + quote + "," + '\n');*/

            /*if (titleTranscription != null)
                sb.append(quote + "dcndl:titleTranscription" + quote + ":" + titleTranscription + "," + '\n');

            if (citation != null)
                sb.append(quote + "schema:citation" + quote + ":" + citation + "," + '\n');

            if (spatial != "")
                sb.append(quote + "dcterms:spatial" + quote + ":" + quote+spatial +quote + "," + '\n');

            if (medium != null)
                sb.append(quote + "dcterms:medium" + quote + ":" + medium + "," + '\n');

            if (lizenz != "")
                sb.append(quote + "CrossAsia_Lizenz" + quote + ":" + quote + lizenz.replace("type=\"CrossAsia Lizenz\" ","") + quote + "," + '\n');*/
                sb.append(quote + "dc:source" + quote + ":" + quote + "Digital Library of Lao Manuscripts" + quote + "," + '\n');
                sb.append(quote + "crossasia:hasModel" + quote + ":" + quote + "Book" + quote + "" + '\n');

                sb.append("}");
                sb.append("]}");

                sb.deleteCharAt(sb.length() - 1);
                //PrintStream out = new PrintStream(new FileOutputStream(file));
                //out.write("/data1/fedora/ajax-minguo/test2/"+book_id+".json");
                PrintStream out = new PrintStream(new FileOutputStream("/data/dlmnt/fedora/books/"+id+".json"));
                //out = new FileWriter("/data1/fedora/ajax-minguo/test2/"+book_id+".json");
                out.println("["+sb.toString()+"}]");


            }

        }
    }

