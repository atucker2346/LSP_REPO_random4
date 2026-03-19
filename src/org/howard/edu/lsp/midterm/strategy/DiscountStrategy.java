package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy interface for computing a final purchase price from a base price.
 * Each concrete implementation encapsulates one customer-segment discount rule.
 *
 * @author Anthony Tucker
 */
public interface DiscountStrategy {

    /**
     * Computes the final price after applying this strategy's discount rules.
     *
     * @param price the pre-discount purchase amount
     * @return the final price to charge
     */
    double calculateFinalPrice(double price);
}
