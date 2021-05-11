package passwordMeter;

import org.junit.jupiter.api.Test;
import passwordMeter.Deductions.SequentialNumbers;
import passwordMeter.Enums.RequirementLevel;

import static org.junit.jupiter.api.Assertions.*;

class SequentialNumbersTest {

    @Test
    void shouldReturnZeroNumbersOnlyWithRequirementSufficient() {
        var result = new SequentialNumbers("sdfghjkibcdK");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
    }

    @Test
    void shouldReturnDeductionSequentialNumbersWithRequirementWarning() {
        var result = new SequentialNumbers("6612345456");
        assertEquals(4, result.getCount());
        assertEquals(12, result.getBonus());
        assertEquals(RequirementLevel.WARNING, result.getRequirementLevel());
    }
}