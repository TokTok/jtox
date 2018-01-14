# Java Tox client

This is a simple test client for tox4j.

![Screenshot](doc/screenshot.png)


## Contributing

We're using the standard Github workflow for our code reviews. Just open Pull
Requests and the reviewer will guide you through the process.


# Building jTox

## Dependencies: compile

To build the package itself, the following dependencies are required:

- com.chuusai:shapeless_2.11:2.3.2
- com.google.code.findbugs:jsr305:3.0.0
- com.google.guava:guava:19.0
- com.google.protobuf:protobuf-java:3.5.0
- com.intellij:annotations:12.0
- com.lihaoyi:fastparse-utils_2.11:0.3.7
- com.lihaoyi:fastparse_2.11:0.3.7
- com.lihaoyi:sourcecode_2.11:0.1.1
- com.trueaccord.lenses:lenses_2.11:0.4.7
- com.trueaccord.scalapb:scalapb-runtime-grpc_2.11:0.5.43
- com.trueaccord.scalapb:scalapb-runtime_2.11:0.5.43
- com.typesafe.scala-logging:scala-logging_2.11:3.7.2
- io.grpc:grpc-context:1.0.1
- io.grpc:grpc-core:1.0.1
- io.grpc:grpc-stub:1.0.1
- org.scala-lang.modules:scala-java8-compat_2.11:0.7.0
- org.scala-lang.modules:scala-parser-combinators_2.11:1.0.4
- org.scala-lang.modules:scala-xml_2.11:1.0.5
- org.scala-lang:scala-compiler:2.11.12
- org.scala-lang:scala-reflect:2.11.12
- org.scalaz:scalaz-core_2.11:7.3.0-M18
- org.scodec:scodec-bits_2.11:1.1.2
- org.scodec:scodec-core_2.11:1.10.3
- org.slf4j:slf4j-api:1.7.25
- org.toktok:jtox_2.11:0.1.0
- org.toktok:macros_2.11:0.1.0
- org.toktok:tox4j-api_2.11:0.1.3
- org.toktok:tox4j-c_2.11:0.1.3-SNAPSHOT
- org.typelevel:macro-compat_2.11:1.1.1

## Dependencies: test

For testing, the following additional dependencies are required:
