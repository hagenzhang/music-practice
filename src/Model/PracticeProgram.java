package Model;

import Model.enums.Difficulty;

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
    String getPracticeCommand();

    /**
     * Sets the difficulty of the practice program.
     * 
     * @param diff the difficulty to set the program to.
     */
    void setDifficulty(Difficulty diff);

    /**
     * Returns the difficulty of the practice program.
     * 
     * @return the difficulty level.
     */
    Difficulty getDifficulty();

    /**
     * Returns the solution to a practice command. If no solution exists, an empty string will be returned.
     * 
     * @param practiceCommand command to extract solution from
     * @return the practice command's solution
     */
    static String getSolution(String practiceCommand) {
        int markerIndex = practiceCommand.indexOf("##SOLUTION##");
        if (markerIndex != -1) { // a marker exists
            return practiceCommand.substring(markerIndex + 12);
        } else { // no marker exists, no solution exists
            return "";
        }
    }

    /**
     * Returns the problem of a practice command, with no solution attached.
     * 
     * @param practiceCommand command to extract problem from
     * @return the practice command's problem
     */
    static String getProblem(String practiceCommand) {
        int markerIndex = practiceCommand.indexOf("##SOLUTION##");
        if (markerIndex != -1) { // a marker exists
            return practiceCommand.substring(0, markerIndex);
        } else { // no marker exists, the entire msg is the problem string
            return practiceCommand;
        }
    }



}
