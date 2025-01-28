package tar_bait4_q1;

import java.util.HashMap;

public class Catalog {
    private HashMap<String, Double>catalog;
    public Catalog() {
        catalog=new HashMap<String, Double>();
    }
    public void addCatalogProduct(String name, double price) {
        catalog.put(name,price);
    }
    public double getPrice(String ProductName){
        Double price=catalog.get(ProductName);
        if (price==null)
            throw new IllegalArgumentException("Product not found: "+ ProductName);
        return price;
    }
}
