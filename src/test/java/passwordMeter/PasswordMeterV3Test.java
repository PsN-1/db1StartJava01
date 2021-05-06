package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordMeterV3Test {

    @Test
    void main() {
        var expectedCount = 8;
        var expectedBonus = 32;
        var expectedLevel = "sufficient";

        var meter = new NumberOfCharacters();
        var password = "12345678";
//        System.out.println(meter2.calculateCount());
        assertEquals(expectedCount, meter.calculateCount(password));
        assertEquals(expectedBonus, meter.calculateBonus(password));
        assertEquals(expectedLevel, meter.calculateRequirementsLevel(password));
    }
}
