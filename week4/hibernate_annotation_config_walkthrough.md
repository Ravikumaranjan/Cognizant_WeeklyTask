# Hibernate Annotation Configuration — Hands-on 3 Walkthrough

**Reference:** TutorialsPoint Hibernate Annotations — `Employee` entity mapped with JPA/Hibernate annotations instead of an `.hbm.xml` file, with connection details still supplied via `hibernate.cfg.xml`.

Annotation-based mapping is the modern alternative to Part 2's XML mapping file (`Employee.hbm.xml`). The **connection/dialect config** (`hibernate.cfg.xml`) still exists — only the *class-to-table* mapping moves out of a separate XML file and directly onto the Java class itself.

---

## Part 1 — Object-to-Relational Mapping in the `Employee` Persistence Class

```java
import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

   @Id
   @GeneratedValue
   @Column(name = "id")
   private int id;

   @Column(name = "first_name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "salary")
   private int salary;

   public Employee() {}

   public Employee(String firstName, String lastName, int salary) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.salary = salary;
   }

   // getters and setters for id, firstName, lastName, salary
}
```

The mapping information that used to live in `Employee.hbm.xml` (Hands-on 2) is now expressed **inline, as metadata on the class itself**:

| Concern | XML mapping (Hands-on 2) | Annotation mapping (Hands-on 3) |
|---|---|---|
| Bind class to table | `<class name="..." table="EMPLOYEE">` | `@Entity` + `@Table(name = "EMPLOYEE")` |
| Primary key property | `<id name="id" column="id">` | `@Id` on the field |
| Key generation strategy | `<generator class="native"/>` | `@GeneratedValue` |
| Field-to-column mapping | `<property name="..." column="..."/>` | `@Column(name = "...")` |

The net effect is identical — Hibernate still builds the same internal metadata model describing how `Employee` objects correspond to rows in `EMPLOYEE` — but the mapping travels **with the class** rather than in a separate file that has to be kept in sync with it. This is generally considered easier to maintain since the mapping and the class definition can't drift apart, though it does tie the POJO to `javax.persistence`/Hibernate annotation imports.

---

## Part 2 — The Annotations, One by One

### 2.1 `@Entity`

```java
@Entity
public class Employee { ... }
```
- Marks a plain Java class as a **persistent entity** that Hibernate should manage.
- This is the annotation equivalent of declaring `<class name="com.example.Employee">` in the `.hbm.xml` file — it's what tells Hibernate "this class has a corresponding database table and should be included in the mapping metadata."
- Every field in the class that should *not* be persisted can be excluded with `@Transient`; everything else is picked up as a mapped property by default (or you can set `access` explicitly).

### 2.2 `@Table`

```java
@Table(name = "EMPLOYEE")
```
- Specifies which **table** the entity maps to.
- Optional — if omitted, Hibernate defaults to using the class name as the table name. It's used here because the class is `Employee` but the desired table name is `EMPLOYEE` (or to match an existing schema's naming convention, e.g. `emp_master`, plus optional `schema`/`catalog` attributes).
- Equivalent to the `table="EMPLOYEE"` attribute on `<class>` in the XML mapping.

### 2.3 `@Id`

```java
@Id
private int id;
```
- Marks this field as the **primary key** of the entity.
- Every entity must have exactly one field (or property) annotated `@Id` (or a composite key via `@EmbeddedId`/`@IdClass`).
- Equivalent to `<id name="id" column="id">` in the XML mapping.

### 2.4 `@GeneratedValue`

```java
@GeneratedValue
```
- Tells Hibernate the primary key value should be **generated automatically** rather than supplied by the application.
- Equivalent to `<generator class="native"/>` in the XML mapping.
- Common generation strategies (set via `strategy = GenerationType.XXX`):
  - `AUTO` (default) — Hibernate picks a strategy appropriate to the underlying database.
  - `IDENTITY` — relies on an auto-increment/identity column.
  - `SEQUENCE` — uses a database sequence (common on Oracle/PostgreSQL).
  - `TABLE` — simulates a sequence using a separate table, for portability across databases that lack native sequences.

### 2.5 `@Column`

```java
@Column(name = "first_name")
private String firstName;
```
- Maps a specific field to a specific **column**, and optionally constrains it (`length`, `nullable`, `unique`, `precision`, etc.).
- Equivalent to `<property name="firstName" column="first_name" type="string"/>` in the XML mapping.
- If omitted entirely, Hibernate maps the field to a column with the same name as the field — `@Column` is typically used when the Java field name and the database column name differ (as with `firstName` vs `first_name`), or when extra constraints need to be declared.

---

## Part 3 — Hibernate Configuration (`hibernate.cfg.xml`)

Even with annotation-based mapping, you still need a configuration file to tell Hibernate **how to reach the database** and **which annotated classes to load**:

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

      <!-- Annotated class, instead of a <mapping resource="..."> XML file -->
      <mapping class="com.example.Employee"/>

   </session-factory>
</hibernate-configuration>
```

Notice the only structural difference from Hands-on 2's config file is the last line: `<mapping class="com.example.Employee"/>` (pointing directly at the annotated Java class) instead of `<mapping resource="Employee.hbm.xml"/>` (pointing at a separate XML mapping file). Everything about *connecting to the database* stays exactly the same.

### 3.1 Dialect

```xml
<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
```
- Tells Hibernate which **SQL dialect** to generate — since different databases have slightly different SQL syntax, data types, and pagination/locking mechanisms, Hibernate needs to know the target (e.g. `MySQLDialect`, `Oracle12cDialect`, `PostgreSQLDialect`).
- This is what allows the *same* Java/annotation code to run against different databases just by swapping the dialect (and driver/URL) — the entity mapping itself doesn't change.

### 3.2 Driver

```xml
<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
```
- The fully qualified class name of the **JDBC driver** for the target database.
- Hibernate uses plain JDBC under the hood to talk to the database, so this driver must be present on the classpath; Hibernate loads it to open connections.

### 3.3 Connection URL

```xml
<property name="hibernate.connection.url">jdbc:mysql://localhost/EMPLOYEE</property>
```
- The JDBC connection string — identifies the **database server, port, and specific database/schema** to connect to (here, host `localhost`, database `EMPLOYEE`).

### 3.4 Username / Password

```xml
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">password</property>
```
- Credentials used to **authenticate** the JDBC connection against the database server.
- In production setups these are typically externalized (environment variables, a secrets manager, or a connection-pool/datasource configuration) rather than hardcoded in `hibernate.cfg.xml`.

---

## Part 4 — End-to-End Flow (Unchanged from XML Mapping)

The runtime API — `SessionFactory`, `Session`, `Transaction`, `beginTransaction()`, `commit()`, `rollback()`, `session.save()`, `session.createQuery().list()`, `session.get()`, `session.delete()` — behaves **identically** whether the entity is mapped via `.hbm.xml` or via annotations, because that mapping is only consumed at `SessionFactory` build time:

```java
SessionFactory factory = new Configuration().configure().buildSessionFactory();
Session session = factory.openSession();
Transaction tx = session.beginTransaction();

Employee employee = new Employee("Zara", "Ali", 1000);
Integer employeeID = (Integer) session.save(employee);

tx.commit();
session.close();
```

Once the `SessionFactory` is built (from `hibernate.cfg.xml` plus the registered class), Hibernate has the exact same internal metadata regardless of whether that metadata came from parsing an `.hbm.xml` file or scanning annotations on the class. Everything covered in Hands-on 2 about `save()`, `get()`, dirty checking on update, `delete()`, and HQL queries applies without modification here.

---

### Discussion / Hands-on Prompts for the Session

- What would happen if `@Table` were omitted from `Employee` — what table name would Hibernate assume?
- Why might a team choose `GenerationType.IDENTITY` vs `GenerationType.SEQUENCE` — what does that decision depend on?
- If the team switched databases from MySQL to PostgreSQL, which specific `hibernate.cfg.xml` properties would need to change, and which annotations (if any) would need to change?
- What are the practical trade-offs between XML mapping (Hands-on 2) and annotation mapping (Hands-on 3) — e.g. for teams that don't control the entity source code, or want mapping changes without recompiling?
