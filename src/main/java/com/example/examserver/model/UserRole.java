package com.example.examserver.model;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    private Long userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne
    private Role role;

    public UserRole() {
    }
    public UserRole(Long userRoleId, User user, Role role) {
        this.userRoleId = userRoleId;
        this.user = user;
        this.role = role;
    }


    public void setRole(Role role) {
        this.role = role;
    }


    public Role getRole() {
        return role;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
