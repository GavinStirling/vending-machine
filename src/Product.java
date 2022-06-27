public class Product {
    private String name;
    private String category;
    private double price;
    private int maxQty;
    private int qty;

    public Product (String name, String category, double price, int maxQty, int qty) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.maxQty = maxQty;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxQty() {
        return maxQty;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getInfo() {
        return String.format("\nName: %s \nCategory: %s \nPrice: %s \nQty: %s\n", name, category, price, qty);
    }


}
