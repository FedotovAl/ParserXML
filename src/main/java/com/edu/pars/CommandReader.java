package com.edu.pars;

public class CommandReader {
    public static String parserName = "";
    public static String filePath = "";
    public static String keyString = "";

    public static void readCommand(String str){
        if(str.contains(" ")){
            parserName = str.substring(0, str.indexOf(" "));
            str = str.substring(str.indexOf(" ") + 1);
            filePath = str.substring(0, str.indexOf(" "));
            keyString = str.substring(str.indexOf(" ") + 1);
        }
    }

}
