package org.crossasia.existense.adm_japan;

import com.jcraft.jsch.*;

import java.io.*;

public class CheckFileExistense {
    public static void main(String[] args) throws FileNotFoundException {

        String host = "b-lx0005.sbb.spk-berlin.de";
        String user = "andrey.buchmann";
        String password = "ejvmVcej44";
        int port = 22;


        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("Establishing Connection...");
            session.connect();
            System.out.println("Connection established.");
            System.out.println("Crating SFTP Channel.");
            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
            System.out.println("SFTP Channel created.");

            //InputStream inputStream = sftpChannel.get("/mnt/fedora/raw/amd_fo_japan/file.sh");
            PrintStream out = new PrintStream(new FileOutputStream(String.valueOf(sftpChannel.put("/mnt/fedora/raw/amd_fo_japan/result.txt"))));
            //try (Scanner scanner = new Scanner(new InputStreamReader(inputStream))) {
            try(BufferedReader br = new BufferedReader(new FileReader("/data1/existing_check/amd_fo_japan/file.sh"))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                while (line != null) {
                    File f = new File(line);
                    boolean exists2 = f.exists();
                    if (f.exists()){
                        System.out.println(line+" - EXIST");
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
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
        }

        /*PrintStream out = new PrintStream(new FileOutputStream("/data1/existing_check/amd_fo_japan/result.txt"));
        try(BufferedReader br = new BufferedReader(new FileReader("/data1/existing_check/amd_fo_japan/file.sh"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                File f = new File(line);
                boolean exists2 = f.exists();
                if (f.exists()){
                    System.out.println(line+" - EXIST");
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
        }*/

    }
}
