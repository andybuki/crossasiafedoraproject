package org.crossasia.collections.ccg;

import java.io.*;

public class FileOperation
{
    public static void main(String[] args) throws IOException
    {
        // PrintWriter object for output.txt
        PrintWriter pw = new PrintWriter("D:\\SOLR-COLLECTIONS\\CCG\\output2.txt");

        // BufferedReader object for input.txt
        BufferedReader br1 = new BufferedReader(new FileReader("D:\\SOLR-COLLECTIONS\\CCG\\test2.csv"));

        String line1 = br1.readLine();

        // loop for each line of input.txt
        while(line1 != null)
        {
            boolean flag = false;

            // BufferedReader object for output.txt
            BufferedReader br2 = new BufferedReader(new FileReader("D:\\SOLR-COLLECTIONS\\CCG\\output2.txt"));

            String line2 = br2.readLine();

            // loop for each line of output.txt
            while(line2 != null)
            {

                if(line1.equals(line2))
                {
                    flag = true;
                    break;
                }

                line2 = br2.readLine();

            }

            // if flag = false
            // write line of input.txt to output.txt
            if(!flag){
                pw.println(line1);

                // flushing is important here
                pw.flush();
            }

            line1 = br1.readLine();

        }

        // closing resources
        br1.close();
        pw.close();

        System.out.println("File operation performed successfully");
    }
}
