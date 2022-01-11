package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Person;
import fr.solutec.repository.PersonRepository;

@RestController @CrossOrigin("*")
public class PersonRest {
	@Autowired
	private PersonRepository personRepo;
	
	@GetMapping("person")
	public Iterable<Person> getAllPersons(){
		return personRepo.findAll();
	}
	@PostMapping("person")
	public Person savePerson(@RequestBody Person p) {
		return personRepo.save(p);
	}
	
	@DeleteMapping("person/{id}")
	public boolean deletePerson(@PathVariable Long id) {
		Optional<Person> p = personRepo.findById(id);
		if(p.isPresent()) {
			personRepo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
	@PutMapping("person/{id}")
	public Person modifPerson(@PathVariable Long id, @RequestBody Person p) {
		p.setId(id);
		return personRepo.save(p);	
	}
	
	@GetMapping("person/{id}")
	public Optional<Person> getOnePerson(@PathVariable Long id) {
		return personRepo.findById(id);
	}

}
