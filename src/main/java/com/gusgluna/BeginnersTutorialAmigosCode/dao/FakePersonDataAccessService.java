package com.gusgluna.BeginnersTutorialAmigosCode.dao;

import com.gusgluna.BeginnersTutorialAmigosCode.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getPersonName()));
        return 1;
    }

    @Override
    public List<Person> selectPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getPersonId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMayBe = selectPersonById(id);
        if(personMayBe.isEmpty()){
            return 0;
        }
        DB.remove(personMayBe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person updatePerson) {
        return selectPersonById(id).map(person->{
            int indexOfPersonToDelete = DB.indexOf(person);
            if (indexOfPersonToDelete>=0){
                DB.set(indexOfPersonToDelete, updatePerson);
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
