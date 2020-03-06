package com.js.jpademospringdata.account;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Account {
    @Id @GeneratedValue
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    private String email;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Temporal(TemporalType.TIMESTAMP )
    private Date date = new Date();

    private String yes;

    @Transient
    private String no;

    @Embedded
    @AttributeOverrides({
           @AttributeOverride(name = "street",column = @Column(name = "home_street"))
    })
    private Address address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
