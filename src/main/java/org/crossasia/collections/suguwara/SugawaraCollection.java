package org.crossasia.collections.suguwara;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SugawaraCollection {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("/data/suguwara/suguwaraNEW.json"));
        String books = "/data/suguwara/suguwara.json";
        String quote = "\u005c\u0022";
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            String ELA ="";
            String shelfnumber = "";
            String folder = "";
            String fnumber ="";

            String doctype ="";
            String condition ="";
            String physicaldata ="";
            String phystype ="";

            String yinhua_tax_stamp ="";
            String docornot = "";
            String hijuriyear="";
            String animyear = "";

            String hijurimonth ="";
            String hijuridate ="";
            String dow ="";
            String miladidate = "";

            String place01 ="";
            String place02 = "";
            String moqerr="";
            String Person02 = "";

            String qadi ="";
            String abstrac_E ="";
            String references ="";
            String Digitized_by = "";

            JSONObject booksObj = (JSONObject) booksObject.get(i);


            if (booksObj.has("ELA"))
                ELA = (String) booksObj.get("ELA");
            if (booksObj.has("shelfnumber"))
                shelfnumber = (String) booksObj.get("shelfnumber").toString();
            if (booksObj.has("folder"))
                folder = (String) booksObj.get("folder");
            if (booksObj.has("fnumber"))
                fnumber = (String) booksObj.get("fnumber");

            if (booksObj.has("doctype"))
                doctype = (String) booksObj.get("doctype");
            if (booksObj.has("condition"))
                condition = (String) booksObj.get("condition");
            if (booksObj.has("physicaldata"))
                physicaldata = (String) booksObj.get("physicaldata");
            if (booksObj.has("phystype"))
                phystype = (String) booksObj.get("phystype");

            if (booksObj.has("yinhua_tax_stamp"))
                yinhua_tax_stamp = (String) booksObj.get("yinhua_tax_stamp");
            if (booksObj.has("docornot"))
                docornot = (String) booksObj.get("docornot");
            if (booksObj.has("hijuriyear"))
                hijuriyear = (String) booksObj.get("hijuriyear").toString();
            if (booksObj.has("animyear"))
                animyear = (String) booksObj.get("animyear");

            if (booksObj.has("hijurimonth"))
                hijurimonth = (String) booksObj.get("hijurimonth");
            if (booksObj.has("hijuridate"))
                hijuridate = (String) booksObj.get("hijuridate");
            if (booksObj.has("dow"))
                dow = (String) booksObj.get("dow");
            if (booksObj.has("miladidate"))
                miladidate = (String) booksObj.get("miladidate");

            if (booksObj.has("place01"))
                place01 = (String) booksObj.get("place01");
            if (booksObj.has("place02"))
                place02 = (String) booksObj.get("place02");
            if (booksObj.has("moqerr"))
                moqerr = (String) booksObj.get("moqerr");
            if (booksObj.has("Person02"))
                Person02 = (String) booksObj.get("Person02");

            if (booksObj.has("qadi"))
                qadi = (String) booksObj.get("qadi");
            if (booksObj.has("abstrac_E"))
                abstrac_E = (String) booksObj.get("abstrac_E");
            if (booksObj.has("references"))
                references = (String) booksObj.get("references");
            if (booksObj.has("Digitized_by"))
                Digitized_by = (String) booksObj.get("Digitized_by");



            sb.append("{"+ '\n');

            if (shelfnumber!="")
                sb.append(  quote + "sugawara:shelfnumber" + quote + ":" +  quote+ ELA+"_"+shelfnumber+ quote+  "," + '\n');

            if (folder!="")
                sb.append(  quote + "sugawara:foldernumber" + quote + ":" +  quote+ folder+"_"+fnumber+ quote+  "," + '\n');

            if (doctype!="")
                sb.append(  quote + "schema:category" + quote + ":" + quote+ doctype+ quote+ "," + '\n');

            if (condition!="")
                sb.append(  quote + "schema:itemCondition" + quote + ":" + quote+ condition+ quote+ "," + '\n');

            if (physicaldata!="")
                sb.append(  quote + "sugawara:physicaldata" + quote + ":" + quote+ physicaldata+ quote+ "," + '\n');

            if (phystype!="")
                sb.append(  quote + "sugawara:phystype" + quote + ":" + quote+ phystype+ quote+ "," + '\n');

            if (yinhua_tax_stamp!="")
                sb.append(  quote + "sugawara:tax_stamps" + quote + ":" + quote+ yinhua_tax_stamp+ quote+ "," + '\n');

            if (docornot!="")
                sb.append(  quote + "sugawara:documents_style" + quote + ":" + quote+ docornot+ quote+ "," + '\n');

            sb.append(  quote + "sugawara:islamic_date" + quote + ":" +  quote+ hijuriyear+ " "+
                    animyear + " " +
                    hijurimonth + " "+
                    hijuridate + " " +
                    dow + "" +
                    quote+  ","+ '\n');

            if (miladidate!="" )
                sb.append(  quote + "sugawara:gregorian_date" + quote + ":" +  quote+ miladidate+ quote+  ","+ '\n');
            if (place01!="" )
                sb.append(  quote + "dc:place" + quote + ":" +"["  +quote+ place01+ quote+ "," +quote+ place02+ quote+ "]" + ","+ '\n');
            if (moqerr!="" )
                sb.append(  quote + "schema:person" + quote + ":"   +"["  +quote+ moqerr+ quote+ "," +quote+ Person02+ quote+ "]" +   ","+ '\n');

            if (qadi!="" )
                sb.append(  quote + "sugawara:name_Qadi" + quote + ":" +  quote+ qadi+ quote+  ","+ '\n');
            if (abstrac_E!="" )
                sb.append(  quote + "sugawara:info_usageinfo" + quote + ":" +  quote+ abstrac_E+ quote+  ","+ '\n');
            if (references!="" )
                sb.append(  quote + "schema:citation" + quote + ":" +  quote+ references+ quote+  ","+ '\n');
            if (Digitized_by!="" )
                sb.append(  quote + "sugawara:digitized_organization" + quote + ":" +  quote+ Digitized_by+ quote+  ","+ '\n');


            sb.append(  quote + "dc:language" + quote + ":" +   quote+ "eng"+ quote+ "" + '\n');

            sb.append("},");

        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}
