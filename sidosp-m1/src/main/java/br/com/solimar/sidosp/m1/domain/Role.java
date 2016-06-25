package br.com.solimar.sidosp.m1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
 
import org.springframework.security.core.GrantedAuthority;
 
public class Role implements GrantedAuthority{
    private static final long serialVersionUID = -3968396919486158590L;
 
   
    private Long id;
    
   
    private String description;
    
    
    private String name;
 
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
    @Transient
    public String getAuthority() {
        return name;
    }
}