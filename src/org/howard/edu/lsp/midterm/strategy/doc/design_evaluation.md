# Part 1 — Design Evaluation: `PriceCalculator`

## Open-ended growth and the Open/Closed Principle

The method `calculatePrice(String customerType, double price)` implements pricing as a **sequence of string comparisons** (`if (customerType.equals("REGULAR"))`, etc.). Adding a new customer segment (for example, `"STUDENT"` or `"WHOLESALE"`) requires **editing this class and growing the conditional chain**. That makes the class a **single change hotspot** and works against the idea that code should be **open for extension but closed for repeated modification**—exactly the kind of rigidity the **Strategy** pattern is meant to address by encapsulating each pricing rule in its own type.

## Duplication and clarity

Each branch repeats the same structural pattern (compare type, assign `finalPrice`). The `REGULAR` branch is redundant (`finalPrice = price` after it was already initialized to `price`) and the overall method reads like a **procedural dispatch table** inlined in one place rather than a clear model of “a pricing policy.” Magic multipliers (`0.90`, `0.80`, `0.85`) are scattered with **no named constant or documentation**, which hurts readability and makes it easy to introduce inconsistent rules.

## Fragile identification of customer types

Pricing depends on **exact string literals** for `customerType`. Typos, inconsistent casing, or alternate spellings silently fall through all branches and return the **unchanged** base price, which can be wrong for an unknown type (fail vs. default is ambiguous). Centralizing each behavior behind a **strategy object** (or factory) localizes how a type is selected and makes invalid combinations easier to detect or test.

## Testing and maintainability

Because all behaviors live in one method, **unit tests** must exercise many branches in one class. Swapping or temporarily enabling a rule for an experiment requires conditional logic or flags. With **separate strategy classes**, each discount can be tested in isolation, and the context (`PriceCalculator`) can be tested with **stub or mock strategies**—improving **maintainability** as the catalog of customer types grows.

## Summary

The current design **couples** all discount algorithms to one method and **stringly-typed** customer labels. As the business adds or changes pricing rules, the class becomes harder to **extend without breakage**, harder to **read**, and harder to **test**. Refactoring to Strategy moves each discount rule behind a **polymorphic** interface, so new customer pricing can be added by introducing **new classes** rather than editing a central `if` chain.
