package entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * The Service database entity class.
 */
@Entity(name="Service")
@Table(name="service", schema="com.posting")
public class Service {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic
    @Column(name = "description", nullable = false, length = 255)
    private String description;

    /**
     * No-argument constructor
     */
    public Service() {
    }

    /**
     * Full argument constructor
     *
     * @param name        the name
     * @param description the description
     */
    public Service(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * id getter.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * id setter
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * name getter
     *
     * @return name value
     */
    public String getName() {
        return name;
    }

    /**
     * name setter
     *
     * @param name new name value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * description getter
     *
     * @return description value
     */
    public String getDescription() {
        return description;
    }

    /**
     * description setter
     *
     * @param description new description value
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return getId() == service.getId() && getName().equals(service.getName()) && getDescription().equals(service.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription());
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
