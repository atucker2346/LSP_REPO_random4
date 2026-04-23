# Question 1 — AI Usage

**AI Tools Used:**  
Cursor 

**Prompts Used (2–5 max):**

1. Help with final exam Question 1 concurrency: shared resources, Fix A/B/C, Riel public method, ReentrantLock snippet.

**How AI Helped (2–3 sentences):**  
AI was used to structure answers for Parts 1–4 (race conditions, evaluating synchronizing individual methods, encapsulation of `getNextId`, and a lock-based alternative to `synchronized`). I reviewed and edited the explanations so they match my understanding and course terminology.

**Reflection (1–2 sentences):**  
I verified each fix against the code paths (especially that synchronizing only `getNextId` still leaves `ArrayList` unsafe). I will double-check Fix B against whether my instructor treats public `getNextId` as in scope.
