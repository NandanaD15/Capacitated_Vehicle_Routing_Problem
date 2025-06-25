import java.util.*;
public class TreeMapCVRP {
    private  final List<Customer> customers;
    private  final Depot depot;
    private final List<Vehicle> vehicles;

    public TreeMapCVRP(Depot depot, List<Customer> customers) {
        this.depot = depot;
        this.customers = customers;
        this.vehicles = new ArrayList<>();
    }
    private List<Customer> sortCustomer(List<Customer> customers, Depot depot){
        TreeMap<Double, List<Customer>> distanceMap = new TreeMap<>();

        for (Customer customer : customers) {
            double distance = customer.getDistance(depot.getX(), depot.getY());
            distanceMap.computeIfAbsent(distance, k -> new ArrayList<>()).add(customer);
        }

        List<Customer> sortedCustomers = new ArrayList<>();
        for (List<Customer> group : distanceMap.values()) {
            sortedCustomers.addAll(group);
        }
        return sortedCustomers;
    }
    public void solve(){
        List<Customer>  unvisited = sortCustomer(customers,depot);
        int vehicleCapacity = 10;
        Vehicle curVehicle = new Vehicle(vehicleCapacity,depot);

        for (Customer customer : unvisited){
            if (!curVehicle.addCustomer(customer)) {
                vehicles.add(curVehicle);
                curVehicle = new Vehicle(vehicleCapacity, depot);
                curVehicle.addCustomer(customer);
            }
        }

        if (!curVehicle.getRoute().isEmpty()){
            vehicles.add(curVehicle);
        }
        for (Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

}
