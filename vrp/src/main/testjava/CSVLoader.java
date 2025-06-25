import java.io.*;
import java.util.*;
public class CSVLoader {

    public static List<Customer> loadCustomersFromCSV(String filePath) throws IOException {
        List<Customer> customers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        reader.readLine(); // skip header
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            double x = Double.parseDouble(parts[1]);
            double y = Double.parseDouble(parts[2]);
            customers.add(new Customer(id, x, y));
        }
        reader.close();
        return customers;
    }
}
