package com.example.simplifiedpeoplemanager.controllers.v1;

import com.example.simplifiedpeoplemanager.data.vo.v1.PersonVOV1;
import com.example.simplifiedpeoplemanager.services.v1.PersonServiceV1;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/person")
public class PersonControllerV1 {

    @Autowired
    private PersonServiceV1 services;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVOV1> findById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(services.findById(id), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonVOV1>> findAll() {
        return new ResponseEntity<>(services.findALl(), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVOV1> save(@Valid @RequestBody PersonVOV1 person) {
        return new ResponseEntity<>(services.create(person), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVOV1> update(
            @PathVariable(value = "id") long id,
            @Valid @RequestBody PersonVOV1 personToBeUpdated) {
        return new ResponseEntity<>(services.update(id, personToBeUpdated), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }

}
