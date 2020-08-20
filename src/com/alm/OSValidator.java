package com.alm;

public class OSValidator {

    private static String OS = System.getProperty("os.name").toLowerCase();

    public static OS getOs (){
        if (isWindows()) {
            return new OS("powershell", "/C");
        } else if (isMac()) {
            return new OS("/bin/bash", "-c");
        } else {
            return new OS("/bin/bash", "-c");
        }
    }

    private static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    private static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }
}
