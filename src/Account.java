import java.util.HashMap;

public class Account {
    private Catalog catalog;
    private HashMap<String, Integer> quantities;
    private double discount;
    private double price;

    public Account(Catalog catalog) {
        this.catalog = catalog;
        this.quantities = new HashMap<>();
        this.discount = 0;
    }

    public void addProduct(String productName, int quantity) {
        double price = catalog.getPrice(productName); // Ensure product exists
        quantities.put(productName, quantity);
    }

    public void changeQuantity(String productName, int newQuantity) {
        if (quantities.containsKey(productName)) quantities.put(productName, newQuantity);
        else throw new IllegalArgumentException("Product does not exist");
    }

    public void changePrice(String productName, double newPrice) {
        catalog.addCatalogProduct(productName, newPrice);
    }

    public void removeProduct(String productName) {
        if (!quantities.containsKey(productName))
            throw new IllegalArgumentException("Product does not exist");

        quantities.remove(productName);
    }

    public double calcTotalAmount() {
        double sum = 0.0;
        for (String name : quantities.keySet()) {
            sum += catalog.getPrice(name) * quantities.get(name);
        }
        sum = sum * (1 - this.discount);
        return sum;
    }

    public int calcNumOfDiffProds() {
        return quantities.size();
    }

    public int getQuantity(String name) {
        return quantities.getOrDefault(name, 0); // Returns 0 if product not found
    }

    public void applyGlobalDiscount(double discount) {
        if (discount < 0.0 || discount > 1.0) {
            throw new IllegalArgumentException("Discount must be between 0.0 and 1.0");
        }
        this.discount = discount;
    }
}