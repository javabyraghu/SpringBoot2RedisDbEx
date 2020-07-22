package in.nareshit.raghu.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import in.nareshit.raghu.dao.IPersonDao;
import in.nareshit.raghu.model.Person;

@Repository
public class PersonDaoImpl implements IPersonDao {

	private final String KEY ="PERSON";

	@Resource(name = "rt")
	private HashOperations<String, Integer, Person> opr;

	@Override
	public void addPerson(Person p) {
		opr.putIfAbsent(KEY, p.getId(), p);
	}

	@Override
	public void modifyPerson(Person p) {
		opr.put(KEY, p.getId(), p);
	}

	@Override
	public Person getPerson(Integer id) {
		return opr.get(KEY, id);
	}

	@Override
	public Map<Integer, Person> getAllPersons() {
		return opr.entries(KEY);
	}

	@Override
	public void removePerson(Integer id) {
		opr.delete(KEY, id);
	}

}
