package br.com.solimar.sidosp.m1.domain;

import java.util.Collection;
import java.util.List;

import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 

public class User implements UserDetails {
    private static final long serialVersionUID = -7590317347612436291L;
 
    
    private Long id;
    
   
    private String username;
    
   
    private String password;
    
    
    private List<Role> roles;
 
   
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
 
   
    public List<Role> getRoles() {
        return roles;
    }
 
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
 
    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
 
    @Override
    @Transient
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }
 
    @Override
    @Transient
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return false;
    }
 
    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }
 
    @Override
    @Transient
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

	
}