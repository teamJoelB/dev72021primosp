package fr.solutec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Person;
import fr.solutec.repository.PersonRepository;

@SpringBootApplication
public class PrimoSpDev72021Application implements CommandLineRunner {
	@Autowired
	private PersonRepository personRepos;
	
	public static void main(String[] args) {
		SpringApplication.run(PrimoSpDev72021Application.class, args);
		System.out.println("lancement terminé");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("lancement des instructions perso");
		
		Person p1 = new Person(null, "TREY", "Yio", 16, null);
		Person p2 = new Person(null, "YOURI", "BEL", 16, null);
		Person p3 = new Person(null, "TREY", "GIT", 16, null);
		personRepos.save(p1);
		personRepos.save(p2);
		personRepos.save(p3);
		
		personRepos.findByNom("TREY").forEach(p -> {
			System.out.println(p.toString());
		});
	}

}
