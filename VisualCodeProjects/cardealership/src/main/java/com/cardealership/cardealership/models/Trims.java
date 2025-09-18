package com.cardealership.cardealership.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "trims", schema = "car_dealership")
public class Trims extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private Models model;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    public Trims() {
    }

    public Trims(Models model, String name) {
        this.model = model;
        this.name = name;
    }

    public Models getModel() {
        return model;
    }

    public void setModel(Models model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Trims trim = (Trims) o;
        return Objects.equals(getId(), trim.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }

    @Override
    public String toString() {
        return "Trims{" +
                "id=" + getId() +
                ", model=" + (model != null ? model.getId() : null) +
                ", name='" + name + '\'' +
                '}';
    }
}
