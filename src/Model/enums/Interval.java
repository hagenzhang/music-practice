package Model.enums;


/**
 * This enum represents all the basic minor, major, and perfect intervals in Western Music Theory. Augmented and diminished enharmonic 
 * equivalences are included and can be checked for (equality is enforced using the isEqualTo function).
 * 
 * Compound intervals are also included, spanning a total of 2 octaves.
 * 
 * Double augmented and doube diminished intervals are not supported.
 */
public enum Interval {
    P1, m2, M2, m3, M3, P4, P5, m6, M6, m7, M7, P8,
    d2, A1, d3, A2, d4, A3, d5, A4, d6, A5, d7, A6, d8, A7,
    m9, M9, m10, M10, P11, P12, m13, M13, m14, M14, P15,
    d9, A8, d10, A9, d11, A10, d12, A11, d13, A12, d14, A13, d15, A14;

    /**
     * This function checks if 2 Intervals are enharmonically equivalent to each other. 
     * 
     * @param other interval to be checked against.
     * @return true if the intervals are enharmonic equivalences, else false.
     */
    public boolean isEqualTo(Interval other) {
        // initial condition checking for common cases
        if (this == other) return true;

        char otherIntervalName = other.name().charAt(0);
        char thisIntervalName = this.name().charAt(0);
        int thisIntervalValue = Integer.parseInt(this.name().substring(1));
        int otherIntervalValue = Integer.parseInt(other.name().substring(1));

        // don't recursively call this, for some reason it will cause a stack overflow error
        switch (thisIntervalName) {
            case 'P': 
                if (thisIntervalValue == 1) return other == d2;
                else if (thisIntervalValue == 4) return other == A3;
                else if (thisIntervalValue == 5) return other == d6;
                else if (thisIntervalValue == 8) return other == A7 || other == d9;
                else if (thisIntervalValue == 11) return other == A10;
                else if (thisIntervalValue == 12) return other == d13;
                else if (thisIntervalValue == 15) return other == A14;
                else return false;
            case 'm':
                return otherIntervalName == 'A' && (otherIntervalValue + 1 == thisIntervalValue);
            case 'M':
                return otherIntervalName == 'd' && (otherIntervalValue - 1 == thisIntervalValue);
            case 'd':
                if (otherIntervalName == 'A') {
                    return (thisIntervalValue == 5 && otherIntervalValue == 4) || 
                    (thisIntervalValue == 12 && otherIntervalValue == 11);
                } else if (otherIntervalName == 'M') {
                    return otherIntervalValue + 1 == thisIntervalValue;
                } else if (otherIntervalName == 'P') {
                    if (thisIntervalValue == 2) return other == P1;
                    else if (thisIntervalValue == 6) return other == P5;
                    else if (thisIntervalValue == 9) return other == P8;
                    else if (thisIntervalValue == 13) return other == P12;
                } else {
                    return false;
                }
            case 'A':
                if (otherIntervalName == 'd') {
                    return (thisIntervalValue == 4 && otherIntervalValue == 5) || 
                    (thisIntervalValue == 11 && otherIntervalValue == 12);
                } else if (otherIntervalName == 'm') {
                    return otherIntervalValue - 1 == thisIntervalValue;
                } else if (otherIntervalName == 'P') {
                    if (thisIntervalValue == 3) return other == P4;
                    else if (thisIntervalValue == 7) return other == P8;
                    else if (thisIntervalValue == 10) return other == P11;
                    else if (thisIntervalValue == 14) return other == P15;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    /**
     * Returns the number of semitones from the root note that this interval represents.
     * 
     * @throws IllegalArgumentException invalid Interval enum is passed in.
     * @param interval the interval to convert.
     * @return the number of semitones that the interval represents.
     */
    public static int getNumSemitones(Interval interval) {
        if (interval.isEqualTo(P1)) return 0;
        else if (interval.isEqualTo(m2)) return 1;
        else if (interval.isEqualTo(M2)) return 2;
        else if (interval.isEqualTo(m3)) return 3;
        else if (interval.isEqualTo(M3)) return 4;
        else if (interval.isEqualTo(P4)) return 5;
        else if (interval.isEqualTo(d5)) return 6;
        else if (interval.isEqualTo(A4)) return 6;
        else if (interval.isEqualTo(P5)) return 7;
        else if (interval.isEqualTo(m6)) return 8;
        else if (interval.isEqualTo(M6)) return 9;
        else if (interval.isEqualTo(m7)) return 10;
        else if (interval.isEqualTo(M7)) return 11;
        else if (interval.isEqualTo(P8)) return 12;
        else if (interval.isEqualTo(m9)) return 13;
        else if (interval.isEqualTo(M9)) return 14;
        else if (interval.isEqualTo(m10)) return 15;
        else if (interval.isEqualTo(M10)) return 16;
        else if (interval.isEqualTo(P11)) return 17;
        else if (interval.isEqualTo(d12)) return 18;
        else if (interval.isEqualTo(P12)) return 19;
        else if (interval.isEqualTo(m13)) return 20;
        else if (interval.isEqualTo(M13)) return 21;
        else if (interval.isEqualTo(m14)) return 22;
        else if (interval.isEqualTo(M14)) return 23;
        else if (interval.isEqualTo(P15)) return 24;
        else throw new IllegalArgumentException("Invalid Interval");
    }

    /**
     * Function that converts a number of semitones to a corresponding Interval enum. 
     * Negative values and steps over 24 aren't accepted.
     * 
     * @param steps number of half steps to convert.
     * @return the corresponding interval enum.
     * @throws IllegalArgumentException when an invalid number of half steps is provided.
     */
    public static Interval semitonesToInterval(int steps) {
        for (Interval i : Interval.values()) {
            if (Interval.getNumSemitones(i) == steps) {
                return i;
            }
        }
        throw new IllegalArgumentException("Invalid number of half steps");
    }

    /**
     * A function to check whether or not two response Strings are equivalent to each other. Response strings
     * are a String that lists off intervals, each seperated by a space. Example for a major chord: M3 P5.
     * 
     * @param userResponse the response string from the user.
     * @param problemSolution the correct response string given by the PracticeProgram function getSolution.
     * @return true if both responses are equivalent, else false.
     */
    public static boolean isEquivalentResponse(String userResponse, String problemSolution) {
        String[] responseIntervalList = userResponse.split(" ");  // Split the string based on space delimiter
        String[] solutionIntervalList = problemSolution.split(" ");

        boolean isEquivalent = true;
        if (responseIntervalList.length != solutionIntervalList.length) {
            return false;
        } else {
            for (int i = 0; i < responseIntervalList.length; i++) {
                Interval intervalR = Interval.valueOf(responseIntervalList[i]);
                Interval intervalS = Interval.valueOf(solutionIntervalList[i]);

                isEquivalent = isEquivalent && intervalR.isEqualTo(intervalS);
            }
        }
        return isEquivalent;
    }

}