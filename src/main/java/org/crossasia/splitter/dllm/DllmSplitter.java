package org.crossasia.splitter.dllm;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DllmSplitter {
    public List<String> processMessage(Exchange exchange) {

        List<String> messageList = new ArrayList<String>();

        Message message = exchange.getIn();
        String msg = message.getBody(String.class);

        JSONArray jsonArray = new JSONArray(msg);

        //JSONObject jsonObject = new JSONObject(msg);

        //JSONArray booksJsonArray = jsonObject.getJSONArray("books");

        //JSONObject contextJsonArray = (JSONObject) jsonObject.get("@context");
        String quote = "\u005c\u0022";
        //String jsonContext = "{" + quote + "@context" + quote + ":" + contextJsonArray.toString() + ",";

        String jsonBookReplace = "";
        int arrayBlock = 1;
        int arrayLength = jsonArray.length();
        int arrayMod = arrayLength % arrayBlock;


        for (int j=0; j<jsonArray.length(); j++){

            JSONObject jsonObject = (jsonArray.getJSONObject(j));
            jsonBookReplace = jsonObject.toString().replace(",]}", "]}");
            messageList.add(jsonBookReplace);


        }
        return messageList;

    }
}
