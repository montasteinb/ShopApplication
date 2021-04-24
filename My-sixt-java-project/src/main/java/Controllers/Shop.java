package Controllers;
import Entity.Product;
import Entity.User;
import java.util.ArrayList;

public class Shop {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public String createUser(User newUser) {
        users.add(newUser);
        return "user created successfully";
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public String createProduct(Product product) {
        products.add(product);
        return "product created successfully";
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public String buyProduct(String productName, String userEmail, Integer noOfProduct) {
        Product productToSell = findProductByName(productName);
        if(productToSell == null){ return "product not found"; }
        if(productToSell.getQuantity() < noOfProduct) {return "not enough items to fulfill your order";}

        User buyer = findUserByEmail(userEmail);
        if(buyer == null){ return "user not found"; }

        float buyerBalance = buyer.getBalance();
        float totalCostOfPurchase = productToSell.getPrice() * noOfProduct;

        if(buyerBalance < totalCostOfPurchase) {return "not enough balance on users account";}

        buyer.setBalance(buyerBalance - totalCostOfPurchase);
        productToSell.setQuantity(productToSell.getQuantity() - noOfProduct);

        updateUser(buyer);
        updateProduct(productToSell);
        return "Product purchase successful";
    }

    private Product findProductByName(String productName) {
        for(Product currentProduct: this.products) {
            if(currentProduct.getName().equalsIgnoreCase(productName)){
                return currentProduct;
            }
        }
        return null;
    }

    private User findUserByEmail(String userEmail) {
        for(User currentUser: this.users) {
            if(currentUser.getEmail().equalsIgnoreCase(userEmail)){
                return currentUser;
            }
        }
        return null;
    }

    private void updateUser(User userToUpdate) {
        for(User currentUser: this.users) {
            if(currentUser.getId().equals(userToUpdate.getId())){
                currentUser.setBalance(userToUpdate.getBalance());
            }
        }
    }

    private void updateProduct(Product productToUpdate) {
        for (Product currentProduct : this.products) {
            if (currentProduct.getId().equals(productToUpdate.getId())) {
                currentProduct.setQuantity(productToUpdate.getQuantity());
            }
        }
    }

    public String removeUser(String userName) {
        try {
            users.remove(userName);
        } catch (Exception ex) {
            return "Unable to remove specified user";
        }
        return "User removed successfully";

    }
}



