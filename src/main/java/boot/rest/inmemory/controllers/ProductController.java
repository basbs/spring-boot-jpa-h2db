package boot.rest.inmemory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import boot.rest.inmemory.models.Group;
import boot.rest.inmemory.models.Product;
import boot.rest.inmemory.services.ProductService;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
   // @RequestMapping(value = "/products", method = RequestMethod.GET)
    private List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/groupBy")
    private List<? extends Group> groupBy(@RequestParam(defaultValue = "brand") String keyword) {
        if("brand".equals(keyword)) {
            return productService.groupByBrand();
        }
        else if("color".equals(keyword)) {
            return productService.groupByColor();
        }
        else if("size".equals(keyword)) {
            return productService.groupBySize();
        }
        else {
        return null;
        }

    }


    @GetMapping("/product/{sku}")
    private Product getProduct(@PathVariable("sku") Long sku) {
        return productService.getBySku(sku);
    }

    @DeleteMapping("/product/{sku}")
    private void deleteProduct(@PathVariable("sku") Long sku) {
        productService.delete(sku);
    }

    @PostMapping("/product")
    private Long saveProduct(@RequestBody Product product) {
        productService.saveOrUpdate(product);
        return product.getSku();
    }
}