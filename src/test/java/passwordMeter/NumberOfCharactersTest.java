package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfCharactersTest {

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
        var result = new NumberOfCharacters("1234567");
        assertEquals(7, result.getCount());
        assertEquals(28, result.getBonus());
        assertEquals(RequirementLevel.FAILURE, result.getRequirementLevel());
        assertEquals(OperationType.ADDITTIONS, result.getOperationType());
    }

    @Test
    void shouldReturnExpectedValuesWithPasswordWithCharactersAndRequirementSufficient() {
        var result = new NumberOfCharacters("12345678");
        assertEquals(8, result.getCount());
        assertEquals(32, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
        assertEquals(OperationType.ADDITTIONS, result.getOperationType());
    }
    @Test
    void shouldReturnExpectedValuesWithPasswordWithCharactersAndRequirementExceptional() {
        var result = new NumberOfCharacters("123456789");
        assertEquals(9, result.getCount());
        assertEquals(36, result.getBonus());
        assertEquals(RequirementLevel.EXCEPTIONAL, result.getRequirementLevel());
        assertEquals(OperationType.ADDITTIONS, result.getOperationType());
    }

}
