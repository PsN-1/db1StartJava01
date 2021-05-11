package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordComplexityTest {

    @Test
    void shouldReturnVeryWeakWithZeroInput() {
        var result = new PasswordComplexity(0);
        var expected = "Very Weak";
        assertEquals(expected, result.calculatePasswordComplexity());
    }
    @Test
    void shouldReturnVeryWeak() {
        var result = new PasswordComplexity(14);
        var expected = "Very Weak";
        assertEquals(expected, result.calculatePasswordComplexity());
    }
    @Test
    void shouldReturnWeak() {
        var result = new PasswordComplexity(32);
        var expected = "Weak";
        assertEquals(expected, result.calculatePasswordComplexity());
    }
    @Test
    void shouldReturnGood() {
        var result = new PasswordComplexity(57);
        var expected = "Good";
        assertEquals(expected, result.calculatePasswordComplexity());
    }
    @Test
    void shouldReturnStrong() {
        var result = new PasswordComplexity(71);
        var expected = "Strong";
        assertEquals(expected, result.calculatePasswordComplexity());
    }
    @Test
    void shouldReturnVeryStrong() {
        var result = new PasswordComplexity(80);
        var expected = "Very Strong";
        assertEquals(expected, result.calculatePasswordComplexity());
    }
}
