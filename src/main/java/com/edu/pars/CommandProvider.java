package com.edu.pars;

public class CommandProvider {
    public static String parserName;
    public static String filePath;
    public static String keyString;

    public static void readCommand(String str){
        str = str.toLowerCase();
        initNewParameters();
        if(str.contains(" ")){
            int index = str.indexOf(" ");
            parserName = str.substring(0, index);
            str = str.substring(index).trim();
            if (str.contains(" ")) {
                index = str.indexOf(" ");
                filePath = str.substring(0, index);
                keyString = str.substring(index).trim();
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
