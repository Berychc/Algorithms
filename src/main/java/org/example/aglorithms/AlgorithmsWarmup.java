package org.example.aglorithms;

public class AlgorithmsWarmup {

    public String fizzString(String str) {
        if (str.startsWith("f") && str.endsWith("b")) {
            return "FizzBuzz";
        } else if (str.startsWith("f")) {
            return "Fizz";
        } else if (str.endsWith("b")) {
            return "Buzz";
        } else {
            return str;
        }
    }

    /**
     *
     Given two temperatures, return true if one is less than 0 and the other is greater than 100.

     icyHot(120, -1) → true
     icyHot(-1, 120) → true
     icyHot(2, 120) → false
     */
    public boolean icyHot(int temp1, int temp2) {
        return (temp1 < 0 && temp2 > 100) || (temp1 > 100 && temp2 < 0);
    }

    /**
     *
     Given a string, take the first 2 chars and return the string with the 2 chars
     added at both the front and back, so "kitten" yields"kikittenki".
     If the string length is less than 2, use whatever chars are there.

     front22("kitten") → "kikittenki"
     front22("Ha") → "HaHaHa"
     front22("abc") → "ababcab"
     */
    public String front22(String str) {
        String front = str.length() < 2 ? str : str.substring(0, 2);
        return front + str + front;
    }

}
