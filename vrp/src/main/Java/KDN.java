
public class KDN {
    Customer customer;
    KDN left, right;
    boolean isVertical;

    public KDN(Customer customer, boolean isVertical) {
        this.customer = customer;
        this.isVertical = isVertical;
    }
}