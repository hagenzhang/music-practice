package Model;

import java.util.Random;

import Model.enums.Difficulty;

/**
 * Abstract Superclass of Practice Programs.
 */
public abstract class AbstractPracticeProgram implements PracticeProgram {
    
    private Difficulty difficulty;
    protected static Random RANDOM = new Random();
    
    protected AbstractPracticeProgram() {
        this.difficulty = null;
    }

    protected AbstractPracticeProgram(Difficulty diff) {
        this.difficulty = diff;
    }

    @Override
    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    @Override
    public void setDifficulty(Difficulty diff) {
        this.difficulty = diff;
    }










}
