public class Rectangle extends GeometricObject {
    private final double recWidth;
    private final double recHeight;

    /*rectangle method*/
    public Rectangle(double recWidth, double recHeight) {
        this.recWidth = recWidth;
        this.recHeight = recHeight;
    }

    /*overridden getGeoArea method calculates Geographic Area*/
    @Override
    public double getGeoArea() {
        return recWidth * recHeight;
    }

}
