class Circle extends GeometricObject {
    private final double rad;
    private final String col = "white";


    public Circle(double r) {
        this(r, "white");
    }

    public Circle(double r, String col) {
        this.rad = r;
    }

    @Override
    public double getGeoArea() {
        return rad * rad * Math.PI;
    }
}