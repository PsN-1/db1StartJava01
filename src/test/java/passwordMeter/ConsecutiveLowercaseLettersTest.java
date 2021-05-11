package passwordMeter;

import org.junit.jupiter.api.Test;
import passwordMeter.Deductions.ConsecutiveLowercaseLetters;
import passwordMeter.Enums.RequirementLevel;

import static org.junit.jupiter.api.Assertions.*;

class ConsecutiveLowercaseLettersTest {
    @Test
    void shouldReturnZeroWithRequirementSufficient(){
        var result = new ConsecutiveLowercaseLetters("");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
    }

    @Test
    void shouldReturnDeductionExpectedConsecutiveUpperCaseCharacterWithRequirementWarning() {
        var result = new ConsecutiveLowercaseLetters("asdfhjkiK4123*@^DFDS");
        assertEquals(7, result.getCount());
        assertEquals(14, result.getBonus());
        assertEquals(RequirementLevel.WARNING, result.getRequirementLevel());
    }

}