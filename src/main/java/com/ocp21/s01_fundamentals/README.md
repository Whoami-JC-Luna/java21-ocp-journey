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


## Comments

Java comments are ignored by the compiler, so they are not part of the bytecode and the JVM never sees them.
Comments are used to give information or explain something about a class, method, variable or block of code, which makes the code easier to maintain.

Comments are also used to hide code temporarily (for example, while testing something) and as `TODO` reminders.

Java has three types of comments:

| Type | Syntax | Used by Javadoc |
|---|---|---|
| Single-line | `// ...` | No |
| Block | `/* ... */` | No |
| Javadoc | `/** ... */` | Yes |

### Good practices

- **Code explains *what*, comments explain *why*.** With descriptive names for classes, methods and variables, the code explains itself: `calculateTotalPrice()` needs no comment, `calc()` does.
- **A comment is useful** when it explains something the code cannot say: a decision, a limitation or an unusual case.
- **Outdated comments are worse than no comments**, because nobody notices when they stop being true.
- **Do not keep commented-out code.** If you comment out code because you do not need it, delete it. With version control (Git) you can always get it back from the history. Keeping old code "just in case" makes classes longer and harder to understand, and most of the time you never use it again.
- **Unit tests also work as documentation:** well-written tests show how the code is used and what is expected.
- **Javadoc** is used mainly for public classes and methods that other people will use.





