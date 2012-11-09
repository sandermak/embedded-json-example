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
     * index is 1-based to correspond with the product naming
     */
    public List<Product> getProducts(int start, int howmany) {

        return productList.subList(start-1, start+howmany-1);
    }

    public int getTotalNumberOfProducts() {
        return productList.size();
    }
}
