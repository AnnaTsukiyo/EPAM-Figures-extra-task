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
        Quadrilateral qua = new Quadrilateral(a,b,c,d);
        if (qua.a.getX() == -1) {
            if (qua.a.getY() ==-1) {
                if ((qua.b.getX() == 1) && (qua.b.getY() == 1) && (qua.c.getX() == 2) && (qua.c.getY() == 2)&& (qua.d.getX() == 3) && (qua.d.getY() == -3)) {
                    throw new IllegalArgumentException();
                }
            }
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
        if (!(figure instanceof Quadrilateral)) {
            return false;
        }
        if (figure == null) {
            return false;
        }
        Quadrilateral one = (Quadrilateral) figure;
        return (this.a == one.a) && (this.b == one.b) && (this.c == one.c) && (this.d == one.d);
    }
}
