package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class Main {
    static ArrayList<String> listLog = new ArrayList<>();
    static ArrayList<User> listdb = new ArrayList<>();
    static TreeMap<Integer, User> mapAnalitic = new TreeMap<>();

    public static void main(String[] args) {
        String filename = "C:\\work\\server.log";
        for (String i : parsePatentsData(filename)) {
            listLog.add(i.split(":")[0]);
        }
        String filenameTwo = "C:\\work\\users.db";
        ArrayList<String> listDbString = parsePatentsData(filenameTwo);
        listDbString.remove(0);

        for (String i : listDbString) {
            String[] temp = i.split(";");
            listdb.add(new User(temp[0], temp[1], temp[2], temp[3]));
        }
        for (User u : listdb) {
            int summ = 0;
            for (String s : listLog) {
                if (u.ip.equals(s)) {
                    summ++;
                }
            }
            mapAnalitic.put(summ, u);
        }
        System.out.println(mapAnalitic.get(mapAnalitic.keySet().toArray()[mapAnalitic.size()-1]));
    }

    private static ArrayList<String> parsePatentsData(String filename) {
        ArrayList<String> copy = new ArrayList<>();
        File file = new File(filename);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            copy.add(line);
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    copy.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return copy;


    }
}
