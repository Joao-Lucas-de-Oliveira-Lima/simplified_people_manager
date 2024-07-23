package com.example.simplifiedpeoplemanager.services.v2;

import com.example.simplifiedpeoplemanager.data.vo.v2.PersonVOV2;
import com.example.simplifiedpeoplemanager.exceptions.ResourceNotFoundException;
import com.example.simplifiedpeoplemanager.mapper.ModelMapper;
import com.example.simplifiedpeoplemanager.models.PersonModel;
import com.example.simplifiedpeoplemanager.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PersonServiceV2 {
    @Autowired
    private PersonRepository repository;
    //Para geração de logs
    private static final Logger logger = Logger.getLogger(PersonServiceV2.class.getName());

    public PersonVOV2 findById(long id) throws ResourceNotFoundException {
        logger.info("Looking for a person!");
        PersonModel personFound = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return ModelMapper.parseObject(personFound, PersonVOV2.class);
    }

    public List<PersonVOV2> findALl() {
        logger.info("Searching for all people!");
        List<PersonModel> people = repository.findAll();
        return ModelMapper.parseListObjects(people, PersonVOV2.class);
    }

    public PersonVOV2 create(PersonVOV2 person) {
        logger.info("Creating one person!");
        PersonModel personToBeCreated = ModelMapper.parseObject(person, PersonModel.class);
        return ModelMapper.parseObject(repository.save(personToBeCreated), PersonVOV2.class);
    }

    public PersonVOV2 update(Long id, PersonVOV2 personData) throws ResourceNotFoundException {
        logger.info("Updating a person");
        PersonModel personToBeUpdated = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        personToBeUpdated.setFirstName(personData.getFirstName());
        personToBeUpdated.setLastName(personData.getLastName());
        personToBeUpdated.setAddress(personData.getAddress());
        personToBeUpdated.setGender(personData.getGender());
        personToBeUpdated.setBirthdate(personData.getBirthdate());

        return ModelMapper.parseObject(repository.save(personToBeUpdated), PersonVOV2.class);
    }

    public void delete(long id) throws ResourceNotFoundException {
        logger.info("Deleting a person!");

        Optional<PersonModel> personToBeDeleted = repository.findById(id);

        if (personToBeDeleted.isEmpty()) throw new ResourceNotFoundException("No records found for this ID!");

        repository.delete(personToBeDeleted.get());
    }
}
