package ma.ensaf.springboot.controller;

import ma.ensaf.springboot.model.Product;
import ma.ensaf.springboot.model.ProductCategory;
import ma.ensaf.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    private ProductService productService;

    //display list of products
    @GetMapping("/products")
    @ResponseBody
    private List<Product> getProducts(){
        return productService.getAllProducts();
    }

    //display products by id
    @GetMapping("/products/{id}")
    @ResponseBody
    public Product getproduct(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    //add product
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addProduct")
    @ResponseBody
    public String addProduct(@RequestBody Product product) {
        System.out.println(product);
        return productService.save(product);
    }

    //update product
    @PutMapping("/updateProduct/{id}")
    @ResponseBody
    public String updateProduct(@PathVariable (value = "id") Long id, @RequestParam(value = "title") String title, @RequestParam(value = "publisher") String publisher, @RequestParam(value = "price") BigDecimal price, @RequestParam(value = "description") String description, @RequestParam(value = "imageUrl") String imageUrl, @RequestParam(value = "category") ProductCategory category) {
        Product product = productService.getProductById(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setPublisher(publisher);
        product.setDescription(description);
        product.setCategory(category);
        product.setImageUrl(imageUrl);
        return productService.save(product);
    }
    //delete product by id
    @DeleteMapping("/deleteProduct/{id}")
    @ResponseBody
    public void deleteProduct(@PathVariable (value = "id") Long id) {
        this.productService.deleteProductById(id);
    }


}
