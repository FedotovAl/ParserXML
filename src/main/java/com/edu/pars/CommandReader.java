package com.edu.pars;

public class CommandReader {
    public static String parserName;
    public static String filePath;
    public static String keyString;

    public static void readCommand(String str){
        str = str.toLowerCase();
        initNewParameters();
        if(str.contains(" ")){
            parserName = str.substring(0, str.indexOf(" "));
            str = str.substring(str.indexOf(" ")).trim();
            if (str.contains(" ")) {
                filePath = str.substring(0, str.indexOf(" "));
                keyString = str.substring(str.indexOf(" ")).trim();
            } else {
                filePath = str;
                keyString = "-all";
            }
        } else {
            System.out.println("Filepath is empty");
        }
    }

    private static void initNewParameters(){
        parserName = "";
        filePath = "";
        keyString = "";
    }

}
