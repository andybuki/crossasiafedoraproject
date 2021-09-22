package org.crossasia.solr.types;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.solr.constants.Constants.QUOTE;
import static org.crossasia.solr.main.CreateBookSolr.jsonObj;

public class SubjectImpl implements Edition{

    public static StringBuilder addSubjects() throws FileNotFoundException {
        JSONArray subjects = null;
        String subject ="";
        StringBuilder subjectsBuilder = new StringBuilder();

        if (jsonObj.has("subject")) {

            if ((jsonObj.get("subject")) instanceof JSONArray) {
                subjects = (JSONArray) jsonObj.get("subject");

                if (subjects != null) {
                    subjectsBuilder.append(QUOTE + "subject" + QUOTE + ":" +  subjects +  "," + '\n');
                    return subjectsBuilder;
                } else {
                    return new StringBuilder();
                }
            } else {
                subject = (String) jsonObj.get("subject");
                if (subject != "") {
                    subjectsBuilder.append(QUOTE + "subject" + QUOTE + ":" + QUOTE+  subject + QUOTE+ "," + '\n');
                    return subjectsBuilder;
                } else {
                    return new StringBuilder();
                }

            }
        } else {
                return new StringBuilder();
        }
    }
}
