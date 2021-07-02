package pl.kkx2754.utils.io;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

public class FileIO {

    public static void overwrite(String filename, String data) {
        try {
            File f = new File(filename);

            if (!f.exists()) {
                final boolean newFile = f.createNewFile();
            }

            FileWriter fw = new FileWriter(filename);
            fw.write(data+"\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }

    public static void append(String filename, String data) {
        try {
            File f = new File(filename);

            if (!f.exists()) {
                final boolean newFile = f.createNewFile();
            }

            FileWriter fw = new FileWriter(filename,true);
            fw.write(data+System.lineSeparator());
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }

    public static String read(String filename) {
        StringBuilder data = new StringBuilder();
        try {
            File obj = new File(filename);
            Scanner reader = new Scanner(obj);
            while (reader.hasNextLine()) {
                data.append(reader.nextLine()).append(System.lineSeparator());
            }
            reader.close();

            return data.toString();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
            return data.toString();
        }
    }

}
