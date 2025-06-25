import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private static int counter= 0;
    int id;
    private final int capacity;
    private  final Depot depot;
    private final List<Customer> route;

    public Vehicle(int capacity, Depot depot) {
        this.id= ++counter;
        this.capacity = capacity;
        this.depot = depot;
        this.route = new ArrayList<>();
    }

    public boolean addCustomer(Customer customer){
        if (route.size() < capacity){
            route.add(customer);
            return true;
        }
        return false;
    }

    public Depot getDepot() {
        return depot;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Customer> getRoute() {
        return route;
    }

    @Override
    public String toString() {
        return STR."ID : \{id} Route: \{route}";
    }
}