package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    Point centr;
    double radius;

    public Circle(Point centr, double radius)  throws IllegalArgumentException{
        if (centr != null) {
            this.centr = centr;
            this.radius = radius;
        }
        if (radius<=0 || centr == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Point centroid() {
        return centr;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null) {
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
