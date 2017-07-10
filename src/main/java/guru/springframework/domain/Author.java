package guru.springframework.domain;

import javax.persistence.Entity;

/**
 * Created by jt on 1/26/16.
 */
@Entity
public class Author extends AbstractDomainClass {
    
    private String firstName;
    private String lastName;
    private String image;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
