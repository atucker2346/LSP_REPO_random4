package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for member customers: 10% discount (pay 90% of base price).
 *
 * @author Anthony Tucker
 */
public class MemberDiscountStrategy implements DiscountStrategy {

    private static final double MEMBER_MULTIPLIER = 0.90;

    /**
     * Applies a 10% discount to the base price.
     *
     * @param price the pre-discount purchase amount
     * @return {@code price * 0.90}
     */
    @Override
    public double calculateFinalPrice(double price) {
        return price * MEMBER_MULTIPLIER;
    }
}
