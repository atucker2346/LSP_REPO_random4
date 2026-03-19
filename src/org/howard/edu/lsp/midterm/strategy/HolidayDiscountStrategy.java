package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for holiday promotional pricing: 15% discount (pay 85% of base price).
 *
 * @author Anthony Tucker
 */
public class HolidayDiscountStrategy implements DiscountStrategy {

    private static final double HOLIDAY_MULTIPLIER = 0.85;

    /**
     * Applies a 15% discount to the base price.
     *
     * @param price the pre-discount purchase amount
     * @return {@code price * 0.85}
     */
    @Override
    public double calculateFinalPrice(double price) {
        return price * HOLIDAY_MULTIPLIER;
    }
}
