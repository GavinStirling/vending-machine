# Vending Machine

## Brief

Develop a Vending machine command line program.

The programe needs to:
- Contain a number of products to buy
    - Each product has a name, category and price
    - Some example categories are: drink, crisps, chocolate bars and cereal bars.
- The machine can only hold a certain amount of each product.
- On startup a random number of each product is stocked
- After each turn the machine should display all products, ordered by category and the name
    - If a product is in stock it should display how many are left
    - If a product is out of stock it should just display out of stock

## Interaction

The Vending Machine should accept a number of commands:
- Buy
    - Allow a user to buy a particular product. They are prompted for money and
      must enter a valid amount of money.
    - Machine should ‘dispense’ the product and
      the correct change.
- Refill
    - Allows a user to refill a product with an amount.
    - User is prompted for an amount to add. Must not exceed capacity for that product.
- Stock
    - Allows user to take a stock take of the unsold products.
    - Should display each product with quantity unsold and value.
    - Should also print a total value for all stock
- Quit
    - Exits the programe
---

## Tips

- **Use the four pillars Encapsualtion, Abstraction, Inheritance and Polymorphism.**
- **ArrayList, Scanner?**