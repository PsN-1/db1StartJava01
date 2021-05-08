package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordMeterV3Test {

    @Test
    void main() {
        var expected = "Password: asdfhjkiK4123*@^DFDS\n" +
                "Score: 0\n" +
                "Complexity: null\n" +
                "Addictions\n" +
                "[C: 20 | B: 80] Number of Characters\n" +
                "[C: 5 | B: 30] Uppercase Letters\n" +
                "[C: 8 | B: 24] Lowercase Letters\n" +
                "[C: 4 | B: 16] Numbers\n" +
                "[C: 3 | B: 18] Symbols\n" +
                "[C: 7 | B: 14] Middle Numbers or Symbols\n" +
                "[C: 5 | B: 10] Requirements\n" +
                "Deductions\n" +
                "[C: 0 | B: 0] Letters Only";


        var result = new PasswordMeterV3("asdfhjkiK4123*@^DFDS");
        System.out.println(result);
//        assertEquals(expected, result.toString());
    }


}