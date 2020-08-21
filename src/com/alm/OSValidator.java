package com.alm;

public class OSValidator {

    private static String OS = System.getProperty("os.name").toLowerCase();

    public static OS getOs (){
        if (isWindows()) {
            return new OS("powershell", "/C", "$env:username");
        } else {
            return new OS("/bin/bash", "-c","whoami");
        }
    }

    private static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

}
