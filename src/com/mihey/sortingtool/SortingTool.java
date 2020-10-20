package com.mihey.sortingtool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SortingTool<T extends Comparable<? super T>> {

    public void sortByCount(ArrayList<T> arrayList, String type) {
        HashMap<T, Integer> dataEntryToCount = new HashMap<>();
        for (T elem : arrayList) {
            //add new elem to map and elem is already in map, add one
            if (dataEntryToCount.containsKey(elem)) {
                dataEntryToCount.replace(elem, dataEntryToCount.get(elem) + 1);
            } else {
                dataEntryToCount.put(elem, 1);
            }
        }
        //place values in a set and keys in list, then sort keys
        Set<Integer> mapValues = new HashSet(dataEntryToCount.values());
        ArrayList<T> mapKeys = new ArrayList<>();
        dataEntryToCount.forEach((k, v) -> mapKeys.add((T) k));
        Collections.sort(mapKeys);
        //print
        System.out.println("Total " + (type) + ": " + arrayList.size() + ".");
        for (Integer mv : mapValues) {
            for (int j = 0; j < mapKeys.size(); j++) {
                if (dataEntryToCount.get(mapKeys.get(j)) == mv) {
                    System.out.print(mapKeys.get(j) + ": " + mv + " time(s), ");
                    System.out.println(Math.round((double) mv / arrayList.size() * 100) + "%");
                }
            }
        }
    }

    ////
    public static void writeToFile(String text, String pathToFile) throws IOException {
        File file = new File(pathToFile);
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
    }

    ////
    public void naturalSort(ArrayList<T> arrayList, String type) {
        System.out.println("Total " + (type) + ": " + arrayList.size());
        arrayList.sort(Comparator.naturalOrder());

        if (type.equals("line")) {
            System.out.println("Sorted data: ");
            arrayList.forEach(e -> System.out.println(e + " "));
        } else {
            System.out.print("Sorted data: ");
            arrayList.forEach(e -> System.out.print(e + " "));
        }
        System.out.println();
    }

    public static void main(final String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String param = "";
        for (String arg : args) {
            param += arg;
        }

        ArrayList<Long> numList = new ArrayList<>();
        ArrayList<String> stringList = new ArrayList<>();
        SortingTool test = new SortingTool();


        if (param.contains("long")) {

            while (scanner.hasNext()) {
                numList.add(scanner.nextLong());
            }

            if (param.contains("byCount")) {
                test.sortByCount(numList, "long");
            } else {
                test.naturalSort(numList, "long");
            }
        }
        //words
        if (param.contains("word")) {

            while (scanner.hasNext()) {
                stringList.add(scanner.next());
            }
            if (param.contains("byCount")) {
                test.sortByCount(stringList, "word");
            } else {
                test.naturalSort(stringList, "word");
            }
        }
        //lines
        if (param.contains("line")) {

            while (scanner.hasNext()) {
                stringList.add(scanner.nextLine());
            }

            if (param.contains("byCount")) {
                test.sortByCount(stringList, "line");
            } else {
                test.naturalSort(stringList, "line");
            }
        }
        scanner.close();

    }
}



