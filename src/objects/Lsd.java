package objects;

public class Lsd {
    private static final int ONE_POUND_IN_SHILLINGS = 20;
    private static final int ONE_SHILLING_IN_PENCE = 12;

    private int pounds;
    private int shillings;
    private int pence;

    public Lsd(int pounds, int shillings, int pence) {
        setPounds(pounds);
        setShillings(shillings);
        setPence(pence);
    }

    public Lsd(int shillings, int pence) {
        this(0, shillings, pence);
    }

    public Lsd(int pence) {
        this(0, pence);
    }

    public int valueInPence() {
        return ((pounds * ONE_POUND_IN_SHILLINGS) + shillings) * ONE_SHILLING_IN_PENCE + pence;
    }

    public int getPounds() {
        return pounds;
    }

    public int getShillings() {
        return shillings;
    }

    public int getPence() {
        return pence;
    }

    public void setPounds(int pounds) {
        this.pounds = pounds;
    }

    public void setShillings(int shillings) {
        this.shillings = shillings;
        carryShillings();
    }

    private void carryShillings() {
        if (shillings >= ONE_POUND_IN_SHILLINGS) {
            pounds += shillings / ONE_POUND_IN_SHILLINGS;
            shillings %= ONE_POUND_IN_SHILLINGS;
        }
    }

    public void setPence(int pence) {
        this.pence = pence;
        carryPence();
    }

    private void carryPence() {
        if (pence >= ONE_SHILLING_IN_PENCE) {
            shillings += pence / ONE_SHILLING_IN_PENCE;
            pence %= ONE_SHILLING_IN_PENCE;
            carryShillings();
        }
    }

    public Lsd add(Lsd other) {
        return new Lsd(valueInPence() + other.valueInPence());
    }

    public Lsd sub(Lsd other) {
        return new Lsd(valueInPence() - other.valueInPence());
    }

    public Lsd mul(int other) {
        return new Lsd(valueInPence() * other);
    }

    public int div(Lsd other) {
        return valueInPence() / other.valueInPence();
    }

    public int mod(Lsd other) {
        return valueInPence() % other.valueInPence();
    }

    public Lsd withTip(int percentage) {
        return new Lsd(valueInPence() * (100 + percentage) / 100);
    }

    @Override
    public String toString() {
        return String.format("£%d.%ds.%dd.", pounds, shillings, pence);
    }

    public static void task2() {
        Lsd costOfMeal = new Lsd(4, 1, 6);
        Lsd costOfDrink = new Lsd(0, 10, 6);
        int people = 2;

        Lsd costOfOrder = costOfMeal.add(costOfDrink).mul(people);
        Lsd totalCost = costOfOrder.withTip(15);
        System.out.println("Total: " + totalCost);
    }
}
