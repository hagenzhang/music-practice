package com.music.practice.model;

import com.music.practice.model.enums.Difficulty;

/**
 * This interface represents a practice program. 
 */
public interface PracticeProgram {
 
    /**
     * This function will return a String. The string will contain a command, telling what the user should do
     * on the guitar in order to practice, as well as the correct solution if one exists.
     * 
     * The solution will be seperated by "##SOLUTION##" as a marker.
     * 
     * An example of a string will be: [Insert command here] ##SOLUTION##[Insert solution here].
     * 
     * @return String for the user.
     */
    String getPracticeCommand(Difficulty diff);
}
