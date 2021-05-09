package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepeatCharactersTest {

    @Test
    void shouldReturnZeroWithRequirementSufficient(){
        var result = new RepeatCharacters("");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
    }

    @Test
    void shouldReturnDeductionRepeatedCharacterWithRequirementWarning() {
        var result = new RepeatCharacters("asdasS");
        assertEquals(4, result.getCount());
        assertEquals(2, result.getBonus());
        assertEquals(RequirementLevel.WARNING, result.getRequirementLevel());
    }

    @Test
    void shouldReturnDeductionExpectedRepeatedCharacterWithRequirementWarning() {
        var result = new RepeatCharacters("asdfhjkiK4123*@^DFDS");
        assertEquals(2, result.getCount());
        assertEquals(1, result.getBonus());
        assertEquals(RequirementLevel.WARNING, result.getRequirementLevel());
    }
}