class Product {
    String productId, productName, category;
    double price;
    int stockQuantity;

    static int totalProducts = 0;

    Product(String id, String name, double price, String category, int stock) {
        this.productId = id;
        this.productName = name;
        this.price = price;
        this.category = category;
        this.stockQuantity = stock;
        totalProducts++;
    }

    static Product findProductById(Product[] products, String productId) {
        for (Product p : products) if (p.productId.equals(productId)) return p;
        return null;
    }
}

class ShoppingCart {
    String cartId, customerName;
    Product[] products;
    int[] quantities;
    double cartTotal = 0;
    int count = 0;

    ShoppingCart(String id, String name, int capacity) {
        this.cartId = id; this.customerName = name;
        products = new Product[capacity];
        quantities = new int[capacity];
    }

    void addProduct(Product p, int qty) {
        if (p.stockQuantity >= qty) {
            products[count] = p;
            quantities[count] = qty;
            cartTotal += p.price * qty;
            p.stockQuantity -= qty;
            count++;
        } else System.out.println("Not enough stock!");
    }

    void removeProduct(String productId) {
        for (int i = 0; i < count; i++) {
            if (products[i].productId.equals(productId)) {
                cartTotal -= products[i].price * quantities[i];
                products[i].stockQuantity += quantities[i];
                System.out.println(products[i].productName + " removed.");
                products[i] = products[count - 1]; // shift
                quantities[i] = quantities[count - 1];
                count--;
                return;
            }
        }
        System.out.println("Not in cart!");
    }

    void displayCart() {
        System.out.println("\nCart of " + customerName + ":");
        for (int i = 0; i < count; i++) {
            System.out.println(products[i].productName + " x " + quantities[i]);
        }
        System.out.println("Total: $" + cartTotal);
    }
}

public class ShoppingCartDemo {
    public static void main(String[] args) {
        // Products
        Product[] items = {
            new Product("P1", "Laptop", 800, "Electronics", 5),
            new Product("P2", "Book", 15, "Books", 10),
            new Product("P3", "Shirt", 25, "Clothing", 8)
        };

        // Cart
        ShoppingCart cart = new ShoppingCart("C1", "Alice", 10);

        cart.addProduct(items[0], 1); // Laptop
        cart.addProduct(items[1], 2); // Books
        cart.displayCart();

        cart.removeProduct("P2"); // Remove books
        cart.displayCart();

        System.out.println("Total Products Created: " + Product.totalProducts);
    }
}
