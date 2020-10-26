class Complex {

    double real;
    double image;

    public void add(Complex addition) {
        this.real = this.real + addition.real;
        this.image = this.image + addition.image;
//        System.out.printf("%d %d" this.real, this.image )
    }

    public void subtract(Complex subtraction) {
        this.real = this.real - subtraction.real;
        this.image = this.image - subtraction.image;
    }
}