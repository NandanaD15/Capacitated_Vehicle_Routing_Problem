
class Customer {
    public double x, y;
    public int id;
    private int demand;




    public Customer(int id, double x, double y, int demand) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.demand = demand;
    }

    public Customer(int id, double x, double y) //if using kdtree
    {
        this(id, x, y, 1);
    }

    public int getDemand() {
        return demand;
    }




    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Customer other)) return false;
        return this.id == other.id;
    }
}


