package org.crossasia.collections.ccg;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.crossasia.collections.ccg.JSONObject.wrap;

public class XmlFileToJson

{

    private final LinkedHashMap<String, Object> map;

    public XmlFileToJson() {
        this.map = new LinkedHashMap<String, Object>();
    }


    public XmlFileToJson(Map<String, Object> map) {
        this.map = new LinkedHashMap<String, Object>();
        if (map != null) {
            Iterator<Map.Entry<String, Object>> i = map.entrySet().iterator();
            while (i.hasNext()) {
                Map.Entry<String, Object> entry = i.next();
                Object value = entry.getValue();
                if (value != null) {
                    this.map.put(entry.getKey(), wrap(value));
                }
            }
        }
    }

    public static void main(String[] args)
    {
        String data = "";

        try
        {
            // Read the student.xml
            String xml = FileUtils.readFileToString(new File("F:\\c\\SZFZ2928-00000003-00027.xml"));
            System.out.println(org.json.XML.toJSONObject(xml).toString());

            //List entries = xmlMapper.readValue(new File("F:\\c\\SZFZ2928-00000003-00027.xml"), List.class);



            System.out.println("*** Converting XML to JSON ***");
            //System.out.println(value);


        } catch (JsonParseException e)
        {
            e.printStackTrace();
        } catch (JsonMappingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
