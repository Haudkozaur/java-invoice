package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Collection<Product> products = new HashSet<>();
    private Map<String, Integer> productsMap = new HashMap<>();
    public void addProduct(Product product) {
        productsMap.put(product.getName(), 1);
        products.add(product);
    }
    public void addProduct(Product product, Integer quantity) {
        productsMap.put(product.getName(), quantity);
    }
    public BigDecimal getSubtotal() {
        BigDecimal subTotal = new BigDecimal(0);
        for (Product product : products) {
            subTotal.add((new BigDecimal(productsMap.get(product.getName()))).multiply(product.getPrice()));
        }
        return subTotal;
    }

    public BigDecimal getTax() {
        return null;
    }

    public BigDecimal getTotal() {
        return null;
    }


}
