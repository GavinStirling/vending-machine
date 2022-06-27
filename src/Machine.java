import java.util.ArrayList;
import java.util.List;

public class Machine {
    private List stockedMachine = new ArrayList<Product>();

    public Machine (List stockedMachine) {
        this.stockedMachine = stockedMachine;
    }

    public List getStockedMachine() {
        return stockedMachine;
    }

    public void setStockedMachine(List stockedMachine) {
        this.stockedMachine = stockedMachine;
    }

    //Add a product
    public void addProduct(Product product) {
        stockedMachine.add(product);
    }

    // Remove a product
    public void removeProduct(int index) {
        if (getStockAmount() <= 0) {
            System.out.println("The vending machine is already empty.");
        } else {
            stockedMachine.remove(index);
        }
    }

    public void incrementProduct(int index, int qty) {

    }

    // Check the size of the array
    public int getStockAmount() {
        return stockedMachine.size();
    }

    // Check amount of products in the machine


    public Product getProduct(int index) {
        return (Product) (stockedMachine.get(index));
    }

    public String getCurrentStock() {
        String currentStock = "";
        for (int i = 0; i < getStockAmount(); i++) {
            Product product = getProduct(i);
            if (product.getQty() > 0) {
                currentStock += product.getInfo();
            }
        }
        return currentStock;
    }

    public int getQty(String cat) {
        int qty = 0;
        for (int i = 0; i < stockedMachine.size(); i++) {
            if (getProduct(i).getCategory().equals(cat)) {
                qty += 1;
            }
        }
        return qty;
    }

    public void buyProduct(String name,double cash, int qty) {
        for (int i = 0; i < stockedMachine.size(); i++) {
            Product product = (Product) (stockedMachine.get(i));
            if (product.getQty() == 0) {
                System.out.println("Sorry, this product is sold out");
            } else if (product.getName().equalsIgnoreCase(name)) {
                double price = product.getPrice();
                double cashOut = 0;
                int productQty = product.getQty();

                if (productQty < qty) {
                    System.out.println("You can only purchase " + productQty + " of this item. Please try again.");
                } else {
                    if (cash < price * productQty) {
                        System.out.println("You have insufficient funds for this transaction. Please try again once you have the correct amount.");
                    } else {
                        product.setQty(productQty-qty);
                        cashOut = cash - (price * productQty);
                        System.out.println(" You purchased " + qty + " " + name + ". Thanks you for shopping with us.");
                        getCurrentStock();
                    }
                }
            } else {
                System.out.println("Not a valid input, please try again.");
            }
        }



    }

    public void refillProduct (int qty, String name) {
        for (int i = 0; i < stockedMachine.size(); i++) {
            Product product = (Product) (stockedMachine.get(i));
            if (product.getName().equalsIgnoreCase(name)) {
                int maxQty = product.getMaxQty();
                int currentQty = product.getQty();

                if (maxQty < currentQty + qty) {
                    product.setQty(maxQty);
                    System.out.println("The machine can only hold a maximum of " + maxQty + " of this product. \nIt has been filled to this quantity.");
                } else {
                    product.setQty(currentQty + qty);
                    System.out.println("You added an additional " + qty + " of " + name + ", there is now a total quantity of " + product.getQty() + " in the machine.");
                }
            } else {
                System.out.println("Not a valid input, please try again.");
            }
        }


    }

    public void takeStock () {
        double totalValue = 0;
        System.out.println("The stock list is shown as below:");
        for (int i = 0; i < stockedMachine.size(); i++) {
            Product product = (Product) (stockedMachine.get(i));
            if (product.getQty() > 0) {
                double currentValue = product.getQty() * product.getPrice();
                totalValue += currentValue;
                System.out.println(product.getInfo());
                System.out.println("Total value of this products stock is: $" + Math.round(currentValue));
            }
        }
        System.out.println("\nThe total value of the stock in the machine is: $" + totalValue);
    }

}
