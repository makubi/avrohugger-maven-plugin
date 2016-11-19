# Avrohugger Maven Plugin

Maven plugin for generating Scala case classes and ADTs from Apache Avro
schemas, datafiles, and protocols.

[![Build Status](https://travis-ci.org/makubi/avrohugger-maven-plugin.svg?branch=master)](https://travis-ci.org/makubi/avrohugger-maven-plugin)
[![Maven Central](https://img.shields.io/maven-central/v/at.makubi.maven.plugin/avrohugger-maven-plugin.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%at.makubi.maven.plugin%22%20AND%20a%3A%22avrohugger-maven-plugin%22)

## Usage

The plugin currently supports one goal:

* **generate-scala-sources**: This generates the Scala sources for the
    Avro schema

```xml
<plugin>
    <groupId>at.makubi.maven.plugin</groupId>
    <artifactId>avrohugger-maven-plugin_${scala.binary.version}</artifactId>
    <version>1.0-SNAPSHOT</version>
    <executions>
        <execution>
            <phase>generate-sources</phase>
            <goals>
                <goal>generate-scala-sources</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

Replace `${scala.binary.version}` with the used Scala binary version,
e.g. `2.11`.

### Usage in conjunction with the scala-maven-plugin

This plugin can be used in conjunction with the
[scala-maven-plugin](http://davidb.github.io/scala-maven-plugin/) to
add the generated Scala sources to your Scala build.

```xml
<plugins>
    <plugin>
        <groupId>at.makubi.maven.plugin</groupId>
        <artifactId>avrohugger-maven-plugin_${scala.binary.version}</artifactId>
        <executions>
            <execution>
                <phase>generate-sources</phase>
                <goals>
                    <goal>generate-scala-sources</goal>
                </goals>
            </execution>
        </executions>
    </plugin>

    <plugin>
        <groupId>net.alchim31.maven</groupId>
        <artifactId>scala-maven-plugin</artifactId>
        <executions>
            <execution>
                <id>add-generated-sources</id>
                <phase>generate-sources</phase>
                <goals>
                    <goal>add-source</goal>
                </goals>
                <configuration>
                    <sourceDir>target/generated-sources</sourceDir>
                </configuration>
            </execution>
            <execution>
                <goals>
                    <goal>compile</goal>
                    <goal>testCompile</goal>
                </goals>
            </execution>
        </executions>
        ...
    </plugin>
</plugins>
```

### Override variables

You can override the following variables in the plugin configuration:

#### sourceDirectory
* Path to the directory containing the Avro schema files
* Defaults to **src/main/resources/avro**

#### outputDirectory
* Path to the output directory for the generated Scala sources
* Defaults to **target/generated-sources**

#### Example

To override the **sourceDirectory** and **outputDirectory**, use

```xml
<plugins>
    <plugin>
        <groupId>at.makubi.maven.plugin</groupId>
        <artifactId>avrohugger-maven-plugin_${scala.binary.version}</artifactId>
        <executions>
            <execution>
                <phase>generate-sources</phase>
                <goals>
                    <goal>generate-scala-sources</goal>
                </goals>
            </execution>
        </executions>
        <configuration>
            <sourceDirectory>src/main/avro</sourceDirectory>
            <outputDirectory>target/classes</outputDirectory>
        </configuration>
    </plugin>
</plugins>
```

## License
The Avrohugger Maven Plugin is released under version 2.0 of the [Apache License](http://www.apache.org/licenses/LICENSE-2.0).
