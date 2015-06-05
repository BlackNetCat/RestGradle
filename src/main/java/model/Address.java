package model;
/**
 * Created by netcat on 30.05.2015.
 */

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Data
@Entity
@Table(name="address")
/*@XmlRootElement(name = "address")*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "street", "city", "id_person"})
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="street")
    private String street;

    @Column(name="city")
    private String city;

    @ManyToOne
    @JoinColumn(name="id_person")

    private Person person;



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("id=").append(id);
        sb.append(", street='").append(street).append('\'');
        sb.append(", city=").append(city).append('\'');
        sb.append(", id_person=");
        sb.append('}');
        return sb.toString();
    }


}