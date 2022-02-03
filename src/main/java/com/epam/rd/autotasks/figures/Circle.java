package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    Point centr;
    double radius;

    public Circle(Point centr, double radius) {
        if (centr != null) {
            this.centr = centr;
            this.radius = radius;
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
