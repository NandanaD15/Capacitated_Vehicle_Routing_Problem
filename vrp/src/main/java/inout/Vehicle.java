package java.inout;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    int capacity;
    Depot depot;
    public List<Customer> route;

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