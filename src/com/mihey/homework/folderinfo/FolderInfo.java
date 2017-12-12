package com.mihey.homework.folderinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

class SubFolderInfo {

    public String getFoldersInfo(File subFolder) {
        if (subFolder.isDirectory())
            return "Folder location: " + subFolder + "; Created: " +
                    subFolder.lastModified() + "; Folder size: " + getFolderSize(subFolder) + "bytes" + "\n";

        return subFolder + " \"is not a folder\"\n";
    }

    private long getFolderSize(File folder) {
        long size = 0;
        if (folder.isFile()) {
            size = folder.length();
        } else {
            File[] subFile = folder.listFiles();
            for (File file : subFile) {
                if (file.isFile()) {
                    size += file.length();
                } else size += getFolderSize(file);
            }
        }
        return size;
    }
}

public class FolderInfo {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("No path");
            return;
        }
        try {
            Properties prop = new Properties();
            prop.load(new FileReader(args[0]));
            File file = new File(prop.getProperty("folderPath"));

            SubFolderInfo folder = new SubFolderInfo();
            File[] folders = file.listFiles();
            for (int i = 0; i < folders.length; i++) {
                System.out.println(folder.getFoldersInfo(folders[i]));
            }
        } catch (NullPointerException e) {
            System.out.println(" No path to folder, fill the property file");
        } catch (FileNotFoundException e) {
            System.out.println(" Path to property file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
