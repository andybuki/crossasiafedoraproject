package org.crossasia.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class GsonDateAdapter extends TypeAdapter {

    private static final String FORMAT = "yyyy.mm.dd";
    private SimpleDateFormat format = new SimpleDateFormat();

    @Override
    public Date read(JsonReader jsonReader) throws IOException {

        format.applyPattern(FORMAT);
        String value = jsonReader.nextString();

        try {
            return format.parse(value);
        } catch (ParseException e) {
            return null;
        }

    }

    @Override
    public void write(JsonWriter jsonWriter, Object date) throws IOException {

        format.applyPattern(FORMAT);
        jsonWriter.value(format.format(date));

    }

}