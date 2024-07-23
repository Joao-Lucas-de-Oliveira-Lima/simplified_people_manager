package com.example.simplifiedpeoplemanager.data.vo.v2;

import com.example.simplifiedpeoplemanager.enums.Gender;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.Objects;

public class PersonVOV2 {
    public long id;
    @NotEmpty
    public String firstName;
    @NotEmpty
    public String lastName;
    @NotNull
    public Date birthdate;
    @NotEmpty
    public String address;
    @NotNull
    public Gender gender;

    public PersonVOV2() {
    }

    public PersonVOV2(long id, String firstName, String lastName, Date birthdate, String address, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PersonVOV2 that = (PersonVOV2) object;
        return Objects.equals(this.id, that.id) && Objects.equals(this.firstName, that.firstName) && Objects.equals(this.lastName, that.lastName) && Objects.equals(this.address, that.address) && Objects.equals(this.gender
                , that.gender) && Objects.equals(this.birthdate, that.birthdate);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthdate, address, gender);
    }
}
