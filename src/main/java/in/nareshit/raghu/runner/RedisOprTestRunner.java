package in.nareshit.raghu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.nareshit.raghu.dao.IPersonDao;
import in.nareshit.raghu.model.Person;

@Component
public class RedisOprTestRunner implements CommandLineRunner{
	@Autowired
	private IPersonDao dao;

	@Override
	public void run(String... args) throws Exception {
		dao.addPerson(new Person(10,"A",52));
		dao.addPerson(new Person(11,"B",48));
		dao.modifyPerson(new Person(12,"C",91));

		dao.removePerson(11);
		dao.getAllPersons().forEach((k,v)->System.out.println(k+"-"+v));
		System.out.println(dao.getPerson(10));
	}
}