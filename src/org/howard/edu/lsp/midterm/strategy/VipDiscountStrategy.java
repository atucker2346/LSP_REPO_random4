package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for VIP customers: 20% discount (pay 80% of base price).
 *
 * @author Anthony Tucker
 */
public class VipDiscountStrategy implements DiscountStrategy {

    private static final double VIP_MULTIPLIER = 0.80;

    /**
     * Applies a 20% discount to the base price.
     *
     * @param price the pre-discount purchase amount
     * @return {@code price * 0.80}
     */
    @Override
    public double calculateFinalPrice(double price) {
        return price * VIP_MULTIPLIER;
    }
}
