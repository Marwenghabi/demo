package com.example.demo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "Email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "Role")
    private String role;

    // Other fields, getters, and setters...

    
    
    
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // You'll need to implement this method to return the user's roles as a collection of GrantedAuthority
        // For example:
        // return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
        return null;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implement your logic for account expiration here
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement your logic for account locking here
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement your logic for credentials expiration here
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement your logic for enabling/disabling accounts here
    }


}
