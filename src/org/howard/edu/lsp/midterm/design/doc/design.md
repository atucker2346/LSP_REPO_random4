# Part 2 — Redesigned System (CRC Cards)

The redesign separates **domain data**, **pricing policy**, **persistence**, **receipt presentation**, and **notifications** so each class has a narrow, understandable role. An orchestrating class coordinates the workflow without implementing every low-level detail.

---

**Class:** `Customer`

**Responsibilities:**

- Store customer name and email
- Provide customer details to other components when needed

**Collaborators:**

- `Order`

---

**Class:** `Order`

**Responsibilities:**

- Store the ordered item and base price
- Associate the order with a `Customer`
- Hold or expose data needed for totals and reporting (without performing file I/O or printing)

**Collaborators:**

- `Customer`

---

**Class:** `OrderPricing`

**Responsibilities:**

- Compute tax amount from a base price using a configurable or named tax rate
- Apply discount rules (e.g., reduce total when price exceeds a threshold)
- Produce final monetary totals (subtotal, tax, total) in a clear order

**Collaborators:**

- `Order`

---

**Class:** `OrderRecordStore`

**Responsibilities:**

- Append a persisted representation of a processed order (e.g., CSV line) to storage
- Handle file (or other) I/O errors in one place

**Collaborators:**

- `Order`
- (optional value object for totals/line format, if introduced)

---

**Class:** `ReceiptFormatter`

**Responsibilities:**

- Build human-readable receipt lines (customer, item, totals)
- Format output for whatever sink is used (e.g., console); does not compute business rules

**Collaborators:**

- `Order`
- `OrderPricing` (or a small `OrderTotals` / result object produced by pricing)

---

**Class:** `OrderNotifier`

**Responsibilities:**

- Send or simulate order confirmation to the customer’s email address
- Isolate notification mechanics from tax and persistence

**Collaborators:**

- `Customer`

---

**Class:** `OrderWorkflow`

**Responsibilities:**

- Orchestrate processing: compute totals via `OrderPricing`, render receipt via `ReceiptFormatter`, persist via `OrderRecordStore`, notify via `OrderNotifier`, log completion time
- Enforce a sensible sequence (e.g., finalize totals before persist and display)

**Collaborators:**

- `Order`
- `OrderPricing`
- `OrderRecordStore`
- `ReceiptFormatter`
- `OrderNotifier`

---

**Assumptions (design):**

- `OrderPricing` returns consistent totals so persistence and receipts use the **same** final numbers.
- `OrderRecordStore` may take formatted strings or DTOs; details are implementation-specific and hidden from `Order`.
