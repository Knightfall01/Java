package com.suganth.amrita.cys.jpl.datastructures;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> studentRollNumbers = new ArrayList<String>();

        studentRollNumbers.add("CB.EN.U4CYS22026");
        studentRollNumbers.add("CB.EN.U4CYS22027");
        studentRollNumbers.add("CB.EN.U4CYS22028");
        studentRollNumbers.add("CB.EN.U4CYS22029");
        studentRollNumbers.add("CB.EN.U4CYS22030");

        Iterator<String> iterator = studentRollNumbers.iterator();

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}

