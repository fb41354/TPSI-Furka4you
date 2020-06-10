package wizut.tpsi.ogloszenia.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "car_model")
public class CarModel {

    @Override
    public String toString() {
        return  manufacturer.getName() + " " + id + " " + name;
    }
    
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id")
    @ManyToOne
    private CarManufacturer manufacturer;

    public void setManufacturer(CarManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public CarManufacturer getManufacturer() {
        return manufacturer;
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
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