package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    void shouldReturnZeroValuesWhenTestedWithEmptyPassword() {
        var result = new Score("");
        assertEquals(0, result.calculateScore());
    }

    @Test
    void shouldReturnZeroValueToTestUnder0Score() {
        var result = new Score("1111111");
        assertEquals(0, result.calculateScore());
    }


    @Test
    void shouldReturnExpectedScoreWithSequenceOfSymbols() {
        var result = new Score("ssshdj@#$ksabcl");
        assertEquals(63, result.calculateScore());
    }

    @Test
    void shouldReturnExpectedScoreLowerUpperAndNumbers() {
        var result = new Score("asdfhjkiK41");
        assertEquals(72, result.calculateScore());
    }

    @Test
    void shouldReturnExpectedScoreLowerUpperSymbolAndNumbers() {
        var result = new Score("asdfhjkiK41@");
        assertEquals(90, result.calculateScore());
    }

}