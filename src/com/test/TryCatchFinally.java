package com.test;
public class TryCatchFinally {
 
    @SuppressWarnings("finally")
    public static final String test() {
        String t = "";
 
        try {
            t = "try";
            Integer.parseInt(null);
            return t;
        } catch (Exception  e) {
            // result = "catch";
            t = "catch";
            return t;
        } finally {
            t = "finally";
            String.valueOf(null);
            return t;
        }
    }
 
    public static void main(String[] args) {
        System.out.print(TryCatchFinally.test());
    }
 
}