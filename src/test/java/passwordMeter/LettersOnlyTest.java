package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LettersOnlyTest {

    @Test
    void shouldReturnZeroLettersOnly() {
        var result = new LettersOnly("123456");
        assertEquals(0, result.getCount());
        assertEquals(0, result.getBonus());
    }
    @Test
    void shouldReturnDeductionLettersOnly() {
        var result = new LettersOnly("asdasS");
        assertEquals(6, result.getCount());
        assertEquals(6, result.getBonus());
    }

}