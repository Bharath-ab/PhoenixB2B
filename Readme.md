
# Phoenix B2B

Phoenix B2B Application


## Dependencies
```
JDK 21
Maven

        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <jackson.version>2.17.0</jackson.version>
        <restassured.version>5.4.0</restassured.version>
        <junit.version>5.10.2</junit.version>
        <cucumber.version>7.16.1</cucumber.version>
        <TestNg.version>7.9.0</TestNg.version>
        <extentReport.version>5.1.1</extentReport.version>
        <faker.version>1.0.2</faker.version>
        <apachecollections.version>4.5.0-M1</apachecollections.version>
        <junit-platform.version>1.10.2</junit-platform.version>
```
## Running Tests

`
Running a single scenario or feature from the CLI
To select a single scenario or feature the cucumber.features property can be used. Because this property will cause Cucumber to ignore any other selectors from JUnit, it is prudent to execute only the Cucumber engine.
`


To select the scenario on line 10 of the 1.LoginAPI.feature file use:

Maven

```
mvn test -Dsurefire.includeJUnit5Engines=cucumber -Dcucumber.plugin=pretty -Dcucumber.features="src/test/resources/apifeatures/1.LoginAPI.feature"
```

To Run Multiple feature
```
mvn test -Dsurefire.includeJUnit5Engines=cucumber -Dcucumber.plugin=pretty -Dcucumber.features=src/test/resources/apifeatures
```


[Junit5 Reference](https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-junit-platform-engine#tags)

[Configuations Options](https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-junit-platform-engine#configuration-options)