package in.nareshit.raghu.dao;

import java.util.Map;

import in.nareshit.raghu.model.Person;

public interface IPersonDao {
	
	public void addPerson(Person p);
	public void modifyPerson(Person p);
	public Person getPerson(Integer id);
	public Map<Integer,Person> getAllPersons();
	public void removePerson(Integer id);

}