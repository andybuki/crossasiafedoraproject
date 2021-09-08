package org.crossasia.dlntm.fedora;

public class FedoraHeader {

    public static StringBuilder addFedoraHeader() {
        StringBuilder fedoraheader = new StringBuilder();
        fedoraheader.append("{\n");
        fedoraheader.append("  \"@context\": {\n");
        fedoraheader.append("    \"fedora\": \"https://fedora.info/definitions/v4/2016/10/18/repository#\",\n");
        fedoraheader.append("    \"crossasia\": \"http://crossasia.org/schema/v1#\",\n");
        fedoraheader.append("    \"pcdm\": \"http://pcdm.org/models#\",\n");
        fedoraheader.append("    \"mods\": \"http://www.loc.gov/mods/modsrdf/v1#\",\n");
        fedoraheader.append("    \"book_id\": \"http://schema.org/identifier\",\n");
        fedoraheader.append("    \"dcndl\": \"http://ndl.go.jp/dcndl/\",\n");

        fedoraheader.append("    \"dc\": \"http://purl.org/dc/elements/1.1/\",\n");
        fedoraheader.append("    \"seriesTitle\": \"http://ndl.go.jp/dcndl/terms/seriesTitle\",\n");
        fedoraheader.append("    \"schema\": \"http://schema.org/\",\n");
        //fedoraheader.append("    \"person\": \"http://schema.org/Person\",\t\n");
        fedoraheader.append("    \"dcterms\": \"http://purl.org/dc/terms/\",\n");

        fedoraheader.append("    \"dllm\": \"http://dllm.org/schema/v1#\",\n");

        /*fedoraheader.append("    \"CHGIS\": {\n");
        fedoraheader.append("      \"@id\": \"http://crossasia.org/schema/v1#CHGIS\",\n");
        fedoraheader.append("      \"@type\": \"@id\"\n");
        fedoraheader.append("    },\n");

        fedoraheader.append("    \"TGAZ API\": {\n");
        fedoraheader.append("      \"@id\": \"http://crossasia.org/schema/v1#TGAZ_API\",\n");
        fedoraheader.append("      \"@type\": \"@id\"\n");
        fedoraheader.append("    },\n");*/


        fedoraheader.append("    \"CrossAsia_Lizenz\": {\n");
        fedoraheader.append("      \"@id\": \"http://crossasia.org/schema/v1#CrossAsia_Lizenz\",\n");
        fedoraheader.append("      \"@type\": \"@id\"\n");
        fedoraheader.append("    },\n");

        fedoraheader.append("    \"uri\": {\n");
        fedoraheader.append("      \"@id\": \"http://purl.org/dc/terms/uri\",\n");
        fedoraheader.append("      \"@type\": \"@id\"\n");
        fedoraheader.append("    },\n");

        fedoraheader.append("    \"url\": {\n");
        fedoraheader.append("      \"@id\": \"http://schema.org/url\",\n");
        fedoraheader.append("      \"@type\": \"@id\"\n");
        fedoraheader.append("    },\n");

        fedoraheader.append("    \"solr\": {\n");
        fedoraheader.append("      \"@id\": \"http://crossasia.org/schema/v1#solr\",\n");
        fedoraheader.append("      \"@type\": \"@id\"\n");
        fedoraheader.append("   }\n\t");
        fedoraheader.append(" },\n\n");
        fedoraheader.append("\"@id\": \"urn:x-arq:DefaultGraphNode\",\n");

        fedoraheader.append("\"@graph\": [" + '\n');

        fedoraheader.append("{" + '\n');

        fedoraheader.append("\"@type\": \"pcdm:Object\",\n");
        fedoraheader.append("\"@id\": \"\",\n");

        return fedoraheader;
    }
}
