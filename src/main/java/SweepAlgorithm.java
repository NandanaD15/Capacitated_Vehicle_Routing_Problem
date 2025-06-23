import java.util.*;

public class SweepAlgorithm {
    private  Depot depot;
    private  List<Customer> customers;
    private int vehicleCapacity;

    public SweepAlgorithm(Depot depot, List<Customer> customers, int vehicleCapacity) {
        this.depot = depot;
        this.customers = new ArrayList<>(customers);
        this.vehicleCapacity = vehicleCapacity;
    }

    private double calculateAngleFromDepot(Customer customer) {
        double dx = customer.x - depot.x;
        double dy = customer.y - depot.y;
        return Math.atan2(dy, dx);
    }
    public List<Vehicle> runSweep() {
        customers.sort(Comparator.comparingDouble(this::calculateAngleFromDepot));

        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle currentVehicle = new Vehicle(vehicleCapacity, depot);

        for (Customer customer : customers) {
            if (!currentVehicle.addCustomer(customer)) {
                vehicles.add(currentVehicle);
                currentVehicle = new Vehicle(vehicleCapacity, depot);
                currentVehicle.addCustomer(customer);
            }
        }

        if (!currentVehicle.route.isEmpty()) {
            vehicles.add(currentVehicle);
        }

        return vehicles;
    }
}
