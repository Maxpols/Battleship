class Circle {

    double radius;

    public double getLength() {
        return 2 * this.radius * Math.PI;
    }

    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }
}