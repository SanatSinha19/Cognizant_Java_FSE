# Difference between JPA, Hibernate, and Spring Data JPA

**JPA (Java Persistence API)** is a specification (JSR 338) — a set of rules and interfaces
defining how Java objects should be mapped to relational database tables. JPA itself has
no implementation; it only defines the contract (annotations like @Entity, @Id, and
interfaces like EntityManager).

**Hibernate** is one of several concrete implementations of the JPA specification. It is
an ORM (Object-Relational Mapping) tool that actually does the work of translating Java
objects into SQL and back, managing sessions, transactions, and caching.

**Spring Data JPA** is a further abstraction layer built on top of JPA (and typically uses
Hibernate underneath as the JPA provider). It removes boilerplate code — instead of writing
manual EntityManager/Session code for basic CRUD operations, you simply define a repository
interface (extending JpaRepository), and Spring Data JPA generates the implementation for
you at runtime.

**In short:**
JPA = specification (the "what")
Hibernate = implementation (the "how")
Spring Data JPA = convenience layer on top of an implementation (removes the "how" boilerplate)