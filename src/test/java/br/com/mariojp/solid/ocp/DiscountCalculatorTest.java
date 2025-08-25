package br.com.mariojp.solid.ocp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DiscountCalculatorTest {
    private DiscountCalculator calculator;

    @BeforeEach
    void setUp() {
        Map<CustomerType, DiscountPolicy> policies = Map.of(
                CustomerType.REGULAR, new RegularPolicy(),
                CustomerType.PREMIUM, new PremiumPolicy(),
                CustomerType.PARTNER, new PartnerPolicy()
        );
        calculator = new DiscountCalculator(policies);
    }

    @Test
    void testRegular() {
        assertEquals(95.0, calculator.apply(100, CustomerType.REGULAR));
    }

    @Test
    void testPremium() {
        assertEquals(90.0, calculator.apply(100, CustomerType.PREMIUM));
    }

    @Test
    void testPartner() {
        assertEquals(88.0, calculator.apply(100, CustomerType.PARTNER));
    }

    @Test
    void testNoDiscount() {
        assertEquals(100.0, calculator.apply(100, CustomerType.UNKNOWN), 0.001);
    }
}
