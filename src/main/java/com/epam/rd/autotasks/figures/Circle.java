package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    static final double PI = Math.PI;
    Point centr;
    double radius;

    public Circle(Point centr, double radius) {
        if (centr == null) {
            throw new IllegalArgumentException();
        }
        this.centr = centr;
        this.radius = radius;
        if (radius<=0){
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public Point centroid() {
        return centr;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null){
            return false;
        }
        if (this == figure) {
            return true;
        }
        if (!(figure instanceof Circle)) {
            return false;
        }
        Circle one = (Circle) figure;
        return (this.centr == one.centr) && (this.radius == one.radius);
    }
}
