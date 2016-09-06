package com.pelayolluna.filmviewerservice.serviceTEST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pelayolluna.filmviewerservice.domainTEST.User;

@Service("userService")
public class UserService {
	
	private List<User> users = new ArrayList<User>();
	
	public UserService() {
		
		User user1 = new User();
		user1.setId(1L);
		user1.setFirstName("Test1");
		user1.setLastName("Test1.1");
		
		User user2 = new User();
		user2.setId(2L);
		user2.setFirstName("Test2");
		user2.setLastName("Test2.1");
		
		User user3 = new User();
		user3.setId(3L);
		user3.setFirstName("Test3");
		user3.setLastName("Test3.1");
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}
	
	public List<User> getAll() {
		return users;
	}
	
	public User get(Long id)
        {
		
		for(User user : users)
                {
			if(user.getId().longValue() == id.longValue())
                        {
				return user;
			}
		}
		return null;
	}
}
