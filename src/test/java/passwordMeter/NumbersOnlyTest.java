package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersOnlyTest {

    @Test
    void shouldReturnZeroNumbersOnlyWithRequirementSufficient() {
        var result = new NumbersOnly("asdasS");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
    }
    @Test
    void shouldReturnDeductionNumberOnlyWithRequirementWarning() {
        var result = new NumbersOnly("123456");
        assertEquals(6, result.getCount());
        assertEquals(6, result.getBonus());
        assertEquals(RequirementLevel.WARNING, result.getRequirementLevel());
    }
}