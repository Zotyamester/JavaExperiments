package objects;

public class Polynomial {
    private final double[] coefficients;

    public Polynomial(int n) {
        coefficients = new double[n + 1];
    }

    public int degree() {
        return coefficients.length - 1;
    }

    public void setCoefficient(int power, double coefficient) {
        coefficients[power] = coefficient;
    }

    public double getCoefficient(int power) {
        return coefficients[power];
    }

    public double getValue(double x) {
        double value = 0.0;

        for (int power = degree(); power >= 0; power--) {
            value = (value * x) + coefficients[power]; // Horner's method
        }

        return value;
    }

    public Polynomial add(Polynomial other) {
        Polynomial sum = new Polynomial(Math.max(degree(), other.degree()));

        for (int i = 0; i < degree(); i++) {
            sum.setCoefficient(i,
                    getCoefficient(i));                                         // sum[i] = my[i];
        }
        for (int i = 0; i < other.degree(); i++) {
            sum.setCoefficient(i,
                    sum.getCoefficient(i) + other.getCoefficient(i)); // sum[i] += other[i];
        }

        return sum;
    }

    public Polynomial mul(Polynomial other) {
        Polynomial prod = new Polynomial(degree() + other.degree());

        for (int i = 0; i <= degree(); i++) {
            for (int j = 0; j <= other.degree(); j++) {
                prod.setCoefficient(i + j,
                        prod.getCoefficient(i + j) +    // prod[i + j] =
                                getCoefficient(i) * getCoefficient(j)); //     prod[i + j] + my[i] * sum[j];
            }
        }

        return prod;
    }

    public static void task1() {
        Polynomial xxp2xp1 = new Polynomial(2); // x² + 2x + 1 = (x + 1)²
        xxp2xp1.setCoefficient(2, 1);
        xxp2xp1.setCoefficient(1, 2);
        xxp2xp1.setCoefficient(0, 1);

        Polynomial xp1 = new Polynomial(1); // x + 1
        xp1.setCoefficient(1, 1);
        xp1.setCoefficient(0, 1);

        Polynomial xp1_xp1 = xp1.mul(xp1); // (x + 1)(x + 1) = (x + 1)²

        for (double x = -2.0; x <= 2.0; x += 0.1) {
            double y1 = xxp2xp1.getValue(x);
            double y2 = xp1_xp1.getValue(x);
            assert (y1 == y2);
        }

        System.out.println("All good!");
    }
}
