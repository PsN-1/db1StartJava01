package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {
    @Test
    void shouldReturnZeroValuesWhenTestedWithEmptyPassword() {
        var result = new Numbers("");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.FAILURE, result.getRequirementLevel());
        assertEquals(OperationType.ADDITIONS, result.getOperationType());
    }

    @Test
    void shouldReturnExpectedValuesWithPasswordWithNumbersRequirementExceptional() {
        var result = new Numbers("123asDF");
        assertEquals(3, result.getCount());
        assertEquals(12, result.getBonus());
        assertEquals(RequirementLevel.EXCEPTIONAL, result.getRequirementLevel());
        assertEquals(OperationType.ADDITIONS, result.getOperationType());
    }

    @Test
    void shouldReturnExpectedValuesWithPasswordWithNumbersRequirementSufficient() {
        var result = new Numbers("1aSdf");
        assertEquals(1, result.getCount());
        assertEquals(4, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
        assertEquals(OperationType.ADDITIONS, result.getOperationType());
    }
}