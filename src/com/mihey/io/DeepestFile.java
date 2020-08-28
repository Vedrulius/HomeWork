package com.mihey.io;

import java.io.File;

public class DeepestFile {
    static String dirName = "";
    static int deepFile = 0;
    static int permDeep = 0;

    public static String getFiles(File files) {

        for (File file : files.listFiles()) {
            if (file.isDirectory()) {
                permDeep++;
                getFiles(file);
                if (permDeep > deepFile) {
                    deepFile = permDeep;
                    dirName = file.getName();
                }
                permDeep--;
            } else {
                if (permDeep > deepFile) {
                    deepFile = permDeep;
                    dirName = file.getName();
                }
            }
        }
        return dirName;
    }


    public static void main(String[] args) {

        File file = new File("basedir");
        System.out.println(getFiles(file));
    }
}
