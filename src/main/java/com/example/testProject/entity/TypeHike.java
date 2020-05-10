package com.example.testProject.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class TypeHike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long type_hike_id;
    @NotBlank(message = "Please fill the type")
    @Length(max = 20, message = "types too long (more than 20 symbols)")
    private String types;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "typeHike")
    private Set<Hike> hikes;

    public TypeHike() {
    }

    public TypeHike(String types) {
        this.types = types;
    }

    public Long getType_hike_id() {
        return type_hike_id;
    }

    public void setType_hike_id(Long type_hike_id) {
        this.type_hike_id = type_hike_id;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public Set<Hike> getHikes() {
        return hikes;
    }

    public void setHikes(Set<Hike> hikes) {
        this.hikes = hikes;
    }
}
