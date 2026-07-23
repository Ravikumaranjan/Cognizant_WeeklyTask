import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    // Create Logger Object
    private static final Logger logger =
            LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {

        logger.info("Application Started");

        logger.warn("This is a warning message.");

        logger.error("This is an error message.");

        logger.info("Application Finished");
    }
}

// ---------------pom.xml
// -------------------------------------------------
// -----------------------------------------------
// <project xmlns="http://maven.apache.org/POM/4.0.0"
//          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//          xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
//          http://maven.apache.org/xsd/maven-4.0.0.xsd">

//     <modelVersion>4.0.0</modelVersion>

//     <groupId>com.cognizant</groupId>
//     <artifactId>LoggingExample</artifactId>
//     <version>1.0</version>

//     <dependencies>

//         <!-- SLF4J API -->
//         <dependency>
//             <groupId>org.slf4j</groupId>
//             <artifactId>slf4j-api</artifactId>
//             <version>1.7.30</version>
//         </dependency>

//         <!-- Logback Implementation -->
//         <dependency>
//             <groupId>ch.qos.logback</groupId>
//             <artifactId>logback-classic</artifactId>
//             <version>1.2.3</version>
//         </dependency>

//     </dependencies>

// </project>