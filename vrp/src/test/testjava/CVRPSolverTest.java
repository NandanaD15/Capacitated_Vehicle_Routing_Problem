import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.*;
class CVRPSolverTest {

    private Depot createDepot() {
        return new Depot(0, 50, 50);
    }

    private List<Customer> generateRandomCustomers(int count, double minX, double maxX, double minY, double maxY) {
        List<Customer> customers = new ArrayList<>();
        Random rand = new Random();

        for (int i = 1; i <= count; i++) {
            double x = minX + rand.nextDouble() * (maxX - minX);
            double y = minY + rand.nextDouble() * (maxY - minY);
            customers.add(new Customer(i, x, y));
        }

        return customers;
    }
    @Test
    void testDiffAmgTwoApp(){
        Depot depot = new Depot(0,5,10);
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, 10.0, 20.0));
        customers.add(new Customer(2, 20.0, 30.0));
        customers.add(new Customer(3, 10.0, 15.0));
        customers.add(new Customer(4, 15.0, 10.0));

        CVRPSolver solver = new CVRPSolver(depot, customers);
        solver.solve();
        assertFalse(solver.getVehicles().isEmpty(), "Solver should produce at least one route.");

    }
    @Test
    void testSingleCustomer() {
        Depot depot = createDepot();
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, 10.0, 20.0));
//        List<Customer> customers = List.of(new Customer(1, 5, 5));
        CVRPSolver solver = new CVRPSolver(depot, customers);
        solver.solve();

        assertEquals(1, solver.getVehicles().size(), "Should use one vehicle for one customer.");
        assertEquals(1, solver.getVehicles().getFirst().getRoute().size(), "Route should contain one customer.");
    }

    @Test
    void testNoCustomers() {
        Depot depot = createDepot();
        List<Customer> customers = new ArrayList<>();

        CVRPSolver solver = new CVRPSolver(depot, customers);
        solver.solve();

        assertEquals(0, solver.getVehicles().size(), "No vehicles should be used when there are no customers.");
    }

    @Test
    void testDiffVehicleCapacity() {
        Depot depot = createDepot();
        List<Customer> customers = generateRandomCustomers(11, 10.23, 25.02,10.04,50.70); // vehicleCapacity = 10

        CVRPSolver solver = new CVRPSolver(depot, customers);
        solver.solve();
        assertFalse(solver.getVehicles().isEmpty(), "Solver should produce at least one route.");
    }

    @Test
    void testMultipleVehicles() {
        Depot depot = createDepot();
        List<Customer> customers = generateRandomCustomers(25, 75, 451,100,500); // 3 vehicles expected

        CVRPSolver solver = new CVRPSolver(depot, customers);
        solver.solve();

        assertEquals(3, solver.getVehicles().size(), "Should use 3 vehicles for 25 customers.");
        int totalCustomers = solver.getVehicles().stream().mapToInt(v -> v.getRoute().size()).sum();
        assertEquals(25, totalCustomers, "All customers should be assigned to routes.");
    }

    /*@Test
    void testNoDuplicateCustomers() {
        Depot depot = new Depot(0, 522, 672);
        List<Customer> customers = generateRandomCustomers(100000, 0, 100000,0,100000);
        CVRPSolver solver = new CVRPSolver(depot, customers);
        solver.solve();

        Set<Integer> visited = new HashSet<>();
        for (Vehicle v : solver.getVehicles()) {
            for (Customer c : v.getRoute()) {
                assertTrue(visited.add(c.getId()), STR."Customer \{c.getId()} is visited more than once.");
            }
        }
    }*/
    @Test
    void testRandomizedCustomerPositions() {
        Depot depot = new Depot(0, 50, 50);
        List<Customer> customers = generateRandomCustomers(25, 150, 250,250,400);

        CVRPSolver solver = new CVRPSolver(depot, customers);
        solver.solve();

        assertFalse(solver.getVehicles().isEmpty(), "Solver should produce at least one route.");
    }
    @Test

    void testBigData() throws IOException {
        Depot depot = new Depot(0 , 50 , 50);
        List<Customer> customers = CSVLoader.loadCustomersFromCSV("C:\\Users\\DevaannamalaiRavikum\\Desktop\\VRP-sbt\\vrp\\Data\\customer.csv");
        CVRPSolver solver = new CVRPSolver(depot, customers);
        solver.solve();
        assertFalse(solver.getVehicles().isEmpty(), "Solver should produce at least one route.");
    }
    @Test
    void testBigData1() throws IOException {
        Depot depot = new Depot(0 , 50 , 50);
        List<Customer> customers = CSVLoader.loadCustomersFromCSV("C:\\Users\\DevaannamalaiRavikum\\Desktop\\VRP-sbt\\vrp\\Data\\customer2.csv");
        CVRPSolver solver = new CVRPSolver(depot, customers);
        solver.solve();
        assertFalse(solver.getVehicles().isEmpty(), "Solver should produce at least one route.");
    }
}
