package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsecutiveUppercaseLettersTest {
    @Test
    void shouldReturnZeroWithRequirementSufficient(){
        var result = new ConsecutiveUppercaseLetters("");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
    }

    @Test
    void shouldReturnDeductionExpectedConsecutiveUpperCaseCharacterWithRequirementWarning() {
        var result = new ConsecutiveUppercaseLetters("asdfhjkiK4123*@^DFDS");
        assertEquals(3, result.getCount());
        assertEquals(6, result.getBonus());
        assertEquals(RequirementLevel.WARNING, result.getRequirementLevel());
    }
}