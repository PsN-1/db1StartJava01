package passwordMeter;

import org.junit.jupiter.api.Test;
import passwordMeter.Additions.Symbols;
import passwordMeter.Enums.RequirementLevel;

import static org.junit.jupiter.api.Assertions.*;

class SymbolsTest {
    @Test
    void shouldReturnZeroValuesWhenTestedWithEmptyPassword() {
        var result = new Symbols("");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
        assertEquals(RequirementLevel.FAILURE, result.getRequirementLevel());
    }

    @Test
    void shouldReturnExpectedValuesWithPasswordWithSymbolsRequirementExceptional() {
        var result = new Symbols("1@2as$DF");
        assertEquals(2, result.getCount());
        assertEquals(12, result.getBonus());
        assertEquals(RequirementLevel.EXCEPTIONAL, result.getRequirementLevel());
    }

    @Test
    void shouldReturnExpectedValuesWithPasswordWithSymbolsRequirementSufficient() {
        var result = new Symbols("12aS@df");
        assertEquals(1, result.getCount());
        assertEquals(6, result.getBonus());
        assertEquals(RequirementLevel.SUFFICIENT, result.getRequirementLevel());
    }
}