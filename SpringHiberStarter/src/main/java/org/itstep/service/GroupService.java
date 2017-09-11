package org.itstep.service;

import java.util.List;

import org.itstep.dao.pojo.Group;

public interface GroupService {

	Group createAndUpdate(Group group);
	Group getOne(long id);
	List<Group> findAllByCourse(int course);
	void delete(long id);
	boolean isUnique(Group group);
	
}
