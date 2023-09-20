import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Product {
    private String productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Cart {
    private Map<String, Product> cartMap;

    public Cart() {
        this.cartMap = new HashMap<>();
    }


    public Map<String, Product> getCartMap() {
        return this.cartMap;
    }

    public void addToCart(Product prod) {
        String prodID = prod.getProductID();

        if(this.cartMap.containsKey(prodID)) {
            System.out.println("product already in cart");
        }
        this.cartMap.put(prodID, prod);
    }

    public void removeFromCart(String productID) {
        this.cartMap.remove(productID);
    }

    public void updateQuantity(String productID, int quantity) {
        Product prod = this.cartMap.get(productID);
        prod.setQuantity(quantity);
        this.cartMap.put(productID, prod);
    }

    public void viewCart() {
        int count = 1;
        System.out.println("------------ Cart ------------");
        for(Product prod: this.cartMap.values()) {
            System.out.println("sr no. " + count);
            System.out.println("product ID: |" + prod.getProductID());
            System.out.println("name:       |" + prod.getProductName());
            System.out.println("price(INR): |" + prod.getPrice());
            System.out.println("quantity:   |" + prod.getQuantity());
            System.out.println("------------------------------");
            count++;
        }
    }

    public void checkout() {
        System.out.println("proceed to checkout.");
        System.out.println("order completed!");
        this.cartMap.clear();
        System.out.println("cart now empty.");
    }
}

class CartService {
    private boolean check;

    public CartService() {
        this.check = true;
    }
    public static boolean idCheck(String productID) {
        if(productID.isBlank() || productID.length() != 5) {
            return false;
        }

        String regex = "^\\d{5}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(productID);
        return m.matches();

    }
    public static boolean idExist(String productID, Cart cart) {
        if(cart.getCartMap().containsKey(productID)) {
            System.out.println("product with ID:" + productID + " already in cart.");
            return true;
        }

        return false;
    }
    public void addToCartBlock(Scanner sc, Cart cart) {
        this.check = true;
        while(this.check) {

            String productID = new String();
            String productName = new String();
            double price = 0.0d;
            int quantity = 0;

            try {
                System.out.println("enter product details:");
                System.out.println("product ID(unique, 5 digit): ");
                productID = sc.nextLine();
                if (!idCheck(productID) || idExist(productID, cart)) {
                    System.out.println("enter a unique 5 digit ID.");
                    continue;
                }
                System.out.println("product name: ");
                productName = sc.nextLine();
                if (productName.isBlank()) {
                    System.out.println("enter a valid name");
                    continue;
                }
                System.out.println("price(INR): ");
                price = sc.nextDouble();
                sc.nextLine(); // consumes extra newline character
                if (price <= 0) {
                    System.out.println("enter a valid price");
                    continue;
                }
                System.out.println("quantity: ");
                quantity = sc.nextInt();
                if (quantity <= 0) {
                    System.out.println("enter a valid quantity");
                    continue;
                }
            } catch(Exception e) {
                System.out.println("enter valid inputs");
            }

            Product prod = new Product(productID, productName, price, quantity);
            cart.addToCart(prod);
            System.out.println("`"+ productName + "` added to cart");
            this.check = false;
        }
    }

    public void removeFromCartBlock(Scanner sc, Cart cart) {
        this.check = true;
        while(this.check) {
            System.out.println("enter product ID to search:");
            String productID = sc.nextLine();
            if(!idCheck(productID)) {
                System.out.println("enter a unique 5 digit ID.");
                continue;
            } else if(!idExist(productID, cart)) {
                System.out.println("no product found.");
                return;
            }
            cart.removeFromCart(productID);
            System.out.println("product with ID: " + productID + " removed");
            this.check = false;
        }
    }

    public void updateQuantityBlock(Scanner sc, Cart cart) {
        this.check = true;
        while(this.check) {
            System.out.println("enter product ID to search:");
            String productID = sc.nextLine();
            if(!idCheck(productID)) {
                System.out.println("enter a unique 5 digit ID.");
                continue;
            } else if(!idExist(productID, cart)) {
                System.out.println("no product found.");
                return;
            }
            System.out.println("enter update quantity: ");
            int quantityNew;
            try{
                quantityNew = sc.nextInt();
            } catch(Exception e) {
                System.out.println("enter an integer input");
                continue;
            }
            if(quantityNew<=0) {
                System.out.println("input cannot be 0 or negative");
                continue;
            }
            cart.updateQuantity(productID, quantityNew);
            System.out.println("quantity updated");
            this.check = false;
        }

    }

    public void viewCartBlock(Cart cart) {
        if(cart.getCartMap().isEmpty()) {
            System.out.println("cart is empty");
            return;
        }
        cart.viewCart();
    }

    public void checkoutBlock(Cart cart) {
        if(cart.getCartMap().isEmpty()) {
            System.out.println("cannot checkout empty cart.");
            return;
        }
        cart.checkout();
    }




}

public class Main {
    public static void main(String[] args) {
        CartService cartServiceObj = new CartService();
        Cart cartObj = new Cart();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("---------- cart management system ----------");
            System.out.println("enter options to perform: ");
            System.out.println("1- add to cart");
            System.out.println("2- remove from cart");
            System.out.println("3- update quantity");
            System.out.println("4- view cart");
            System.out.println("5- checkout");
            System.out.println("0- exit");
            int option = sc.nextInt();
            sc.nextLine(); // consumes extra newline character
            switch(option) {
                case 0: //exit the system
                    sc.close();
                    System.out.println("exiting....");
                    System.exit(0);
                case 1: // add product to cart
                    cartServiceObj.addToCartBlock(sc, cartObj);
                    break;
                case 2: // remove product from cart
                    cartServiceObj.removeFromCartBlock(sc, cartObj);
                    break;
                case 3: // update quantity of a selected product
                    cartServiceObj.updateQuantityBlock(sc, cartObj);
                    break;
                case 4: // view all the products in cart
                    cartServiceObj.viewCartBlock(cartObj);
                    break;
                case 5: // checkout all the items in the cart
                    cartServiceObj.checkoutBlock(cartObj);
                    break;
                default:
                    System.out.println("invalid option, enter a value between 0-5");
            }
        }
    }
}