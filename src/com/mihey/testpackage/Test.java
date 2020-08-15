package com.mihey.testpackage;

import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine().trim();
        reader.close();
        if (str.length() == 0) {
            System.out.println(0);
            return;
        }
        String[] s = str.split("\\s+");
        System.out.println(s.length);
    }
}

class Range implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @serial
     */
    private final int from;
    /**
     * @serial
     */
    private final int to;

    private void readObject(ObjectInputStream ois) throws IllegalArgumentException, IOException, ClassNotFoundException {
        if (from > to) {
            throw new IllegalArgumentException("Start is greater than end");
        } else
            ois.defaultReadObject();
    }

    /**
     * Creates Range.
     *
     * @param from start
     * @param to   end
     * @throws IllegalArgumentException if start is greater than end.
     */
    public Range(int from, int to) {
        if (from > to) {
            throw new IllegalArgumentException("Start is greater than end");
        }
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

}