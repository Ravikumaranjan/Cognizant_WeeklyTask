# Hibernate XML Configuration — Hands-on 2 Walkthrough

**Reference:** TutorialsPoint Hibernate Examples — classic `Employee` POJO + `hibernate.cfg.xml` + `.hbm.xml` sample.

This walkthrough is built around the standard example: an `Employee` Java class mapped to an `EMPLOYEE` table, accessed through a `ManageEmployee` class that performs create / read / update / delete (CRUD) operations.

---

## Part 1 — Object-to-Relational Mapping in the XML Configuration

Hibernate needs two things to bridge Java objects and database tables:

1. **`hibernate.cfg.xml`** — tells Hibernate *how to connect* to the database and *which mapping files* to load.
2. **`<ClassName>.hbm.xml`** — tells Hibernate *how a specific class maps* to a specific table, field by field.

### 1.1 The POJO (Plain Old Java Object)

```java
public class Employee {
   private int id;
   private String firstName;
   private String lastName;
   private int salary;

   // getters and setters for all properties
}
```

A POJO for Hibernate has no special interface to implement — it just needs a no-argument constructor and getter/setter pairs for each persistent property. This is the "object" side of the mapping.

### 1.2 The mapping file — `Employee.hbm.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD//EN"
 "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">

<hibernate-mapping>
   <class name="com.example.Employee" table="EMPLOYEE">

      <meta attribute="class-description">
         This class contains the employee detail.
      </meta>

      <id name="id" type="int" column="id">
         <generator class="native"/>
      </id>

      <property name="firstName" column="first_name" type="string"/>
      <property name="lastName"  column="last_name"  type="string"/>
      <property name="salary"    column="salary"     type="int"/>

   </class>
</hibernate-mapping>
```

How this maps object → relational:

| XML element | What it does |
|---|---|
| `<class name="..." table="...">` | Binds the fully qualified Java class to a specific database table. |
| `<id name="id" column="id">` | Identifies the primary key property in Java and its corresponding primary key column. Every persistent class needs exactly one. |
| `<generator class="native">` | Tells Hibernate how the primary key value is produced — `native` delegates to the underlying database's identity/sequence mechanism (auto-increment in MySQL, sequence in Oracle, etc.). Other options include `increment`, `sequence`, `assigned`, `uuid`. |
| `<property name="..." column="..." type="...">` | Maps one Java field/property to one table column, with an explicit Hibernate type (`string`, `int`, `long`, `date`, etc.) that governs how Java↔SQL type conversion happens. |
| `<meta>` | Optional documentation metadata, not functional. |

The key idea: **the mapping file is a declarative translation table** — it removes the need to hand-write SQL `INSERT`/`SELECT`/`UPDATE`/`DELETE` statements or JDBC `ResultSet` handling. Hibernate reads this XML once (at `SessionFactory` build time) and uses it to generate SQL dynamically for every CRUD call.

### 1.3 The configuration file — `hibernate.cfg.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
   "-//Hibernate/Hibernate Configuration DTD//EN"
   "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
   <session-factory>

      <property name="hibernate.dialect">
         org.hibernate.dialect.MySQLDialect
      </property>
      <property name="hibernate.connection.driver_class">
         com.mysql.jdbc.Driver
      </property>
      <property name="hibernate.connection.url">
         jdbc:mysql://localhost/EMPLOYEE
      </property>
      <property name="hibernate.connection.username">root</property>
      <property name="hibernate.connection.password">password</property>

      <property name="hibernate.hbm2ddl.auto">update</property>
      <property name="hibernate.show_sql">true</property>

      <!-- Mapping files -->
      <mapping resource="Employee.hbm.xml"/>

   </session-factory>
</hibernate-configuration>
```

Key responsibilities of this file:
- **Connection properties** — driver, URL, credentials — how to physically reach the database.
- **`hibernate.dialect`** — which SQL "flavor" to generate (MySQL, Oracle, PostgreSQL, etc.), since SQL syntax differs slightly across vendors.
- **`hibernate.hbm2ddl.auto`** — optional schema-management behavior (`validate`, `update`, `create`, `create-drop`).
- **`<mapping resource="...">`** — registers each `.hbm.xml` file so the `SessionFactory` knows every class it's responsible for persisting.

**Summary of the mapping flow:** `hibernate.cfg.xml` (connection + dialect + list of mapping files) → each `.hbm.xml` (class ↔ table, property ↔ column) → Hibernate builds an internal metadata model it uses to generate SQL on demand.

---

## Part 2 — The End-to-End Runtime API

The classic flow, taken from the `ManageEmployee` example, looks like this:

```java
public class ManageEmployee {
   private static SessionFactory factory;

   public static void main(String[] args) {
      factory = new Configuration().configure().buildSessionFactory();

      ManageEmployee ME = new ManageEmployee();

      Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
      ME.listEmployees();
      ME.updateEmployee(empID1, 5000);
      ME.deleteEmployee(empID1);
      ME.listEmployees();
   }
   // ... CRUD methods below
}
```

### 2.1 `SessionFactory`

- Built **once per application** (or once per database) from `hibernate.cfg.xml`: `new Configuration().configure().buildSessionFactory();`
- It is a **heavyweight, thread-safe factory object** — expensive to create, so it's created a single time and reused for the application's lifetime.
- It holds the compiled mapping metadata (from all the `.hbm.xml` files) and second-level cache settings.
- Its one real job at runtime is to **hand out `Session` objects**.

### 2.2 `Session`

- Created per unit of work: `Session session = factory.openSession();`
- Represents a **single-threaded, short-lived conversation** between the application and the database — roughly analogous to a JDBC `Connection`, but object-oriented.
- All persistence operations (`save`, `get`, `update`, `delete`, `createQuery`, etc.) are invoked through a `Session`.
- The `Session` also maintains the **first-level cache** (the "persistence context") — objects loaded/saved in a session are tracked so Hibernate can detect changes and avoid redundant database hits within that session.
- Should be closed once the unit of work finishes: `session.close();`

### 2.3 `Transaction`

- Wraps a unit of work in an atomic boundary: `Transaction tx = session.beginTransaction();`
- Hibernate operations against the database are expected to run inside a transaction — even a single `save()` should be transactional so it can be committed or rolled back as a whole.
- A `Transaction` object is obtained from the `Session`, and it delegates to the underlying JDBC transaction (or JTA, in managed environments).

### 2.4 `beginTransaction()`

```java
Transaction tx = session.beginTransaction();
```
- Marks the **start** of an atomic block of work.
- Everything done through the `Session` after this call is provisional until `commit()` or `rollback()` is called.
- Must be paired with exactly one `commit()` or `rollback()`.

### 2.5 `commit()`

```java
tx.commit();
```
- **Flushes** any pending changes tracked in the session (INSERTs/UPDATEs/DELETEs generated from the objects you manipulated) to the database, and then commits the underlying database transaction, making the changes permanent.
- This is the point at which Hibernate actually converts your object operations into SQL and sends it to the DB (though `flush()` can happen earlier too).

### 2.6 `rollback()`

```java
tx.rollback();
```
- Used to **discard** all changes made in the current transaction — typically inside a `catch` block when an exception occurs.
- Typical defensive pattern:

```java
Transaction tx = null;
try {
   tx = session.beginTransaction();
   // ... session.save(), session.update(), etc.
   tx.commit();
} catch (HibernateException e) {
   if (tx != null) tx.rollback();
   e.printStackTrace();
} finally {
   session.close();
}
```
- Ensures the database is never left in a half-updated, inconsistent state if something fails mid-operation.

### 2.7 `session.save()`

```java
public Integer addEmployee(String fname, String lname, int salary) {
   Session session = factory.openSession();
   Transaction tx = null;
   Integer employeeID = null;
   try {
      tx = session.beginTransaction();
      Employee employee = new Employee(fname, lname, salary);
      employeeID = (Integer) session.save(employee);
      tx.commit();
   } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
   } finally {
      session.close();
   }
   return employeeID;
}
```
- **Inserts** a new record corresponding to the given object.
- Generates the primary key according to the `<generator>` strategy declared in the mapping file, and returns that generated identifier.
- The object becomes "persistent" — it's now tracked by the session.

### 2.8 `session.createQuery().list()`

```java
public void listEmployees() {
   Session session = factory.openSession();
   Transaction tx = null;
   try {
      tx = session.beginTransaction();
      List employees = session.createQuery("FROM Employee").list();
      for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
         Employee employee = (Employee) iterator.next();
         System.out.print("First Name: " + employee.getFirstName());
         System.out.print("  Last Name: " + employee.getLastName());
         System.out.println("  Salary: " + employee.getSalary());
      }
      tx.commit();
   } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
   } finally {
      session.close();
   }
}
```
- `createQuery(...)` takes **HQL (Hibernate Query Language)** — note `FROM Employee` refers to the **Java class name**, not the table name. HQL queries operate on the object model, and Hibernate translates them into the correct SQL against `EMPLOYEE` using the mapping metadata.
- `.list()` executes the query and returns the full result set as a `List` of populated objects (already-instantiated `Employee` objects, not raw rows).
- This replaces manual JDBC `ResultSet` iteration and manual object population.

### 2.9 `session.get()`

```java
Employee employee = (Employee) session.get(Employee.class, employeeID);
```
- **Retrieves a single object by its primary key.**
- Returns `null` immediately if no row matches (unlike `session.load()`, which throws an exception for a missing row and uses lazy-loading proxies).
- Typically used before an update or delete, to first bring the object into the session so Hibernate can track and later persist changes made to it (as seen in `updateEmployee` below).

```java
public void updateEmployee(Integer employeeID, int salary) {
   Session session = factory.openSession();
   Transaction tx = null;
   try {
      tx = session.beginTransaction();
      Employee employee = (Employee) session.get(Employee.class, employeeID);
      employee.setSalary(salary);
      tx.commit();
   } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
   } finally {
      session.close();
   }
}
```
Notice there's no explicit `session.update()` call here — because `employee` is a managed/persistent object within the active session, Hibernate's **automatic dirty checking** detects the change to `salary` and issues the `UPDATE` SQL automatically at `commit()` time.

### 2.10 `session.delete()`

```java
public void deleteEmployee(Integer employeeID) {
   Session session = factory.openSession();
   Transaction tx = null;
   try {
      tx = session.beginTransaction();
      Employee employee = (Employee) session.get(Employee.class, employeeID);
      session.delete(employee);
      tx.commit();
   } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
   } finally {
      session.close();
   }
}
```
- Marks the given persistent object for **deletion**.
- The object must first be loaded into the session (typically via `get()`), so Hibernate knows exactly which row (by primary key) to remove.
- The actual `DELETE` SQL is issued at `commit()`.

---

## Part 3 — Putting It All Together (End-to-End Flow)

1. `Configuration().configure().buildSessionFactory()` — read `hibernate.cfg.xml` + all registered `.hbm.xml` files once → build `SessionFactory`.
2. `factory.openSession()` — open a `Session` for one unit of work.
3. `session.beginTransaction()` — start a transactional boundary.
4. Perform operations: `save()` / `createQuery().list()` / `get()` + mutate / `delete()`.
5. `tx.commit()` — flush pending SQL and commit; or `tx.rollback()` on failure.
6. `session.close()` — always release the session (typically in a `finally` block).

This is the pattern every CRUD method in the TutorialsPoint example (`addEmployee`, `listEmployees`, `updateEmployee`, `deleteEmployee`) follows identically — only the body between `beginTransaction()` and `commit()` changes.

---

### Discussion / Hands-on Prompts for the Session

- Why does `session.get()` need to be called before an update, even though we never call `session.update()` explicitly?
- What happens if `commit()` is called without a prior `beginTransaction()`?
- What's the difference in behavior between `session.get()` and `session.load()` when the row doesn't exist?
- Why is `SessionFactory` created once, while `Session` is opened per operation/request?
