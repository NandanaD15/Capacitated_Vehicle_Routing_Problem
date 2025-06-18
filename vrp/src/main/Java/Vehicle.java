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

    @Override
    public String toString() {
        return STR."Route: \{route}";
    }
}