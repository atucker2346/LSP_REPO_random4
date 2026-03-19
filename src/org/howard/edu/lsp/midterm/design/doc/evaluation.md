# Part 1 — Design Evaluation: `OrderProcessor`

## Encapsulation and data hiding

The class exposes **all order-related fields as `public`** (`customerName`, `email`, `item`, `price`). Any client can read or assign inconsistent values at any time, bypassing validation and breaking invariants (for example, negative prices or empty items). Good object-oriented design (including Riel-style heuristics) favors **keeping state private** and exposing behavior through methods so the object can enforce rules and hide representation details. Here, `OrderProcessor` is structured like a **data bag** with a procedure attached, not a cohesive object that protects its own state.

## Single responsibility and cohesion

`processOrder()` **bundles many unrelated concerns** into one long method: computing tax and totals, printing a receipt to the console, persisting to a file, simulating email, applying a discount policy, and logging a timestamp. That violates the idea that a class should have **one primary axis of change** (often summarized as the Single Responsibility Principle). A tax-rate change, a new storage format, a new notification channel, or a new discount rule would all force edits to the **same** class and method, increasing regression risk and making the code harder to understand or test in isolation.

## Separation of abstraction levels

**Domain logic** (pricing, discounts) is mixed with **infrastructure** (file I/O, console output, date logging) and **presentation strings**. Riel’s heuristics encourage factoring by **roles**—for example, persistence and user-facing output should not be entangled with core order calculations—so each piece can evolve and be replaced (database instead of file, real mailer instead of `println`) without rewriting business rules.

## Magic numbers and maintainability

Tax (`0.07`), discount thresholds (`500`), and discount factors (`0.9`) are **hard-coded literals**. They encode business policy in the middle of procedural code. That makes the system brittle: policy updates require code edits in multiple hidden places, and the intent (“high-value order discount”) is not named or centralized.

## Error handling and robustness

The code catches **`Exception`** broadly and only prints a stack trace. That swallows failures in a way that callers cannot handle, and it treats all errors the same (for example, I/O errors vs. programming errors). It also uses **`FileWriter` without try-with-resources**, so if an exception occurs after opening the file, resources may not close cleanly (depending on path). These choices hurt **maintainability** and **reliability** compared to narrower catch blocks, explicit failure reporting, or delegating persistence to a dedicated component.

## Logical / ordering issues in the flow

The method computes `total`, prints and **writes** it to the file, then **later** may apply a discount that changes `total`—after the receipt and persistence steps. So the **persisted and displayed total can disagree** with the final discounted amount, and the discount logic runs **after** “sending” confirmation. Even as procedural code, the **sequence of operations** is confusing and error-prone, which is a symptom of doing too much in one place without a clear model of an “order” and its lifecycle.

## Summary

Overall, the design **weakens encapsulation**, **overloads one class with many responsibilities**, **mixes layers** (business vs. I/O vs. UI), and embeds **policy as unnamed constants**. Together, these issues make the system harder to **extend** (new channels, rules, or storage), harder to **test**, and easier to break when requirements change—consistent with the kinds of problems object-oriented decomposition and heuristics such as Riel’s are meant to avoid.
