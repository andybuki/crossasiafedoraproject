package org.crossasia.existense.dfz;

import java.io.*;

public class CheckFileExistense {
    public static void main(String[] args) throws FileNotFoundException {

        PrintStream out = new PrintStream(new FileOutputStream("/data1/existing_check/dfz/result2.txt"));
        try(BufferedReader br = new BufferedReader(new FileReader("/data1/existing_check/dfz/file2.sh"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                File f = new File(line);
                boolean exists2 = f.exists();
                if (f.exists()){
                    //out.println(line+" - EXIST");
                }else {
                    out.println(line+" - NOT EXIST");
                }
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
