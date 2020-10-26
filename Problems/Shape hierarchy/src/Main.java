abstract class Shape {

    protected double a;

    protected Shape(double a) {
        this.a = a;
    }

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {

    private double b;
    private double c;

    protected Triangle(double a, double b, double c) {
        super(a);
        this.b = b;
        this.c = c;
    }

    @Override
    double getPerimeter() {
        return (a+b+c);
    }

    @Override
    double getArea() {
        double s = getPerimeter()/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
}

class Rectangle extends Shape {

    private double b;

    protected Rectangle(double a, double b) {
        super(a);
        this.b = b;
    }

    @Override
    double getPerimeter() {
        return (b*2)+(a*2);
    }

    @Override
    double getArea() {
        return a*b;
    }
}

class Circle extends Shape {

    protected Circle(double a) {
        super(a);
    }

    @Override
    double getPerimeter() {
        return Math.PI * (a*2);
    }

    @Override
    double getArea() {
        return Math.PI * (a*a);
    }
}