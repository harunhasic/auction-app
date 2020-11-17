package com.atlantbh.auction.model;

import com.atlantbh.auction.model.dto.RegisterRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Model that is used for describing the main users of this application.
 *
 * @author Harun Hasic
 */
@Entity
@Table(name = "auction_users")
public class User extends BaseModel<User, Long> implements UserDetails {

    @Column(name = "roles")
    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> roles;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email(message = "Valid email is required")
    @Column(unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "profile_photo_url")
    private String profilePhotoUrl;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Address address;

    public User() {

    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(RegisterRequest registerRequest) {
        this.firstName = registerRequest.getFirstName();
        this.lastName = registerRequest.getLastName();
        this.email = registerRequest.getEmail();
        this.password = registerRequest.getPassword();
    }

    public User(
            String firstName,
            String lastName,
            String email,
            String gender,
            Date birthDate,
            String phoneNumber,
            String password,
            String profilePhotoUrl
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.profilePhotoUrl = profilePhotoUrl;
    }

    @NotBlank(message = "User first name is required!")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @NotBlank(message = "Users last name is required.")

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


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    @NotBlank(message = "User password is required!")
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public Date getBirthDate() {
        if (birthDate != null) {
            return new Date(birthDate.getTime());
        }
        return null;
    }

    public void setBirthDate(Date birthDate) {
        if (birthDate != null) {
            this.birthDate = new Date(birthDate.getTime());
        } else {
            this.birthDate = null;
        }
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhoto) {
        this.profilePhotoUrl = profilePhoto;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public void update(User model) {
        firstName = model.firstName;
        lastName = model.lastName;
        password = model.password;
        email = model.email;
        profilePhotoUrl = model.profilePhotoUrl;
        address = model.address;
    }

    @Override
    public User duplicate(User obj) {
        return null;
    }
}

