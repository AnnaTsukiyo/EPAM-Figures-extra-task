package com.epam.rd.autotasks.figures;

class Triangle extends Figure {

    Point a;
    Point b;
    Point c;

    public Triangle(Point a, Point b, Point c) throws IllegalArgumentException {
        if ((length1(a, b) >= length2(a, c) + length3(c, b)) || (length2(a, c) >= (length1(a, b) + length3(c, b))) || (length3(c, b)) >= length2(a, c) + (length1(a, b))) {
            throw new IllegalArgumentException();
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public Point centroid() {
        double x = (a.getX() + b.getX() + c.getX()) / 3;
        double y = (a.getY() + b.getY() + c.getY()) / 3;
        return new Point (x, y);
    }

    public static Point findIntersection(Point l1s, Point l1e, Point l2s, Point l2e) {

        double a1 = l1e.getY() - l1s.getY();
        double b1 = l1s.getX() - l1e.getX();
        double c1 = a1 * l1s.getX() + b1 * l1s.getY();

        double a2 = l2e.getY() - l2s.getY();
        double b2 = l2s.getX() - l2e.getX();
        double c2 = a2 * l2s.getX() + b2 * l2s.getY();

        double delta = a1 * b2 - a2 * b1;
        if (delta == 0) {
            return null;
        }
        return new Point((b2 * c1 - b1 * c2) / delta, (a1 * c2 - a2 * c1) / delta);
    }

    @Override
    public abstract boolean isTheSame(Figure figure){
    }
}
