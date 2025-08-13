# Centralized Queue Manager

A Java implementation of the **Singleton Design Pattern** for a centralized, shared queue across multiple help desk stations. This project shows how a single, globally accessible manager can coordinate queue numbers consistently and safely.

## 📋 Overview

The Centralized Queue Manager provides one queue number shared by three help desks. Each desk requests the next number from the same `HelpDesk` instance. The system supports displaying the current number and resetting the counter when necessary (e.g., reorganization or recovery from issues).

## 🏗️ Architecture

This project implements the **Singleton Pattern** with the following components:

- **`HelpDesk` (Singleton Manager)**: The single source of truth for the queue number
- **`CentralSystem` (Main Application)**: Demonstrates serving customers from three desks and the reset flow
- **UML Diagram**: High-level view of the classes and their relationships

### Design Pattern Benefits

- **Single source of truth**: Guarantees one authoritative queue manager
- **Controlled access**: Centralizes queue operations via a single instance
- **Lazy initialization**: Instance is created only when first requested
- **Thread-safety**: Synchronized methods prevent race conditions in concurrent scenarios

## 📊 UML Class Diagram

<img width="1223" height="632" alt="UML Class Diagram" src="https://github.com/user-attachments/assets/345a6c6a-3647-4b0c-8141-66cf2c58b6bc" />

The following UML class diagram illustrates:
- The `HelpDesk` singleton and its synchronized operations
- The `CentralSystem` entry point using the singleton instance
- How the Singleton design pattern is applied in this project

## 🚀 Features

- **Single Global Queue**: One counter shared across all desks
- **Singleton Manager**: `HelpDesk` ensures only one instance exists
- **Thread-Safe Operations**: Synchronized access to the counter
- **Queue Reset**: Set the queue number to a specific value
- **Console Demonstration**: Clear example flow and output

## 📁 Project Structure

```
centralized-queue-singleton/
├── src/
│   ├── CentralSystem.java           # Main application demo
│   └──  HelpDesk.java               # Singleton queue manager
└── README.md                        # Project documentation
```

## 🛠️ Installation & Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or a terminal

### Getting Started

1. **Clone or download** the project files
2. **Navigate** to the project directory
3. **Compile** the Java files:
   ```bash
   javac -d out src/*.java
   ```
4. **Run** the application:
   ```bash
   java -cp out CentralSystem
   ```

## 📖 Usage

### Basic Usage

The main application (`CentralSystem.java`) demonstrates how the singleton queue manager is used:

```java
HelpDesk helpDesk = HelpDesk.getInstance();

helpDesk.serveNextCustomer("Help Desk #1");
helpDesk.serveNextCustomer("Help Desk #2");
helpDesk.serveNextCustomer("Help Desk #3");

helpDesk.displayCurrentQueueNumber();

helpDesk.resetQueueNumber(1);

helpDesk.serveNextCustomer("Help Desk #1");
helpDesk.serveNextCustomer("Help Desk #2");
helpDesk.serveNextCustomer("Help Desk #3");
```

### Expected Output

```
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

## 🔧 Extending the Project

### Adding New Capabilities

- **Concurrency Simulation**: Create multiple threads that call `serveNextCustomer` on the same `HelpDesk` instance to simulate real desks
- **UI/Monitoring**: Replace console prints with a GUI or web dashboard for real-time visibility
- **Persistence**: Save and restore the queue number across restarts (file or database)

## 🎯 Design Patterns Used

### Singleton Pattern
- **Purpose**: Provide a single, globally accessible instance managing the queue
- **Benefits**: Ensures consistency, centralizes logic, and simplifies coordination
- **Implementation**: Private constructor, synchronized `getInstance()`, and synchronized queue operations

## 🤝 Contributing

Contributions are welcome:
- Add monitoring/UI layers
- Improve concurrency simulations and benchmarks
- Enhance documentation and examples
- Add tests

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

**Note**: This implementation demonstrates clean code principles and design patterns best practices. The Singleton pattern is particularly useful when you must ensure exactly one instance of a component across the application, coordinate access to shared state/resources, or centralize configuration and control behind a globally accessible façade.
