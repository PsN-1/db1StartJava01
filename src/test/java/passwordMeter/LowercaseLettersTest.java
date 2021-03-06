package passwordMeter;

import org.junit.jupiter.api.Test;
import passwordMeter.Additions.LowercaseLetters;
import passwordMeter.Enums.RequirementLevel;

import static org.junit.jupiter.api.Assertions.*;

class LowercaseLettersTest {
    @Test
    void shouldReturnZeroValuesWhenTestedWithEmptyPassword() {
        var result = new LowercaseLetters("");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.FAILURE, result.getRequirementLevel());
    }
    @Test
    void shouldReturnExpectedValuesWithPasswordWithLowerCaseLettersRequirementExceptional() {
        var result = new LowercaseLetters("12asDF");
        assertEquals(2, result.getCount());
        assertEquals(8, result.getBonus());
        assertEquals(RequirementLevel.EXCEPTIONAL, result.getRequirementLevel());
    }

    @Test
    void shouldReturnExpectedValuesWithPasswordWithLowerCaseLettersRequirementSufficient() {
        var result = new LowercaseLetters("12aSTG");
        assertEquals(1, result.getCount());
        assertEquals(10, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
    }
}