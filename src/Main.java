import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        String[][] drinks = new String[][]{{"Water", "1.50"}, {"Coco Cola", "1.00"}, {"Creme Soda", "1.25"}};
//        String[][] crisps = new String[][]{{"Lightly Salted", "1.00"}, {"Fruit Chutney", "0.75"}, {"Salt & Vinegar", "0.85"}};
//        String[][] chocolateBars = new String[][]{{"Bar One", "0.9"}, {"Mars", "0.85"}, {"Kit Kat", "1.05"}};
//        String[][] cerealBars = new String[][]{{"Kellogs", "1.35"}, {"High Protein", "1.25"}, {"Otees", "1.55"}};
//
//        String[] types = new String[]{"drinks", "crisps", "chocolate-bar", "cereal-bar"};

        List stockList = new ArrayList<Product>();
        Machine stock = new Machine(stockList);

        stock.addProduct(new Product( "Water", "drink", 1.50, 10, (int) (Math.random()*10)));
        stock.addProduct(new Product( "Coco Cola", "drink", 1.00, 10, (int) (Math.random()*10)));
        stock.addProduct(new Product( "Creme Soda", "drink", 1.25, 10, (int) (Math.random()*10)));
        stock.addProduct(new Product( "Lightly Salted", "crisps", 1.00, 10, (int) (Math.random()*10)));
        stock.addProduct(new Product( "Fruit Chutney", "crisps", 0.75, 10, (int) (Math.random()*10)));
        stock.addProduct(new Product( "Salt & Vinegar", "crisps", 0.85, 10, (int) (Math.random()*10)));
        stock.addProduct(new Product( "Bar One", "chocolate-bar", 0.9, 10, (int) (Math.random()*10)));
        stock.addProduct(new Product( "Mars", "chocolate-bar", 0.85, 10, (int) (Math.random()*10)));
        stock.addProduct(new Product( "Kit Kat", "chocolate-bar", 1.05, 10, (int) (Math.random()*10)));
        stock.addProduct(new Product( "Kelloggs", "cereal-bar", 1.35, 10, (int) (Math.random()*10)));
        stock.addProduct(new Product( "High Protein", "cereal-bar", 1.25, 10, (int) (Math.random()*10)));
        stock.addProduct(new Product( "Otees", "cereal-bar", 1.55, 10, (int) (Math.random()*10+1)));

//        for (int i = 0; i < stock.getStockAmount(); i++) {
//            int typeIndex = (int) (Math.random() * types.length);
//            String name = "";
//            String cat = "";
//            double price = 0;
//
//            int index = 0;
//
//            switch (typeIndex) {
//                // Drinks case
//                case 0:
//
//                    index = (int) (Math.random() * drinks.length);
//                    name = drinks[index][0];
//                    cat = "drink";
//                    price = Double.parseDouble(drinks[index][1]);
//
//                    break;
//                // Crisps case
//                case 1:
//                    index = (int) (Math.random() * crisps.length);
//                    name = crisps[index][0];
//                    cat = "crisps";
//                    price = Double.parseDouble(crisps[index][1]);
//                    break;
//                // Chocolate Bar case
//                case 2:
//                    index = (int) (Math.random() * chocolateBars.length);
//                    name = chocolateBars[index][0];
//                    cat = "chocolate-bar";
//                    price = Double.parseDouble(chocolateBars[index][1]);
//                    break;
//                // Drinks case
//                case 3:
//                    index = (int) (Math.random() * cerealBars.length);
//                    name = cerealBars[index][0];
//                    cat = "cereal-bar";
//                    price = Double.parseDouble(cerealBars[index][1]);
//                    break;
//            }
//            stock.addProduct(new Product(name, cat,price));
//        }

//        System.out.println(stock.getCurrentStock());



        Commands currentCommands = new Commands("Vending Machine", new String[]{});
        String nextCommand = "home";
        boolean isActive = true;

        currentCommands.printMessage("Welcome to Gavin's Vending Machine");
        while (isActive) {
            switch(nextCommand) {
                case "home" :
                    currentCommands.printGreeting();
                    stock.getCurrentStock();
                    currentCommands = new Commands("Home", new String[]{"Buy something", "Refill a product", "Check the stock", "Quit the vending machine"});
                    currentCommands.printCommands();
                    currentCommands.printMessage("Please select an option from above:");
                    int userChoice = currentCommands.getCommandInput();
                    switch(userChoice) {
                        case 1:
                            currentCommands.printMessage("Buy an item:");
                            currentCommands.printMessage(stock.getCurrentStock());
                            currentCommands.printMessage("Please type the name of the product which you wish to purchase:");
                            String productName = currentCommands.getStringInput();
                            currentCommands.printMessage("Please select the quantity of the product which you which to purchase:");
                            int productQty = currentCommands.getIntegerInput();
                            currentCommands.printMessage("Please insert your cash to complete purchase transaction:");
                            double userCash = currentCommands.getDoubleInput();
                            stock.buyProduct(productName, userCash, productQty);
                            stock.getCurrentStock();
                            nextCommand = "home";
                            break;

                        case 2:
                            currentCommands.printMessage("Refill a product");
                            currentCommands.printMessage("Please type the name of the product which you wish to restock:");
                            String refillProductName = currentCommands.getStringInput();
                            currentCommands.printMessage("Please select the quantity of the product which you wish to restock:");
                            int refillProductQty = currentCommands.getIntegerInput();
                            stock.refillProduct(refillProductQty,refillProductName);
                            stock.getCurrentStock();
                            nextCommand = "home";
                            break;

                        case 3:
                            currentCommands.printMessage("Check stock");
                            stock.takeStock();
                            nextCommand = "home";
                            break;

                        case 4:
                            currentCommands.printMessage("Thank you for shopping with us!");
                            isActive = false;
                    }


                    break;

                default:
                    isActive = false;
            }
        }


    }

}
