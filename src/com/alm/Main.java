package com.alm;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String[] gitMessage = {"Kontrollera vart nånstans användaren ligger", "Skapa en mapp med namnet 'softwaredev' för sitt första projekt",
                "Gå in i mappen du skapade", "skapa filen Main.java", "Börja en initial commit",

                "Kolla vilka filer vi har i mappen", "Lägg till alla filer i projektet", "Lägg till fil Main2.java i commiten", "Se tracked och untracked filer", "Commita med kommentar 'first commit'",
                "Lägg till remote på: https://github.com/myfirstgithubrepo/softwaredev.git", "pusha till master"};

        String[] gitAnswer = {"/c/Users/user", "softwaredev skapad", "/c/Users/user/softwaredev", "Main.java skapad ", "ny Git repository skapad"
                , "Main.java\nMain2.java", "Main.java added", "Main2.java added", "Main.java ready to commit\nMain2.java ready to commit"
                , "Main.java commit\nMain2.java commit\nKomentar: first commit", "git remote origin added", "push project remote to github\nGRATTIS"};


        String[] gitCommands = {"pwd", "mkdir softwaredev",
                "cd softwaredev", "touch Main.java", "git init",
                "ls", "git add .", "git add Main2.java", "git status", "git commit -m \"first commit\"",
                "git remote add origin https://github.com/myfirstgithubrepo/softwaredev.git", "git push -u origin master"};


        System.out.println("Fazlis Branch ");
        System.out.println("Test issues from  from terminal again 2");
        System.out.println("Close issue from  asdterminal");
        System.out.println("Close issue from terminal");
        System.out.println("Test from terminal again ");
        System.out.println("Test from terminal again joakim");
        System.out.println("Test from terminal again joakim22");
        System.out.println("Test from terminal again joakim22");
        System.out.println("Test from terminal again joakim232");
        System.out.println("Test from terminal again JOAKIM");




                System.out.println("Följ instruktionerna och ange svaret i terminalen");
                System.out.println("Assign a reviewr from terminal");
                printSeparator();

                for (int i = 0; i < gitCommands.length; i++) {
                    while (!getInput(gitMessage[i]).equalsIgnoreCase(gitCommands[i])) {

                        System.out.println("Felaktig inmatning, försök igen");
                    }
                    System.out.println("Rätt?");
                    printSeparator();
                }

        }


            public static String getInput (String message){

                Scanner sc = new Scanner(System.in);
                System.out.println(message);
                printSeparator();
                System.out.print("Terminal: ");
                return sc.nextLine();
            }
            public static void printSeparator () {
                System.out.println("--------------------------------------------");
            }


        }


