package com.example.simplifiedpeoplemanager.controllers.v2;

import com.example.simplifiedpeoplemanager.data.vo.v2.PersonVOV2;
import com.example.simplifiedpeoplemanager.services.v2.PersonServiceV2;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v2/person")
public class PersonControllerV2 {

    @Autowired
    private PersonServiceV2 services;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVOV2> findById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(services.findById(id), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonVOV2>> findAll() {
        return new ResponseEntity<>(services.findALl(), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVOV2> save(@Valid @RequestBody PersonVOV2 person) {
        return new ResponseEntity<>(services.create(person), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVOV2> update(
            @PathVariable(value = "id") long id,
            @Valid @RequestBody PersonVOV2 personToBeUpdated) {
        return new ResponseEntity<>(services.update(id, personToBeUpdated), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }

}
