public class Plane implements Vehicle {
    private String brand;
    private DatabaseOPS dbOps;

    @Override
    public void saveIntoDB() {
        System.out.println("Saving Plane brand: " + brand);
        System.out.println("Using DB connection: " + dbOps.getUrl() + " | User: " + dbOps.getUsername());
        
    }

    // Setter injection
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDbOps(DatabaseOPS dbOps) {
        this.dbOps = dbOps;
    }
}