# Exercise 1: Setting Up JUnit

## Scenario

Set up JUnit in a Java project to enable writing and running unit tests.

---

## Step 1: Create a New Java Project

Create a new Java project in your preferred IDE.

Examples:

- IntelliJ IDEA
- Eclipse
- Visual Studio Code

---

## Step 2: Add JUnit Dependency

If using Maven, add the following dependency inside the `pom.xml` file.

```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
```

---

## Step 3: Create a Test Class

Create a Java test class inside the `src/test/java` folder.

Example:

```java
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAddition() {
        int result = 5 + 3;
        assertEquals(8, result);
    }
}
```

---

## Step 4: Run the Test

Run the test using your IDE or Maven.

If using Maven:

```bash
mvn test
```

---

## Expected Output

```
Tests run: 1
Failures: 0
Errors: 0

BUILD SUCCESS
```

---

## Benefits of JUnit

- Automates unit testing.
- Helps identify bugs early.
- Improves code quality.
- Simplifies regression testing.
- Integrates easily with Maven and Gradle.

---

## Conclusion

JUnit is one of the most widely used Java testing frameworks. It allows developers to write and execute unit tests efficiently, ensuring that application components work as expected.