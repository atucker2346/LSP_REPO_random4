# Question 1 — Answers

## Part 1

**Shared Resource #1:**  
The field `nextId` (shared mutable counter used to assign request IDs).

**Shared Resource #2:**  
The `requests` list (`ArrayList<String>`), shared mutable storage for all request strings.

**Concurrency Problem:**  
Race conditions (lost updates / inconsistent state). Two threads can interleave on `nextId`, so duplicate IDs are possible. They can also call `add` on the same `ArrayList` concurrently; `ArrayList` is not thread-safe for concurrent modification.

**Why addRequest() is unsafe:**  
It performs a multi-step update that is not atomic: it allocates an ID via `getNextId()` (read / increment / write on `nextId`) and then mutates `requests`. Another thread can run the same steps between those steps, breaking ID uniqueness and/or corrupting the list’s internal structure.

---

## Part 2

**Fix A: Explanation**  
**Not correct.** Synchronizing only `getNextId()` serializes ID generation, but `requests.add(...)` is still unsynchronized. Concurrent `addRequest()` calls can still execute `add` at the same time and leave the `ArrayList` in an unsafe state.

**Fix B: Explanation**  
**Correct** (when ID assignment happens only through `addRequest`, which is typical if `getNextId()` is not part of the public API for callers). `synchronized` on `addRequest` uses the instance’s intrinsic lock so ID assignment and list insertion run as one critical section relative to other `addRequest` calls—preventing duplicate IDs on that path and preventing concurrent `ArrayList.add` from those calls. If `getNextId()` were public and called directly from other code while `addRequest` runs, additional coordination would be needed; keeping ID generation encapsulated avoids that.

**Fix C: Explanation**  
**Not correct.** Synchronizing `getRequests()` only protects returning the list reference briefly; it does not make `addRequest()` or unsynchronized mutations safe, and `addRequest()` can still race on `nextId` and on `requests`.

---

## Part 3

**Answer + Explanation**  
**No — `getNextId()` should not be public** under Arthur Riel’s guidance to minimize visibility and keep a minimal, stable public interface. Allocating the next ID is an implementation detail of registering a request; exposing it encourages coupling to internal mechanics and can allow callers to bypass `addRequest` and complicate thread safety. Making it **private** improves encapsulation and maintainability because the class can change how IDs are generated without widening the API.

---

## Part 4

**Description:**  
An alternative to the `synchronized` keyword is to use **`java.util.concurrent.locks.ReentrantLock`** for explicit mutual exclusion. The same critical section (read/increment `nextId` and append to `requests`) is wrapped in `lock()` / `try` / `finally` / `unlock()`. Another lecture option is **`AtomicInteger`** for `nextId` combined with a thread-safe list or additional locking for `requests.add`, since atomic IDs alone do not make `ArrayList` safe.

**Code Snippet:**

```java
private final java.util.concurrent.locks.ReentrantLock lock =
        new java.util.concurrent.locks.ReentrantLock();

public void addRequest(String studentName) {
    lock.lock();
    try {
        int id = getNextId();
        requests.add("Request-" + id + " from " + studentName);
    } finally {
        lock.unlock();
    }
}
```
