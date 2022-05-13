package asv.conditions;

/**
 * Created by asvidersky on 5/13/2022.
 */

public class WhatWillReturn {
    static boolean func1(){
        System.out.println("Step 2");
        return true;
    }

    static void doIf(boolean value) {
        if (value || func1()) {
            System.out.println("Step 1");
        }
    }
    public static void main(String[] args) {
        doIf(false);
        doIf(true);
        String result = ("".length() == 6) ? "First" : "Second";
        System.out.println(result);
    }
}
