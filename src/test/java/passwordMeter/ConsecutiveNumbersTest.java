package passwordMeter;

import org.junit.jupiter.api.Test;
import passwordMeter.Deductions.ConsecutiveNumbers;
import passwordMeter.Enums.RequirementLevel;

import static org.junit.jupiter.api.Assertions.*;

class ConsecutiveNumbersTest {

    @Test
    void shouldReturnZeroWithRequirementSufficient(){
        var result = new ConsecutiveNumbers("");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
    }

    @Test
    void shouldReturnDeductionExpectedConsecutiveNumberWithRequirementWarning() {
        var result = new ConsecutiveNumbers("asdfhjkiK4123*@^DFDS");
        assertEquals(3, result.getCount());
        assertEquals(6, result.getBonus());
        assertEquals(RequirementLevel.WARNING, result.getRequirementLevel());
    }
}