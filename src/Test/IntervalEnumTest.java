package Test;

import Model.enums.Interval;

public class IntervalEnumTest {
    public static void main(String args[]) {

        System.out.println("Checking if isEqualTo() works: " + checkAllEquivalent());

        Interval[] interval = Interval.values();
        for (Interval i : interval) {
            System.out.print(i.name() + " ");
        }

        System.out.println("\n");

        for (Interval i : interval) {
            try {
                System.out.println("Interval " + i.name() + " has " + Interval.getNumSemitones(i) + " semitones in it");
            } catch (Exception e) {
                System.out.println("Interval " + i.name() + " caused an error");
            }  
        }
        
        boolean responseEqualTest = Interval.isEquivalentResponse("d2 A1 A4 A9 P5", "P1 m2 d5 m10 d6");
        System.out.println("Response Equal Test: " + responseEqualTest);
        
    } 

    public static boolean checkAllEquivalent() {
       return Interval.P1.isEqualTo(Interval.d2) && Interval.d2.isEqualTo(Interval.P1) &&
            Interval.m2.isEqualTo(Interval.A1) && Interval.A1.isEqualTo(Interval.m2) &&
            Interval.M2.isEqualTo(Interval.d3) && Interval.d3.isEqualTo(Interval.M2) &&
            Interval.P4.isEqualTo(Interval.A3) && Interval.A3.isEqualTo(Interval.P4) &&
            Interval.d5.isEqualTo(Interval.A4) && Interval.A4.isEqualTo(Interval.d5) &&
            Interval.P5.isEqualTo(Interval.d6) && Interval.d6.isEqualTo(Interval.P5) &&
            Interval.m7.isEqualTo(Interval.A6) && Interval.A6.isEqualTo(Interval.m7) &&
            Interval.M7.isEqualTo(Interval.d8) && Interval.d8.isEqualTo(Interval.M7) &&
            Interval.P8.isEqualTo(Interval.A7) && Interval.A7.isEqualTo(Interval.P8) &&
            Interval.m10.isEqualTo(Interval.A9) && Interval.A9.isEqualTo(Interval.m10) &&
            Interval.P11.isEqualTo(Interval.A10) && Interval.A10.isEqualTo(Interval.P11) &&
            Interval.d12.isEqualTo(Interval.A11) && Interval.A11.isEqualTo(Interval.d12) &&
            Interval.P12.isEqualTo(Interval.d13) && Interval.d13.isEqualTo(Interval.P12) &&
            Interval.m13.isEqualTo(Interval.A12) && Interval.A12.isEqualTo(Interval.m13) &&
            Interval.P15.isEqualTo(Interval.A14) && Interval.A14.isEqualTo(Interval.P15);
    }

}
