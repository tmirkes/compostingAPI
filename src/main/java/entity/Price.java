package entity;

import javax.persistence.*;

import java.util.*;

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

    public Price() {
    }

    public Price(double perUnit, String unitType) {
        this.perUnit = perUnit;
        this.unitType = unitType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPerUnit() {
        return perUnit;
    }

    public void setPerUnit(double perUnit) {
        this.perUnit = perUnit;
    }

    public String getUnitType() {
        return unitType;
    }

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
