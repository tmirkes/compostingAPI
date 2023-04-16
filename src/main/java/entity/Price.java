package entity;

import javax.persistence.*;

import java.util.*;

/**
 * The Price database entity class.
 */
@Entity(name="Price")
@Table(name="price", schema="com.posting")
public class Price {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "per_unit", nullable = false, precision = 2)
    private double perUnit;
    @Basic
    @Column(name = "unit_type", nullable = false, length = 50)
    private String unitType;

    /**
     * No-argument constructor
     */
    public Price() {
    }

    /**
     * Full argument constructor
     *
     * @param perUnit cost per unit
     * @param unitType unit per cost
     */
    public Price(double perUnit, String unitType) {
        this.perUnit = perUnit;
        this.unitType = unitType;
    }

    /**
     * id getter
     *
     * @return value of id
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
     * perUnit getter
     *
     * @return value of perUnit
     */
    public double getPerUnit() {
        return perUnit;
    }

    /**
     * perUnit setter
     *
     * @param perUnit new perUnit value
     */
    public void setPerUnit(double perUnit) {
        this.perUnit = perUnit;
    }

    /**
     * unitType getter
     *
     * @return value of unitType
     */
    public String getUnitType() {
        return unitType;
    }

    /**
     * unitType setter
     *
     * @param unitType new unitType value
     */
    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return getId() == price.getId() && Double.compare(price.getPerUnit(), getPerUnit()) == 0 && getUnitType().equals(price.getUnitType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPerUnit(), getUnitType());
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", perUnit=" + perUnit +
                ", unitType='" + unitType + '\'' +
                '}';
    }
}
