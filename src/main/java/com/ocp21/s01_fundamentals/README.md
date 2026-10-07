# Fundamentals

## HelloWorld

### The code
**Note:** Java recommends naming packages in lowercase, using reverse domain names, e.g. `com.example.myapp`. 
- `package com.ocp21.s01_fundamentals;` – the package where the class lives.
- `public class HelloWorld` – a public class must have the same name as its `.java` file.
- `public static void main(String[] args)` – the entry point: the JVM looks for this exact method to start the program.
- `System.out.println("Hello World");` – prints the text to the console.

### Compile and run it from the terminal to understand how Java code is compiled to bytecode and executed by the JVM

Another way to understand how compiling and running a Java program works:

1. Forget the IDE. Open a simple text editor and write the same code in a `HelloWorld.java` file, but **without the package line**. Save the file.
2. Open your terminal in the same directory and run:

| Step | Command | What it does |
|---|---|---|
| Compile | `javac HelloWorld.java` | Turns the source code into bytecode and creates `HelloWorld.class` |
| Run | `java HelloWorld` | Starts the JVM and runs the bytecode (without the `.class` extension) |


The output is the same as running the program as a Java Application in the IDE:

```
Hello World
```

### Forcing errors

This is interesting because we can see how this works at a lower level, and the difference between a compilation error and a runtime error.

**Compilation error:** change the name of the public class, for example `public class HelloWorld2`. `javac` fails, because the name of the public class must match the name of the `.java` file.

**Runtime error:** change the name of the method from `main` to `mainx`. Now `javac` compiles without errors, but `java` fails. Why? The JVM cannot find the `main` method it needs to start the application.

#### This way, we can see two typical types of errors:

- **Compilation errors** are detected by the compiler before the program runs. The program cannot run until we fix them.

- **Runtime errors** only appear when the program runs. They can be more dangerous: the code compiles without problems, so the error can reach production if no test executes that case (there are no tests, the tests do not cover that case, or the error depends on real data or the environment).

This is why tests are important: they help us find runtime errors before our users do.
