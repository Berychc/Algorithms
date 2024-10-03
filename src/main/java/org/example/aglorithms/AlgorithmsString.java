package org.example.aglorithms;

public class AlgorithmsString {

    /**
     * Given an "out" string length 4, such as "<<>>", and a word,
     * return a new string where the word is in the middle of the out string, e.g. "<<word>>".
     * Note: use str.substring(i, j) to extract the String starting at index
     * i and going up to but not including index j.
     *
     *
     * makeOutWord("<<>>", "Yay") → "<<Yay>>"
     * makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
     * makeOutWord("[[]]", "word") → "[[word]]"
     */
    public String makeOutWord(String out, String word) {
        String firstHalf = out.substring(0, out.length() / 2);
        String secondHalf = out.substring(out.length() / 2);

        return firstHalf + word + secondHalf;
    }

    /**
     * Given a string of even length, return the first half. So the string "WooHoo" yields "Woo".
     *
     * firstHalf("WooHoo") → "Woo"
     * firstHalf("HelloThere") → "Hello"
     * firstHalf("abcdef") → "abc"
     */
    public String firstHalf(String str) {
        return str.substring(0, str.length() / 2);
    }

    /**
     * Given 2 strings, return their concatenation, except omit the first char of each.
     * The strings will be at least length 1.
     *
     *
     * nonStart("Hello", "There") → "ellohere"
     * nonStart("java", "code") → "avaode"
     * nonStart("shotl", "java") → "hotlava"
     */
    public String nonStart(String a, String b) {
        return a.substring(1) + b.substring(1);
    }


    /**
     *
     Given a string, return a string length 1 from its front,
     unless front is false, in which case return a string length 1 from its back. The string will be non-empty.

     theEnd("Hello", true) → "H"
     theEnd("Hello", false) → "o"
     theEnd("oh", true) → "o"
     */
    public String theEnd(String str, boolean front) {
        return front ? str.substring(0,1) : str.substring(str.length() - 1);
    }


    /**
     *
     Given a string, return true if it ends in "ly".

     endsLy("oddly") → true
     endsLy("y") → false
     endsLy("oddy") → false
     */
    public boolean endsLy1(String str) {
        if (str.endsWith("ly")) {
            return true;
        } else {
            return false;
        }
    }

    // Second way
    public boolean endsLy2(String str) {
        return str.endsWith("ly");
    }


    /**
     *
     Given a string of odd length, return the string length 3 from its middle,
     so "Candy" yields "and". The string length will be at least 3.

     middleThree("Candy") → "and"
     middleThree("and") → "and"
     middleThree("solving") → "lvi"
     */
    public String middleThree1(String str) {
        int mid = str.length() / 2;
        return str.substring(mid - 1, mid + 2);
    }
    // Second way
    public String middleThree2(String str) {
        return str.substring(str.length() / 2 - 1, str.length() / 2 + 2);
    }

    /**
     * Given 2 strings, a and b, return a new string made
     * of the first char of a and the last char of b, so "yo" and "java" yields "ya".
     * If either string is length 0, use '@' for its missing char.
     *
     * lastChars("last", "chars") → "ls"
     * lastChars("yo", "java") → "ya"
     * lastChars("hi", "") → "h@"
     */
    public String lastChars(String a, String b) {
        char firstChar = a.isEmpty() ? '@' : a.charAt(0);
        char lastChar = b.isEmpty() ? '@' : b.charAt(b.length() - 1);
        return "" + firstChar + lastChar;
    }

    /**
     *
     Given a string, if the string begins with "red" or "blue"
     return that color string, otherwise return the empty string.

     seeColor("redxx") → "red"
     seeColor("xxred") → ""
     seeColor("blueTimes") → "blue"
     */
    public String seeColor(String str) {
        if (str.startsWith("red")) {
            return "red";
        } else if (str.startsWith("blue")) {
            return "blue";
        } else {
            return "";
        }
    }

    /**
     *
     Given a string, return a new string made of 3 copies
     of the first 2 chars of the original string. The string may be any length.
     If there are fewer than 2 chars, use whatever is there.

     extraFront("Hello") → "HeHeHe"
     extraFront("ab") → "ababab"
     extraFront("H") → "HHH"
     */
    public String extraFront(String str) {
        String front;
        if (str.length() < 2) {
            front = str;
        } else {
            front = str.substring(0, 2);
        }
        return front + front + front;
    }

    /**
     * Given a string and a second "word" string, we'll say that the word matches
     * the string if it appears at the front of the string, except its first char does
     * not need to match exactly. On a match, return the front of the string, or otherwise return the empty string.
     * So, so with the string "hippo" the word "hi" returns "hi" and "xip" returns "hip".
     * ёThe word will be at least length 1.
     *
     * startWord("hippo", "hi") → "hi"
     * startWord("hippo", "xip") → "hip"
     * startWord("hippo", "i") → "h"
     */
    public String startWord(String str, String word) {
        if (word.length() < 1 || str.length() < word.length()) {
            return "";
        }
        String front = str.substring(0, word.length());

        if (front.substring(1).equals(word.substring(1))) {
            return front;
        } else {
            return "";
        }
    }

    /**
     *Given two strings, a and b, return
     * the result of putting them together in the order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi".
     *
     makeAbba("Hi", "Bye") → "HiByeByeHi"
     makeAbba("Yo", "Alice") → "YoAliceAliceYo"
     makeAbba("What", "Up") → "WhatUpUpWhat"
     */
    public String makeAbba(String a, String b) {
        return a + b + b + a;
    }

    /**
     *
     Given a string, return a new string made of 3 copies of the last 2 chars of the
     original string. The string length will be at least 2.

     extraEnd("Hello") → "lololo"
     extraEnd("ab") → "ababab"
     extraEnd("Hi") → "HiHiHi"
     */
    public String extraEnd(String str) {
        String lastTwoChars = str.substring(str.length() - 2);
        return lastTwoChars + lastTwoChars + lastTwoChars;
    }

    /**
     *
     Given a string, return a version without the first and last char, so "Hello" yields "ell".
     The string length will be at least 2.

     withoutEnd("Hello") → "ell"
     withoutEnd("java") → "av"
     withoutEnd("coding") → "odin"
     */
    public String withoutEnd(String str) {
        return str.substring(1, str.length() - 1);
    }

    /**
     * Given a string, return a "rotated left 2" version where the first 2 chars are moved to the end.
     * The string length will be at least 2.
     *
     * left2("Hello") → "lloHe"
     * left2("java") → "vaja"
     * left2("Hi") → "Hi"
     */
    public String left2(String str) {
        if (str.length() <= 2) {
            return str;
        }
        return str.substring(2) + str.substring(0, 2);
    }

    /**
     *
     Given a string, return a version without both the first and last char of the string.
     The string may be any length, including 0.

     withoutEnd2("Hello") → "ell"
     withoutEnd2("abc") → "b"
     withoutEnd2("ab") → ""
     */
    public String withoutEnd2(String str) {
        if (str.length() < 2) {
            return "";
        }
        return str.substring(1, str.length() - 1);
    }

    /**
     *
     Given a string and an int n, return a string made of the first and last n chars from the string.
     The string length will be at least n.

     nTwice("Hello", 2) → "Helo"
     nTwice("Chocolate", 3) → "Choate"
     nTwice("Chocolate", 1) → "Ce"
     */
    public String nTwice(String str, int n) {
        String firstN = str.substring(0, n);
        String lastN = str.substring(str.length() - n);
        return firstN + lastN;
    }




}
