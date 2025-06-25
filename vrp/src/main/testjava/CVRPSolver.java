import java.util.*;
public class CVRPSolver {
    private final Depot depot;
    private final List<Customer> customers;
    private final List<Vehicle> vehicles;

    int vehicleCapacity=10;

    public CVRPSolver(Depot depot, List<Customer> customers) {
        this.depot = depot;
        this.customers = customers;
        this.vehicles = new ArrayList<>();
    }

    public void solve() {

        Set<Customer> unvisitedSet = new HashSet<>(customers);


        KDTree tree = new KDTree(customers);

        while (!unvisitedSet.isEmpty()) {

            Vehicle vehicle = new Vehicle(vehicleCapacity, depot);
            Customer current = depot;

            int customersAdded = 0;

            while (customersAdded < vehicleCapacity && !unvisitedSet.isEmpty()) {

                Customer nearest = tree.nearestNeighbor(current, unvisitedSet);

                if (nearest == null) {
                    break;
                }

                vehicle.getRoute().add(nearest);
                unvisitedSet.remove(nearest);
                current = nearest;
                customersAdded++;
            }

            vehicles.add(vehicle);
        }

        for (Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }
    public List<Vehicle> getVehicles(){
        return vehicles;
    }

}


