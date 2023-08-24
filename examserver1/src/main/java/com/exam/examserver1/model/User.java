package com.exam.examserver1.model;

import com.exam.examserver1.model.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Data

@NoArgsConstructor

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
   // private String firstname;
    private  String firstname;
    private String lastname;
    private String email;
    private String phone;
    private boolean enable=true;
    private String profile;



    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "user")
    @JsonIgnore
    private Set<UserRole> UserRoles=new HashSet<>();
//
//    public User(int id, String username, String password, String firstname,  String fname ,String lastname, String email, String phone, boolean enable, String profile) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.email = email;
//        this.phone = phone;
//        this.enable = enable;
//        this.profile = profile;
//        this.fname=fname;
//    }
//

    public Set<UserRole> getUserRoles() {
        return UserRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority>set=new HashSet<>();
        this.getUserRoles().forEach(userRole -> {
            set.add(new Authority(userRole.getRole().getRoleName()));
        });
        return set;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

//    public void setUserRoles(Set<UserRole> userRoles) {
//        UserRoles = userRoles;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getEmail(String s) {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public boolean isEnable() {
//        return enable;
//    }
//
//    public void setEnable(boolean enable) {
//        this.enable = enable;
//    }
//
//    public String getProfile() {
//        return profile;
//    }
//
//    public void setProfile(String profile) {
//        this.profile = profile;
//    }
//


}