package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiddleNumbersOrSymbolsTest {
    @Test
    void shouldReturnZeroValuesWhenTestedWithEmptyPassword() {
        var result = new MiddleNumbersOrSymbols("");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.FAILURE, result.getRequirementLevel());
        assertEquals(OperationType.ADDITTIONS, result.getOperationType());
    }

    @Test
    void shouldReturnExpectedValuesWithPasswordWithUpperCaseLettersRequirementExceptional() {
        var result = new MiddleNumbersOrSymbols("12@asDF!");
        assertEquals(2, result.getCount());
        assertEquals(4, result.getBonus());
        assertEquals(RequirementLevel.EXCEPTIONAL, result.getRequirementLevel());
        assertEquals(OperationType.ADDITTIONS, result.getOperationType());
    }

    @Test
    void shouldReturnExpectedValuesWithPasswordWithUpperCaseLettersRequirementSufficient() {
        var result = new MiddleNumbersOrSymbols("12asDF!");
        assertEquals(1, result.getCount());
        assertEquals(2, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
        assertEquals(OperationType.ADDITTIONS, result.getOperationType());
    }

}