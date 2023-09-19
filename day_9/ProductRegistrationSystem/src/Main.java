import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Product {
    private String productID;
    private String productName;
    private String description;
    private String manufacturer;
    private int warrantyPeriod;

    public Product(String productID, String productName, String description, String manufacturer, int warrantyPeriod) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.manufacturer = manufacturer;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getProductID() {
        return this.productID;
    }
    public String getProductName() {
        return this.productName;
    }
    public String getDescription() {
        return this.description;
    }
    public String getManufacturer() {
        return this.manufacturer;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
}

class ProductRegistrationSystem {

    private Map<String, Integer> prodFreqMap;
    private List<Product> prodList;

    public ProductRegistrationSystem() {
        this.prodList = new ArrayList<>();
        this.prodFreqMap = new HashMap<>();
    }

    public List<Product> getProdList() {
        return prodList;
    }

    public Map<String, Integer> getProdFreqMap() {
        return prodFreqMap;
    }

    public void register(String productID, String productName, String description, String manufacturer, int warrantyPeriod) {
        Product prod = new Product(productID, productName, description, manufacturer, warrantyPeriod);
        this.prodList.add(prod);
        String uniqueKey = productID + "@" + productName + "@" + String.valueOf(warrantyPeriod > 0?1:0);
        if(this.prodFreqMap.containsKey(uniqueKey)) {
            this.prodFreqMap.put(uniqueKey, this.prodFreqMap.get(uniqueKey) + 1);
        } else {
            this.prodFreqMap.put(uniqueKey, 1);
        }
    }

    public void displayAll() {
        if(this.prodList.isEmpty()) {
            System.out.println("registry is empty");
        }
        System.out.println("Displaying all the products:");
        for(Product prod: this.prodList) {
            System.out.println("-----------------------------------------------------");
            System.out.println("id:                | " + prod.getProductID());
            System.out.println("name:              | " + prod.getProductName());
            System.out.println("description:       | " + prod.getDescription());
            System.out.println("manufacturer:      | " + prod.getManufacturer());
            System.out.println("warranty (months): | " + prod.getWarrantyPeriod());
            System.out.println("-----------------------------------------------------");
        }
    }

    public void searchByID(String productID) {
        for(Product prod: this.prodList) {
            if(productID.equals(prod.getProductID())) {
                System.out.println("product found!");
                System.out.println("------------------------------------------------");
                System.out.println("id:                |" + prod.getProductID());
                System.out.println("name:              |" + prod.getProductName());
                System.out.println("description:       |" + prod.getDescription());
                System.out.println("manufacturer:      |" + prod.getManufacturer());
                System.out.println("warranty (months): |" + prod.getWarrantyPeriod());
                System.out.println("-------------------------------------------------");
                break;
            }
        }
        System.out.println("no such product found.");
    }

    public void report() {
        if(this.prodFreqMap.isEmpty()) {
            System.out.println("registry is empty");
            return;
        }
        System.out.println("------- report -------");
        System.out.println("-------------------------------------------------------------------------");
        String warrantyCheck;
        for(Map.Entry<String, Integer> map : prodFreqMap.entrySet()) {
            String[] infoArr = map.getKey().split("@");
            if(infoArr[2].equals("1")) {
                warrantyCheck = "available";
            } else {
                warrantyCheck = "unavailable";
            }
            System.out.println("name: " + infoArr[1] + ", count: " + map.getValue() + ", warranty: " + warrantyCheck);
            System.out.println("-------------------------------------------------------------------------");
        }
    }

}

public class Main {

    public static boolean idExist(String productID, ProductRegistrationSystem ProdReg) {
        Set<String> keySet = ProdReg.getProdFreqMap().keySet();
        // separating productID from key (created using ID, name, warranty)
        List<String> separateID = Arrays.asList(String.join("@", keySet).split("@"));
        if(separateID.contains(productID)) {
            System.out.println("Product ID already present.");
            return true;
        }

        return false;
    }
    public static boolean idCheck(String productID, ProductRegistrationSystem ProdReg) {
        if(productID.isBlank() || productID.length() != 5) {
            return false;
        }

        String regex = "^\\d{5}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(productID);
        return m.matches();
    }
    public static void main(String[] args) {
        ProductRegistrationSystem prodReg = new ProductRegistrationSystem();
        Scanner sc = new Scanner(System.in);
        System.out.println("------ Product Registration System ------");
        boolean check;
        while(true) {
            System.out.println("choose an option to perform:");
            System.out.println("1- register the product");
            System.out.println("2- display all the product info");
            System.out.println("3- search product using ID");
            System.out.println("4- show report");
            System.out.println("0 - exit");

            int option = sc.nextInt();
            sc.nextLine(); // consume unnecessary newline character

            switch(option) {
                case 0:
                    sc.close();
                    System.out.println("exiting.....");
                    System.exit(0);
                case 1:
                    check = true;
                    while(check) {
                        System.out.println("enter product details:");
                        System.out.println("product ID(unique, 5 digit): ");
                        String productID = sc.nextLine();
                        if(!idCheck(productID, prodReg) || idExist(productID, prodReg)) {
                            System.out.println("enter a unique 5 digit ID.");
                            continue;
                        }
                        System.out.println("product name: ");
                        String productName = sc.nextLine();
                        if(productName.isBlank()) {
                            System.out.println("enter a valid name");
                            continue;
                        }
                        System.out.println("description: ");
                        String description = sc.nextLine();
                        if(description.isBlank()) {
                            System.out.println("enter a valid description");
                            continue;
                        }
                        System.out.println("manufacturer: ");
                        String manufacturer = sc.nextLine();
                        if(manufacturer.isBlank()) {
                            System.out.println("enter a valid manufacturer");
                            continue;
                        }
                        System.out.println("warranty period(months): ");
                        int warrantyPeriod = sc.nextInt();
                        sc.nextLine(); // consumes unnecessary newline character
                        prodReg.register(productID, productName, description, manufacturer, warrantyPeriod);
                        System.out.println("product '" + productName + "' registered.");
                        check = false;
                    }
                case 2:
                    prodReg.displayAll();
                    break;
                case 3:
                    check = true;
                    while(check) {
                        System.out.println("enter product ID to search:");
                        String productID = sc.nextLine();
                        if(!idCheck(productID, prodReg)) {
                            System.out.println("enter a unique 5 digit ID.");
                            continue;
                        } else if(!idExist(productID, prodReg)) {
                            System.out.println("no product found.");
                            break;
                        }
                        for(Product prod: prodReg.getProdList()) {
                            if(productID.equals(prod.getProductID())) {
                                System.out.println("product found!");
                                System.out.println("---------------------------------------");
                                System.out.println("product id: " + prod.getProductID());
                                System.out.println("name: " + prod.getProductName());
                                System.out.println("description: " + prod.getDescription());
                                System.out.println("manufacturer: " + prod.getManufacturer());
                                System.out.println("warranty period(months): " + prod.getWarrantyPeriod());
                                System.out.println("---------------------------------------");
                                check = false;
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    prodReg.report();
                    break;
                default:
                    System.out.println("invalid option, enter an option between 0-4");
                    break;
            }
        }
    }
}