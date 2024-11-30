// Abstraction: Shape interface
interface Shape {
    double calculateArea();
}

// Concrete implementation: Circle
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Concrete implementation: Rectangle
class Rectangle implements Shape {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double calculateArea() {
        return length * breadth;
    }
}

// High-level module: ShapePrinter depends on Shape abstraction
class ShapePrinter {
    private final Shape shape;

    public ShapePrinter(Shape shape) {
        this.shape = shape;
    }

    public void printArea() {
        System.out.println("Area: " + shape.calculateArea());
    }
}

// Main class
public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        ShapePrinter circlePrinter = new ShapePrinter(circle);
        circlePrinter.printArea();

        Shape rectangle = new Rectangle(8, 4);
        ShapePrinter rectanglePrinter = new ShapePrinter(rectangle);
        rectanglePrinter.printArea();
    }
}
