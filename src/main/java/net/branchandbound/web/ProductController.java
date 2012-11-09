package net.branchandbound.web;

import net.branchandbound.product.Product;
import net.branchandbound.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "list", produces = "application/json")
    @ResponseBody
    public List<Product> getProducts(@RequestParam int page, @RequestParam int pageSize) {
        int startIndex = 1 + (page - 1) * pageSize;
        return productService.getProducts(startIndex, pageSize);
    }
}
