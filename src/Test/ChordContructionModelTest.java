package Test;

import Model.ChordConstructionPractice;
import Model.enums.Difficulty;

public class ChordContructionModelTest {
    public static void main(String[] args) {
        ChordConstructionPractice practice = new ChordConstructionPractice(Difficulty.EASY);

        System.out.println("Difficulty should be easy: " + practice.getDifficulty());
        for (int i = 0; i < 11; i++) {
            System.out.println("Easy Practice Command + Answer: " + practice.getPracticeCommand());
        }
        System.out.println("\n\n");

        practice = new ChordConstructionPractice(Difficulty.MEDIUM);

        System.out.println("Difficulty should be easy: " + practice.getDifficulty());
        for (int i = 0; i < 11; i++) {
            System.out.println("Easy Practice Command + Answer: " + practice.getPracticeCommand());
        }
        System.out.println("\n\n");

        practice = new ChordConstructionPractice(Difficulty.HARD);

        System.out.println("Difficulty should be easy: " + practice.getDifficulty());
        for (int i = 0; i < 11; i++) {
            System.out.println("Easy Practice Command + Answer: " + practice.getPracticeCommand());
        }
        System.out.println("\n\n");

        practice = new ChordConstructionPractice(Difficulty.RAPID);

        System.out.println("Difficulty should be easy: " + practice.getDifficulty());
        for (int i = 0; i < 11; i++) {
            System.out.println("Easy Practice Command + Answer: " + practice.getPracticeCommand());
        }
    }
}
