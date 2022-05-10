package it.lucianofilippucci.zgest.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    private Long id;
    private String name;
    private String lastName;
    private String address;
    private Collection<Phone> phones;
    private Collection<Email> emails;

    public User() {
    }

    public User(String name, String lastName, String address, Collection<Phone> phones, Collection<Email> emails) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phones = phones;
        this.emails = emails;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Collection<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Collection<Phone> phones) {
        this.phones = phones;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Collection<Email> getEmails() {
        return emails;
    }

    public void setEmails(Collection<Email> emails) {
        this.emails = emails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && name.equals(user.name) && lastName.equals(user.lastName) && address.equals(user.address) && Objects.equals(phones, user.phones) && Objects.equals(emails, user.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, address, phones, emails);
    }
}
