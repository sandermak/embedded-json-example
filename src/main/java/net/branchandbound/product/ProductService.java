package net.branchandbound.product;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private static List<Product> productList = new ArrayList<Product>();

    @PostConstruct
    private void buildProducts() {
        for (int i =1; i <= 10; i++)
            productList.add(new Product("product " + i, i*15, "Fabulous product " + i));
    }

    /**
     * paging is 1-based to correspond with the screen
     */
    public List<Product> getProducts(int page, int howmany) {
        int start = (page - 1) * howmany;
        return productList.subList(start, Math.min(productList.size(), start+howmany));
    }

    public int getTotalNumberOfProducts() {
        return productList.size();
    }
}
