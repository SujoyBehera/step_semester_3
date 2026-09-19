# STEP Semester 3

A collection of my Semester 3 coursework, practice problems, assignments, and Java implementations completed as part of the STEP program.

## Date: 19-09-2026
**Today's Work:**
- Completed Week 7 Category B Practice and Assignment problems focused on abstraction, interfaces, inheritance, polymorphism, method overriding, method overloading, `super`, and `instanceof`.
- Added Week 7 work under `src/week7/class_problems/` and `src/week7/assigment_problems/` on `feature/session_7`.
- Followed the repository format of **5 questions = 5 Java code files** for each Week 7 section.
- Classwork files: `Toy.java`, `Printable.java`, `Instrument.java`, `KitchenTool.java`, and `DeliveryNote.java`.
- Assignment files: `Ringable.java`, `ArtPiece.java`, `GardenTool.java`, `ClassroomDevice.java`, and `Drone.java`.

**Next Session Plan:**
- Continue with the next Semester 3 Java/OOP session and create the next feature branch from `develop`.

**Issues Faced:**
- The Week 7 Garden Tools problem asks for an abstract `use()` method in `GardenTool` while also requiring subclasses to call `super.use()`. Since Java cannot call an abstract parent method with `super.use()`, the base class provides the shared garden-use message so the inheritance chain remains compilable and follows the intended output.

---

## 📚 Current Progress

### Java / OOP

Currently working through Java Object-Oriented Programming concepts and weekly assignments.

#### Week 1 — Session 1
Completed classwork and assignment problems covering Java Strings, arrays, input handling, methods, validation, loops, and basic problem solving.

#### Week 2 — Session 2
Completed classwork and assignment problems covering String manipulation, validation, parsing, formatting, arrays, loops, and frequency analysis.

#### Week 3 — Session 3
Completed classwork and assignment problems covering classes and objects, constructors, constructor overloading, `this`, `final`, static members, static blocks, and `instanceof`.

#### Week 4 — Session 4
Completed classwork and assignment problems covering constructor overloading, `this()`, `this`, `final`, static initialization, static members, and `instanceof`.

#### Week 5 — Session 5
Completed Category B practice and assignment problems covering access modifiers, visibility rules, subclass access, encapsulation, JavaBeans, write-once/write-only properties, immutability, defensive copying, static initialization, and `instanceof`-based processing.

#### Week 6 — Session 6
Completed Category B practice and assignment problems focused on inheritance and polymorphism.

Practice work covers `LibraryMember`, `StudentMember`, `HonorsStudentMember`, `FacultyMember`, method overriding, fine-history defensive copying, polymorphic reporting, safe downcasting, static member numbering, renewal-code validation, overloaded borrowing, and nightly audit processing.

Assignment work covers `GymMember`, `PremiumMember`, `EliteMember`, `GroupClassMember`, inheritance hierarchies, late-fee overriding with `super`, polymorphic display, safe downcasting, static membership numbering, referral-code validation, overloaded fee payments, and weekly check-in processing.

#### Week 7 — Session 7
Completed Category B Practice and Assignment problems focused on abstraction, interfaces, inheritance, and polymorphism.

**Class Problems — 5 code files**
- `Toy.java` — Talking Toy Box
- `Printable.java` — Warehouse Label Printer
- `Instrument.java` — Orchestra Warm-Up Routine
- `KitchenTool.java` — Smart Kitchen Assistant
- `DeliveryNote.java` — Package Drop-Off Log

**Assignment Problems — 5 code files**
- `Ringable.java` — Morning Wake-Up Circuit
- `ArtPiece.java` — Gallery Description Cards
- `GardenTool.java` — Backyard Toolshed Routine
- `ClassroomDevice.java` — Digital Classroom Setup
- `Drone.java` — Skyline Delivery Fleet

### Problems Completed

| Week | Session | Section | Progress |
|------|---------|---------|----------|
| Week 1 | Session 1 | Class Problems | ✅ Complete |
| Week 1 | Session 1 | Assignment Problems | ✅ Complete |
| Week 2 | Session 2 | Class Problems | ✅ Complete |
| Week 2 | Session 2 | Assignment Problems | ✅ Complete |
| Week 3 | Session 3 | Class Problems | ✅ Complete |
| Week 3 | Session 3 | Assignment Problems | ✅ Complete |
| Week 4 | Session 4 | Class Problems | ✅ Complete |
| Week 4 | Session 4 | Assignment Problems | ✅ Complete |
| Week 5 | Session 5 | Class Problems | ✅ Complete |
| Week 5 | Session 5 | Assignment Problems | ✅ Complete |
| Week 6 | Session 6 | Class Problems | ✅ Complete |
| Week 6 | Session 6 | Assignment Problems | ✅ Complete |
| Week 7 | Session 7 | Class Problems | ✅ Complete |
| Week 7 | Session 7 | Assignment Problems | ✅ Complete |

## 🗂️ Repository Structure

```text
step_semester_3/
│
├── src/
│   ├── week1/
│   │   ├── class_problems/
│   │   └── assigment_problems/
│   │
│   ├── week2/
│   │   ├── class_problems/
│   │   └── assigment_problems/
│   │
│   ├── week3/
│   │   ├── class_problems/
│   │   └── assigment_problems/
│   │
│   ├── week4/
│   │   ├── class_problems/
│   │   └── assigment_problems/
│   │
│   ├── week5/
│   │   ├── class_problems/
│   │   └── assigment_problems/
│   │
│   ├── week6/
│   │   ├── class_problems/
│   │   └── assigment_problems/
│   │
│   └── week7/
│       ├── class_problems/
│       │   ├── Toy.java
│       │   ├── Printable.java
│       │   ├── Instrument.java
│       │   ├── KitchenTool.java
│       │   └── DeliveryNote.java
│       │
│       └── assigment_problems/
│           ├── Ringable.java
│           ├── ArtPiece.java
│           ├── GardenTool.java
│           ├── ClassroomDevice.java
│           └── Drone.java
│
└── README.md
```

## 🌿 Branching Model

- `main` — documentation and daily progress log
- `develop` — clean base Java project skeleton
- `feature/session_<n>` — coding work for each session

Feature branches are created from `develop` and are not merged back into `develop`.
