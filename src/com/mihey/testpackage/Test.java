package com.mihey.testpackage;


import java.util.Scanner;

public class Test {
    private static class TableEntry<T> {
        private final int key;
        private final T value;
        private boolean removed;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

        public void remove() {
            removed = true;
        }

        public boolean isRemoved() {
            return removed;
        }
    }

    private static class HashTable<T> {
        private int size;
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            int idx = findKey(key);

            if (idx == -1) {
                return false;
            }

            table[idx] = new TableEntry(key, value);
            return true;
        }

        public T get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();
        }

        public void remove(int key) {
            int idx = findKey(key);
            if (!(idx == -1 || table[idx] == null)) {
                table[idx].remove();
            }
        }


        private int findKey(int key) {
            int hash = key % size;

            while (!(table[hash] == null || table[hash].getKey() == key)) {
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    return -1;
                }
            }

            return hash;
        }

        private void rehash() {
            size = size * 2;
            TableEntry[] te = new TableEntry[size];
            int i = 0;

            for (TableEntry t : table) {
                te[i] = t;
                i++;
            }
            table = new TableEntry[size];
            int j = 0;
            for (TableEntry t : te) {
                if (t != null) {
                    j = findKey(t.getKey());
                    table[j] = t;
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder tableStringBuilder = new StringBuilder();

            for (int i = 0; i < table.length; i++) {
                if (table[i] == null) {
                    tableStringBuilder.append(i + ": null");
                } else {
                    tableStringBuilder.append(i + ": key=" + table[i].getKey()
                            + ", value=" + table[i].getValue()
                            + ", removed=" + table[i].isRemoved());
                }

                if (i < table.length - 1) {
                    tableStringBuilder.append("\n");
                }
            }

            return tableStringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashTable<String> table = new HashTable(5);
        for (int i = 0; i < n; i++) {
            if (i == table.size) {
                table.rehash();
            }
            int key = sc.nextInt();
            String val = sc.next();
            if (table.get(key) == null) {
                table.put(key, val);
            } else {
                table.put(key, table.get(key) + " " + val);
            }
        }
        for (int i = 0; i < m; i++) {
            table.remove(sc.nextInt());
        }
        System.out.print(table.toString());
    }
}