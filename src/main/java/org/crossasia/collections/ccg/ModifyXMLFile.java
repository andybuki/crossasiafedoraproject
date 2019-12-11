package org.crossasia.collections.ccg;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.xml.sax.InputSource;

import java.io.*;
import java.util.List;

public class ModifyXMLFile {
    public static void main(String[] args) {
        SAXBuilder builder = new SAXBuilder();
        File dir = new File("F:\\SZFZ_OLD\\");
        //File dir = new File("F:\\a\\");

        for (File file : dir.listFiles()) {
            String encoding = "UTF-8";
            /*Reader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(
                        new FileInputStream("F:\\a\\SZFZ2888-00000001-00046.xml"), StandardCharsets.UTF_8));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }*/
            //BufferedReader br = new BufferedReader(reader);

            try {

                /*StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();

                }*/
                InputStream inputStream= new FileInputStream(file);
                Reader reader2 = new InputStreamReader(inputStream,"UTF-8");
                InputSource is = new InputSource(reader2);
                is.setEncoding("UTF-8");
                SAXBuilder sax = new SAXBuilder();

                Document doc = sax.build(is);



                //Document doc = builder.build(new File(String.valueOf(file)));
                //Document doc = builder.build(new File("F:\\a\\SZFZ2888-00000001-00046.xml"));

                //FileOutputStream out2 = new FileOutputStream ("F:\\a\\SZFZ2888-00000001-00046_NEW.xml");
                //PrintStream stream  = new PrintStream(out2, true, StandardCharsets.UTF_8.toString());


                //OutputStreamWriter out2 =new OutputStreamWriter(new FileOutputStream("F:\\c\\SZFZ2888-00000001-00046_NEW.xml"), StandardCharsets.UTF_8);
                //Writer out3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(String.valueOf(out2)), "UTF8"));
                //System.out.println(out3);
                //PrintStream  out2 = new PrintStream(new FileOutputStream("F:\\c\\SZFZ2888-00000001-00046_NEW.xml"));
                //PrintStream out2 = new PrintStream(file,"UTF-8");
                //PrintStream out2 = new PrintStream(new FileOutputStream(file));
                XMLOutputter xmlOutputter = new XMLOutputter();
                Format format = Format.getPrettyFormat();
                //format.setEncoding("UTF-8");
                format.setEscapeStrategy((c) -> false);
                xmlOutputter.setFormat(format);
                //XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat().setEncoding("UTF-8"));

                Element root = doc.getRootElement();
                root.removeAttribute("id");
                root.removeAttribute("relate_id");
                root.removeAttribute("size");
                root.removeAttribute("image_size");
                root.removeChild("paper");
                root.removeChildren("rectangle");
                root.removeChildren("line");

                List<Element> elementList = root.getChildren("text_line");
                int root_size = root.getChildren("text_line").size();
                if (root_size>0) {
                    System.out.println("<text_line>" + root_size);
                    // ------------------------- BEGIN TEXT LINE -------------------------------------------------
                    for (int i = 0; i < root_size; i++) {
                        //elementList.get(i).getChild("text").removeAttribute("image_position");
                        elementList.get(i).removeAttribute("total_column");
                        elementList.get(i).removeAttribute("spacing");


                        // ------------------------BEGIN TEXT --------------------------------------------------
                        List<Element> element_text = elementList.get(i).getChildren("text");
                        int text_size = elementList.get(i).getChildren("text").size();
                        if (text_size>0) {
                            System.out.println("<text>" + text_size);
                            for (int j = 0; j < text_size; j++) {
                                element_text.get(j).removeChildren("font");
                                element_text.get(j).removeAttribute("image_position");
                            }
                        }
                        // ------------------------END TEXT --------------------------------------------------

                        // ------------------------BEGIN MULTI TEXT --------------------------------------------------
                        List<Element> element_multi_text = elementList.get(i).getChildren("multi_text");
                        int multi_text_size = elementList.get(i).getChildren("multi_text").size();
                        if (multi_text_size>0) {
                            System.out.println("<multi_text>" + multi_text_size);
                            if (multi_text_size > 0) {
                                for (int x = 0; x < multi_text_size; x++) {
                                    element_multi_text.get(x).removeAttribute("total_column");
                                    element_multi_text.get(x).removeAttribute("spacing");
                                    //element_multi_text.get(x).getChild("text").removeAttribute("image_position");
                                    //element_multi_text.get(x).getChild("text").removeChild("font");

                                    // ------------------------BEGIN  TEXT --------------------------------------------------
                                    List<Element> element_muiti_text_text = element_multi_text.get(x).getChildren("text");
                                    int multi_text_text_size = element_multi_text.get(x).getChildren("text").size();
                                    if (multi_text_text_size>0) {
                                        System.out.println("<text2>" + multi_text_text_size);
                                        for (int y = 0; y < multi_text_text_size; y++) {
                                            element_muiti_text_text.get(y).removeChildren("font");
                                            element_muiti_text_text.get(y).removeAttribute("image_position");
                                            element_muiti_text_text.get(y).removeChildren("not_occupy");
                                            element_muiti_text_text.get(y).removeChildren("decoration");
                                        }
                                    }
                                    // ------------------------END  TEXT --------------------------------------------------


                                    // ---------------------BEGIN MULTI MULTI TEXT -----------------------------------------

                                    List<Element> element_muiti_multi_text_text = element_multi_text.get(x).getChildren("multi_text");
                                    System.out.println(element_muiti_multi_text_text.size());
                                    if (element_muiti_multi_text_text.size()>0){
                                        int multi_multi_text_text_size = element_muiti_multi_text_text.size();
                                        for (int mm=0; mm<multi_multi_text_text_size ;mm++) {
                                            element_muiti_multi_text_text.get(mm).removeAttribute("total_column");
                                            element_muiti_multi_text_text.get(mm).removeAttribute("spacing");
                                            element_muiti_multi_text_text.get(mm).removeAttribute("column_no");
                                            element_muiti_multi_text_text.get(mm).removeAttribute("collocate");



                                            List<Element> element_muiti_multi_text = element_muiti_multi_text_text.get(mm).getChildren("text");
                                            int muiti_multi_text_size = element_muiti_multi_text.size();
                                            if (muiti_multi_text_size>0){
                                                for( int mmt=0; mmt <muiti_multi_text_size ;mmt++) {
                                                    element_muiti_multi_text.get(mmt).removeAttribute("image_position");
                                                    element_muiti_multi_text.get(mmt).removeChildren("font");
                                                }
                                            }

                                            List<Element> element_muiti_multi_multi_text_text = element_muiti_multi_text_text.get(mm).getChildren("multi_text");
                                            int muiti_multi_multi_text_text_size = element_muiti_multi_text_text.get(mm).getChildren("multi_text").size();
                                            if (muiti_multi_multi_text_text_size>0){
                                                for (int mmm=0; mmm<muiti_multi_multi_text_text_size ;mmm++) {
                                                    element_muiti_multi_multi_text_text.get(mmm).removeAttribute("total_column");
                                                    element_muiti_multi_multi_text_text.get(mmm).removeAttribute("spacing");
                                                    element_muiti_multi_multi_text_text.get(mmm).removeAttribute("column_no");
                                                    element_muiti_multi_multi_text_text.get(mmm).removeAttribute("collocate");

                                                    List<Element> element_muiti_multi_multi_text_text_text = element_muiti_multi_text_text.get(mmm).getChildren("text");
                                                    int muiti_multi_multi_text_text_text_size = element_muiti_multi_text_text.get(mmm).getChildren("text").size();
                                                    for (int mmmt=0; mmmt<muiti_multi_multi_text_text_text_size; mmmt++){
                                                        element_muiti_multi_multi_text_text_text.get(mmmt).removeChildren("font");
                                                    }


                                                }
                                            }

                                        }
                                    }

                                    // ---------------------END MULTI MULTI TEXT -----------------------------------------
                                }
                            }
                        }
                        // ------------------------END MULTI TEXT --------------------------------------------------
                        elementList.get(i).removeChild("region");



                    }

                    // -------------------------  BEGIN  TABLE ------------------------------------------------------
                    List<Element> element_table = root.getChildren("table");
                    int table_size = root.getChildren("table").size();

                    if (table_size>0) {
                        root.getChild("table").removeChildren("rectangle");
                        root.getChild("table").removeChildren("line");

                        for (int tabl=0; tabl< table_size; tabl++){
                            element_table.get(tabl).removeChildren("line");
                            element_table.get(tabl).removeChildren("region");
                        }

                        System.out.println("<table>"+table_size);

                        for (int tb=0; tb<table_size;tb++){
                            element_table.get(tb).getChild("text_line").removeChild("region");
                            List<Element> element_table_text_line = element_table.get(tb).getChildren("text_line");
                            int table_text_line_size = element_table.get(tb).getChildren("text_line").size();
                            //System.out.println("xa"+table_text_line_size);

                            if (table_text_line_size>0) {
                                for (int tl=0; tl<table_text_line_size; tl++) {
                                    element_table_text_line.get(tl).removeChildren("region");
                                    element_table_text_line.get(tl).removeChildren("line");

                                    //element_table_text_line.get(tl).getChild("multi_text").removeAttribute("total_column");
                                    //element_table_text_line.get(tl).getChild("multi_text").removeAttribute("spacing");

                                    List<Element> element_table_multi_text = element_table_text_line.get(tl).getChildren("multi_text");
                                    int table_multi_text_size= element_table_text_line.get(tl).getChildren("multi_text").size();
                                    if (table_multi_text_size>0) {

                                        for (int ts=0; ts<table_multi_text_size; ts++) {

                                            element_table_multi_text.get(ts).removeAttribute("total_column");
                                            element_table_multi_text.get(ts).removeAttribute("spacing");
                                            element_table_multi_text.get(ts).removeAttribute("image_position");
                                            element_table_multi_text.get(ts).getChild("text").removeAttribute("image_position");
                                            element_table_multi_text.get(ts).getChild("text").removeAttribute("mode");
                                            element_table_multi_text.get(ts).getChild("text").removeChildren("font");
                                            element_table_multi_text.get(ts).removeChildren("line");
                                            List<Element> element_table_text = element_table_multi_text.get(ts).getChildren("text");
                                            int table_text_size= element_table_multi_text.get(ts).getChildren("text").size();

                                            if (table_text_size>0) {
                                                System.out.println("xa"+table_text_size);
                                                for (int tt=0; tt<table_text_size; tt++) {
                                                    element_table_text.get(tt).removeChildren("font");
                                                    element_table_text.get(tt).removeAttribute("image_position");

                                                }
                                            }
                                            List<Element> element_multi_table_text = element_table_multi_text.get(ts).getChildren("multi_text");
                                            int table_multi_multi_text_size= element_table_multi_text.get(ts).getChildren("multi_text").size();

                                            if (table_multi_multi_text_size>0){
                                                for (int mmtm=0; mmtm<table_multi_multi_text_size; mmtm++) {
                                                    element_multi_table_text.get(mmtm).removeAttribute("total_column");
                                                    element_multi_table_text.get(mmtm).removeAttribute("column_no");
                                                    element_multi_table_text.get(mmtm).removeAttribute("spacing");
                                                    element_multi_table_text.get(mmtm).removeAttribute("image_position");

                                                    List<Element> element_multi_table_text_text = element_multi_table_text.get(mmtm).getChildren("text");
                                                    int table_multi_multi_text_text_size= element_multi_table_text.get(mmtm).getChildren("text").size();

                                                    for (int mmtt=0; mmtt<table_multi_multi_text_text_size; mmtt++){
                                                        element_multi_table_text_text.get(mmtt).removeChildren("font");
                                                        element_multi_table_text_text.get(mmtt).removeAttribute("image_position");
                                                    }
                                                }
                                            }
                                        }
                                    }


                                    List<Element> element_table_text = element_table_text_line.get(tl).getChildren("text");
                                    int table_text_size= element_table_text_line.get(tl).getChildren("text").size();
                                    if (table_text_size>0) {
                                        for (int txt2=0; txt2<table_text_size; txt2++) {
                                            element_table_text.get(txt2).removeAttribute("image_position");
                                            element_table_text.get(txt2).removeAttribute("mode");
                                            element_table_text.get(txt2).removeChildren("font");
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // -------------------------END  TABLE ------------------------------------------------------


                }
                // -------------------------END  TEXT LINE -------------------------------------------------

                // -------------------------  BEGIN  IMAGE ------------------------------------------------------
                List<Element> element_image = root.getChildren("image");
                int image_size = root.getChildren("image").size();
                System.out.println("<image>" + image_size);
                if (image_size > 0) {
                    for (int z = 0; z < image_size; z++) {
                        element_image.get(z).removeChild("region");
                    }
                }
                // -------------------------END  IMAGE ------------------------------------------------------


                xmlOutputter.output(doc,new FileOutputStream (file));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}