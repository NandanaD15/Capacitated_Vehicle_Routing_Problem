import java.util.*;
public class CVRPSolver {
    public static void main(String[] args) {
        Depot depot = new Depot(0, 50, 50);
//        Depot depot = new Depot(0, 50, 50);
        List<Customer> customers = generateRandomCustomers(100, 200, 200,10);

//        List<Customer> customers = new ArrayList<>();
//        customers.add(new Customer(1, 2, 3, 1));
//        customers.add(new Customer(2, 5, 4, 2));
//        customers.add(new Customer(3, -2, -1, 1));
//        customers.add(new Customer(4, 4, -3, 3));
//        customers.add(new Customer(5, 1, 6, 2));
//        customers.add(new Customer(6, -3, 4, 1));
//        customers.add(new Customer(7, -4, -2, 1));


        int vehicleCapacity = 100;


        SweepAlgorithm sweep = new SweepAlgorithm(depot, customers, vehicleCapacity);
        List<Vehicle> vehicles = sweep.runSweep();


        System.out.println("VRP Solution using Sweep Algorithm:");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println("Vehicle " + (i + 1) + ": " + vehicles.get(i));
        }
    }
    private static List<Customer> generateRandomCustomers(int count, double maxX, double maxY, int maxDemand) {
        List<Customer> customers = new ArrayList<>();
        Random rand = new Random();
        for (int i = 1; i <= count; i++) {
            double x = rand.nextDouble() * maxX;
            double y = rand.nextDouble() * maxY;
            int demand = 1 + rand.nextInt(maxDemand);
            customers.add(new Customer(i, x, y, demand));
        }
        return customers;
    }

}
