package model;

public class BookingOnline extends Hotel {
    private String discount;

    public BookingOnline(String discount) {
        this.discount = discount;
    }

    public BookingOnline(double numOfDay, String roomType, double cost, String discount) {
        super(numOfDay, roomType, cost);
        this.discount = discount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String toString() {
        return "BookingOnline{" +
                "discount='" + discount + '\'' +
                '}';
    }

    @Override
    public double payForRoom() {
        return 0;
    }
}
