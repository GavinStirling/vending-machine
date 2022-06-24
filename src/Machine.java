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
            currentStock += ((Product) (getProduct(i))).getInfo();
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


}
