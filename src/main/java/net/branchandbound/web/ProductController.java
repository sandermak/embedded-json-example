package net.branchandbound.web;

import net.branchandbound.product.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "list", produces = "application/json")
    @ResponseBody
    public List<Product> getProducts() {

        List<Product> productList = new ArrayList<Product>();
        for (int i =0; i< 5; i++)
            productList.add(new Product("product " + i, i*15, "Fabulous product " + i));

        return productList;
    }
}
