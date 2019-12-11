package org.crossasia.existense.rmrb;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.*;
import java.util.Vector;


public class CheckFileExistense {


    /**
     * @param args
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws FileNotFoundException {
        String SFTPHOST = "b-lx0005.sbb.spk-berlin.de";
        int    SFTPPORT = 22;
        String SFTPUSER = "andrey.buchmann";
        String SFTPPASS = "ejvmVcej44";
        String SFTPWORKINGDIR = "/mnt/fedora/raw/amd_fo_japan/images/FO_262_1767";
        String SFTPPRIVATEKEY = "/data1/existing_check/amd_fo_japan/file.sh";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/existing_check/amd_fo_japan/result.txt"));

        //String filepath = "/mnt/fedora/raw/rmrb/txt";
        //PrintStream out = new PrintStream(new FileOutputStream("/data1/existing_check/rmrb/result.txt" ));

        Session     session     = null;
        Channel     channel     = null;
        ChannelSftp channelSftp = null;

        try{
            JSch jsch = new JSch();
            File privateKey = new File(SFTPPRIVATEKEY);

            /*if(privateKey.exists() && privateKey.isFile()) {
                jsch.addIdentity(SFTPPRIVATEKEY);
                System.out.println(SFTPPRIVATEKEY);
                File file = new File(SFTPPRIVATEKEY);
                boolean exists = file.exists();
                System.out.println(exists);
            }*/
            session = jsch.getSession(SFTPUSER,SFTPHOST,SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp)channel;
            channelSftp.cd(SFTPWORKINGDIR);


            Vector filelist = channelSftp.ls(SFTPWORKINGDIR);
            for(int i=0; i<filelist.size();i++){
                LsEntry entry = (LsEntry) filelist.get(i);

                try(BufferedReader br = new BufferedReader(new FileReader(SFTPPRIVATEKEY))) {
                    StringBuilder sb = new StringBuilder();
                    String line = br.readLine();

                    while (line != null) {
                        File f = new File(line);
                        boolean exists2 = f.exists();
                        if (f.exists()){
                            out.println(line+" - EXIST");
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
                //Vector directories = channelSftp.ls(((SFTPWORKINGDIR).listFiles(File::isDirectory)));

                //System.out.println(directories);
                System.out.println(entry.getFilename());
            }

        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if(session != null) session.disconnect();
            if(channel != null) channel.disconnect();
        }
    }
}

