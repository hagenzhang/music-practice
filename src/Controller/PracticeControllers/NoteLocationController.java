package Controller.PracticeControllers;


import Display.PracticeProgramDisplays.PracticeProgramDisplay;
import Model.NoteLocationPractice;

public class NoteLocationController implements PracticeController {

    private NoteLocationPractice practice;
    private PracticeProgramDisplay display;

    public NoteLocationController(PracticeProgramDisplay display) {
        this.display = display;
        this.practice = new NoteLocationPractice();
    }

    /**
     * Starts the Note Location Practice Program. Prompts user for difficulty, initializes the Practice Program object, and runs the "run" function.
     */
    public void start() {
        if (this.practice.getDifficulty() == null) {
            this.display.startSetupMenu(this.practice, this);
        } else {
            System.out.println("We have a difficulty set, we're ready to proceed!");
            run();
        }
    }

    @Override
    public void run() {
        display.runExercises(practice, this);
    }

    @Override
    public void end() {
        // Just kill the program.
        System.exit(0);
    }
    
}
