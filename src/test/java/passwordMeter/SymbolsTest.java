package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymbolsTest {
    @Test
    void shouldReturnZeroValuesWhenTestedWithEmptyPassword() {
        var result = new Symbols("");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.FAILURE, result.getRequirementLevel());
        assertEquals(OperationType.ADDITTIONS, result.getOperationType());
    }

    @Test
    void shouldReturnExpectedValuesWithPasswordWithUpperCaseLettersRequirementExceptional() {
        var result = new Symbols("1@2as$DF");
        assertEquals(2, result.getCount());
        assertEquals(12, result.getBonus());
        assertEquals(RequirementLevel.EXCEPTIONAL, result.getRequirementLevel());
        assertEquals(OperationType.ADDITTIONS, result.getOperationType());
    }

    @Test
    void shouldReturnExpectedValuesWithPasswordWithUpperCaseLettersRequirementSufficient() {
        var result = new Symbols("12aS@df");
        assertEquals(1, result.getCount());
        assertEquals(6, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
        assertEquals(OperationType.ADDITTIONS, result.getOperationType());
    }
}