# Library Management System

## Overview

Library Management System is a console-based Java application developed to demonstrate core Java concepts such as Object-Oriented Programming, Collections Framework, Generics, Streams API, Lambda Expressions, and Custom Exception Handling.

The application simulates a real-world library environment where members can borrow and return books, maintain borrowing history, and manage pending borrow requests. The project follows a modular design and applies industry-standard programming practices while keeping the implementation simple and easy to understand.

---

## Features

### Book Management
- Add books to the library catalog
- Display all books
- Search books by author
- View available books
- Sort books by title
- Group books by genre

### Member Management
- Register library members
- Maintain member information using unique member IDs
- Track borrowing history

### Borrowing System
- Borrow available books
- Prevent duplicate borrowing of unavailable books
- Create borrowing records
- Maintain borrowing history for each member

### Return System
- Return borrowed books
- Update borrow records with return information
- Automatically process pending borrow requests

### Request Queue
- Queue borrow requests when a book is unavailable
- Process queued requests automatically when the book is returned

---

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework
- Generics
- Streams API
- Lambda Expressions
- Custom Exceptions

---

## Object-Oriented Design

### Abstraction

`LibraryItem` is implemented as an abstract class that contains common attributes shared by all library items.

### Inheritance

- `Book` extends `LibraryItem`
- `Magazine` extends `LibraryItem`

### Interface

`Borrowable` defines the contract for borrowing operations.

### Encapsulation

Class attributes are kept private and accessed through constructors and methods.

### Polymorphism

The `display()` method is overridden by subclasses to provide specific behavior.

---

## Collections Framework Usage

### List

Used for:

- Book storage
- Borrow records
- Borrow history

### Map

Used to store members:

```java
Map<String, Member>
```

### Set

Used to maintain unique genres:

```java
Set<String>
```

### Queue

Used to manage pending borrow requests:

```java
Queue<BorrowRequest>
```

---

## Generics

### LibraryCatalog<T>

A generic catalog implementation used to manage library items in a type-safe manner.

Example:

```java
LibraryCatalog<Book>
```

### SearchResult<T>

A generic wrapper used to store search results.

Example:

```java
SearchResult<Book>
```

---

## Streams and Lambda Expressions

The application uses Java Streams for common operations such as:

### Search By Author

```java
stream()
.filter(...)
```

### Filter Available Books

```java
stream()
.filter(Book::isAvailable)
```

### Sort Books By Title

```java
stream()
.sorted(...)
```

### Group Books By Genre

```java
Collectors.groupingBy(...)
```

---

## Custom Exceptions

The project includes custom exception handling for common library operations.

### BookNotFoundException

Thrown when a requested book does not exist.

### BookNotAvailableException

Thrown when a book is already borrowed.

### MemberNotFoundException

Thrown when an invalid member ID is provided.

---

## Borrowing Workflow

1. Validate member information
2. Locate the requested book
3. Check availability
4. Create a borrow record
5. Mark the book as unavailable
6. Update member borrowing history

---

## Return Workflow

1. Validate member information
2. Locate active borrow record
3. Update return timestamp
4. Mark book as available
5. Process pending borrow requests

---

## Project Structure

```text
src
└── org.library
    ├── catalog
    │   ├── LibraryCatalog.java
    │   └── SearchResult.java
    │
    ├── exception
    │   ├── BookNotAvailableException.java
    │   ├── BookNotFoundException.java
    │   └── MemberNotFoundException.java
    │
    ├── interfaces
    │   └── Borrowable.java
    │
    ├── main
    │   └── Main.java
    │
    ├── model
    │   ├── LibraryItem.java
    │   ├── Book.java
    │   ├── Magazine.java
    │   ├── Member.java
    │   ├── BorrowRecord.java
    │   └── BorrowRequest.java
    │
    └── service
        └── LibraryService.java
```

---

## Sample Data

### Books

| Book ID | Title | Genre | Author |
|----------|---------|---------|---------|
| B101 | Java Fundamentals | Programming | James Gosling |
| B102 | Spring Boot | Programming | Rod Johnson |
| B103 | MySQL Guide | Database | Paul Dubois |
| B104 | SQL Mastery | Database | Alan Beaulieu |
| B105 | Design Patterns | Design | Gang of Four |
| B106 | Clean Architecture | Design | Robert Martin |

### Members

| Member ID | Name |
|------------|--------|
| M101 | Chaitanya |
| M102 | Rahul |
| M103 | Priya |

---

## Functionalities Demonstrated

The application supports the following scenarios:

- Add books across multiple genres
- Register library members
- Search books by author
- Display available books
- Sort books alphabetically
- Borrow books
- Handle unavailable book requests
- Return books
- Process queued borrow requests
- Group books by genre
- Maintain borrowing history

---

## Learning Outcomes

This project helped reinforce the following concepts:

- Abstraction
- Encapsulation
- Inheritance
- Polymorphism
- Interfaces
- Collections Framework
- Generic Programming
- Streams API
- Lambda Expressions
- Exception Handling
- Queue Processing
- Object-Oriented Design

---

## How to Run

1. Clone the repository

```bash
git clone <repository-url>
```

2. Open the project in IntelliJ IDEA

3. Run:

```text
Main.java
```

4. Use the menu options to interact with the system

---

## Author

Chaitanya Vinjamuri
