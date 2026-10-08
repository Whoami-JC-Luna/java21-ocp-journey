package com.ocp21.s02_primitives_variables_arrays;

/**
 * Examples of primitive types, literals, {@code var},
 * conversions (casting) and autoboxing/unboxing.
 * The explanations are in the README of this package.
 */
public class Primitives {

    /**
     * Runs the examples of the class.
     *
     * @param args not used
     */
    public static void main(String[] args) {

        byte b = 1;

        short s;  // declared first, value assigned later
        s = 2;

        int i = 4;
        long l = 6;
        char c = 'a';
        boolean bool = true;

        float f = 1.8F;                  // F: decimal literals are double by default
        long l1 = 2_000_000_000_000L;    // L: integer literals are int by default
        double d = 1.2;

        var v = 1;  // the compiler decides v is an int

        // Narrowing: 128 is out of the byte range
        byte b2 = (byte) 128;
        System.out.println(b2); // -128

        // long -> double can lose information (IEEE 754)
        long number = 499_999_999_000_000_001L;
        double converted = (double) number;
        System.out.println(number - (long) converted); // 1

        Integer i4 = 1;  // autoboxing: int -> Integer
        int i5 = i4;     // unboxing: Integer -> int

        System.out.println(b + " " + s + " " + i + " " + l + " " + c + " " + bool + " "
                + f + " " + l1 + " " + d + " " + v + " " + i4 + " " + i5);
    }
}