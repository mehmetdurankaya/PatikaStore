import java.util.Set;
import java.util.TreeSet;

public class MobilePhone extends Product {
    private String memoryInfo;
    private String batteryPower;
    private String colour;
    private final String productType;
    static Set<MobilePhone> mobilePhones = new TreeSet<>();

    public MobilePhone(String name, double price, Brand brandInfo, String screenSize, String ram, String memoryInfo, String batteryPower, String colour) {
        super(name, price, brandInfo, screenSize, ram);
        this.memoryInfo = memoryInfo;
        this.batteryPower = batteryPower;
        this.colour = colour;
        this.productType = "Telefon";
    }

    public String getMemoryInfo() {
        return memoryInfo;
    }

    public void setMemoryInfo(String memoryInfo) {
        this.memoryInfo = memoryInfo;
    }

    public String getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(String batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getProductType() {
        return productType;
    }
    
}
