package com.example.testProject.entity;

import javax.persistence.*;

@Entity
public class DistributionSupervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long distribution_supervisor_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hike_id")
    private Hike hike;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;

    public DistributionSupervisor() {
    }

    public DistributionSupervisor(Hike hike,
                                  Supervisor supervisor
    ) {
        this.hike = hike;
        this.supervisor = supervisor;

    }

    public Long getDistribution_supervisor_id() {
        return distribution_supervisor_id;
    }

    public void setDistribution_supervisor_id(Long distribution_supervisor_id) {
        this.distribution_supervisor_id = distribution_supervisor_id;
    }

    public Hike getHike() {
        return hike;
    }

    public void setHike(Hike hike) {
        this.hike = hike;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
}
