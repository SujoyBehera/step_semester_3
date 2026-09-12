# STEP Semester 3

A collection of my Semester 3 coursework, practice problems, assignments, and Java implementations completed as part of the STEP program.

## Date: 13-09-2026
**Today's Work:**
- Completed Week 6 Category B practice and assignment problems focused on inheritance and polymorphism.
- Added Week 6 work under `src/week6/class_problems/` and `src/week6/assigment_problems/` on `feature/session_6`.
- Covered single, multilevel, and hierarchical inheritance, method overriding, `super`, polymorphism, `instanceof`, safe downcasting, static counters, final fields, overloaded methods, defensive copying, `StringBuilder`, and validation using `charAt()` and `Character` methods.

**Next Session Plan:**
- Continue with the next Semester 3 Java/OOP session and add the work to a new feature branch from `develop`.

**Issues Faced:**
- Week 6 contains multiple classes with the same conceptual names across the Practice and Assignment sets, so each set is kept in its own `class_problems` / `assigment_problems` package to avoid class-name conflicts.

---

## Date: 11-09-2026
**Today's Work:**
- Added Week 5 / Session 5 assignment problems on access modifiers, encapsulation, JavaBeans, immutability, and object modeling.
- Added all 5 assignment problems under `src/week5/assigment_problems/` on `feature/session_5`.
- Implemented access checking, subclass visibility rules, inventory encapsulation, write-once/write-only JavaBean properties, defensive copying, immutable loan receipts, static initialization, and `instanceof`-based nightly circulation processing.

**Next Session Plan:**
- Continue with the next Semester 3 Java/OOP session and add the work to a new feature branch from `develop`.

**Issues Faced:**
- The Week 5 assignment specifies `LoanReceipt` as `final` while also requiring `ReferenceOnlyLoanReceipt` to extend it. These requirements conflict in Java, so inheritance was prioritized to keep the requested polymorphic design compilable.

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

Completed Category B practice problems covering access modifiers, visibility rules, subclass access, encapsulation, JavaBeans, write-only OTP properties, immutability, defensive copying, and `instanceof`-based settlement processing.

Completed assignment problems covering access visibility aggregation, cross-package subclass access, validated inventory state transitions, JavaBean write-once/write-only properties, and immutable loan receipts with nightly circulation processing.

#### Week 6 — Session 6

Completed Category B practice and assignment problems focused on inheritance and polymorphism.

Practice work covers `LibraryMember` inheritance, `StudentMember`, `HonorsStudentMember`, `FacultyMember`, method overriding, fine-history defensive copying, polymorphic reporting, safe downcasting, static member numbering, renewal-code validation, overloaded borrowing, and nightly audit processing.

Assignment work covers `GymMember`, `PremiumMember`, `EliteMember`, `GroupClassMember`, inheritance hierarchies, late-fee overriding with `super`, polymorphic display, safe downcasting, static membership numbering, referral-code validation, overloaded fee payments, and weekly check-in processing.

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
│   └── week6/
│       ├── class_problems/
│       └── assigment_problems/
│
└── README.md
```

## 🌿 Branching Model

- `main` — documentation and daily progress log
- `develop` — clean base Java project skeleton
- `feature/session_<n>` — coding work for each session

Feature branches are created from `develop` and are not merged back into `develop`.
