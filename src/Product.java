import java.util.Set;
import java.util.TreeSet;

public abstract class Product implements Comparable<Product> {
    private final int id;
    private double price;
    private double discountRate;
    private int amountOfStock;
    private String name;
    Brand brandInfo;
    private static int count;
    private String screenSize;
    private String ram;
    static Set<Product> products = new TreeSet<>();


    public Product(String name, double price, Brand brandInfo, String screenSize, String ram) {
        count++;
        this.id = count;
        this.name = name;
        this.price = price;
        this.brandInfo = brandInfo;
        this.screenSize = screenSize;
        this.ram = ram;
        this.discountRate = 0;
        this.amountOfStock = 50;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        double tempDiscountRate;
        tempDiscountRate = this.discountRate / 100;
        tempDiscountRate = this.price * tempDiscountRate;
        this.price -= tempDiscountRate;
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;

    }

    public int getAmountOfStock() {
        return amountOfStock;
    }

    public void setAmountOfStock(int amountOfStock) {
        this.amountOfStock = amountOfStock;
    }

    public Brand getBrandInfo() {
        return brandInfo;
    }

    public void setBrandInfo(Brand brandInfo) {
        this.brandInfo = brandInfo;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    @Override
    public int compareTo(Product o) {
        if (this.getId() > o.getId()) {
            return 1;
        } else if (o.getId() > this.getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}
