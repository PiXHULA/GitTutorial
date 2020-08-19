package com.alm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] gitMessage = {"Kontrollera vart nånstans användaren ligger? ", "Skapa en mapp med namnet 'softwaredev' för sitt första projekt",
                "Gå in i mappen du skapade", "skapa filen Main.java", "Börja en initial commit",
                "Kolla vilka filer vi har i mappen", "Lägg till alla filer i projektet", "Lägg till fil Main2.java i commiten", "Se tracked och untracked filer", "Commita med kommentar 'first commit'",
                "Lägg till remote på: https://github.com/myfirstgithubrepo/softwaredev.git", "pusha till master"};

        String[] gitAnswer = {"/c/Users/user", "softwaredev skapad", "/c/Users/user/softwaredev","Main.java skapad ", "ny Git repository skapad"
        ,"Main.java\nMain2.java","Main.java added","Main2.java added","Main.java ready to commit\nMain2.java ready to commit"
        ,"Main.java commit\nMain2.java commit\nKomentar: first commit","git remote origin added","push project remote to github\nGRATTIS"};


        String[] gitCommands = {"pwd", "mkdir softwaredev",
                "cd softwaredev/", "touch Main.java", "git init",
                "ls", "git add .", "git add Main2.java", "git status", "git commit -m \"first commit\"",
                "git remote add origin https://github.com/myfirstgithubrepo/softwaredev.git", "git push -u origin master"};



        for (int i = 0; i < gitCommands.length; i++) {
            while(!getInput(gitMessage[i] + ": ").equals(gitCommands[i])) {
                System.out.println("Felaktig inmatning, försök igen");
            }
        }
    }
    public static String getInput(String message) {
        Scanner sc=new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }


}
