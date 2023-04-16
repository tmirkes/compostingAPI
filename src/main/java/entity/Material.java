package entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * The Material database entity class.
 */
@Entity(name="Material")
@Table(name="material", schema="com.posting")
public class Material {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "comments", nullable = false, length = 255)
    private String comments;

    /**
     * No-argument constructor
     */
    public Material() {
    }

    /**
     * Full argument constructor
     * @param name name value
     * @param comments comments value
     */
    public Material(String name, String comments) {
        this.name = name;
        this.comments = comments;
    }

    /**
     * id getter
     * @return id value
     */
    public int getId() {
        return id;
    }

    /**
     * id setter
     * @param id new id value
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * name getter
     * @return name value
     */
    public String getName() {
        return name;
    }

    /**
     * name setter
     * @param name new name value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * comments getter
     * @return comments value
     */
    public String getComments() {
        return comments;
    }

    /**
     * comments setter
     * @param comments new comments value
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return getId() == material.getId() && getName().equals(material.getName()) && getComments().equals(material.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getComments());
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
