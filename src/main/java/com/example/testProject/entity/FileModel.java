package com.example.testProject.entity;

import javax.persistence.*;

@Entity
@Table(name = "file_model")
public class FileModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mimetype")
    private String mimetype;


    @Column(name = "pic")
    private byte[] pic;

   /* @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "message_id", nullable = false)
    private Message message;*/

    public FileModel() {
    }

    public FileModel(String name, String mimetype, byte[] pic) {
        this.name = name;
        this.mimetype = mimetype;
        this.pic = pic;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMimetype() {
        return this.mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public byte[] getPic() {
        return this.pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

}