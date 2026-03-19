# Question 3 — Development Log

## External resources used

**Cursor** (AI coding assistant)

**Prompt** - Is everything for question 3 correct

---

### How this resource was used


**Checking the work:** Cursor was also used in a general way to **review** the Question 3 deliverables against the instructions—for example, that the pattern structure, file locations, output format, and logging expectations were addressed. It was an extra pass to confirm things were complete and consistent before turning in, without walking through every fine-grained detail here.

**How it helped overall:** Provided second look at whether the submission aligned with what the question asked for.

---
**Exact Response** 

Part 1 — design_evaluation.md
Correct: Analyzes the old if/equals design, maintainability, stringly-typed types, magic multipliers, and why 
Strategy fits.
Correct location: midterm/strategy/doc/design_evaluation.md
Part 2 — Strategy refactor
Correct pattern: DiscountStrategy + four concrete strategies + PriceCalculator as context delegating to a strategy.
Correct math vs. original: REGULAR → 100, MEMBER → 90, VIP → 80, HOLIDAY → 85 on base 100.
Correct structure: Package org.howard.edu.lsp.midterm.strategy, one class per file.
Javadoc: Classes and public API are documented with @param / @return where appropriate. Fine for the rubric.
(Extra null-check on PriceCalculator’s strategy is allowed; not required.)

