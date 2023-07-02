package Controller.PracticeControllers;

import Display.PracticeProgramDisplays.PracticeProgramDisplay;
import Model.ChordConstructionPractice;

public class ChordConstructionController implements PracticeController {

    private ChordConstructionPractice practice;
    private PracticeProgramDisplay display;

    public ChordConstructionController(PracticeProgramDisplay display) {
        this.display = display;
        this.practice = new ChordConstructionPractice();
    }


    @Override
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
        System.exit(0);
    }

    
}
