package org.itstep.dao.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SUBJECT")
@Setter
@Getter
public class Subject {

	@Id
	@Column(name = "NAME")
	private String name;
}
