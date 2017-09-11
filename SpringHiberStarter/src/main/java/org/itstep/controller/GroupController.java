package org.itstep.controller;

import java.util.ArrayList;
import java.util.List;

import org.h2.value.DataType;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.itstep.dao.pojo.Group;
import org.itstep.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter.DataWithMediaType;

@Controller
@RequestMapping(value = "/group")
public class GroupController {

	@Autowired
	GroupService groupService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Group> saveGroup(Group group) {
		if (groupService.isUnique(group)) {
			Group groupDB = groupService.createAndUpdate(group);
			return new ResponseEntity<Group>(groupDB, HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Group> updateGroup(Group group) {
		if (!groupService.isUnique(group)) {
			Group groupDB = groupService.createAndUpdate(group);
			return new ResponseEntity<Group>(groupDB, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/get-one", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Group> getGroup(long id) {
		Group groupDB = groupService.getOne(id);
		if (groupDB != null) {
			return new ResponseEntity<Group>(groupDB, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/get-all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Group>> getGroupsByCourse(int course) {
		ArrayList<Group> groupList = (ArrayList<Group>) groupService.findAllByCourse(course);
		return new ResponseEntity<List<Group>>(groupList, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity deleteGroup(long id) {
		groupService.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
