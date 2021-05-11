package passwordMeter;

import org.junit.jupiter.api.Test;
import passwordMeter.Deductions.SequentialSymbols;
import passwordMeter.Enums.RequirementLevel;

import static org.junit.jupiter.api.Assertions.*;

class SequentialSymbolsTest {

    @Test
    void shouldReturnZeroNumbersOnlyWithRequirementSufficient() {
        var result = new SequentialSymbols("asdasS");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
    }

    @Test
    void shouldReturnDeductionSequentialSymbolsWithRequirementWarning() {
        var result = new SequentialSymbols("66!@#@$@#$12*&^56");
        assertEquals(3, result.getCount());
        assertEquals(9, result.getBonus());
        assertEquals(RequirementLevel.WARNING, result.getRequirementLevel());
    }
}