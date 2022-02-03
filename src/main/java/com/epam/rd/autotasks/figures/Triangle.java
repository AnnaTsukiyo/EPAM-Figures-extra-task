package com.epam.rd.autotasks.figures;

class Triangle extends Figure {

    Point a;
    Point b;
    Point c;
    double length1, length2, length3;

    public Triangle(Point a, Point b, Point c) throws IllegalArgumentException {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException();
        }
        if ((length1(a, b) >= length2(a, c) + length3(c, b)) || (length2(a, c) >= (length1(a, b) + length3(c, b))) || (length3(c, b)) >= length2(a, c) + (length1(a, b))) {
            throw new IllegalArgumentException();
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    double length1(Point a, Point b) {
        double xDistanceSquare = Math.pow(a.getX() - b.getX(), 2);
        double yDistanceSquare = Math.pow(a.getY() - b.getY(), 2);
        return Math.sqrt(xDistanceSquare + yDistanceSquare);
    }

    double length2(Point a, Point c) {
        double xDistanceSquare = Math.pow(a.getX() - c.getX(), 2);
        double yDistanceSquare = Math.pow(a.getY() - c.getY(), 2);
        return Math.sqrt(xDistanceSquare + yDistanceSquare);
    }

    double length3(Point c, Point b) {
        double xDistanceSquare = Math.pow(c.getX() - b.getX(), 2);
        double yDistanceSquare = Math.pow(c.getY() - b.getY(), 2);
        return Math.sqrt(xDistanceSquare + yDistanceSquare);
    }

    @Override
    public Point centroid() {
        double xc = (a.getX() + b.getX() + c.getX()) / 3;
        double yc = (a.getY() + b.getY() + c.getY()) / 3;
        return new Point(xc, yc);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (this == figure) {
            return true;
        }
        if (figure instanceof Triangle) {
            return true;
        }
        if (figure == null) {
            return false;
        }
        Triangle one = (Triangle) figure;
        return (this.a == one.a) && (this.b == one.b) && (this.c == one.c);
    }
}
