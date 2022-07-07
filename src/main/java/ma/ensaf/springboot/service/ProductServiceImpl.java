package ma.ensaf.springboot.service;

import ma.ensaf.springboot.model.Product;
import ma.ensaf.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();

    }
    @Override
    public void addProduct(Product product) {
        this.productRepository.save(product);

    }
    @Override
    public Product getProductById(long id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = null;
        if(optional.isPresent()) {
            product = optional.get();
        }else {
            throw new RuntimeException("Product not found for id :: "+id);
        }
        return product;
    }

    public void deleteProductById(long id) {
        Optional<Product> optional = productRepository.findById(id);
        if(optional.isPresent()){
            this.productRepository.deleteById(id);}
        else {
            throw new RuntimeException("Product not found for id :: "+id);
        }

    }

    @Override
    public String save(Product product) {
        return productRepository.save(product).toString();
    }

}
