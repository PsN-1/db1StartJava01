package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordMeterV2Test {

    @Test
    void passwordWithOnlyNumbers() {

        var expected = "Password: 123456\n" +
                "Score: 4\n" +
                "Complexity: Very Weak\n" +
                "Addictions\n" +
                "[C: 6 | B: 24] Number of Characters\n" +
                "[C: 0 | B: 0] Uppercase Letters\n" +
                "[C: 0 | B: 0] Lowercase Letters\n" +
                "[C: 6 | B: 0] Numbers\n" +
                "[C: 0 | B: 0] Symbols\n" +
                "[C: 4 | B: 8] Middle Numbers or Symbols\n" +
                "[C: 1 | B: 0] Requirements\n" +
                "Deductions\n" +
                "[C: 0 | B: 0] Letters Only\n" +
                "[C: 6 | B: 6] Numbers Only\n" +
                "[C: 0 | B: 0] Repeat Characters (Case Insensitive)\n" +
                "[C: 0 | B: 0] Consecutive Uppercase Letters\n" +
                "[C: 0 | B: 0] Consecutive Lowercase Letters\n" +
                "[C: 5 | B: 10] Consecutive Numbers\n" +
                "[C: 0 | B: 0] Sequential Letters\n" +
                "[C: 4 | B: 12] Sequential Numbers\n" +
                "[C: 0 | B: 0] Sequential Symbols";

        var meter = new PasswordMeterV2("123456");
//        System.out.println(meter);
        assertEquals(expected, meter.toString());
    }

    @Test
    void main() {
        var expected = "Password: asdfhjkiK4123*@^DFDS\n" +
                "Score: 100\n" +
                "Complexity: Very Strong\n" +
                "Addictions\n" +
                "[C: 20 | B: 80] Number of Characters\n" +
                "[C: 5 | B: 30] Uppercase Letters\n" +
                "[C: 8 | B: 24] Lowercase Letters\n" +
                "[C: 4 | B: 16] Numbers\n" +
                "[C: 3 | B: 18] Symbols\n" +
                "[C: 7 | B: 14] Middle Numbers or Symbols\n" +
                "[C: 5 | B: 10] Requirements\n" +
                "Deductions\n" +
                "[C: 0 | B: 0] Letters Only\n" +
                "[C: 0 | B: 0] Numbers Only\n" +
                "[C: 2 | B: 1] Repeat Characters (Case Insensitive)\n" +
                "[C: 3 | B: 6] Consecutive Uppercase Letters\n" +
                "[C: 7 | B: 14] Consecutive Lowercase Letters\n" +
                "[C: 3 | B: 6] Consecutive Numbers\n" +
                "[C: 0 | B: 0] Sequential Letters\n" +
                "[C: 1 | B: 3] Sequential Numbers\n" +
                "[C: 0 | B: 0] Sequential Symbols";


        var result = new PasswordMeterV2("asdfhjkiK4123*@^DFDS");
//        System.out.println(result);
        assertEquals(expected, result.toString());
    }

    @Test
    void main2() {
        var expected = "Password: asd123@EWQ\n" +
                "Score: 89\n" +
                "Complexity: Very Strong\n" +
                "Addictions\n" +
                "[C: 10 | B: 40] Number of Characters\n" +
                "[C: 3 | B: 14] Uppercase Letters\n" +
                "[C: 3 | B: 14] Lowercase Letters\n" +
                "[C: 3 | B: 12] Numbers\n" +
                "[C: 1 | B: 6] Symbols\n" +
                "[C: 4 | B: 8] Middle Numbers or Symbols\n" +
                "[C: 5 | B: 10] Requirements\n" +
                "Deductions\n" +
                "[C: 0 | B: 0] Letters Only\n" +
                "[C: 0 | B: 0] Numbers Only\n" +
                "[C: 0 | B: 0] Repeat Characters (Case Insensitive)\n" +
                "[C: 2 | B: 4] Consecutive Uppercase Letters\n" +
                "[C: 2 | B: 4] Consecutive Lowercase Letters\n" +
                "[C: 2 | B: 4] Consecutive Numbers\n" +
                "[C: 0 | B: 0] Sequential Letters\n" +
                "[C: 1 | B: 3] Sequential Numbers\n" +
                "[C: 0 | B: 0] Sequential Symbols";

        var result = new PasswordMeterV2("asd123@EWQ");
//        System.out.println(result);
        assertEquals(expected, result.toString());
    }

    @Test
    void main3() {
        var expected = "Password: ssshdjkssabcl\n" +
                "Score: 9\n" +
                "Complexity: Very Weak\n" +
                "Addictions\n" +
                "[C: 13 | B: 52] Number of Characters\n" +
                "[C: 0 | B: 0] Uppercase Letters\n" +
                "[C: 13 | B: 0] Lowercase Letters\n" +
                "[C: 0 | B: 0] Numbers\n" +
                "[C: 0 | B: 0] Symbols\n" +
                "[C: 0 | B: 0] Middle Numbers or Symbols\n" +
                "[C: 2 | B: 0] Requirements\n" +
                "Deductions\n" +
                "[C: 13 | B: 13] Letters Only\n" +
                "[C: 0 | B: 0] Numbers Only\n" +
                "[C: 5 | B: 3] Repeat Characters (Case Insensitive)\n" +
                "[C: 0 | B: 0] Consecutive Uppercase Letters\n" +
                "[C: 12 | B: 24] Consecutive Lowercase Letters\n" +
                "[C: 0 | B: 0] Consecutive Numbers\n" +
                "[C: 1 | B: 3] Sequential Letters\n" +
                "[C: 0 | B: 0] Sequential Numbers\n" +
                "[C: 0 | B: 0] Sequential Symbols";

        var result = new PasswordMeterV2("ssshdjkssabcl");
//        System.out.println(result);
        assertEquals(expected, result.toString());
    }
    @Test
    void main4() {
        var expected = "Password: ssshdj@#$ksabcl\n" +
                "Score: 63\n" +
                "Complexity: Strong\n" +
                "Addictions\n" +
                "[C: 15 | B: 60] Number of Characters\n" +
                "[C: 0 | B: 0] Uppercase Letters\n" +
                "[C: 12 | B: 6] Lowercase Letters\n" +
                "[C: 0 | B: 0] Numbers\n" +
                "[C: 3 | B: 18] Symbols\n" +
                "[C: 3 | B: 6] Middle Numbers or Symbols\n" +
                "[C: 3 | B: 0] Requirements\n" +
                "Deductions\n" +
                "[C: 0 | B: 0] Letters Only\n" +
                "[C: 0 | B: 0] Numbers Only\n" +
                "[C: 4 | B: 1] Repeat Characters (Case Insensitive)\n" +
                "[C: 0 | B: 0] Consecutive Uppercase Letters\n" +
                "[C: 10 | B: 20] Consecutive Lowercase Letters\n" +
                "[C: 0 | B: 0] Consecutive Numbers\n" +
                "[C: 1 | B: 3] Sequential Letters\n" +
                "[C: 0 | B: 0] Sequential Numbers\n" +
                "[C: 1 | B: 3] Sequential Symbols";

        var result = new PasswordMeterV2("ssshdj@#$ksabcl");
//        System.out.println(result);
        assertEquals(expected, result.toString());
    }

}

