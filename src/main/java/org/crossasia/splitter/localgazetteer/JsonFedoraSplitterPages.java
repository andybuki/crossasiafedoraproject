package org.crossasia.splitter.localgazetteer;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.camel.Message;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Splits a Camel Exchange with a body containing JSON messages in to individual messages
 *
 */
public class JsonFedoraSplitterPages {

    @Handler
    public List<String> processMessage(Exchange exchange) {

        List<String> messageList = new ArrayList<String>();
        //List<String> sectionList = new ArrayList<String>();

        Message message = exchange.getIn();
        String msg = message.getBody(String.class);

        JSONObject jsonObject = new JSONObject(msg);
        JSONArray booksJsonArray = jsonObject.getJSONArray("@graph");

        JSONObject contextJsonArray = (JSONObject) jsonObject.get("@context");
        String id = (String) jsonObject.get("@id");
        String quote = "\u005c\u0022";
        String jsonContext = "{"+quote+"@context"+quote+":"+contextJsonArray.toString()+",";
        String jsonId = quote+"@id"+quote+":"+quote+id.toString()+quote+",";
        String jsonBookReplace="";
        int arrayBlock=0;
        int arrayLength = booksJsonArray.length();
        int arrayMod=0;

        if (arrayMod==0) {
            for(int i=0; i<arrayLength; i++) {
                String booksBandJsonArray = "";
                JSONObject page = (JSONObject) booksJsonArray.get(i);

                /*String sections_id = (String) page.get("chapter_id");
                String[] sections = sections_id.split("\\,", -1);
                int sec=0;
                for (sec=0; sec<sections.length;sec++) {
                  // String section=+sections[0];
                }*/
                //sectionList.add("["+sections[sec].toString()+"]");
                for (int j = 1; j <= arrayBlock; j++) {
                    booksBandJsonArray += booksJsonArray.get(j + (i * arrayBlock)).toString() + ",";
                    String jsonBook = quote + "@graph" + quote + ":[" + booksBandJsonArray.toString() + "]}";
                    jsonBookReplace = jsonBook.replace(",]}", "]}");
                }
                String jsonMsgBook = quote + "@graph" + quote + ":[" + booksJsonArray.get(i).toString() + "]}";
                messageList.add(jsonContext +jsonId+ jsonMsgBook);
            }
        } else {
            arrayMod = arrayLength%arrayBlock;
            for(int i=0; i<arrayLength/arrayBlock; i++) {
                String booksBandJsonArray = "";
                for (int j=1; j<=arrayBlock; j++){
                    booksBandJsonArray += booksJsonArray.get(j+(i*arrayBlock)).toString()+",";
                    String jsonBook = quote+"@graph"+quote+":["+ booksBandJsonArray.toString()+"]}";
                    jsonBookReplace = jsonBook.replace(",]}","]}");
                }
                if(messageList.size()==arrayLength/arrayBlock-1) {
                    for (int j=1; j<=arrayMod; j++){
                        booksBandJsonArray += booksJsonArray.get(j+(i*arrayBlock)).toString()+",";
                        String jsonBook = quote+"@graph"+quote+":["+ booksBandJsonArray.toString()+"]}";
                        jsonBookReplace = jsonBook.replace(",]}","]}");
                    }
                }
                String jsonMsgBook = quote+"@graph"+quote+":["+ booksJsonArray.get(i).toString()+"]}";
                messageList.add(jsonContext+jsonBookReplace);
            }

        }
        return messageList;
    }
}