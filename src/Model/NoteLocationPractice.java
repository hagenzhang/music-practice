package Model;

import Model.enums.Difficulty;

/**
 * This Class represents the Note Location Practice Program. 
 * 
 * In this program, the user will have to find a certain note on the fretboard in a variety of ways, depending on the 
 * user specified difficulty. Each of the excercises within a difficulty setting will also have a set chance of appearing.
 * 
 * Easy Difficulty:
 * - 1 note is chosen to be played on all 6 strings. The odds for the note to be played from the 0th to 11th frets are 60%, and the odds for
 *   the 12th to 23rd fret will be 40%
 * 
 * Medium Difficulty:
 * - An Easy task will be chosen 20% of the time (with the original weights applied)
 * - 2 notes are chosen. The first note should be played going down the strings, and the second note should be played going up the strings.
 *   The odds for playing those notes in the 0th to 11th frets will be 50%, and the odds for the 12th to 23rd fret will be 30%
 * 
 * Hard Difficulty:
 * - An Easy task will be chosen 10% of the time (with the original weights applied)
 * - A Medium task will be chosen 30% of the time (with the original weights applied)
 * - 6 notes will be chosen (1 for each string). Play on the 0th to 11th frets 40% of the time, and 12th to 23rd fret 20% of the time.
 * 
 * Enharmonic equivalences can sometimes come up, and that's okay (for example, Bb and A# can appear together in the same excercise).
 */
public class NoteLocationPractice extends AbstractPracticeProgram {

    /**
     * Default contructor for a Note Location Practice program. Difficulty is set to null, and must be manually set later.
     */
    public NoteLocationPractice() {
        super();
    }

    /**
     * Contructor for a Note Location Practice Program that specifies difficulty.
     * 
     * @param diff Difficulty Level for the user.
     */
    public NoteLocationPractice(Difficulty diff) {
        super(diff);
    }

    @Override
    public String getPracticeCommand() {
        String message = "";

        // Start by splitting this operation by difficulty
        if (super.getDifficulty().equals(Difficulty.EASY)) {
            message = generateEasyMode();
        } else if (super.getDifficulty().equals(Difficulty.MEDIUM)) {
            message = generateMediumMode();
        } else if (super.getDifficulty().equals(Difficulty.HARD)) {
            message = generateHardMode();
        } else if (super.getDifficulty().equals(Difficulty.RAPID)) {
            message = generateRapidMode();
        } else {
            throw new IllegalArgumentException("Invalid Difficulty Value Provided: " + super.getDifficulty());
        }

        return message;
    }

    // Generates the user a challege in Easy Mode.
    private String generateEasyMode() {
        String note = generateNote();
        String fretMessage = "";
        
        int probability = AbstractPracticeProgram.RANDOM.nextInt(10);

        if (probability > 3) {
            fretMessage = "0 to 11";
        } else {
            fretMessage = "12 to 23";
        }

        return "Play the note " + note + " on all 6 strings, between frets " + fretMessage;
    }

    // Generates the user a challenge in Medium Mode.
    private String generateMediumMode() {
        int probability = AbstractPracticeProgram.RANDOM.nextInt(10);
        String fretMessage = "";

        if (probability < 2) {
            return generateEasyMode();
        } else if (probability > 4){
            fretMessage = "0 to 11";
        } else {
            fretMessage = "12 to 23";
        }
        
        String note1 = generateNote();
        String note2 = generateNote();

        return "Play the note " + note1 + " on all 6 strings going down, " + " and play the note " + note2 + " on all 6 strings going up, between frets " + fretMessage;
    }

    // Generates the user a challenge in Hard Mode.
    private String generateHardMode() {
        int probability = AbstractPracticeProgram.RANDOM.nextInt(10);
        String fretMessage = "";

        if (probability < 1) {
            return generateEasyMode();
        } else if (probability > 0 && probability < 4){
            return generateMediumMode();
        } else if (probability > 5){
            fretMessage = "0 to 11";
        } else {
            fretMessage = "12 to 23";
        }
        
        String[] noteArray = new String[6];
        for (int i = 0; i < 6; i++) {
            noteArray[i] = generateNote();
        }
        
        return "From frets " + fretMessage + ":\n" +
            "Play " + noteArray[0] + " on the low E string\n" + 
            "Play " + noteArray[1] + " on the A string\n" + 
            "Play " + noteArray[2] + " on the D string,\n" + 
            "Play " + noteArray[3] + " on the G string,\n" + 
            "Play " + noteArray[4] + " on the B string,\n" + 
            "Play " + noteArray[5] + " on the E string";
    }
    
    // Generates the user a rapid fire style challenge.
    private String generateRapidMode() {
        String note = generateNote();
        int stringNum = AbstractPracticeProgram.RANDOM.nextInt(6) + 1;
        String stringType = "";

        switch (stringNum) {
            case 1: stringType = "Low E";
                    break;
            case 2: stringType = "A";
                    break;
            case 3: stringType = "D";
                    break;
            case 4: stringType = "G";
                    break;
            case 5: stringType = "B";
                    break;
            case 6: stringType = "High E";
                    break;
            default: stringType = "Invalid String Number!";
                    break;
        }
        
        String fretLocation = AbstractPracticeProgram.RANDOM.nextInt(2) == 0 ? "0 - 11" : "12 - 23";

        return "From frets " + fretLocation + ", play " + note + " on the " + stringType + " string.";
    }

    // Generates a random note.q
    private String generateNote() {
        String[] notes = {"A", "B", "C", "D", "E", "F", "G",
                        "A#", "B#", "C#", "D#", "E#", "F#", "G#",
                        "Ab", "Bb", "Cb", "Db", "Eb", "Fb", "Gb"};

        int select = AbstractPracticeProgram.RANDOM.nextInt(notes.length - 1);
        return notes[select];
    }
}
