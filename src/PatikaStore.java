import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PatikaStore {
    Scanner input = new Scanner(System.in);

    static {
        Brand.Brands.add(new Brand("Samsung"));
        Brand.Brands.add(new Brand("Lenovo"));
        Brand.Brands.add(new Brand("Apple"));
        Brand.Brands.add(new Brand("Huawei"));
        Brand.Brands.add(new Brand("Casper"));
        Brand.Brands.add(new Brand("Asus"));
        Brand.Brands.add(new Brand("HP"));
        Brand.Brands.add(new Brand("Xiaomi"));
        Brand.Brands.add(new Brand("Monster"));

        MobilePhone.mobilePhones.add(new MobilePhone("Samsung Galaxy A51", 3199, new Brand("Samsung"), "6.5", "6 GB", "128 GB", "4000", "Siyah"));
        MobilePhone.mobilePhones.add(new MobilePhone("iphone 11 64 GB", 7379, new Brand("Apple"), "6.1", "6 GB", "64 GB", "3046", "Mavi"));
        MobilePhone.mobilePhones.add(new MobilePhone("Redmi Note 10 Pro 8GB", 4012, new Brand("Xiaomi"), "6.5", "12 GB", "128 GB", "4000", "Beyaz"));

        Notebook.notebooks.add(new Notebook("LENOVO V14 IGL ", 3699, new Brand("Lenovo"), "14.0", "16", "1024"));
        Notebook.notebooks.add(new Notebook("HUAWEI Matebook 14 ", 7000, new Brand("Huawei"), "14.0", "16", "512"));
        Notebook.notebooks.add(new Notebook("ASUS Tuf Gaming  ", 8199, new Brand("Asus"), "15.6", "16", "2048"));

        Product.products.addAll(MobilePhone.mobilePhones);
        Product.products.addAll(Notebook.notebooks);
    }

    void run() {

        while (true) {
            System.out.println("**************************************************");
            System.out.println("Patika Store Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("4 - Yeni Ürün Ekle");
            System.out.println("5 - Ürünleri ID Numarası veya Markaya Göre Listele");
            System.out.println("6 - Ürün Sil");
            System.out.println("7 - Çıkış Yap");
            System.out.print("Tercihiniz: ");
            int select;

            try {
                select = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Geçersiz veri girişi!");
                break;
            }
            if (select == 7) {
                break;
            }

            switch (select) {
                case 1 -> {
                    System.out.print("1 - Notebook ürünlerini listele\n" +
                            "Çıkış yapmak için herhangi bir karakteri tuşlayınız: ");
                    try {
                        select = Integer.parseInt(input.next());
                    } catch (NumberFormatException e) {
                        System.out.println("Çıkış yapıldı!");
                    }
                    if (select == 1) {
                        listNotebooks();
                    }
                }
                case 2 -> {
                    System.out.print("1 - Cep telefonu ürünlerini listele\n" +
                            "Çıkış yapmak için herhangi bir karakteri tuşlayınız: ");
                    try {
                        select = Integer.parseInt(input.next());
                    } catch (NumberFormatException e) {
                        System.out.println("Çıkış yapıldı!");
                    }
                    if (select == 1) {
                        listMobilePhones();
                    }
                }
                case 3 -> listBrands();
                case 4 -> addProduct();
                case 5 -> {
                    System.out.println("1 - ID numarasına göre filtrele\n" +
                            "2 - Markaya göre filtrele");
                    try {
                        select = Integer.parseInt(input.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Geçersiz bir veri girdiniz!");
                    }
                    if (select == 1) {
                        System.out.print("Ürünün ID numarasını giriniz: ");
                        try {
                            select = Integer.parseInt(input.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Geçersiz bir veri girdiniz!");
                        }
                        listAllProducts(select);
                    }
                    if (select == 2) {
                        listBrands();
                        System.out.print("Marka ismini giriniz: ");
                        listAllProducts(input.nextLine());
                    }
                }
                case 6 -> {
                    System.out.print("Silmek istediğiniz ürünün ID numarasını giriniz: ");
                    int idNum = input.nextInt();
                    input.nextLine();
                    Set<Product> toRemove = new TreeSet<>();
                    for (Product p : Product.products) {
                        if (p.getId() == idNum) {
                            toRemove.add(p);
                        }
                    }
                    Product.products.removeAll(toRemove);
                    Notebook.notebooks.removeAll(toRemove);
                    MobilePhone.mobilePhones.removeAll(toRemove);
                }
            }
        }
    }

    public void listBrands() {
        System.out.println("Markalarımız");
        System.out.println("--------------");
        for (Brand brand : Brand.Brands) {
            System.out.println(brand.getName());
        }
    }

    public void listMobilePhones() {
        System.out.println("Cep Telefonu Listesi\n");

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-8s%10s%27s%11s%18s%12s%13s%15s%16s%n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Pil", "RAM", "Renk");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        for (MobilePhone mp : MobilePhone.mobilePhones) {
            System.out.printf("%-10s%-30s%-11s%-15s%-15s%-15s%-15s%-15s%-15s%n", mp.getId(), mp.getName(), mp.getPrice(), mp.getBrandInfo().getName()
                    , mp.getMemoryInfo(), mp.getScreenSize(), mp.getBatteryPower(), mp.getRam(), mp.getColour()
            );
        }
        System.out.println();
    }

    public void listNotebooks() {
        System.out.println();
        System.out.println("Notebook Listesi\n");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-8s%10s%27s%11s%18s%12s%13s%n", "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Notebook n : Notebook.notebooks) {
            System.out.printf("%-10s%-30s%-11s%-15s%-15s%-15s%-15s%n", n.getId(), n.getName(), n.getPrice(), n.getBrandInfo().getName(), n.getStorageCapacity(), n.getScreenSize(), n.getRam()
            );
        }
    }

    public void addProduct() {
        System.out.println("1 - Telefon");
        System.out.println("2 - Notebook");
        System.out.print("Eklemek istediğiniz ürün grubunu giriniz: ");


        int productType = input.nextInt();
        input.nextLine();

        if (productType == 1) {
            System.out.println("Telefon özelliklerini sırasıyla giriniz: ");

            System.out.print("Ürün Adı: ");
            String productName = input.nextLine();
            System.out.print("Ürün Fiyatı: ");
            int price = input.nextInt();
            input.nextLine();

            listBrands();
            System.out.println("--------------");
            System.out.print("Seçeceğiniz markayı yazınız: ");

            String brand = input.nextLine();
            String firstLatter;
            firstLatter = brand.substring(0, 1).toUpperCase();
            brand = firstLatter + brand.substring(1);

            while (!Brand.Brands.contains(new Brand(brand))) {

                System.out.println("Geçersiz marka ismi girdiniz! Lütfen tekrar deneyiniz.");
                brand = input.nextLine();
                firstLatter = brand.substring(0, 1).toUpperCase();
                brand = firstLatter + brand.substring(1);
            }

            System.out.print("Depolama: ");
            String storageCapacity = input.nextLine();
            System.out.print("Ekran: ");
            String screenSize = input.nextLine();
            System.out.print("Pil: ");
            String battery = input.nextLine();
            System.out.print("RAM: ");
            String ram = input.nextLine();
            System.out.print("Renk: ");
            String color = input.nextLine();

            System.out.println("Ürün eklendi.");
            MobilePhone.mobilePhones.add(new MobilePhone(productName, price, new Brand(brand), screenSize, ram, storageCapacity, battery, color));

        } else if (productType == 2) {
            System.out.println("Notebook özelliklerini sırasıyla giriniz: ");

            System.out.print("Ürün Adı: ");
            String productName = input.nextLine();
            System.out.print("Ürün Fiyatı: ");
            int price = input.nextInt();
            input.nextLine();
            listBrands();

            System.out.print("Seçeceğiniz markayı yazınız: ");
            System.out.println("--------------");

            String brand = input.nextLine();
            String firstLatter;
            firstLatter = brand.substring(0, 1).toUpperCase();
            brand = firstLatter + brand.substring(1);

            while (!Brand.Brands.contains(new Brand(brand))) {
                System.out.println("Geçersiz marka ismi girdiniz! Lütfen tekrar deneyiniz.");
                brand = input.nextLine();
                firstLatter = brand.substring(0, 1).toUpperCase();
                brand = firstLatter + brand.substring(1);
            }

            System.out.print("Depolama: ");
            String storageCapacity = input.nextLine();
            System.out.print("Ekran: ");
            String screenSize = input.nextLine();
            System.out.print("RAM: ");
            String ram = input.nextLine();
            System.out.println("Ürün eklendi!");
            Notebook.notebooks.add(new Notebook(productName, price, new Brand(brand), screenSize, ram, storageCapacity));
        }
        Product.products.addAll(Notebook.notebooks);
        Product.products.addAll(MobilePhone.mobilePhones);
    }

    public void listAllProducts(int select) {
        System.out.println("Ürün Listesi\n");
        System.out.format("%-15s%-35s%-15s%n", "Ürün ID", "Ürün Adı", "Ürün Markası");

        for (Product product : Product.products) {
            if (product.getId() == select) {
                System.out.format("%-15s%-35s%-15s", product.getId(), product.getName(), product.getBrandInfo().getName());
            }
        }
        System.out.println();
    }

    public void listAllProducts(String select) {
        System.out.println("Ürün Listesi\n");
        System.out.format("%-15s%-35s%-15s%n", "Ürün ID", "Ürün Adı", "Ürün Markası");

        for (Product product : Product.products) {
            if (product.brandInfo.getName().equalsIgnoreCase(select)) {
                System.out.format("%-15s%-35s%-15s", product.getId(), product.getName(), product.getBrandInfo().getName());
            }
        }
        System.out.println();
    }
}
