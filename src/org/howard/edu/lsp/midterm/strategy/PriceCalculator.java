package org.howard.edu.lsp.midterm.strategy;

/**
 * Context for the Strategy pattern: delegates final price calculation to a
 * {@link DiscountStrategy} supplied at construction time.
 *
 * @author Anthony Tucker
 */
public class PriceCalculator {

    private final DiscountStrategy discountStrategy;

    /**
     * Creates a calculator that uses the given discount strategy.
     *
     * @param discountStrategy the strategy that encodes customer-specific pricing; must not be null
     */
    public PriceCalculator(DiscountStrategy discountStrategy) {
        if (discountStrategy == null) {
            throw new IllegalArgumentException("discountStrategy must not be null");
        }
        this.discountStrategy = discountStrategy;
    }

    /**
     * Calculates the final price for a purchase using the configured strategy.
     *
     * @param price the pre-discount purchase amount
     * @return the final price after applying the strategy
     */
    public double calculatePrice(double price) {
        return discountStrategy.calculateFinalPrice(price);
    }
}
