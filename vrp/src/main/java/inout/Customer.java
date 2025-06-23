package java.inout;

public class Customer {
    public  final double x, y;
    public int id;

    public Customer(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Customer other)) return false;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return STR."IO.Customer \{id} (\{x}, \{y})";
    }
}




