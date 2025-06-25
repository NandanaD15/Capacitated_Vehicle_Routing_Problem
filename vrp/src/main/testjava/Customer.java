public class Customer {
    private  final double x, y;
    private final int id;

    public Customer(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }


    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public double getDistance(double depotX, double depotY){
        double dx = this.x - depotX ;
        double dy = this.y - depotY;
        return Math.sqrt(((dx * dx ) + (dy * dy)));
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Customer other)) return false;
        return this.id == other.id;
    }
    // Debug
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return STR."\{id} (\{x}, \{y})";
    }
}




