package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordMeterV3Test {

    @Test

    void shouldReturnZeroValuesWhenTestedWithEmptyPassword() {
        var result = new NumberOfCharacters("");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.FAILURE, result.getRequirementLevel());
        assertEquals(OperationType.ADDITTIONS, result.getOperationType());
    }

    @Test
    void shouldReturnExpectedValuesWithPasswordWithCharacters() {
        var result = new NumberOfCharacters("123456");
        assertEquals(6, result.getCount());
        assertEquals(24, result.getBonus());
        assertEquals(RequirementLevel.FAILURE, result.getRequirementLevel());
        assertEquals(OperationType.ADDITTIONS, result.getOperationType());
    }

    @Test
    void shouldReturnExpectedValuesAndRequirementsWithPasswordWithCharacters() {
        var result = new NumberOfCharacters("12345678");
        assertEquals(8, result.getCount());
        assertEquals(32, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
        assertEquals(OperationType.ADDITTIONS, result.getOperationType());
    }

}
