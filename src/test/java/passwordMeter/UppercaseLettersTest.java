package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UppercaseLettersTest {

    @Test
    void shouldReturnZeroValuesWhenTestedWithEmptyPassword() {
        var result = new UppercaseLetters("");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.FAILURE, result.getRequirementLevel());
        assertEquals(OperationType.ADDITTIONS, result.getOperationType());
    }
    @Test
    void shouldReturnExpectedValuesWithPasswordWithUpperCaseLettersRequirementExceptional() {
        var result = new UppercaseLetters("12asDF");
        assertEquals(2, result.getCount());
        assertEquals(8, result.getBonus());
        assertEquals(RequirementLevel.EXCEPTIONAL, result.getRequirementLevel());
        assertEquals(OperationType.ADDITTIONS, result.getOperationType());
    }

    @Test
    void shouldReturnExpectedValuesWithPasswordWithUpperCaseLettersRequirementSufficient() {
        var result = new UppercaseLetters("12aSdf");
        assertEquals(1, result.getCount());
        assertEquals(10, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
        assertEquals(OperationType.ADDITTIONS, result.getOperationType());
    }
}