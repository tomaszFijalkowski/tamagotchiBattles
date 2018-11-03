package com.codecool.Entity;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user", schema = "public")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "password")
    private String password;
    @Column(name = "username")
    private String username;
    @Column(name = "active")
    private int active;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = com.codecool.Entity.Role.class)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> role;

//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
//    private Long id;
//    private String username;
//    private String password;
//    private int active;
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> role;



    public User() {
    }

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;

    }

    public User(User user) {
        super();
        this.role = user.getRoles();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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


    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

   @OneToMany(mappedBy = "user_role")
    public Set<Role> getRoles() {
        return role;
    }

    public void setRoles(Set<Role> role) {
        this.role = role;
    }

}
