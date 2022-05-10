package it.lucianofilippucci.zgest.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Employee extends User{
    private Long employeeId;
    private Collection<Role> role;

    public Employee() {
        super();
    }

    public Employee(Long id, Collection<Role> role, String name, String lastName, String address, Collection<Phone> phones, Collection<Email> emails) {
        super(name, lastName, address, phones, emails);
        this.employeeId = id;
        this.role = role;
    }


    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employee_id) {
        this.employeeId = employee_id;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Collection<Role> getRole() {
        return role;
    }

    public void setRole(Collection<Role> role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employeeId, role);
    }
}
