package org.crossasia.splitter.localgazetteer;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.camel.Message;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Splits a Camel Exchange with a body containing JSON messages in to individual messages
 *
 */
public class JsonSplitterBooks {

    @Handler
    public List<String> processMessage(Exchange exchange) {

        List<String> messageList = new ArrayList<String>();

        Message message = exchange.getIn();
        String msg = message.getBody(String.class);

        JSONObject jsonObject = new JSONObject(msg);
        JSONArray booksJsonArray = jsonObject.getJSONArray("books");

        JSONObject contextJsonArray = (JSONObject) jsonObject.get("@context");
        //JSONObject fedoraModel = (JSONObject) jsonObject.get("fedora-model:hasModel");
        //JSONObject fedoraIsMember = (JSONObject) jsonObject.get("fedora:isMemberOfCollection");
        //String id  =jsonObject.getString("@id");
        String quote = "\u005c\u0022";
        String jsonContext = "{" + quote + "@context" + quote + ":" + contextJsonArray.toString() + ",";
        //String jsonId = quote + "@id" + quote + ":" + id.toString() + ",";
        //String jsonFedoraModel = "{" + quote + "fedora-model:hasModel" + quote + ":" + fedoraModel.toString() + ",";
        //String jsonFedoraIsMember = "{" + quote + "fedora:isMemberOfCollection" + quote + ":" + fedoraIsMember.toString() + ",";

        String jsonBookReplace = "";
        int arrayBlock = 1;
        int arrayLength = booksJsonArray.length();
        int arrayMod = arrayLength % arrayBlock;

        if (arrayLength > arrayBlock) {
            for (int i = 0; i < arrayLength / arrayBlock; i++) {
                if (arrayMod == 0) {
                    String booksBandJsonArray = "";
                    for (int j = 1; j <= arrayBlock; j++) {
                        booksBandJsonArray += booksJsonArray.get(j + (i * arrayBlock)-1).toString() + ",";
                        String jsonBook = quote + "fedora" + quote + ":[" + booksBandJsonArray.toString() + "]}";
                        jsonBookReplace = jsonBook.replace(",]}", "]}");
                    }
                    String jsonMsgBook = quote + "fedora" + quote + ":[" + booksJsonArray.get(i).toString() + "]}";
                    messageList.add(jsonContext + jsonBookReplace);
                } else {
                    String booksBandJsonArray = "";
                    for (int j = 1; j <= arrayBlock; j++) {
                        booksBandJsonArray += booksJsonArray.get(j + (i * arrayBlock)).toString() + ",";
                        String jsonBook = quote + "fedora" + quote + ":[" + booksBandJsonArray.toString() + "]}";
                        jsonBookReplace = jsonBook.replace(",]}", "]}");
                    }
                    if (messageList.size() == arrayLength / arrayBlock - 1) {
                        for (int j = 1; j <= arrayMod; j++) {
                            booksBandJsonArray += booksJsonArray.get(j + (i * arrayBlock)).toString() + ",";
                            String jsonBook = quote + "fedora" + quote + ":[" + booksBandJsonArray.toString() + "]}";
                            jsonBookReplace = jsonBook.replace(",]}", "]}");
                        }
                    }
                    String jsonMsgBook = quote + "fedora" + quote + ":[" + booksJsonArray.get(i).toString() + "]}";
                    messageList.add(jsonContext + jsonBookReplace);
                }
            }
            return messageList;
        } else {
            for (int i = 0; i < arrayLength; i++) {
                String jsonBook = quote + "fedora" + quote + ":[" + booksJsonArray.get(i).toString() + "]}";
                jsonBookReplace = jsonBook.replace(",]}", "]}");
                messageList.add(jsonContext + jsonBookReplace);
                //messageList.add(jsonContext +jsonFedoraModel +jsonFedoraIsMember + jsonBookReplace);
            }
            return messageList;
        }
    }
}