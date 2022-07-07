package ma.ensaf.springboot.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Category")

public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "categoryName")
    private String categoryName;
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
