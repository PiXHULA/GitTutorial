package com.alm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] gitMessage = {"Kontrollera vart nånstans användaren ligger? ", "Skapa en mapp med namnet 'softwaredev' för sitt första projekt",
                "Gå in i mappen du skapade", "skapa filen Main.java", "Börja en initial commit",
                "Kolla vilka filer vi har i mappen", "Lägg till alla filer i projektet", "Lägg till en fil i commiten", "Se tracked och untracked filer", "Commita med kommentar 'first commit'",
                "Lägg till remote på: https://github.com/myfirstgithubrepo/softwaredev.git", "pusha till master"};


        String[] gitCommands = {"pwd", "mkdir softwaredev",
                "cd softwaredev/", "touch Main.java", "git init",
                "ls", "git add .", "git add Main2.java", "git status", "git commit -m \"first commit\"",
                "git remote add origin https://github.com/myfirstgithubrepo/softwaredev.git", "git push -u origin master"};

        System.out.println("Test from terminal");
        System.out.println("Test from terminal again 2");

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
