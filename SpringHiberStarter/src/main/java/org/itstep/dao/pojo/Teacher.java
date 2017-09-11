package org.itstep.dao.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "TEACHERS")
public class Teacher extends User{
	
	@Column(name = "SUBJECT")
	private String subject;

}
