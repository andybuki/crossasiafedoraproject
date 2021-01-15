package org.crossasia.collections.cepiec;

import java.io.*;
public class TxtToJson {
    public static void main(String[] args) throws IOException {

        File dir = new File("/data/solr/cepiec/");
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/cepiec3.json"));
        String id ="";
        String publication_name="";
        String issued ="";
        String date ="";
        String position ="";
        String subject ="";
        String author= "";
        String title= "";
        String text = "";
        ////////////////////////////////////

        String quote = "\u005c\u0022";
        File file2 = new File("/data/solr/cepiec");
        StringBuilder sb = null;

        String encoding = "UTF-8";
        for (File file : dir.listFiles()) {

            Reader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), encoding));
            BufferedReader br = new BufferedReader(reader);
            sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                //sb.append(line);
                //sb.append(System.lineSeparator());
                line = br.readLine();
                if (line!=null) {
                    String fileName = file.toString();
                    System.out.println(fileName);
                    String[] splitter = line.split("\\t");
                    id = splitter[0].toString();
                    publication_name = splitter[1].toString();
                    date = splitter[2].substring(0,4);
                    issued = splitter[2].substring(0,4)+"-"+splitter[2].substring(4,6)+"-"+splitter[2].substring(6,8);
                    position = splitter[3].replace("0000","");
                    subject = splitter[4];
                    author = splitter[5].replace("　","");
                    title = splitter[6].trim();
                    text = splitter[7].trim();

                    sb.append("{" + '\n');
                    sb.append(quote + "id" + quote + ":" + quote + id +"_"+splitter[2]+"_"+ position+ quote + "," + '\n');
                    sb.append(quote + "publication_name" + quote + ":" + quote + publication_name + quote + "," + '\n');
                    sb.append(quote + "date" + quote + ":" + quote + date + quote + "," + '\n');
                    sb.append(quote + "issued" + quote + ":" + quote + issued + quote + "," + '\n');
                    sb.append(quote + "position" + quote + ":" + quote + position.substring(0,1) + quote + "," + '\n');
                    sb.append(quote + "subject" + quote + ":" + quote + subject + quote + "," + '\n');

                    if (author!="")
                        sb.append(quote + "author" + quote + ":" + quote + author + quote + "," + '\n');

                    sb.append(quote + "title" + quote + ":" + quote + title + quote + "," + '\n');
                    sb.append(quote + "text" + quote + ":" + quote + text + quote + "," + '\n');
                    sb.append(quote + "url" + quote + ":" + quote + "http://tk.dhcdb.com.tw/tknewsusr/00001/clip/tktj" +splitter[2]+position+".pdf"+ quote + "," + '\n');
                    sb.append(quote + "erflink" + quote + ":" + quote + "http://tk.dhcdb.com.tw.xy3i3a3h0689.erf.sbb.spk-berlin.de/tknewsusr/00001/clip/tktj"+splitter[2]+position +".pdf" + quote + "," + '\n');
                    sb.append(quote + "hasModel" + quote + ":" + quote + "Article" + quote + "," + '\n');
                    sb.append(quote + "collection" + quote + ":" + quote + "Dagongbao (Tianjin ban)" + quote + "," + '\n');
                    sb.append("},");
                }

            }

            out.println(sb.toString());
        }



    }
}