package com.mihey.homework.csvgenerator;

/**
 *
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneratorCsv {
    String header;
    int rows;
    int columns;
    boolean b;

/*    GeneratorCsv(int c, int r, String h) {
        this.rows = r;
        this.columns = c;
        this.header = h;
    }*/

/*    private List<String> GenerateCsv(String header) {
        List<String> list = new ArrayList<>();
        String[] headerCsv = header.split(" ");
        list.addAll(Arrays.asList(headerCsv));
        return  list;
    }*/

    public static void main(String[] args) throws IOException {
        GeneratorCsv g = new GeneratorCsv();
        g.header = "1 2 3 4 5 6 7 8 9";
        BufferedWriter bw = new BufferedWriter(new FileWriter("/home/mihey/file.csv"));
        bw.write(g.header);
        bw.close();

    }

}
