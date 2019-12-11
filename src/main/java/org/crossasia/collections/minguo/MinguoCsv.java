package org.crossasia.collections.minguo;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MinguoCsv {
    public static void main(String[] args) throws Exception {



                File input = new File("/data3/solr/ajax-minguo/pages/sections.csv");
                File output = new File("/data3/solr/ajax-minguo/pages/sections.json");

                List<Map<?, ?>> data = readObjectsFromCsv(input);
                writeAsJson(data, output);
            }

            public static List<Map<?, ?>> readObjectsFromCsv(File file) throws IOException {
                CsvSchema bootstrap = CsvSchema.emptySchema().withHeader().withColumnSeparator('|').withNullValue("");
                CsvMapper csvMapper = (CsvMapper) new CsvMapper();
                MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader(Map.class).with(bootstrap).readValues(file);

                return mappingIterator.readAll();
            }

            public static void writeAsJson(List<Map<?, ?>> data, File file) throws IOException {
                ObjectMapper mapper = new ObjectMapper();
                //mapper.writeValue(file, data);
                mapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
            }
        }


