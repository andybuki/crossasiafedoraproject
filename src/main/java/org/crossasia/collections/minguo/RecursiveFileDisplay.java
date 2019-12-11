package org.crossasia.collections.minguo;

import java.io.*;

public class RecursiveFileDisplay {

    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        File currentDir = new File("F:\\TXT\\"); // current directory
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\Minguo\\minguo.json"));
        try {
            File[] files = currentDir.listFiles();
            String f ="";
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    //System.out.println(file.getCanonicalPath().replace("F:\\TXT\\",""));
                    f =files[i].getCanonicalPath().replace("F:\\TXT\\","");
                    //displayDirectoryContents(file);
                    //out.println("{" + quote + "dir" + quote + ":" + quote + file.getCanonicalPath()+"_rmrb" + quote + "," + '\n' +"},");
                    out.println("{" + quote + "id" + quote + ":" + quote + f + quote + "," + '\n'
                            +"},"
                    );
                } else if (files[i].isDirectory()) {
                    f = files[i].getCanonicalPath().replace("F:\\TXT\\","").replace(".txt","");
                    System.out.println(f);
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        //displayDirectoryContents(currentDir);

    }

    /*public RecursiveFileDisplay(File dir) throws FileNotFoundException {

        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(file.getCanonicalPath().replace("F:\\TXT\\",""));
                    //displayDirectoryContents(file);
                    //out.println("{" + quote + "dir" + quote + ":" + quote + file.getCanonicalPath()+"_rmrb" + quote + "," + '\n' +"},");
                } else {
                    String f = file.getCanonicalPath().replace("F:\\TXT\\","").replace(".txt","");
                    System.out.println(file.getCanonicalPath().replace("F:\\TXT\\","").replace(".txt",""));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


}