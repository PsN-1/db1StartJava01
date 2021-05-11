package passwordMeter;

import org.junit.jupiter.api.Test;
import passwordMeter.Deductions.LettersOnly;
import passwordMeter.Enums.RequirementLevel;

import static org.junit.jupiter.api.Assertions.*;

class LettersOnlyTest {

    @Test
    void shouldReturnZeroLettersOnlyWithRequirementSufficient() {
        var result = new LettersOnly("123456");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
    }
    @Test
    void shouldReturnDeductionLettersOnlyWithRequirementWarning() {
        var result = new LettersOnly("asdasS");
        assertEquals(6, result.getCount());
        assertEquals(6, result.getBonus());
        assertEquals(RequirementLevel.WARNING, result.getRequirementLevel());
    }

}