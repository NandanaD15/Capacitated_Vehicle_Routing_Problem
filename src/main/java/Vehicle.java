import java.util.ArrayList;
import java.util.List;

class Vehicle {
    int capacity;
    Depot depot;
    List<Customer> route;

    public Vehicle(int capacity, Depot depot) {
        this.capacity = capacity;
        this.depot = depot;
        this.route = new ArrayList<>();
    }
    public boolean addCustomer(Customer customer) {
        if (canAddCustomer(customer)) {
            route.add(customer);
            return true;
        }
        return false;
    }
    public boolean canAddCustomer(Customer customer) {
        return getCurrentLoad() + customer.getDemand() <= capacity;
    }

    public int getCurrentLoad() {
        int load = 0;
        for (Customer c : route) {
            load += c.getDemand();
        }
        return load;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Route: Depot -> ");
        for (Customer c : route) {
            sb.append("C").append(c.id).append(" -> ");
        }
        sb.append("Depot");
        return sb.toString();
    }




//    @Override
//    public String toString() {
//        return STR."Route: \{route}";
//    }
}