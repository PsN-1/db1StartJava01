package passwordMeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordMeterV3Test {

    @Test
    void main() {
        var expectedCount = 8;
        var expectedBonus = 32;
        var expectedLevel = "sufficient";

        var password = "12345678";
        var meter = new NumberOfCharacters();
//        System.out.println(meter2.calculateCount());
        assertEquals(expectedCount, meter.calculateCount(password));
        assertEquals(expectedBonus, meter.calculateBonus(password));
        assertEquals(expectedLevel, meter.calculateRequirementLevel(password));

        password = "1234567";
        expectedLevel = "failure";
        assertEquals(expectedLevel, meter.calculateRequirementLevel(password));

        password = "123456789";
        expectedLevel = "exceptional";
        assertEquals(expectedLevel, meter.calculateRequirementLevel(password));
    }
}
