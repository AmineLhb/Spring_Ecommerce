package ma.ensaf.springboot.service;

import ma.ensaf.springboot.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(long id);
    void deleteProductById(long id);
    String save(Product product);
    void addProduct(Product product);

}
