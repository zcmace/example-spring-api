package com.prophet.prophetapi.util;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestComponentTest {

    @Test
    public void testPlasmaMultiplication() {
        float chips = 150f;
        float multi = 2500000f;

        float balancedNumber = (chips / 2) + (multi / 2);
        chips = balancedNumber;
        multi = balancedNumber;
        assertEquals(chips, multi);
        
    }

}
