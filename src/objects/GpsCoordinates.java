package objects;

import java.util.Locale;

public class GpsCoordinates {
    private double latitude;
    private double longitude;

    public GpsCoordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return representationWithDegrees();
    }

    public String representationWithDecimals() {
        return formatDecimal(Math.abs(latitude), getLatitudePole(latitude)) +
                " " +
                formatDecimal(Math.abs(longitude), getLongitudePole(longitude));
    }

    public String formatDecimal(double degree, char pole) {
        return String.format("%c%.3f", pole, degree);
    }

    public String representationWithDegrees() {
        return formatDegree(Math.abs(latitude), getLatitudePole(latitude)) +
                " " +
                formatDegree(Math.abs(longitude), getLongitudePole(longitude));
    }

    private static char getLatitudePole(double degree) {
        return degree > 0 ? 'N' : 'S';
    }

    private static char getLongitudePole(double degree) {
        return degree > 0 ? 'E' : 'W';
    }

    private static String formatDegree(double degree, char pole) {
        int evenDegree = (int) degree;
        int evenArcMinutes = (int) (degree * 60.0) % 60;
        double arcSeconds = degree * 3600.0 - evenDegree * 3600 - evenArcMinutes * 60;
        return String.format("%c%d°%d'%.2f\"", pole, evenDegree, evenArcMinutes, arcSeconds);
    }

    public static void task3() {
        Locale.setDefault(Locale.US);
        GpsCoordinates coordinates = new GpsCoordinates(17.345, 11.543);
        System.out.println(coordinates.representationWithDecimals());
        System.out.println(coordinates.representationWithDegrees());
    }
}
