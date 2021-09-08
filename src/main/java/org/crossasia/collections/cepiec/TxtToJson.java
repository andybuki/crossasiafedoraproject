package org.crossasia.collections.cepiec;

import java.io.*;
public class TxtToJson {
    public static void main(String[] args) throws IOException {

        File dir = new File("/data/solr/ajax-cepiec/toberlintxt/");
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/ajax-cepiec/toberlintxt.json"));
        String id ="";
        String publication_name="";
        String issued ="";
        String date ="";
        int position=0;
        String pos ="";
        String subject ="";
        String author= "";
        String title= "";
        String text = "";
        String link = "";
        ////////////////////////////////////

        String quote = "\u005c\u0022";
        File file2 = new File("/data/solr/ajax-cepiec/toberlintxt");
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
                    //System.out.println(fileName);
                    String[] splitter = line.split("\\t");
                    id = splitter[0].toString();
                    publication_name = splitter[1].toString();
                    date = splitter[2].substring(0,4);
                    issued = splitter[2].substring(0,4)+"-"+splitter[2].substring(4,6)+"-"+splitter[2].substring(6,8);
                    //position = splitter[3].replace("0000","");
                    position = Integer.parseInt(splitter[3].replaceFirst("^0+(?!$)", ""));
                    if (position>=1000) {
                        pos = ""+position;
                        pos = pos.substring(0,2);
                        link = splitter[2]+pos;
                    } else {
                        pos = ""+position;
                        pos = pos.substring(0,1);
                        link = splitter[2]+"0"+pos;
                    }
                    subject = splitter[4];
                    author = splitter[5].replace("　","");
                    title = splitter[6].trim();
                    text = splitter[7].trim();
                    System.out.println(fileName+ " " + position);
                    sb.append("{" + '\n');
                    sb.append(quote + "id" + quote + ":" + quote + id +"_"+splitter[2]+"_"+ position + quote + "," + '\n');
                    //sb.append(quote + "publication_name" + quote + ":" + quote + publication_name.replaceFirst("　 ","").replaceFirst("　","").replace("\""," ").replaceAll("^\"|\"$", "") + quote + "," + '\n');

                    sb.append(quote + "publication_name" + quote + ":" + quote +"大公報 (天津版)"+ quote + "," + '\n');
                    sb.append(quote + "date" + quote + ":" + quote + date + quote + "," + '\n');
                    sb.append(quote + "date_original" + quote + ":" + quote + issued + quote + "," + '\n');
                    sb.append(quote + "position" + quote + ":" + quote + pos + quote + "," + '\n');
                    sb.append(quote + "text" + quote + ":" + quote + text.trim().replaceFirst("　 ","").replace("\""," ").replaceAll("^\"|\"$", "") + quote + "," + '\n');

                    if (text.length()<3) {
                        if (!subject.isEmpty()) {
                            sb.append(quote + "subject" + quote + ":" + "["+quote+ subject+quote+","+quote+ "天津版" +quote +","+quote+"advertisement" +quote +"]" + "," + '\n');
                        } else {
                            sb.append(quote + "subject" + quote + ":" + "["+quote+ "天津版"+quote+","+quote+"advertisement" +quote +"]" + "," + '\n');
                        }
                    } else {
                        if (!subject.isEmpty()) {
                            sb.append(quote + "subject" + quote + ":" + "["+quote+ subject +quote+"," +quote+ "天津版" +quote +"]"  + "," + '\n');
                        } else {
                            sb.append(quote + "subject" + quote + ":" + "["+quote+ "天津版" +quote +"]"  + "," + '\n');
                        }
                    }

                    sb.append(quote + "language" + quote + ":" + quote + "chi" + quote + "," + '\n');
                    sb.append(quote + "author" + quote + ":" + quote + author.replaceFirst("　 ","").replaceFirst("　","").replace("\""," ").replaceAll("^\"|\"$", "") + quote + "," + '\n');
                    sb.append(quote + "title" + quote + ":" + quote + title.replaceFirst("　 ","").replaceFirst("　","").replace("\""," ").replaceAll("^\"|\"$", "") + quote + "," + '\n');
                    sb.append(quote + "url" + quote + ":" + quote + "http://tk.dhcdb.com.tw/tknewsc/tknewskm?!!IXtktj" +link+ quote + "," + '\n');
                    sb.append(quote + "erflink" + quote + ":" + quote + "http://erf.sbb.spk-berlin.de/han/cepiec-tkp/tk.dhcdb.com.tw/tknewsc/tknewskm?!!IXtktj"+link+"" + quote + "," + '\n');
                    sb.append(quote + "hasModel" + quote + ":" + quote + "Article" + quote + "," + '\n');
                    sb.append(quote + "collection" + quote + ":" + quote + "The Ta Kung Pao 大公報" + quote + "," + '\n');
                    sb.append("},");
                }
            }
            out.println(sb.toString());
        }
    }
}