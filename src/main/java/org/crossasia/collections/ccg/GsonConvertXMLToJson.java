package org.crossasia.collections.ccg;

import com.stanfy.gsonxml.GsonXml;
import com.stanfy.gsonxml.GsonXmlBuilder;
import com.stanfy.gsonxml.XmlParserCreator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import static org.junit.Assert.assertEquals;

class SimpleModel {
    private String name;
    private String description;

    public String getName() { return name; }
    public String getDescription() { return description; }
}

public class GsonConvertXMLToJson {
    public static void main(String[] args) {

        XmlParserCreator parserCreator = new XmlParserCreator() {
            @Override
            public XmlPullParser createParser() {
                try {
                    return XmlPullParserFactory.newInstance().newPullParser();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };

        GsonXml gsonXml = new GsonXmlBuilder()
                .setXmlParserCreator(parserCreator)
                .create();

        String xml = "<model><name>my name</name><description>my description</description></model>";
        SimpleModel model = gsonXml.fromXml(xml, SimpleModel.class);

        assertEquals("my name", model.getName());
        assertEquals("my description", model.getDescription());

    }
}
