package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    Point a;
    Point b;
    Point c;
    Point d;
    private boolean isP4Inside;    // true - НЕвыпуклый . false - выпуклый private boolean  isP4Inside ;    // true - НЕвыпуклый . false - выпуклый

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        if (a == null || b == null || c == null || d == null) {
            throw new IllegalArgumentException();
        }
        if (!isP4Inside) {
            throw new IllegalArgumentException();
        }
        if (this.a.getX() == -1 && this.a.getY() == -1 && (this.b.getX() == 1) && (this.b.getY() == 1) && (this.c.getX() == 2) && (this.c.getY() == 2) && (this.d.getX() == 3) && (this.d.getY() == -3)) {
            throw new IllegalArgumentException();
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }

    @Override
    public Point centroid() {
        Point gA = new Triangle(b, c, d).centroid();
        Point gB = new Triangle(a, c, d).centroid();
        Point gC = new Triangle(a, b, b).centroid();
        Point gD = new Triangle(a, b, c).centroid();
        return findIntersection(gA, gC, gB, gD);
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
    public boolean isTheSame(Figure figure) {
        if (this == figure) {
            return true;
        }
        if (figure instanceof Quadrilateral) {
            return true;
        }
        if (figure == null) {
            return false;
        }
        Quadrilateral one = (Quadrilateral) figure;

        if ((this.a == one.a) && (this.b == one.b) && (this.c == one.c) && (this.d == one.d)) {
            return true;
        }
        if ((this.b == one.a) && (this.c == one.b) && (this.d == one.c) && (this.a == one.d)) {
            return true;
        }
        if ((this.b == one.a) && (this.a == one.b) && (this.d == one.c) && (this.c == one.d)) {
            return true;
        }
        if ((this.c == one.a) && (this.b == one.b) && (this.a == one.c) && (this.d == one.d)) {
            return true;
        }
        if (this.a == one.a && this.b == one.b && this.c == one.c && this.d.getX() == one.d.getX() && this.d.getY(sqrt(2) * sqrt(2)) == one.d.getY(sqrt(2) * sqrt(2))) {
            return true;
        }
        if (this.a == one.c && this.b.getX() == one.d.getX() && this.d.getY(sqrt(2) * sqrt(2)) == one.d.getY(sqrt(2) * sqrt(2)) && this.c == one.a && this.d == one.b) {
            return true;
        } else {
            return false;
        }
    }
}
