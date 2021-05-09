package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequirementsTest {

    @Test
    void shouldReturnCorrectAmountOfRequirementsAndLevelFailure() {
        var result = new Requirements("123456");
        assertEquals(1, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.FAILURE, result.getRequirementLevel());
    }

    @Test
    void shouldReturnCorrectAmountOfRequirements2AndLevelExceptional() {
        var result = new Requirements("asdfhjkiK4123*@^DFDS");
        assertEquals(5, result.getCount());
        assertEquals(10, result.getBonus());
        assertEquals(RequirementLevel.EXCEPTIONAL, result.getRequirementLevel());
    }
    @Test
    void shouldReturnCorrectAmountOfRequirements3AndLevelSufficient() {
        var result = new Requirements("asdfhjkiK2");
        assertEquals(4, result.getCount());
        assertEquals(8, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
    }
}