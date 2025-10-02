public class Car implements Vehicle {
    private String brand;
    private DatabaseOPS dbOps;

    // Constructor injection
    public Car(String brand, DatabaseOPS dbOps) {
        this.brand = brand;
        this.dbOps = dbOps;
    }

    @Override
    public void saveIntoDB() {
        System.out.println("Saving Car brand: " + brand);
        System.out.println("Using DB connection: " + dbOps.getUrl() + " | User: " + dbOps.getUsername());
    }
}