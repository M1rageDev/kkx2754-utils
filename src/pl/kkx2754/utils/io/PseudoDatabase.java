package pl.kkx2754.utils.io;

import java.io.File;
import java.io.IOException;

import static pl.kkx2754.utils.io.FileIO.read;
import static pl.kkx2754.utils.io.FileIO.append;

public class PseudoDatabase {

    String filename = "";

    public PseudoDatabase(String filename) {
        this.filename = filename;
    }

    public void addEntry(String key, String value) {
        append(this.filename, key+":"+value);
    }

    public String readAllEntries() {
        File f = new File(this.filename);
        if (!f.exists()) {
            try {
                final boolean newFile = f.createNewFile();
                return "";
            } catch(IOException e) {
                System.out.println("An error occurred!");
                e.printStackTrace();
            }
        }
        return read(this.filename);
    }

    public Boolean findKey(String key) {
        String entries = readAllEntries();

        return entries.contains(key + ":");
    }

    public Boolean findValue(String value) {
        String entries = readAllEntries();

        return entries.contains(":" + value);
    }

    public Integer getKeyIndex(String key) {
        String entries = readAllEntries();

        return entries.indexOf(key);
    }

    public Integer getValueIndex(String value) {
        String entries = readAllEntries();

        return entries.indexOf(":" + value) + 1;
    }

}
