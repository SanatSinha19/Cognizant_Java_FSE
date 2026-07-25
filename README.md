# Cognizant Java FSE — Digital Nurture 5.0

**Sanat Sinha**

Weekly hands-on submissions for the Cognizant Digital Nurture 5.0 Java FSE program.

---

## 📋 Progress

| Week | Topic                                         |    Status    |
| :--: | :-------------------------------------------- | :----------: |
|  1   | Engineering Concepts & Programming Languages  | ✅ Completed |
|  2   | Spring Core, Maven, Spring Data JPA/Hibernate | ✅ Completed |
|  3   | Spring REST using Spring Boot 3               | ✅ Completed |
|  4   | Microservices (Account & Loan services)       | ✅ Completed |
|  5   | Angular v20 — Student Course Portal           | ✅ Completed |

> Refer to this README file for a detailed week-by-week breakdown of the work completed, exercises solved, concepts learned, and key takeaways.

---

## 📑 Table of Contents

- [Week 1 — Engineering Concepts & Programming Languages](#week-1--engineering-concepts--programming-languages)
- [Week 2 — Spring Core, Maven & Spring Data JPA with Hibernate](#week-2--spring-core-maven--spring-data-jpa-with-hibernate)
- [Week 3 — Spring REST using Spring Boot 3](#week-3--spring-rest-using-spring-boot-3)
- [Week 4 — Microservices with Spring Boot 3 | Account & Loan Services](#week-4--microservices-with-spring-boot-3--account--loan-services)
- [Week 5 — Angular (v20) Hands-On | Student Course Portal](#week-5--angular-v20-hands-on--student-course-portal)

---

## Week 1 — Engineering Concepts & Programming Languages

_Digital Nurture 5.0 — Java FSE Track_

Covers the foundational engineering layer: design principles/patterns and data structures & algorithms, followed by the programming-language layer (PL/SQL, JUnit/Mockito, SLF4J).

### Hands-On Exercises Completed

| Category                     | Exercise                                       |
| :--------------------------- | :--------------------------------------------- |
| Design Patterns & Principles | Ex1: Singleton Pattern                         |
| Design Patterns & Principles | Ex2: Factory Method Pattern                    |
| Data Structures & Algorithms | Ex2: E-commerce Platform Search Function       |
| Data Structures & Algorithms | Ex7: Financial Forecasting                     |
| PL/SQL Programming           | Ex1: Control Structures                        |
| PL/SQL Programming           | Ex3: Stored Procedures                         |
| JUnit5                       | Ex1: Setting Up JUnit                          |
| JUnit5                       | Ex3: Assertions in JUnit                       |
| JUnit5                       | Ex4: AAA Pattern, Test Fixtures                |
| Mockito                      | Ex1: Mocking and Stubbing                      |
| Mockito                      | Ex2: Verifying Interactions                    |
| SLF4J                        | Ex1: Logging Error Messages and Warning Levels |

### What Each Exercise Covered

#### Design Patterns — Singleton Pattern

Implemented a `Logger` utility class following the Singleton pattern: a private static instance, a private constructor (blocking external instantiation), and a public static `getInstance()` method. Verified the pattern works correctly by confirming two separate `getInstance()` calls returned the same object reference, and that the constructor log message printed only once across both calls.

#### Design Patterns — Factory Method Pattern

Built a `ShapeFactory` that returns different concrete `Shape` implementations (Circle, Square, Rectangle) based on a string input, without the client code ever calling `new` directly. This demonstrates decoupling object creation from object usage — client code depends only on the `Shape` interface.

#### DSA — E-commerce Platform Search Function

Implemented and compared Linear Search (O(n) worst case) and Binary Search (O(log n) worst case) on a `Product` array containing `productId`, `productName`, and `category`. Binary search required pre-sorting the array by `productId` using `Arrays.sort()` with a `Comparator`. Concluded binary search is the better fit for a large, mostly-static product catalog, while linear search is only preferable for small/unsorted/frequently-changing lists.

### Key Concepts Learned

- Java rule: `public class X` must match filename `X.java` exactly (case-sensitive).
- A class needs a separate `main()`-bearing class (e.g., `*Test`/`*Demo`) to be runnable — the class under test is not itself an entry point.
- Java packages require the physical folder structure to mirror the package name, and must be compiled/run from outside the package folder using the fully qualified class name (`package.ClassName`).
- Big O notation describes algorithmic growth rate, not raw speed — critical for judging scalability (e.g., catalog search) rather than just current performance.
- Binary search's requirement of a sorted input is a real trade-off: faster lookups at the cost of needing sorted/maintained data.

### Tech Stack

Java (JDK 17) · Plain `javac`/`java` compilation (no build tool needed for this week)

### Project Structure

```
Week01_EngineeringConcepts_ProgrammingLanguages/
├── DesignPatterns/
│   └── src/
│       ├── Singleton.java, SingletonDemo.java (generic demo)
│       ├── Shape.java, Circle.java, Square.java, Rectangle.java, ShapeFactory.java, FactoryDemo.java
│       └── SingletonPatternExample/
│           ├── Logger.java
│           └── LoggerTest.java
├── DSA/
│   └── src/
│       └── EcommerceSearchExample/
│           ├── Product.java
│           ├── LinearSearch.java
│           ├── BinarySearch.java
│           └── SearchDemo.java
├── PLSQL/ (pending)
├── TDD_JUnit_Mockito_SLF4J/ (pending)
└── screenshots/
```

### Running Locally

```bash
# From src/ folder, for package-based examples:
javac SingletonPatternExample/Logger.java SingletonPatternExample/LoggerTest.java
java SingletonPatternExample.LoggerTest

# For the search demo:
cd DSA/src
javac EcommerceSearchExample/Product.java EcommerceSearchExample/LinearSearch.java EcommerceSearchExample/BinarySearch.java EcommerceSearchExample/SearchDemo.java
java EcommerceSearchExample.SearchDemo
```

---

## Week 2 — Spring Core, Maven & Spring Data JPA with Hibernate

_Digital Nurture 5.0 — Java FSE Track_

Covers the Products & Frameworks layer: Spring's IoC/DI fundamentals, Maven project configuration, and Spring Data JPA with Hibernate for database access.

### Hands-On Exercises Completed

| Category                  | Exercise                                      |
| :------------------------ | :-------------------------------------------- |
| Spring Core & Maven       | Ex1: Configuring a Basic Spring Application   |
| Spring Core & Maven       | Ex2: Implementing Dependency Injection        |
| Spring Core & Maven       | Ex4: Creating and Configuring a Maven Project |
| Spring Data JPA/Hibernate | Quick Example (Country entity + repository)   |
| Spring Data JPA/Hibernate | JPA vs Hibernate vs Spring Data JPA (written) |

### What Each Exercise Covered

#### Ex1 — Configuring a Basic Spring Application

Built a `LibraryManagement` Spring project using pure XML configuration (`applicationContext.xml`), defining `BookService` and `BookRepository` as independent Spring beans, loaded via `ClassPathXmlApplicationContext`.

#### Ex2 — Implementing Dependency Injection

Extended Ex1 by wiring `BookRepository` into `BookService` using setter injection (`<property name="bookRepository" ref="bookRepository" />` in XML), demonstrating that Spring — not the class itself — is responsible for creating and supplying dependencies.

#### Ex4 — Creating and Configuring a Maven Project

Configured a standalone Maven `pom.xml` for `LibraryManagement`, adding Spring Context, Spring AOP, and Spring WebMVC dependencies, plus the Maven Compiler Plugin explicitly targeting Java 1.8.

#### Spring Data JPA — Quick Example

Built `Country` as a JPA `@Entity`, `CountryRepository` extending `JpaRepository<Country, String>`, and `CountryService` with a `@Transactional` `getAllCountries()` method. Used an H2 in-memory database (rather than MySQL, to avoid a separate DB server install) with `data.sql` for seed data, demonstrating the same ORM flow described in the exercise.

#### Written — JPA vs Hibernate vs Spring Data JPA

Documented that JPA is a specification (no implementation), Hibernate is a concrete ORM implementation of that specification, and Spring Data JPA is a further abstraction on top of an implementation (typically Hibernate) that removes CRUD boilerplate via repository interfaces.

### Key Concepts Learned

- IoC/DI means the framework supplies dependencies to a class rather than the class constructing them itself.
- Setter injection vs. constructor injection — both wire dependencies, differ in immutability and when the dependency is required.
- `@Entity`, `@Table`, `@Id`, `@Column` map a Java class directly to a relational table.
- Spring Boot 3.x uses `jakarta.persistence` imports (not `javax.persistence`), a breaking change from older Spring Boot versions.
- H2 in-memory databases are a fast, zero-install substitute for MySQL during learning/prototyping — `ddl-auto=create` lets Hibernate generate the schema from the entity class itself.

### Tech Stack

Java 17 · Spring Framework 5.3 / Spring Boot 3.2 · Maven · H2 Database

### Project Structure

```
Week02_SpringCore_Maven_SpringDataJPA_Hibernate/
├── SpringCoreMaven/
│   ├── Ex1_BasicSpring/   (pom.xml, applicationContext.xml, BookService, BookRepository)
│   ├── Ex2_DI/            (setter-injected BookService)
│   └── Ex4_MavenSetup/    (pom.xml with Spring Context/AOP/WebMVC + Java 1.8 compiler plugin)
├── SpringDataJPA_Hibernate/
│   ├── QuickEx/           (Country entity, CountryRepository, CountryService, H2 config)
│   ├── CountryCRUD/       (optional — not attempted)
│   └── JPA_vs_Hibernate.md
└── screenshots/
```

### Running Locally

```bash
cd SpringCoreMaven/Ex1_BasicSpring
mvn compile exec:java -Dexec.mainClass="com.library.App"

cd ../../SpringDataJPA_Hibernate/QuickEx
mvn spring-boot:run
```

---

## Week 3 — Spring REST using Spring Boot 3

_Digital Nurture 5.0 — Java FSE Track_

Covers building RESTful web services with Spring Boot 3, from a basic project scaffold through to a functioning JWT authentication endpoint. All 6 mandatory exercises were split into separate, independently runnable Maven projects for clarity during evaluation.

### Hands-On Exercises Completed

|  #  | Exercise                                                 |
| :-: | :------------------------------------------------------- |
|  1  | Create a Spring Web Project using Maven                  |
|  2  | Spring Core – Load Country from Spring Configuration XML |
|  3  | Hello World RESTful Web Service                          |
|  4  | REST - Country Web Service                               |
|  5  | REST - Get country based on country code                 |
|  6  | Create authentication service that returns JWT           |

### What Each Exercise Covered

#### Ex1 — Create a Spring Web Project using Maven

Scaffolded `spring-learn`, a Spring Boot 3 project with `spring-boot-starter-web` and DevTools, including startup logging to confirm `main()` execution.

#### Ex2 — Load Country from Spring Configuration XML

Modeled 4 countries (US, DE, IN, JP) as Spring beans in `country.xml`, then read and displayed one via `ClassPathXmlApplicationContext` and `context.getBean()` — reinforcing how Spring's IoC container resolves beans from XML config.

#### Ex3 — Hello World RESTful Web Service

First REST endpoint: `GET /hello` returning a hardcoded `"Hello World!!"` string via `@RestController` and `@GetMapping`, with start/end logging inside the handler method.

#### Ex4 — REST - Country Web Service

`GET /country` returns India's details as JSON, loading the bean from `country.xml` inside the controller method — demonstrating how a Spring bean becomes a JSON HTTP response automatically via Spring's message converters.

#### Ex5 — REST - Get country based on country code

`GET /countries/{code}` performs a case-insensitive country lookup using `@PathVariable` and a Java Stream/lambda filter (`equalsIgnoreCase`) over the full country list — moved into a dedicated `CountryService` for separation of concerns.

#### Ex6 — Authentication service that returns JWT

`GET /authenticate` reads a Basic Auth header, decodes the Base64 `username:password`, validates hardcoded credentials, and — if valid — generates and returns a signed JWT using the `jjwt` library, matching the exact `curl -u user:pwd ...` flow described in the exercise.

### Key Concepts Learned

- `@RestController` + `@GetMapping`/`@RequestMapping` are the core building blocks of a Spring REST API.
- `@PathVariable` extracts dynamic URL segments for parameterized endpoints.
- Spring automatically serializes returned Java objects (or Maps) to JSON — no manual conversion needed.
- Basic Authentication sends credentials as `Base64(username:password)` in the `Authorization` header — decoding this is the first step of any custom auth flow.
- JWTs are self-contained, signed tokens — once issued, the server doesn't need to store session state to validate them.

### Tech Stack

Java 17 · Spring Boot 3.2 · Spring Web · Spring Security · JJWT (JSON Web Token library) · Maven

### Project Structure

```
Week03_SpringREST_SpringBoot3/
├── Ex1_SpringWebProject/
├── Ex2_LoadCountryXML/
├── Ex3_HelloWorldREST/
├── Ex4_CountryWebService/
├── Ex5_CountryByCode/
├── Ex6_JWTAuth/
└── screenshots/
```

### Running Locally (once Maven is installed)

```bash
cd Ex3_HelloWorldREST
mvn spring-boot:run
# then visit http://localhost:8083/hello

cd ../Ex6_JWTAuth
mvn spring-boot:run
# then: curl -u user:pwd http://localhost:8090/authenticate
```

---

## Week 4 — Microservices with Spring Boot 3 | Account & Loan Services

_Digital Nurture 5.0 — .NET Full Stack Engineer Track_

Two independent Spring Boot RESTful microservices for a bank system, built to demonstrate how splitting an application into separate deployable services works in practice — including the classic "port already in use" problem that comes with running multiple standalone services.

### Project Overview

Instead of one monolithic Spring Boot app handling both accounts and loans, this exercise splits the functionality into two completely independent Maven projects, each with its own `pom.xml`, own `main()` entry point, and own REST controller. Neither service has a database or calls the other — both return hardcoded dummy responses — so the focus stays entirely on the mechanics of running multiple Spring Boot applications side by side.

### What Was Built

| Service         |      Port       | Endpoint                 | Purpose                               |
| :-------------- | :-------------: | :----------------------- | :------------------------------------ |
| Account Service | 8080 (default)  | `GET /accounts/{number}` | Returns dummy savings account details |
| Loan Service    | 8081 (explicit) | `GET /loans/{number}`    | Returns dummy car loan details        |

#### Account Microservice

A standalone Spring Boot app (`com.cognizant.account`) generated via Spring Initializr with Spring Web and Spring Boot DevTools. `AccountController` exposes a single GET endpoint that accepts an account number as a path variable and returns a hardcoded JSON response (number, type, balance) — no persistence layer involved.

#### Loan Microservice

A second, entirely separate Spring Boot app (`com.cognizant.loan`), structured identically to the Account service but returning loan details instead (number, type, loan amount, EMI, tenure).

### The Core Learning Point: Port Conflicts

Spring Boot apps default to port `8080`. Running the Account service first claims that port. Attempting to start the Loan service afterward — without any port configuration — fails immediately with a **"port already in use" (bind exception)** error, because both services try to claim the same port independently.

The fix: set `server.port=8081` in the Loan service's `application.properties`, giving it a distinct port so both services can run simultaneously.

> This is the exact problem API gateways and service discovery tools (like Eureka) are built to solve at scale — this exercise reproduces the raw, manual version of that problem first, before any tooling is introduced.

### Key Concepts Demonstrated

- Splitting a single application's responsibilities into independent, deployable microservices
- Each microservice as a self-contained Maven project with its own build lifecycle (`mvn clean package`, `mvn spring-boot:run`)
- Default vs. explicit port configuration via `application.properties`
- Diagnosing and resolving a live port-binding conflict between two running services
- RESTful GET endpoints with path variables (`@PathVariable`) returning JSON
- Running and monitoring multiple Spring Boot console instances in parallel (via Eclipse's console-switching or separate terminals)

### Tech Stack

Java 17 · Spring Boot 3.2.5 · Spring Web · Spring Boot DevTools · Maven

### Project Structure

```
Week04_SonarQube_Microservices/
└── Microservices/
    ├── account/
    │   ├── pom.xml
    │   └── src/main/
    │       ├── java/com/cognizant/account/
    │       │   ├── AccountApplication.java
    │       │   └── controller/AccountController.java
    │       └── resources/
    │           └── application.properties
    └── loan/
        ├── pom.xml
        └── src/main/
            ├── java/com/cognizant/loan/
            │   ├── LoanApplication.java
            │   └── controller/LoanController.java
            └── resources/
                └── application.properties
```

### Running Locally

**Terminal 1 — Account service:**

```bash
cd Microservices/account
mvn spring-boot:run
```

Visit `http://localhost:8080/accounts/00987987973432`

**Terminal 2 — Loan service (keep Account running):**

```bash
cd Microservices/loan
mvn spring-boot:run
```

Visit `http://localhost:8081/loans/H00987987972342`

Both services run independently and simultaneously, each on its own port.

### Sample Responses

**Account Service** — `GET /accounts/00987987973432`

```json
{
  "number": "00987987973432",
  "type": "savings",
  "balance": 234343
}
```

**Loan Service** — `GET /loans/H00987987972342`

```json
{
  "number": "H00987987972342",
  "type": "car",
  "loan": 400000,
  "emi": 3258,
  "tenure": 18
}
```

---

## Week 5 — Angular (v20) Hands-On | Student Course Portal

_Digital Nurture 5.0 — .NET Full Stack Engineer Track_

A single Angular application built incrementally across multiple hands-on exercises, covering components, data binding, directives, pipes, services, dependency injection, routing, guards, and reactive forms.

### Project Overview

**Student Course Portal** is a college-system SPA where students can browse courses, view course details, enroll/unenroll, check their profile, and submit an enrollment request through a validated reactive form.

Rather than building separate demo projects per topic, every hands-on exercise added a new capability on top of the same running application — mirroring how features are layered onto a real production app.

### Hands-On Exercises Completed

|  #  | Topic                                                   |
| :-: | :------------------------------------------------------ |
|  1  | Project Setup, Structure & First Components             |
|  2  | Data Binding, Lifecycle Hooks & Component Communication |
|  3  | Directives & Pipes — Built-in and Custom                |
|  5  | Reactive Forms — FormBuilder, Validators, FormArray     |
|  6  | Services & Dependency Injection                         |
|  7  | Routing — Guards, Lazy Loading & Route Params           |

### What Each Hands-On Covered

#### Hands-On 1 — Project Setup & First Components

Scaffolded the Angular workspace with `ng new`, explored every generated file (`angular.json`, `tsconfig.json`, `main.ts`, `app.config.ts`, etc.), and created the first components: `Header`, `Home`, `CourseList`, `StudentProfile`. Learned the purpose of build budgets in `angular.json` and how `ng build` produces the `dist/` bundle.

#### Hands-On 2 — Data Binding, Lifecycle Hooks & Component Communication

Implemented all four Angular binding types — interpolation, property binding, event binding, and two-way binding with `[(ngModel)]` — on the Home page. Added `ngOnInit`/`ngOnDestroy` lifecycle hooks to log component initialization/teardown, and built the `CourseCard` component using `@Input()`/`@Output()` with `EventEmitter` for parent-child communication, including `ngOnChanges` to track input value changes.

#### Hands-On 3 — Directives & Pipes

Used structural directives (`*ngIf`/else, `*ngFor` with `trackBy`, `*ngSwitch`) to control the course list's loading state, empty state, and grade-status badges. Applied `[ngClass]` and `[ngStyle]` for conditional styling (enrolled cards, credit-based highlighting, grade-status border colors). Built a custom `appHighlight` attribute directive using `@HostListener` for hover effects, and a custom `creditLabel` pipe implementing `PipeTransform` to format credit counts into readable text.

#### Hands-On 6 — Services & Dependency Injection

Extracted course and enrollment data into `CourseService` and `EnrollmentService`, both provided at root level (`providedIn: 'root'`) as app-wide singletons. Demonstrated service-to-service injection (`EnrollmentService` depends on `CourseService`) and verified the singleton pattern by adding a course from one component and seeing the count update live in another. Also built a `NotificationService` provided at the component level to demonstrate scoped, non-singleton DI.

#### Hands-On 7 — Routing, Guards & Lazy Loading

Configured all portal routes including a dynamic `courses/:id` detail page (read via `ActivatedRoute`), a search feature using query parameters, and a wildcard 404 route. Implemented `CanActivate` (`authGuard`) to protect the Profile and Enrollment routes behind a login check, and `CanDeactivate` (`unsavedChangesGuard`) to warn users about unsaved form changes before navigating away. The reactive enrollment form route uses `loadComponent()` for lazy loading — the modern standalone-API equivalent of the PDF's `loadChildren` + NgModule approach, verified by checking that a separate JS chunk downloads only on first visit.

#### Hands-On 5 — Reactive Forms

Rebuilt the enrollment form using `FormBuilder`/`FormGroup` instead of template-driven forms, giving full control of form structure and validation from the component class. Added a custom synchronous validator (`noCourseCode`) rejecting course codes starting with "XX", and a custom asynchronous validator (`simulateEmailCheck`) simulating a server-side "email already taken" check with an 800ms delay. Used `FormArray` to let students dynamically add/remove additional course entries.

### Key Concepts Demonstrated

- Standalone components (no NgModules) — Angular 20's default architecture
- Signals (`signal()`) for zoneless-compatible reactive state
- One-way vs. two-way data binding
- Component lifecycle: `ngOnInit`, `ngOnChanges`, `ngOnDestroy`
- Parent → child (`@Input`) and child → parent (`@Output`/`EventEmitter`) communication
- Structural vs. attribute directives, and writing custom versions of both
- Pure pipes and `PipeTransform`
- Singleton vs. component-scoped dependency injection
- Route parameters, query parameters, and route guards
- Lazy-loaded standalone routes
- Reactive forms: `FormBuilder`, `FormGroup`, `FormArray`, sync and async custom validators

### A Real-World Debugging Note

While building Hands-On 3, the Course List page got permanently stuck on "Loading courses..." even though the underlying data loaded correctly. The root cause: this project runs in **zoneless mode** (no Zone.js polyfill), which Angular 20+ increasingly defaults to for new projects. In zoneless mode, mutating a plain class property inside a `setTimeout` callback doesn't automatically trigger a view update — Angular needs an explicit signal of change. The fix was switching the affected state (`courses`, `isLoading`, `selectedCourseId`) to Angular's `signal()` API, which notifies the framework directly without relying on Zone.js patching async APIs. This turned out to be more representative of current production Angular than the template-driven approach the original exercise assumed.

### Tech Stack

Angular v20 · TypeScript · Standalone Components · Signals · Reactive Forms · Angular Router

### Project Structure

```
student-course-portal/
├── src/app/
│   ├── components/
│   │   ├── header/
│   │   ├── course-card/
│   │   ├── course-summary-widget/
│   │   └── notification/
│   ├── pages/
│   │   ├── home/
│   │   ├── course-list/
│   │   ├── course-detail/
│   │   ├── student-profile/
│   │   ├── reactive-enrollment-form/
│   │   └── not-found/
│   ├── directives/
│   │   └── highlight.ts
│   ├── pipes/
│   │   └── credit-label-pipe.ts
│   ├── services/
│   │   ├── course.ts
│   │   ├── enrollment.ts
│   │   ├── auth.ts
│   │   └── notification.ts
│   ├── guards/
│   │   ├── auth-guard.ts
│   │   └── unsaved-changes-guard.ts
│   ├── models/
│   │   └── course.model.ts
│   └── app.routes.ts
└── notes.txt
```

### Running Locally

```bash
npm install
ng serve
```

Navigate to `http://localhost:4200/`.
