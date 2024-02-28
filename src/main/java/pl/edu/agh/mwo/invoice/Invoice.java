package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.*;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Collection<Product> products = new ArrayList<>();
    private Map<String, Integer> productsMap = new HashMap<>();
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Parameters can't be null");
        }
        productsMap.put(product.getName(), 1);
        products.add(product);
    }
    public void addProduct(Product product, Integer quantity) {
        if (quantity == null || quantity <= 0 || product == null) {
            throw new IllegalArgumentException("Parameters can't be null");
        }
        productsMap.put(product.getName(), quantity);
        products.add(product);
    }
    public BigDecimal getSubtotal() {
        BigDecimal subTotal = new BigDecimal(0);
        for (Product product : products) {
            subTotal = subTotal.add((new BigDecimal(productsMap.get(product.getName()))).multiply(product.getPrice()));
        }
        return subTotal;
    }

    public BigDecimal getTax() {
        BigDecimal tax = new BigDecimal(0);
        for (Product product : products) {
            tax = tax.add((new BigDecimal(productsMap.get(product.getName()))).multiply(product.getPriceWithTax().subtract(product.getPrice())));
        }
        return tax;

    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal(0);
        for (Product product : products) {
            total = total.add((new BigDecimal(productsMap.get(product.getName()))).multiply(product.getPriceWithTax()));
        }
        return total;
    }
}



