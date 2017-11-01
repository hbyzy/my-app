package com.mycompany.app.selenium.page_object.Test_Case;

import java.io.*;
import java.util.ArrayList;

public class fileOperate {
    public File file;

    public fileOperate() {
        file = new File("c:\\deleteable\\concordiaTest.txt");
    }

    public void filePrepare() throws IOException {
        File oldFile = new File("c:\\deleteable\\concordiaTestold.txt");
        if (file.exists()) {
            if (oldFile.exists()) {
                oldFile.delete();
                Boolean fileRen=file.renameTo(oldFile);
                Boolean fukeDel=file.delete();
            } else
                file.createNewFile();
        }
    }

    public void testFileWrite(ArrayList Fwrite) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        for (Object e : Fwrite) {
            bw.write(e + "\r\n");
        }
        bw.flush();
        bw.close();
    }


    public void testFileRead() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        try {
            line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}