package com.example.examserver.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;
    private String rollName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
    private Set<UserRole> userRoles = new HashSet<>();

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Role() {
    }

    public Role(Long roleId, String rollName) {
        this.roleId = roleId;
        this.rollName = rollName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRollName() {
        return rollName;
    }

    public void setRollName(String rollName) {
        this.rollName = rollName;
    }
}
