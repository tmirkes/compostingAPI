package entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * The Period database entity class.
 */
@Entity(name="Period")
@Table(name="period", schema="com.posting")
public class Period {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "frequency", nullable = false)
    private int frequency;
    @Basic
    @Column(name = "time_unit", nullable = false, length = 50)
    private String timeUnit;

    /**
     * No-argument constructor
     */
    public Period() {
    }

    /**
     * Full argument constructor
     *
     * @param frequency frequency value
     * @param timeUnit unit of time measure
     */
    public Period(int frequency, String timeUnit) {
        this.frequency = frequency;
        this.timeUnit = timeUnit;
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
     * frequency getter
     * @return frequency value
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * frequency setter
     *
     * @param frequency new frequency value
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    /**
     * timeUnit getter
     * @return value of timeUnit
     */
    public String getTimeUnit() {
        return timeUnit;
    }

    /**
     * timeUnit setter
     * @param timeUnit new timeUnit value
     */
    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return getId() == period.getId() && getFrequency() == period.getFrequency() && getTimeUnit().equals(period.getTimeUnit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFrequency(), getTimeUnit());
    }

    @Override
    public String toString() {
        return "Period{" +
                "id=" + id +
                ", frequency=" + frequency +
                ", timeUnit='" + timeUnit + '\'' +
                '}';
    }
}
