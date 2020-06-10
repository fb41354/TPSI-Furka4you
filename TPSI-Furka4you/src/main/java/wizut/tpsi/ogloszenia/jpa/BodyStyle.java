package wizut.tpsi.ogloszenia.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "body_style")
public class BodyStyle {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    
    @Override
    public String toString() {
        return id + " " + name;
    }
   
    
    @Size(max = 30)
    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
