package com.zhm.entity;

import com.zhm.jpa.ListenerEntity.ListenerEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Model extends ListenerEntity{
    private int id;
    private String name;
    private String createUser;
    private String updateUser;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "create_user")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }


    @Basic
    @Column(name = "update_user")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }


}
