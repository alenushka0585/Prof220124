package org.example.lesson2.figure;

public class FigureTester {
    public static void main(String[] args) {
        Figure[] figures = {new Rectangle(1, 2),
                new Rectangle(2, 3),
                new Circle(1),
                new Triangle(1, 2, 2),
                new Triangle(1, 1, 1)};

        System.out.println(calculateArea(figures));
        System.out.println(calculatePerimeter(figures));

    }

    public static double calculateArea(Figure[] figures) {
        double area = 0;
        for (int i = 0; i < figures.length; i++) {
            area += figures[i].area();
        }
        return area;
    }

    public static double calculatePerimeter(Figure[] figures) {
        double perimeter = 0;
        for (int i = 0; i < figures.length; i++) {
            perimeter += figures[i].perimeter();
        }
        return perimeter;
    }
}
