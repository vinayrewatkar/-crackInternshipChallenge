interface InnerSingleResponsibility {
    int calculateArea();
}

class Circle implements InnerSingleResponsibility {
    private int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    public int calculateArea() {
        return (int) (Math.PI * radius * radius);
    }
}

class Rectangle implements InnerSingleResponsibility {
    private int length;
    private int breadth;

    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public int calculateArea() {
        return length * breadth;
    }
}

class ShapePrinter {
    public void printArea(InnerSingleResponsibility shape) {
        System.out.println("The area is: " + shape.calculateArea());
    }
}

public class SingleResponsibility {
    public static void main(String[] args) {
        Circle c1 = new Circle(5);
        Rectangle r1 = new Rectangle(8, 9);
        ShapePrinter shape = new ShapePrinter();
        shape.printArea(c1);
        shape.printArea(r1);
    }
}
