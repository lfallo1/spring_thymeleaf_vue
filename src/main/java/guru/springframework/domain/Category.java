package guru.springframework.domain;

import javax.persistence.Entity;

/**
 * Created by jt on 1/26/16.
 */
@Entity
public class Category extends AbstractDomainClass {

    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
