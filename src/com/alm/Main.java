package com.alm;

public class Main {

    public static void main(String[] args) {

        String user = "Fazli kan inte så mkt";
        String secondUser = "Atef";
        System.out.println(user + " " + secondUser);

        user = "Jocke";
        System.out.println(user);

        String[] gitCommands = {"pwd", "mkdir softwaredev",
                "cd softwaredev/", "touch Main.java", "git init",
                "ls", "git add .", "git add Main2.java", "git status", "git commit -m \"first commit\"",
                "git remote add origin https://github.com/myfirstgithubrepo/softwaredev.git", "git push -u origin master"};
        for (String s : gitCommands) {
            System.out.println(s);
        }
    }
}