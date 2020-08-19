package com.alm;

import java.util.Scanner;


public class Main {
    static String[] gitAnswer = {"/c/Users/user", "Mapp med namn softwaredev skapad", "/c/Users/user/softwaredev", "Main.java skapad "
            ,"Initialized empty Git repository in C:/Users/user/softwaredev/.git/ "
            , "Main.java", "Main.java added",
            "No commits yet\n\n" +
                    "Changes to be committed:\n" +
                    "\t(use \"git rm --cached <file>...\" to unstage)\n" +
                    "\t\tnew file:   Main.java"
            , "[master (root-commit) ff3bbc8] first commit\n" +
            " 1 file changed, 0 insertions(+), 0 deletions(-)\n" +
            " create mode 100644 Main.java\n", "git remote origin added",
            "Enumerating objects: 3, done.\n" +
            "Counting objects: 100% (3/3), done.\n" +
            "Writing objects: 100% (3/3), 218 bytes | 218.00 KiB/s, done.\n" +
            "Total 3 (delta 0), reused 0 (delta 0)\n" +
            "To https://github.com/myfirstgithubrepo/softwaredev.git\n" +
            " * [new branch]      master -> master\n" +
            "Branch 'master' set up to track remote branch 'master' from 'origin'.\n"
            +"\nGRATTIS!"};

    static String[] gitMessage = {"Kontrollera vilken mapp du står i : pwd",
            "Skapa en mapp med namnet 'softwaredev' för ditt första projekt : mkdir 'mappnamn'",
            "Gå in i mappen du skapade : cd 'mappnamn'", "skapa filen Main.java : touch filnamn",
            "Börja en initial commit : git init",
            "Kolla vilka filer du har i mappen : ls",
            "Lägg till alla filerna i nuvarande mapp för commiten : git add .",
            "Se tracked och untracked filer : git status", "Commita med kommentar 'first commit' : git commit -m \"kommentar\"",
            "Lägg till remote på: https://github.com/myfirstgithubrepo/softwaredev.git :\ngit remote add origin https://github.com/myfirstgithubrepo/softwaredev.git", "pusha till master : git push -u origin master"};

    static String[] gitCommands = {"pwd", "mkdir softwaredev",
            "cd softwaredev", "touch Main.java", "git init",
            "ls", "git add .", "git status", "git commit -m \"first commit\"",
            "git remote add origin https://github.com/myfirstgithubrepo/softwaredev.git", "git push -u origin master"};

    public static void main(String[] args) {

        System.out.println("Välkommen till GitTutorial.");
        System.out.println("\tFölj instruktionerna och ange svaret i terminalen");
        printSeparator();

        for (int i = 0; i < gitCommands.length; i++) {
            while (!getInput(gitMessage[i]).equalsIgnoreCase(gitCommands[i])) {
                System.out.println("Felaktig inmatning, försök igen");
            }
            printMessage(i);
            printSeparator();
        }

    }

    private static void printMessage(int i) {
        System.out.println("Response: " + gitAnswer[i]);
    }

    public static String getInput(String message) {

        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        printSeparator();
        System.out.print("Terminal: ");
        return sc.nextLine();
    }

    public static void printSeparator() {
        System.out.println("-----------------------------------------------------");
    }
}


