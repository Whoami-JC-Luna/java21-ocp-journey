# s02 – Primitive Data Types, Variables and Arrays

Code: [`Primitives.java`](Primitives.java)

## Data types

In Java we have two kinds of data types: **primitive** and **reference** types.

Reference types are classes, annotations, interfaces, enumerations and arrays. We will see them later in the course. Now we focus on primitive types:

- Integers
- Floating-point numbers
- Booleans
- Characters

The main difference: primitive types store the real values, while reference types store the address of the object they refer to.

Primitive types in Java are analogous to the simple types we find in most non-object-oriented languages. "Analogous" means equivalent: like the simple types of C, they store a value and they are not objects.

So, if Java is object-oriented, why do we still have primitive types and not only objects and references? The answer is **efficiency**: converting primitive types into objects reduces performance too much.

## Primitive types table

| Type | Size | Range | Wrapper type |
|---|---|---|---|
| `byte` | 1 byte | -128 to 127 | `Byte` |
| `short` | 2 bytes | -2^15 to 2^15 - 1 (-32,768 to 32,767) | `Short` |
| `int` | 4 bytes | -2^31 to 2^31 - 1 (-2,147,483,648 to 2,147,483,647) | `Integer` |
| `long` | 8 bytes | -2^63 to 2^63 - 1 | `Long` |
| `float` | 4 bytes | approx. ±3.4E38 (6-7 significant digits) | `Float` |
| `double` | 8 bytes | approx. ±1.8E308 (15 significant digits) | `Double` |
| `boolean` | JVM dependent | `true` or `false` | `Boolean` |
| `char` | 2 bytes | 0 to 65,535 | `Character` |

### Wrapper types

The wrapper type is the **object version** of each primitive type: a class that "wraps" the value inside an object.

We need them because some parts of Java only work with objects. For example, collections only accept objects: we can create a `List<Integer>`, but not a `List<int>`. Also, a wrapper can be `null` and has useful methods, like `Integer.parseInt("42")`, which converts a `String` into an `int`.

Most wrappers have the same name as the primitive with a capital letter. Only two are different: `int` → `Integer` and `char` → `Character`.

## Conversions (casting)

The instructor uses this idea: we can put a small box into a bigger box, but not the other way around.

- **Small type → big type (widening):** automatic, Java does it for us.
- **Big type → small type (narrowing):** we must write a cast, for example `(byte)`, and data can be lost.

| Code | Result |
|---|---|
| `int small = 100;`<br>`long big = small;` | `100` (automatic) |
| `int n = (int) 9.99;` | `9` (decimals are lost) |
| `byte b2 = (byte) 128;` | `-128` (128 is out of the `byte` range, so it wraps around) |

## Variables

Java is a **strongly typed** language because:

- Every variable has a type.
- Every expression has a type.
- Every type is strictly defined.

The compiler checks all of this and shows an error when something is not declared correctly.

A variable in Java is a piece of memory that contains a data value. For variable names we usually start with a lowercase letter and use nouns. When a name has more than one word, we use camelCase:

| Examples |
|---|
| `int age = 30;`<br>`double totalPrice = 19.99;`<br>`boolean isActive = true;` |

We cannot use reserved keywords as names.

A variable is defined by the combination of **type** and **identifier**:

| Code | Type | Identifier | Value |
|---|---|---|---|
| `int a = 2;` | `int` | `a` | `2` |

### `var`

We can declare a variable with the keyword `var`. In this case, we don't write the type: the compiler decides it from the first value, and after that the type does not change.

| Code | Result |
|---|---|
| `var v = 1;` | The compiler decides `v` is an `int` |
| `v = "text";` | Error: `v` is still an `int` |

### Scope

Every variable has a scope, and the scope defines its visibility (where we can use it).

## Notes from the code

### Literals

Integer literals are `int` by default, and decimal literals are `double` by default. That is why:

- `float f = 1.8F;` needs `F`.
- `long l1 = 2_000_000_000_000L;` needs `L`, because without it the literal is an `int` and it is out of the `int` range.

| Code | Result |
|---|---|
| `long l1 = 2_000_000_000;` | Compiles: the `int` literal is inside the `int` range |
| `long l1 = 2_000_000_000_000;` | Error: the `int` literal is out of range |
| `long l1 = 2_000_000_000_000L;` | Compiles: `L` makes it a `long` |

We can separate digits with underscores (`_`) to make numbers easier to read.

### IEEE 754: floating-point numbers in memory

Floating-point numbers and integers are stored in memory in a different way. Java follows the **IEEE 754** standard: a `double` uses 64 bits, but only 53 bits are precision for the digits; the other bits are for the sign and the exponent.

Because of this, the conversion between `long` and `double` is not trivial: depending on the real value at runtime, information can be lost.

| Code | Output |
|---|---|
| `long number = 499_999_999_000_000_001L;`<br>`double converted = (double) number;`<br>`System.out.println(number - (long) converted);` | `1` (the `double` could not store the last digit) |

### Autoboxing and unboxing

Every primitive type has its wrapper type. **Autoboxing** is the automatic conversion that the Java compiler makes from a primitive type to its wrapper class. When the conversion goes the other way, from the wrapper to the primitive, it is called **unboxing**.

| Code | What happens |
|---|---|
| `Integer i4 = 1;` | Autoboxing: the `int` 1 is put inside an `Integer` object |
| `int i5 = i4;` | Unboxing: the value is taken out of the `Integer` into an `int` |