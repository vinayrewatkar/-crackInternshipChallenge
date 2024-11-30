interface InnerSingleRes {
    int area();
}

class Circle implements InnerSingleRes {
    private int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    public int area() {
        return (int) 3.14 * radius * radius;
    }
}

class Rectangle implements InnerSingleRes {
    private int length, breadth;

    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public int area() {
        return length * breadth;
    }

    public int length() {
        return length;
    }

    public int breadth() {
        return breadth;
    }
}

class Triangle implements InnerSingleRes {
    private int side;

    Triangle(int side) {
        this.side = side;
    }

    public int area() {
        return side * side * side;
    }
}

class Print {
    public void print(InnerSingleRes res) {
        System.out.println("Area " + res.area());
    }
}

public class singleRes {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        Rectangle r = new Rectangle(5, 10);
        Triangle t = new Triangle(7);
        Print p = new Print();
        p.print(r);
        p.print(c);
        p.print(t);
    }
}