package com.exam.examserver1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@Table(name = "roles")
public class Role
{

    @Id
    private Long roleId;
    private String roleName;


    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "role")
    private Set<UserRole> UserRoles=new HashSet<>();
    public Role() {
    }

    public Set<UserRole> getUserRoles() {
        return UserRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {

        UserRoles = userRoles;
    }
//    public Role(Long roleId, String roleName) {
//        this.roleId = roleId;
//        this.roleName = roleName;
//    }

//    public Long getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(Long roleId) {
//        this.roleId = roleId;
//    }
//
//    public String getRoleName() {
//        return roleName;
//    }
//
//    public void setRoleName(String roleName) {
//        this.roleName = roleName;
//    }
}
