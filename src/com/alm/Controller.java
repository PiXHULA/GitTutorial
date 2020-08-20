package com.alm;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    List<Question> questions;
    View view;
    int counter = 0;

    public Controller() {

        questions = new ArrayList<>();
        questions.add(new Question("/c/Users/user","Kontrollera vilken mapp du står i","pwd"));
        questions.add(new Question("Mapp med namn softwaredev skapad","Skapa en mapp med namnet 'softwaredev' för sitt första projekt","mkdir softwaredev"));
        questions.add(new Question("/c/Users/user/softwaredev","Gå in i mappen softwaredev som du skapade","cd softwaredev"));
        questions.add(new Question("Main.java skapad","Skapa filen Main.java","touch Main.java"));
        questions.add(new Question("Initialized empty Git repository in C:/Users/user/softwaredev/.git/ ","Börja med en initial commit","git init"));
        questions.add(new Question("Main.java","Kolla vilka filer vi har i mappen","ls"));
        questions.add(new Question("Main.java added","Lägg till alla filerna i nuvarande mapp för commiten","git add ."));
        questions.add(new Question("No commits yet\n\n" +
                                            "Changes to be committed:\n" +
                                            "\t(use \"git rm --cached <file>...\" to unstage)\n" +
                                            "\t\tnew file:   Main.java","Se tracked och untracked filer","git status"));
        questions.add(new Question("[master (root-commit) ff3bbc8] first commit\n" +
                                            " 1 file changed, 0 insertions(+), 0 deletions(-)\n" +
                                            " create mode 100644 Main.java\n","Committa med kommentar 'first commit'","git commit -m\"first commit\""));
        questions.add(new Question("git remote origin added","Lägg till remote på: https://github.com/myfirstgithubrepo/softwaredev.git","git remote add origin https://github.com/myfirstgithubrepo/softwaredev.git"));
        questions.add(new Question("Enumerating objects: 3, done.\n" +
                                            "Counting objects: 100% (3/3), done.\n" +
                                            "Writing objects: 100% (3/3), 218 bytes | 218.00 KiB/s, done.\n" +
                                            "Total 3 (delta 0), reused 0 (delta 0)\n" +
                                            "To https://github.com/myfirstgithubrepo/softwaredev.git\n" +
                                            " * [new branch]      master -> master\n" +
                                            "Branch 'master' set up to track remote branch 'master' from 'origin'.\n"
                                            +"\nGRATTIS!","Pusha till master","git push -u origin master"));

        this.view = new View(questions.get(counter), this);

}
public void newQuestion(){
        if (counter==10) {
            view.win();
        }
        counter++;
        this.view.setCurrentQuestion(questions.get(counter));
    }
        }


