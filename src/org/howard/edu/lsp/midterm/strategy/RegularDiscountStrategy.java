package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for regular customers: no discount from the base price.
 *
 * @author Anthony Tucker
 */
public class RegularDiscountStrategy implements DiscountStrategy {

    /**
     * Returns the base price unchanged.
     *
     * @param price the pre-discount purchase amount
     * @return the same value as {@code price}
     */
    @Override
    public double calculateFinalPrice(double price) {
        return price;
    }
}
