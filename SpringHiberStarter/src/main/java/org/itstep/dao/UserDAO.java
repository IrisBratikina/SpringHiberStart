package org.itstep.dao;

import org.itstep.dao.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{
	
	@Query(value = "SELECT * FROM USERS WHERE EMAIL=?1 AND PASSWORD=?2", nativeQuery = true)
	public User findOneByEmailAndPassword(String email, String password);

}
