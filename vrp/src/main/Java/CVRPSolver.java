import java.util.List;
import java.util.ArrayList;
public class CVRPSolver {
    Depot depot;
    List<Customer> customers;
    List<Vehicle> vehicles;

    int vehicleCapacity=10;

    public CVRPSolver(Depot depot, List<Customer> customers) {
        this.depot = depot;
        this.customers = customers;
        this.vehicles = new ArrayList<>();
    }

    public void solve() {
        List<Customer> unvisited = new ArrayList<>(customers);

        while (!unvisited.isEmpty()) {

            Vehicle vehicle = new Vehicle(vehicleCapacity, depot);
            Customer current = depot;


            int customersAdded = 0;

            while (customersAdded < vehicleCapacity && !unvisited.isEmpty()) {
                KDTree tree = new KDTree(unvisited);
                Customer nearest = tree.nearestNeighbor(current);
                if (nearest == null) break;

                vehicle.route.add(nearest);
                unvisited.remove(nearest);
                current = nearest;
                customersAdded++;
            }

            vehicles.add(vehicle);
        }

        printRoutes();
    }

    public void printRoutes() {
        int routeNumber = 1;
        for (Vehicle vehicle : vehicles) {
            System.out.print(STR."Route \{routeNumber}: Depot -> ");
            for (Customer customer : vehicle.route) {
                System.out.print(STR."Customer \{customer.id} -> ");
            }
            System.out.println("Depot");
            routeNumber++;
        }
    }

}