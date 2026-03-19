# Question 1 — Development Log

## External resources used

**Cursor** (AI coding assistant)

---

**Prompt** - Does the midterm have everything that was asked for in question 1

### How this resource was used


**Checking the work:** Cursor was used in a general way to **review** the Question 1 deliverables against the instructions—for example, that required files and behaviors were covered and that the solution still matched constraints like leaving the provided Driver unchanged. No reliance on a single detailed checklist; it was an extra pass to sanity-check completeness before submission.

**How it helped overall:** Provided second look at whether the submission aligned with what the question asked for.

---

**Exact Response**
#Question 1 Development Log
AI USED - Cursor
Question 1 
Prompt - Does the midterm have everything that was asked for in question 1
Answer - Verifying midterm files against Question 1 requirements.
Here’s how your current midterm lines up with Question 1 as you described it earlier:
Implementation — Yes, this covers it
Requirement Status
One .java file per class (Task, TaskManager, Driver)    Yes
Package org.howard.edu.lsp.midterm.crccards on all Java files   Yes
Driver matches the provided program (unchanged logic)   Yes
Task: fields, constructor default OPEN, all required methods, toString format   Yes
Valid statuses only; invalid → UNKNOWN (case-sensitive) Yes
TaskManager: collections-based storage, no duplicate IDs (IllegalArgumentException), findTask → null, 
getTasksByStatus → List<Task>   Yes
Sample output behavior (OPEN list order T1 then T3) Yes, with LinkedHashMap insertion order
Javadoc — Mostly yes; one gap
Item    Status
Task — class + @author + public methods with descriptions, @param / @return where appropriate   Yes
TaskManager — same + @throws on addTask Yes
Driver — class + main documented    No (no Javadoc on Driver or main)
The written rule was “All classes and public methods must include Javadoc,” while the handout also said do not 
modify Driver. So either the grader treats Driver as exempt, or you need instructor guidance on whether 
comment-only Javadoc on Driver is allowed.
Documentation — Yes
Item    Status
development_log.md under .../midterm/crccards/doc/  Present; includes required sentence if you used no outside help
crccards.md — why TaskManager collaborates with Task but not vice versa, tied to CRC responsibilities   Yes (2 
sentences)
Outside the repo
GitHub push — you must do that yourself; the files don’t prove it.
Bottom line: Functionally and structurally, Question 1 is satisfied except for the literal Javadoc rule on Driver, 
unless your course treats the provided Driver as an exception. 