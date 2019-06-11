package com.dohnalovar;

import java.util.*;

/**
 * Created by dohnalovar on 6/11/2019
 */
public class RightTrianglesFactory {

    public class RightTriangleSides {

        // ordinates
        private int a;
        private int b;
        // hypotenus
        private int c;

        private RightTriangleSides() {
        }

        private RightTriangleSides(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int getC() {
            return c;
        }

        @Override
        public String toString() {
            return "{" + a + ", " + b + ", " + c + "}";
        }
    }

    /** Map of Perimeters */
    private static Map<Integer, List<RightTriangleSides>> perimeters = new HashMap<>();
    private static int maxFrequency = 0;
    private static Integer maxFrequencyPerimeter;

    private static RightTrianglesFactory ourInstance = new RightTrianglesFactory();

    public static RightTrianglesFactory getInstance() {
        return ourInstance;
    }

    private RightTrianglesFactory() {

        // generate perimeters
        for (int a = 1; a < 500; a++) {
            for (int b = a; b < (501-a); b++) {
                // Pythagoream Theorem: c^2 = a^2 + b^2
                int sqrC = (int)Math.pow(a, 2) + (int)Math.pow(b, 2);
                Double doubleC = Math.sqrt(sqrC);
                int c = doubleC.intValue(); //losing conversion in case of non-integer value
                if (sqrC == c * c) {
                    RightTriangleSides triangle = new RightTriangleSides(a, b, c);
                    Integer perim = a + b + c;
                    List<RightTriangleSides> listOfTriangles = perimeters.get(perim);
                    if (listOfTriangles == null) {
                        perimeters.put(perim, new ArrayList<>(Arrays.asList(triangle)));
                    } else {
                        listOfTriangles.add(triangle);
                    }
                }
            }
        }

        // set maxFrequency and maxFrequencyPerimeter
        perimeters.forEach((key, value) -> {
            int size = value.size();
            if (size > maxFrequency) {
                maxFrequency = size;
                maxFrequencyPerimeter = key;
            }
        });
    }

    public static int getMaxFrequency() {
        return maxFrequency;
    }

    public static Integer getMaxFrequencyPerimeter() {
        return maxFrequencyPerimeter;
    }

    @Override
    public String toString() {

        String result = "";/* = perimeters.values().toString();*/
        final StringBuilder sb = new StringBuilder("RightTrianglesFactory{key, values} \n" +
                                                   "-----------------------------------\n");
        perimeters.forEach((key, value) -> {
            sb.append(key).append(" -> ").append(value).append("\n");
        });

        return  sb.toString();
    }
}
