package com.example.testProject.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Hike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hike_id;
    @NotBlank(message = "Please fill the name")
    @Length(max = 20, message = "name too long (more than 20 symbols)")
    private String name;
    /*@NotNull(message = "Please fill the price")
    @Size(max = 4, min = 1, message = "price should be min 1")*/
    private Long price;
    @NotBlank(message = "Please fill the description")
    @Length(max = 200, message = "Description too long (more than 200 symbols)")
    private String description;
   /* @NotNull(message = "Please fill the seats")
    @Size(max = 200,min = 1, message = "Seats should be min 1")*/
    private Long seats;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private TypeHike typeHike;

    public Hike() {
    }

    public Hike(String name, Long price, String description, Long seats, TypeHike typeHike) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.seats = seats;
        this.typeHike = typeHike;
    }

    public Long getHike_id() {
        return hike_id;
    }

    public void setHike_id(Long hike_id) {
        this.hike_id = hike_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSeats() {
        return seats;
    }

    public void setSeats(Long seats) {
        this.seats = seats;
    }

    public TypeHike getTypeHike() {
        return typeHike;
    }

    public void setTypeHike(TypeHike typeHike) {
        this.typeHike = typeHike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hike hike = (Hike) o;
        return Objects.equals(hike_id, hike.hike_id) &&
                Objects.equals(name, hike.name) &&
                Objects.equals(price, hike.price) &&
                Objects.equals(description, hike.description) &&
                Objects.equals(seats, hike.seats) &&
                Objects.equals(typeHike, hike.typeHike);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hike_id, name, price, description, seats, typeHike);
    }
}
