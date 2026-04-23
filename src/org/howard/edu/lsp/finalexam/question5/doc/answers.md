# Question 5 — Arthur Riel Heuristics

**Note:** Tailor the “lecture” sentence in each explanation to match **your** instructor’s examples. The names below are standard Riel heuristics.

---

**Heuristic 1:**

**Name:**  
Keep classes simple; minimize the public interface (minimize public members).

**Explanation:**  
A smaller public surface makes code easier to read because callers only see what they are meant to depend on, and it improves maintainability because internal fields and helpers can change without breaking clients. 

---

**Heuristic 2:**

**Name:**  
All data should be hidden (keep data private).

**Explanation:**  
Private state forces access through methods, which clarifies invariants and makes refactoring safer. It improves readability by funneling behavior through named operations instead of scattered direct field access. 

---

**Heuristic 3:**

**Name:**  
Distinguish **has-a** (composition) from **is-a** (inheritance); prefer composition when behavior should be reused without an is-a relationship.

**Explanation:**  
Composition tends to reduce tight coupling and deep inheritance hierarchies, which makes designs easier to understand and extend. 
