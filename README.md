## Centralized Queuing System (Pag-IBIG Office)

A simple Java console application that demonstrates a centralized queuing system for three help desk stations using the Singleton pattern. All desks share the same queue counter, ensuring customers are served in a single, global order. The app also allows resetting the queue number when needed (e.g., reorganization, recovery from issues).

### Features
- **Single global queue**: One counter shared across all help desks.
- **Singleton `HelpDesk`**: Ensures only one instance manages the queue.
- **Thread-safe operations**: Synchronized access to the queue counter.
- **Reset capability**: Set the queue number to a specific value when required.
- **Console demo**: Provides a straightforward example flow and output.

### Design Overview
- **Pattern**: `HelpDesk` implements the Singleton pattern via a private constructor and a synchronized `getInstance()` method.
- **Thread-safety**: `displayCurrentQueueNumber`, `serveNextCustomer`, and `resetQueueNumber` are synchronized to prevent race conditions if invoked from multiple threads.
- **Flow**: `CentralSystem` drives a simple scenario serving customers at three desks, displays the current number, then demonstrates a reset.

### Project Structure
- `src/CentralSystem.java`: Entry point with a basic usage demo.
- `src/HelpDesk.java`: Singleton queue manager.
- `src/UML Class Diagram.png`: High-level class diagram of the design.

### Prerequisites
- Java JDK 8 or newer
- Windows PowerShell, Command Prompt, or any terminal

### Build and Run (Windows PowerShell)
From the project root:

```powershell
cd "C:\Users\Ellaine Dale\Downloads\centralized-queue-singleton"

# Compile to an output directory
javac -d out src\*.java

# Run the program
java -cp out CentralSystem
```

If you prefer compiling directly in-place without `out/`:

```powershell
javac src\*.java
java -cp src CentralSystem
```

### Example Output
```text
Pag-Ibig Queueing System

Currently serving Customer #1 at Help Desk #1
Currently serving Customer #2 at Help Desk #2
Currently serving Customer #3 at Help Desk #3
Currently serving Customer #4 at Help Desk #1
Currently serving Customer #5 at Help Desk #2
Currently serving Customer #6 at Help Desk #3

Current Queue Number: 7

Reset Queue Number to: 1

Currently serving Customer #1 at Help Desk #1
Currently serving Customer #2 at Help Desk #2
Currently serving Customer #3 at Help Desk #3
```

### Extending This Example
- **Concurrency**: Create multiple threads that call `serveNextCustomer` on the same `HelpDesk` instance to simulate real concurrent desks. The synchronized methods will preserve correctness.
- **UI/Monitoring**: Replace console prints with a GUI or web API for real-time monitoring. The queue manager can remain the single source of truth.
- **Persistence**: Store the current queue number to disk or a database to survive restarts.

### Notes
- The included UML diagram is located at `src/UML Class Diagram.png`.
- This repository is a minimal demonstration and intentionally omits persistence and user interfaces beyond console output.