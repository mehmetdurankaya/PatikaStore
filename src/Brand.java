import java.util.Set;
import java.util.TreeSet;

public class Brand implements Comparable<Brand> {
    private final int id;
    private String name;
    private static int count;

    public static Set<Brand> Brands = new TreeSet<>();

    public Brand(int id){
        this.id = id;
    }

    public Brand(String name) {
        this.name = name;
        count++;
        this.id = count;
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

    public void printBrands(){
        for(Brand brand : Brands){
            System.out.println(brand.getName());
        }
    }

    @Override
    public int compareTo(Brand o1) {
        return this.getName().compareTo(o1.getName());
    }

}
