package org.howard.edu.lsp.midterm.strategy;

/**
 * Demonstrates the Strategy-based {@link PriceCalculator} for each customer segment.
 *
 * @author Anthony Tucker
 */
public class Driver {

    private static final double PURCHASE_PRICE = 100.0;

    /**
     * Runs pricing examples for REGULAR, MEMBER, VIP, and HOLIDAY strategies.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        PriceCalculator regular = new PriceCalculator(new RegularDiscountStrategy());
        System.out.println("REGULAR: " + regular.calculatePrice(PURCHASE_PRICE));

        PriceCalculator member = new PriceCalculator(new MemberDiscountStrategy());
        System.out.println("MEMBER: " + member.calculatePrice(PURCHASE_PRICE));

        PriceCalculator vip = new PriceCalculator(new VipDiscountStrategy());
        System.out.println("VIP: " + vip.calculatePrice(PURCHASE_PRICE));

        PriceCalculator holiday = new PriceCalculator(new HolidayDiscountStrategy());
        System.out.println("HOLIDAY: " + holiday.calculatePrice(PURCHASE_PRICE));
    }
}
