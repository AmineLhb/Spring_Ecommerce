package ma.ensaf.springboot.model;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "title")
    private String title;
    @Column(name= "publisher")
    private String publisher;
    @ManyToOne
    @JoinColumn(name= "category_id", nullable = true)
    private ProductCategory category;
    @Column(name= "price")
    private BigDecimal price;
    @Column(name= "description")
    private String description;
	@Column(name = "imageUrl")
    private String imageUrl;




    public Product(ProductCategory category) {

        this.category = category;
    }

    public Product() {

    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product(String title, String publisher, ProductCategory category, BigDecimal price, String description, String imageUrl) {
        this.title = title;
        this.publisher = publisher;
        this.category = category;
        this.price = price;
        this.description=description;
        this.imageUrl=imageUrl;
    }
}
