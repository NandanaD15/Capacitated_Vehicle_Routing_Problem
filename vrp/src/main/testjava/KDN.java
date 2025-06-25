public class KDN {
    private final Customer customer;
    KDN left, right;
    private final boolean isVertical;

    public KDN(Customer customer, boolean isVertical) {
        this.customer = customer;
        this.isVertical = isVertical;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean getIsVertical(){
        return isVertical;
    }
}