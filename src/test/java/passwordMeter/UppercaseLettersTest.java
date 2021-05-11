package passwordMeter;

import org.junit.jupiter.api.Test;
import passwordMeter.Additions.UppercaseLetters;
import passwordMeter.Enums.RequirementLevel;

import static org.junit.jupiter.api.Assertions.*;

class UppercaseLettersTest {

    @Test
    void shouldReturnZeroValuesWhenTestedWithEmptyPassword() {
        var result = new UppercaseLetters("");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.FAILURE, result.getRequirementLevel());
    }

    @Test
    void shouldReturnExpectedValuesWithPasswordWithUpperCaseLettersRequirementExceptional() {
        var result = new UppercaseLetters("12asDF");
        assertEquals(2, result.getCount());
        assertEquals(8, result.getBonus());
        assertEquals(RequirementLevel.EXCEPTIONAL, result.getRequirementLevel());
    }

    @Test
    void shouldReturnExpectedValuesWithPasswordWithUpperCaseLettersRequirementSufficient() {
        var result = new UppercaseLetters("12aSdf");
        assertEquals(1, result.getCount());
        assertEquals(10, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
    }
}