package org.itstep.dao.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "USERS")
@ToString(callSuper = true)
@ApiModel(value = "User description")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long userId;
	
	@JsonProperty
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;
	
	@JsonProperty
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@JsonProperty
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	
	@JsonProperty
	@Column(name = "SECOND_NAME")
	private String secondName;
	
	@JsonProperty
	@Column(name = "PHONE")
	private String phone;
	
	@JsonProperty
	@Column(name = "ADDRESS")
	private String address;
	
	@JsonProperty
	@Column(name = "LAST_ACTION", nullable = false)
	private Long lastAction;
	

}
