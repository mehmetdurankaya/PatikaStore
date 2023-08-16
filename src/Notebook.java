import java.util.Set;
import java.util.TreeSet;

public class Notebook extends Product {
    private String storageCapacity;
    static Set<Notebook> notebooks = new TreeSet<>();
    private String productType;

    public Notebook(String name, double price, Brand brandInfo, String screenSize, String ram, String storageCapacity) {
        super(name, price, brandInfo, screenSize, ram);
        this.storageCapacity = storageCapacity;
        this.productType = "Notebook";
    }

    public String getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(String storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public String getProductType() {
        return productType;
    }
    
}
