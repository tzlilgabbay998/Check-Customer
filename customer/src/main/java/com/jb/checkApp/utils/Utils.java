package com.jb.checkApp.utils;

public class Utils {

    protected boolean isOnlyLetters(String value){
        char[] chars = value.toCharArray();

        for (char c: chars){
            if(!Character.isLetter(c))
                return false;
        }
        return true;
    }

    protected boolean isOnlyDigits(String value){
        char[] chars = value.toCharArray();

        for (char c: chars){
            if(!Character.isDigit(c))
                return false;
        }
        return true;
    }


    protected int countCharInString(String value, char c){
        int counter = 0;

        for (int i=0; i<value.length(); i++){
            if(value.charAt(i) == c){
                counter++;
            }
        }
        return counter;
    }

}
