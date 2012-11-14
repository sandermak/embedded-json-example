package net.branchandbound.web;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import net.branchandbound.product.Product;
import net.branchandbound.product.ProductService;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private static int PAGE_SIZE = 3;

    @Autowired
    private ProductService productService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) throws IOException {
        List<Integer> pageStartIndices = new ArrayList<Integer>();
        int nrOfPages = (int)Math.ceil(((double)productService.getTotalNumberOfProducts()) / PAGE_SIZE);
        for(int i = 1; i <= nrOfPages; i++)
            pageStartIndices.add(i);

        model.addAttribute("pageIndices", pageStartIndices);

        ObjectMapper mapper = new ObjectMapper();
        StringWriter w = new StringWriter();
        mapper.writeValue(w, productService.getProducts(1, PAGE_SIZE));
        model.addAttribute("productJSON", w.toString());

		return "index";
	}
}
