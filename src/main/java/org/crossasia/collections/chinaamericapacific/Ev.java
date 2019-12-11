package org.crossasia.collections.chinaamericapacific;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Ev {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String facebook = "D:\\facebook2.json";
        String instagram = "D:\\instagram2.json";
        PrintStream out = new PrintStream(new FileOutputStream("D:\\f_i.json"));
        JSONArray facebookA = new JSONArray(new JSONTokener(new FileInputStream(facebook)));
        JSONArray instagramA = new JSONArray(new JSONTokener(new FileInputStream(instagram)));
        for (int i=0; i<facebookA.length(); i++) {
            JSONObject facebookO = (JSONObject) facebookA.get(i);
            String web = (String) facebookO.get("web").toString();
            String face = (String) facebookO.get("facebook").toString();
            for (int j=0; j<instagramA.length(); j++) {
                JSONObject instagramO = (JSONObject) instagramA.get(j);
                String web2 = (String) instagramO.get("web").toString();
                String insta = (String) instagramO.get("instagram").toString();

                if (web.equals(web2)) {
                    out.println("{"
                            + quote + "web" + quote + ":" + quote + web + quote + "," +  '\n'
                            + quote + "instagram" + quote + ":" + quote + insta + quote + "," +  '\n'
                            + quote + "facebook" + quote + ":" + quote + face + quote + "" + '\n'
                            +"},"
                    );
                }
            }

            }
        }
    }


