package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class TaxFreeProduct extends Product {
    public TaxFreeProduct(String name, BigDecimal price) {
        super(name, price, BigDecimal.ZERO);
        BigDecimal big0 = new BigDecimal(0);
        if (name == null || name.isEmpty() || price.compareTo(big0) < 0){
            throw new IllegalArgumentException("Parameters can't be null");}
    }
}
