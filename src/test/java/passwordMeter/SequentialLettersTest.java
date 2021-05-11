package passwordMeter;

import org.junit.jupiter.api.Test;
import passwordMeter.Deductions.SequentialLetters;
import passwordMeter.Enums.RequirementLevel;

import static org.junit.jupiter.api.Assertions.*;

class SequentialLettersTest {
    @Test
    void shouldReturnZeroNumbersOnlyWithRequirementSufficient() {
        var result = new SequentialLetters("asdasS");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
    }
    @Test
    void shouldReturnDeductionSequentialLettersWithRequirementWarning() {
        var result = new SequentialLetters("sdfghjkibcdK");
        assertEquals(2, result.getCount());
        assertEquals(6, result.getBonus());
        assertEquals(RequirementLevel.WARNING, result.getRequirementLevel());
    }
    @Test
    void shouldReturnDeductionSequentialLettersWithRequirementWarning2() {
        var result = new SequentialLetters("ABCshdjksal");
        assertEquals(1, result.getCount());
        assertEquals(3, result.getBonus());
        assertEquals(RequirementLevel.WARNING, result.getRequirementLevel());
    }
}