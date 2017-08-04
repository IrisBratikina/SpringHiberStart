package org.itstep.dao.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "GOODS")
public class Good {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GOOD_ID", unique = true, nullable = false)
	private String goodID;
	
	@Column(name = "GROUPS", nullable = false)
	private String groups;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "MAKER", nullable = false)
	private String maker;
	
	@Column(name = "CODE")
	private String code;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "SIZE_L")
	private Integer sizeL;
	
	@Column(name = "SIZE_H")
	private Integer sizeH;
	
	@Column(name = "SIZE_W")
	private Integer sizeW;
	
	@Column(name = "PRICE", nullable = false)
	private Integer price;
	
	@Column(name = "USER_OWNER", nullable = false)
	private String userOwner;
	
}
