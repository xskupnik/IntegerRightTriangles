/*
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?
*/
package com.dohnalovar;

public class Main {

    public static void main(String[] args) {
	// write your code here
        RightTrianglesFactory f = RightTrianglesFactory.getInstance();

        System.out.println("Key: " + f.getMaxFrequencyPerimeter() +
            "\nFrequency: " + f.getMaxFrequency());

        System.out.println(f.toString());
    }
}
