package model;

/**
 * Created by netcat on 30.05.2015.
 */

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Set;

@Data
@Entity
@Table(name="person")
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "fullName", "age"})
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="full_name")
    private String fullName;

    @Column(name="age")
    private int age;

    @OneToMany(mappedBy = "person", cascade={CascadeType.ALL})
    private Set<Address> address;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }


}
