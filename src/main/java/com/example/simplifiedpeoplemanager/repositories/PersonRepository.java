package com.example.simplifiedpeoplemanager.repositories;

import com.example.simplifiedpeoplemanager.models.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonModel, Long> {
}
