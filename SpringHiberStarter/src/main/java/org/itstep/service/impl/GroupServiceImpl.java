package org.itstep.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.itstep.dao.GroupDAO;
import org.itstep.dao.pojo.Group;
import org.itstep.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService{

	@Autowired
	GroupDAO groupDAO;
	
	@Override
	public Group createAndUpdate(Group group) {
		return groupDAO.saveAndFlush(group);
	}

	@Override
	public Group getOne(long id) {
		return groupDAO.getOne(id);
	}

	@Override
	public List<Group> findAllByCourse(int course) {
		return groupDAO.findAllByCourse(course);
	}

	@Override
	public void delete(long id) {
		groupDAO.delete(id);
	}
	
	@Override
	public boolean isUnique(Group group) {
		ArrayList<Group> groups = (ArrayList<Group>) groupDAO.findAllByCourse(group.getCourse());
		for (Group groupDB : groups) {
			if(groupDB.getName().equals(group.getName()))
				return false;
		}
		return true;
	}
}
