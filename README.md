# Java Tox client

This is a simple test client for tox4j.

![Screenshot](doc/screenshot.png)

## Contributing

We're using the standard Github workflow for our code reviews. Just open Pull
Requests and the reviewer will guide you through the process.

# Building jTox

To build the package itself, add the TokTok maven repository
`https://dl.bintray.com/toktok/maven` to your maven settings. If you don't have
any maven settings, run:

```sh
cp settings.xml ~/.m2/
```

Then run:

```sh
mvn package
```

This will create an executable jar with everything you need in it in
`target/jtox-0.1.0-jar-with-dependencies.jar`. You can then execute it from the
command line or by clicking on it in your operating system GUI.

```sh
java -jar target/jtox-0.1.0-jar-with-dependencies.jar
```
