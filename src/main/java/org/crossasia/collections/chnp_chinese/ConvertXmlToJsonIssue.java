package org.crossasia.collections.chnp_chinese;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertXmlToJsonIssue {
    public static void main( String[] args ) throws Exception {

        File dir = new File("D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\issue_error\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\issue_error.json"));
        String bookName = "";
        String page = "";
        String text = "";
        String quote = "\u005c\u0022";
        int year = 0;
        int i;


        for (File file : dir.listFiles()) {
            String encoding = "UTF-8";
            Reader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), encoding));
            BufferedReader br = new BufferedReader(reader);

            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                //String textReplace =  everything.replace("\r\n"," ").replace("\f","");
                String fileName = file.toString();
                //String fileName1 = fileName.replace("/Users/andreybuchmann/Downloads/JOBIK/xml2/", "");

                JSONObject jsonObject = XML.toJSONObject(new String(Files.readAllBytes(Paths.get(fileName))));
                JSONObject dataExport = (JSONObject) jsonObject.get("issue");
                JSONObject metadata = (JSONObject) dataExport.get("metadataInfo");
                JSONObject lang = (JSONObject) metadata.get("language");
                String language = "";
                if (metadata.has("language")) {
                    language = (String) lang.get("content").toString();
                }
                String sourceLibrary = "";
                String libraryName = "";
                String libraryLocation = "";
                JSONObject source = (JSONObject) metadata.get("sourceLibrary");
                if (source.has("libraryName")) {
                    libraryName = (String) source.get("libraryName");
                }

                if (source.has("libraryLocation")) {
                    libraryLocation = (String) source.get("libraryLocation");
                }

                String publicationVolume = "";
                if (metadata.has("volNum")) {
                    publicationVolume = (String) metadata.get("volNum").toString();
                }

                String issue = "";
                if (metadata.has("is")) {
                    issue = (String) metadata.get("is").toString();
                }

                JSONObject da = (JSONObject) metadata.get("da");
                String date_original = "";
                String date = "";

                if (da.has("composed")) {
                    date_original = (String) da.get("composed").toString();
                }
                if (da.has("searchableDateStart")) {
                    date = (String) da.get("searchableDateStart").toString();
                }

                String code = "";
                if (metadata.has("mcode")) {
                    code = (String) metadata.get("mcode").toString();
                }
                String id="";
                if (metadata.has("newspaperID")) {
                    id = (String) metadata.get("newspaperID").toString();
                }
                String assetID="";
                if (metadata.has("assetID")) {
                    assetID = (String) metadata.get("assetID").toString();
                }

                String dviCollectionID="";
                if (metadata.has("dviCollectionID")) {
                    dviCollectionID = (String) metadata.get("dviCollectionID").toString();
                }
                String PSMID ="";
                if (metadata.has("PSMID")) {
                    PSMID = (String) metadata.get("PSMID").toString();
                }

                out.println("{" + quote + "language" + quote + ":" + quote + language + quote + "," + '\n'
                        + quote + "id" + quote + ":" + quote + id+"_"+assetID + quote + "," + '\n'
                        + quote + "description" + quote + ":" + quote + "Source library: "+libraryName+ " ("+libraryLocation+")"+ quote + "," + '\n'
                        + quote + "publicationVolume" + quote + ":" + quote + publicationVolume + quote + "," + '\n'
                        + quote + "volume-number" + quote + ":" + quote + issue + quote + "," + '\n'
                        + quote + "hasModel" + quote + ":" +   quote +"Journal" +  quote + "," + '\n'
                        + quote + "url" + quote + ":" + quote + "http://gdc.galegroup.com/gdc/artemis/atp/AboutThisPublicationPortletWin?p=CFER&mode=view&action=e&mCode="+code+"&prodId=CFER&windowstate=normal&userGroupName=sbbpk" + quote + "," + '\n'
                        + quote + "dviCollectionID" + quote + ":" + quote + dviCollectionID + quote + "," + '\n'
                        + quote + "PSMID" + quote + ":" + quote + PSMID + quote + "," + '\n'
                        + quote + "date_original" + quote + ":" + quote + date_original + quote + "," + '\n'
                        + quote + "date" + quote + ":" + quote + date + quote + "" + '\n'
                        + "},"
                );


            }catch(JSONException e){
                e.printStackTrace();
            }

        }

    }
}
