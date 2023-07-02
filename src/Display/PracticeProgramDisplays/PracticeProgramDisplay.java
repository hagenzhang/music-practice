package Display.PracticeProgramDisplays;

import Controller.PracticeControllers.PracticeController;
import Model.PracticeProgram;

public interface PracticeProgramDisplay {

    /**
     * Prints a given message into the console.
     * 
     * @param msg the message to print.
     */
    void printMessage(String msg);


    /**
     * Returns a String telling the user how to play the game.
     * 
     * @return instruction String.
     */
    String getInstructionString();

    /**
     * 
     * 
     * @param practice
     * @param noteLocationController
     */
    void startSetupMenu(PracticeProgram practice, PracticeController controller);


    /**
     * 
     * 
     * @param practice
     * @param controller
     */
    void runExercises(PracticeProgram practice, PracticeController controller);


}
