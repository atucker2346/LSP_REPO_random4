# CRC Collaboration: Task vs TaskManager

**TaskManager** collaborates with **Task** because its CRC responsibilities—store tasks, add new tasks, find a task by ID, and return tasks by status—require it to hold and operate on `Task` instances. **Task** does not list **TaskManager** as a collaborator because its responsibilities are only to store task information, update task status, and provide task details; none of those require knowing about the collection or lookup logic that `TaskManager` provides.
