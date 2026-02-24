# Draw + Design Patterns

## Context

* **Origin** Developed as part of a course in Java, UML and Design Patterns at Karlstad University.
* **Objective** A drawing program where users can draw different shapes with chosen line width/line color/fill color. Implements several distinct design patterns.
* **Status** 🟢 Complete/Functional

---

## Systems Architechture

* **Logic** MVC
* **Tech Stack** Java + Java Swing (Eclipse IDE)

---

## Functionality

* Draw different shapes (circle, line, rectangle)
* Pick line width, -color, -thickness and fill color.
* Data persistence throuch object serialization (.dat)
* This app was integrated against a pre-made composite-pattern (model/composite)
* Distinct design patterns implemented and where to look for them:
  - Chain of responsibility (app/controller/chain)
  - Composite (model/composite)
  - State (model/state)
  - Visitor (model/visitor)
  - Facade (model)
  - Command (controller/commands)

---

## Setup & Usage

1. Clone the repository
2. Open in IDE of your choice

---

## Learning Outcomes

* Implementing Gang of Four design patterns in a Java setting
* Creating a layered MVC structure from scratch
* Integrating with legacy code (the pre-existing composite)
