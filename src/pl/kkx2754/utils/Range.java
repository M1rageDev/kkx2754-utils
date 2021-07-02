package pl.kkx2754.utils;

import java.util.ArrayList;

public class Range {

    public static ArrayList<Integer> range(Integer n) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (Integer i = 0; i < n; i++) {
            list.add(i);
        }

        return list;
    }

}
