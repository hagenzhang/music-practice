package Display.PracticeProgramDisplays;

import javax.swing.JFrame;

public abstract class AbstractPracticeProgramDisplay implements PracticeProgramDisplay {
    
    protected JFrame frame;

    public AbstractPracticeProgramDisplay(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void printMessage(String msg) {
        System.out.println(msg);
    }

}
