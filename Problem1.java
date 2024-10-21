abstract class Shape {

    private int dimension1;

    private int dimension2;

    public Shape(int dimension1, int dimension2) {

        this.dimension1 = dimension1;

        this.dimension2 = dimension2;

    }

    public int getDimension1() {

        return dimension1;

    }



    public int getDimension2() {

        return dimension2;

    }
    public abstract void printArea();

}

class Rectangle extends Shape {

    public Rectangle(int length, int width) {

        super(length, width);

    }

    public void printArea() {

        int area = getDimension1() * getDimension2(); // length * width

        System.out.println("Area of Rectangle: " + area);

    }

}

class Triangle extends Shape {

    public Triangle(int base, int height) {

        super(base, height);

    }

    public void printArea() {

        double area = 0.5 * getDimension1() * getDimension2(); // 0.5 * base * height

        System.out.println("Area of Triangle: " + area);

    }

}

class Circle extends Shape {

    public Circle(int radius) {

        super(radius, 0); 

    }


    public void printArea() {

        double area = Math.PI * getDimension1() * getDimension1();

        System.out.println("Area of Circle: " + area);

    }

}

public class Problem1 {

    public static void main(String[] args) {

        Rectangle rect = new Rectangle(5, 3);

        rect.printArea();



         Triangle tri = new Triangle(4, 6);

        tri.printArea();



         Circle circle = new Circle(7);

        circle.printArea();

    }

}