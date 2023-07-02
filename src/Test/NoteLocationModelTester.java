package Test;

import Model.NoteLocationPractice;
import Model.PracticeProgram;
import Model.enums.Difficulty;

public class NoteLocationModelTester {

    public static void main(String args[]) {
        System.out.println("Hello World!");
        System.out.println("Practice is important! Lets get started");

        PracticeProgram practiceProgramEasy = new NoteLocationPractice(Difficulty.EASY);
        PracticeProgram practiceProgramMedium = new NoteLocationPractice(Difficulty.MEDIUM);
        PracticeProgram practiceProgramHard = new NoteLocationPractice(Difficulty.HARD);
        PracticeProgram practiceProgramRapid = new NoteLocationPractice(Difficulty.RAPID);

        for (int i = 0; i < 30; i++) {
            System.out.println("\n\nLoop Number " + i + "\n");
            System.out.println("Easy Challenge:");
            System.out.println(practiceProgramEasy.getPracticeCommand() + "\n");
            
            System.out.println("Medium Challenge:");
            System.out.println(practiceProgramMedium.getPracticeCommand() + "\n");

            System.out.println("Hard Challenge:");
            System.out.println(practiceProgramHard.getPracticeCommand() + "\n");

            System.out.println("Rapid Challenge:");
            System.out.println(practiceProgramRapid.getPracticeCommand() + "\n");
        }





    } 

}
