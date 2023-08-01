package com.music.practice.model;

import java.util.Random;

import org.jfugue.theory.Chord;
import org.jfugue.theory.Note;

import com.music.practice.model.enums.*;

/**
 * This Class represents the Chord Contruction Practice Program. <br>
 * 
 * In this program, the user will have to provide the intervals that make up a chord. The interval options are as specified in the corresponding enum.
 * All chord notes should be provided in first inversion.
 * 
 * 
 * Easy Difficulty:
 * - This difficulty will only include the following chord qualities: major, minor, major 7th, dominant 7th, minor 7th,
 *   suspended 2, and suspended 4 chords. 
 * 
 * Medium Difficulty:
 * - An easy task will be selected 30% of the time.
 * - Will included augmented, diminished, diminished 7th, half diminished 7th.
 * 
 * Hard Difficulty:
 * - An Easy task will be chosen 10% of the time (with the original weights applied)
 * - A Medium task will be chosen 20% of the time (with the original weights applied)
 * - Will include 9 chords, 11 chords, and 13 chords (the basic extended chords)
 * - More jazz chords will additional accidentals and layers will be added to the list of possible chords.
 * 
 * Rapid Difficulty:
 * - Generates all chord type with the exact same probability.
 * 
 * Only chord options are those supported by JFugue.
 * 
 * Enharmonic equivalences can sometimes come up, and that's okay (for example, Bb and A# can appear together in the same excercise).
 */
public class ChordConstruction implements PracticeProgram {
    
    Random randomGenerator;

    public ChordConstruction() {
        this.randomGenerator = new Random();
    }


    @Override
    public String getPracticeCommand(Difficulty diff) {
        String message = "";

        // Start by splitting this operation by difficulty
        if (diff.equals(Difficulty.EASY)) {
            message = generateEasyMode();
        } else if (diff.equals(Difficulty.MEDIUM)) {
            message = generateMediumMode();
        } else if (diff.equals(Difficulty.HARD)) {
            message = generateHardMode();
        } else if (diff.equals(Difficulty.RAPID)) {
            message = generateRapidMode();
        } else {
            throw new IllegalArgumentException("Invalid Difficulty Value Provided: " + diff);
        }

        return message;
    }
    
    // Generates a challenge for the easy difficulty.
    private String generateEasyMode() {
        Random rand = new Random();

        String[] chordOptions = {"maj", "min", "maj7", "dom7", "min7", "sus2", "sus4"};
        int randInt = rand.nextInt(chordOptions.length);
        String chordType = chordOptions[randInt];

        Chord chord = new Chord("C" + chordType);
        // System.out.println(chord.toString());

        // Get the individual notes in the chord
        Note[] notes = chord.getNotes();

        String answerString = "";
        // Iterate through the notes, convert all the half step counts into intervals, add them into a list
        for (int i = 0; i < notes.length - 1; i++) {
            Note rootNote = notes[0];
            Note nextNote = notes[i+1];

            int steps = nextNote.getValue() - rootNote.getValue();
            // System.out.println("Number of half steps from " + currentNote + " to " + nextNote + ": " + steps);
            answerString = answerString + Interval.semitonesToInterval(steps) + " ";
        }

        return "List the intervals that make up a " + chordType + " chord: ##SOLUTION##" + answerString.trim();
    }

    // Generates a challenge for the medium difficulty.
    private String generateMediumMode() {
        Random rand = new Random();
        
        // Get an easy exercise 30% of the time
        if (rand.nextInt(10) < 3) {
            return generateEasyMode();
        }

        String[] chordOptions = {"aug", "dim", "dim7", "min7b5"};
        int randInt = rand.nextInt(chordOptions.length);
        String chordType = chordOptions[randInt];

        Chord chord = new Chord("C" + chordType);

        // Get the individual notes in the chord
        Note[] notes = chord.getNotes();

        String answerString = "";
        // Iterate through the notes, convert all the half step counts into intervals, add them into a list
        for (int i = 0; i < notes.length - 1; i++) {
            Note rootNote = notes[0];
            Note nextNote = notes[i+1];

            int steps = nextNote.getValue() - rootNote.getValue();
            // System.out.println("Number of half steps from " + currentNote + " to " + nextNote + ": " + steps);
            answerString = answerString + Interval.semitonesToInterval(steps) + " ";
        }

        return "List the intervals that make up a " + chordType + " chord: ##SOLUTION##" + answerString.trim();
    }

    // Generates a challenge for the hard difficulty.
    private String generateHardMode() {
        // player.play("V0 I[Piano] Cdom9QQ"); // works
        // player.play("V0 I[Piano] Cdom11QQ"); // works
        // player.play("V0 I[Piano] Cdom13QQ"); // works
        Random rand = new Random();
        int nextInt = rand.nextInt(10);
        // Get an easy exercise 20% of the time, medium 30% of the time.
        if (nextInt < 2) {
            return generateEasyMode();
        } else if (nextInt > 6) {
            return generateMediumMode();
        }

        String[] chordOptions = {"dom9", "dom11", "dom13"};
        int randInt = rand.nextInt(chordOptions.length);
        String chordType = chordOptions[randInt];

        Chord chord = new Chord("C" + chordType);

        // Get the individual notes in the chord
        Note[] notes = chord.getNotes();

        String answerString = "";
        // Iterate through the notes, convert all the half step counts into intervals, add them into a list
        for (int i = 0; i < notes.length - 1; i++) {
            Note rootNote = notes[0];
            Note nextNote = notes[i+1];

            int steps = nextNote.getValue() - rootNote.getValue();
            // System.out.println("Number of half steps from " + currentNote + " to " + nextNote + ": " + steps);
            answerString = answerString + Interval.semitonesToInterval(steps) + " ";
        }

        return "List the intervals that make up a " + chordType + " chord: ##SOLUTION##" + answerString.trim();
    }

    // Generates a challenge for the rapid difficulty.
    private String generateRapidMode() {
        Random rand = new Random();

        String[] chordOptions = {"maj", "min", "maj7", "dom7", "min7", "sus2", "sus4",
                                 "aug", "dim", "dim7", "min7b5", "dom9", "dom11", "dom13"};
        
                                 int randInt = rand.nextInt(chordOptions.length);
        String chordType = chordOptions[randInt];

        Chord chord = new Chord("C" + chordType);

        // Get the individual notes in the chord
        Note[] notes = chord.getNotes();

        String answerString = "";
        // Iterate through the notes, convert all the half step counts into intervals, add them into a list
        for (int i = 0; i < notes.length - 1; i++) {
            Note rootNote = notes[0];
            Note nextNote = notes[i+1];

            int steps = nextNote.getValue() - rootNote.getValue();
            // System.out.println("Number of half steps from " + currentNote + " to " + nextNote + ": " + steps);
            answerString = answerString + Interval.semitonesToInterval(steps) + " ";
        }

        return "List the intervals that make up a " + chordType + " chord: ##SOLUTION##" + answerString.trim();
    }

    

}


