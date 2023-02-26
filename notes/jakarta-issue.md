[В чем разница пакетов javax и jakarta?](https://ru.stackoverflow.com/questions/1434938/В-чем-разница-пакетов-javax-и-jakarta)

### Jakarta issue

If you get an error message saying "Dependency 'jakarta.servlet:jakarta.servlet-api:5.0.0' not found" when trying to
update your Jakarta Servlet API dependency, it could be due to a couple of reasons:

1. The dependency is not available in the Maven Central Repository.
2. Your IDE or build tool may not be configured to use the latest version of Maven, which supports the Jakarta EE
   namespace. If you are using an older version of Maven, you may need to add the following plugin to your pom.xml file
   to enable support for the new namespace (xml sample) and try adding the dependency again.

```xml

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-war-plugin</artifactId>
            <version>3.2.3</version>
            <configuration>
                <failOnMissingWebXml>false</failOnMissingWebXml>
                <packagingExcludes>WEB-INF/lib/tomcat-*.jar</packagingExcludes>
                <webXml>${basedir}/src/main/webapp/WEB-INF/web.xml</webXml>
                <failOnMissingJavaVersion>false</failOnMissingJavaVersion>
            </configuration>
        </plugin>
    </plugins>
</build>
```