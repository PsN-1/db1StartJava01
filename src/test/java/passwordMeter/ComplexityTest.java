package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexityTest {

    @Test
    void shouldReturnVeryWeakWithZeroInput() {
        var result = new Complexity(0);
        var expected = "Very Weak";
        assertEquals(expected, result.calculatePasswordComplexity());
    }
    @Test
    void shouldReturnVeryWeak() {
        var result = new Complexity(14);
        var expected = "Very Weak";
        assertEquals(expected, result.calculatePasswordComplexity());
    }
    @Test
    void shouldReturnWeak() {
        var result = new Complexity(32);
        var expected = "Weak";
        assertEquals(expected, result.calculatePasswordComplexity());
    }
    @Test
    void shouldReturnGood() {
        var result = new Complexity(57);
        var expected = "Good";
        assertEquals(expected, result.calculatePasswordComplexity());
    }
    @Test
    void shouldReturnStrong() {
        var result = new Complexity(71);
        var expected = "Strong";
        assertEquals(expected, result.calculatePasswordComplexity());
    }
    @Test
    void shouldReturnVeryStrong() {
        var result = new Complexity(80);
        var expected = "Very Strong";
        assertEquals(expected, result.calculatePasswordComplexity());
    }
}
