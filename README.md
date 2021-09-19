# Avrohugger Maven Plugin

Maven plugin for generating Scala case classes and ADTs from Apache Avro
schemas, datafiles, and protocols.

[![Build Status](https://travis-ci.com/makubi/avrohugger-maven-plugin.svg?branch=master)](https://travis-ci.com/makubi/avrohugger-maven-plugin)
[![Maven Central](https://img.shields.io/maven-central/v/at.makubi.maven.plugin/avrohugger-maven-plugin.svg)](https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22at.makubi.maven.plugin%22%20a%3A%22avrohugger-maven-plugin%22)
[![Join the chat at https://gitter.im/julianpeeters/avrohugger](https://badges.gitter.im/julianpeeters/avrohugger.svg)](https://gitter.im/julianpeeters/avrohugger?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

## ![Attention](http://makubi.at/attention_icon.png) Attention: artifactId changed

Please be aware that the **artifactId** changed from **avrohugger-maven-plugin_2.11** to **avrohugger-maven-plugin**.

There is no reason to cross-compile Maven plugins, see http://maven.apache.org/guides/mini/guide-maven-classloading.html#Plugin_Classloaders.

## Usage

The plugin currently supports one goal:

* **generate-scala-sources**: This generates the Scala sources for the
    Avro schema

```xml
<plugin>
    <groupId>at.makubi.maven.plugin</groupId>
    <artifactId>avrohugger-maven-plugin</artifactId>
    <version>1.6</version>
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

### Usage in conjunction with the scala-maven-plugin

This plugin can be used in conjunction with the
[scala-maven-plugin](http://davidb.github.io/scala-maven-plugin/) to
add the generated Scala sources to your Scala build.

```xml
<plugins>
    <plugin>
        <groupId>at.makubi.maven.plugin</groupId>
        <artifactId>avrohugger-maven-plugin</artifactId>
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
                    <sourceDir>${project.build.directory}/generated-sources/avro</sourceDir>
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
* Defaults to **${basedir}/src/main/avro**

#### outputDirectory
* Path to the output directory for the generated Scala sources
* Defaults to **${project.build.directory}/generated-sources/avro**

#### recursive
* Boolean to allow recursion over the specified **sourceDirectory**
* Defaults to **false**

#### limitedNumberOfFieldsInCaseClasses
* Boolean to restrict case class generation for compatibility with scala 2.10
* Defaults to **false**

#### sourceGenerationFormat
* Format for source code generation
* Possible values are **SCAVRO**, **SPECIFIC_RECORD** and **STANDARD**
* Defaults to **SPECIFIC_RECORD**

#### namespaceMapping
* Map namespace in Avro files to custom package name in generated scala files
* Defaults to **Empty List** (Namespace is not modified)

#### fileIncludes
* List of paths to be included in generation
* **fileInclude** elements consist of
  * **path**: The path to be included
  * **matchSyntax**: **STRING**, **GLOB** or **REGEX**
* Paths are relative to the **sourceDirectory**
* An empty list is overwritten with the default setting
* For **GLOB** see https://docs.oracle.com/javase/7/docs/api/java/nio/file/FileSystem.html#getPathMatcher(java.lang.String)
* Defaults to **FileInclude("\*\*", GLOB)** which includes all files

#### typeOverrides
* Override for types for generation
* Possible elements
  * Complex
    * arrayType
    * enumType
    * fixedType
    * mapType
    * protocolType
    * recordType
    * unionType
  * Primitive
    * booleanType
    * bytesType
    * doubleType
    * floatType
    * intType
    * longType
    * nullType
    * stringType
  * Logical
    * timestampMillisType - possible values are `JavaTimeInstant` or `JavaSqlTimestamp`
* Defaults to no overrides

#### Example

To override the **sourceDirectory** and **outputDirectory**, use

```xml
<plugins>
    <plugin>
        <groupId>at.makubi.maven.plugin</groupId>
        <artifactId>avrohugger-maven-plugin</artifactId>
        <executions>
            <execution>
                <phase>generate-sources</phase>
                <goals>
                    <goal>generate-scala-sources</goal>
                </goals>
            </execution>
        </executions>
        <configuration>
            <sourceDirectory>src/main/resources/avro</sourceDirectory>
            <outputDirectory>target/generated-sources</outputDirectory>
        </configuration>
    </plugin>
</plugins>
```

To override the **sourceDirectory**, **outputDirectory**, recurse over **sourceDirectory**, and restrict generated class fields to be compatible with Scala 2.10 use

```xml
<plugins>
    <plugin>
        <groupId>at.makubi.maven.plugin</groupId>
        <artifactId>avrohugger-maven-plugin</artifactId>
        <executions>
            <execution>
                <phase>generate-sources</phase>
                <goals>
                    <goal>generate-scala-sources</goal>
                </goals>
            </execution>
        </executions>
        <configuration>
            <sourceDirectory>src/main/resources/avro</sourceDirectory>
            <outputDirectory>target/generated-sources</outputDirectory>
            <recursive>true</recursive>
            <limitedNumberOfFieldsInCaseClasses>true</limitedNumberOfFieldsInCaseClasses>>
        </configuration>
    </plugin>
</plugins>
```

To override the **namespaceMapping** of Avro protocols under the `com.example.packagename` namespace to `com.example.packagenamechanged`
and include all files in a subdirectory and its subdirectories named **subdir**, use

```xml
<plugins>
    <plugin>
        <groupId>at.makubi.maven.plugin</groupId>
        <artifactId>avrohugger-maven-plugin</artifactId>
        <executions>
            <execution>
                <phase>generate-sources</phase>
                <goals>
                    <goal>generate-scala-sources</goal>
                </goals>
            </execution>
        </executions>
        <configuration>
            <namespaceMapping>
                <mapping>
                    <from>com.example.packagename</from>
                    <to>com.example.packagenamenew.subchange</to>
                </mapping>
            </namespaceMapping>
            <fileIncludes>
                <fileInclude>
                    <path>subdir/**</path>
                    <matchSyntax>GLOB</matchSyntax>
                </fileInclude>
            </fileIncludes>
        </configuration>
    </plugin>
</plugins>
```

## Dependencies

This plugin heavily relies on
[Avrohugger](https://github.com/julianpeeters/avrohugger) to generate
Scala code.

## Contributors
* [robbruce](https://github.com/robbruce)
* [Eugene Platonov](https://github.com/jozic)
* [Jason Bowman](https://github.com/sini)
* [chrisalbright](https://github.com/chrisalbright)

## License
The Avrohugger Maven Plugin is released under version 2.0 of the [Apache License](http://www.apache.org/licenses/LICENSE-2.0).
