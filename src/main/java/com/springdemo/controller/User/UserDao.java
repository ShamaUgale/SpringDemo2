package com.springdemo.controller.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {

	private static List<User> users= new ArrayList();
	private static int usercount=3;
	
	static {
		
		users.add(new User(1, "Shama Ugale" , new Date()));
		users.add(new User(2, "Ashwini" , new Date()));
		users.add(new User(3, "Akhil" , new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user){
		if(user.getId() == null){
			user.setId(++usercount);
		}
		users.add(user);
		return user;
	}
	
	public User finOne(int id){
		for(User u : users){
			if(u.getId() == id){
				return u;
			}
		}
		return null;
	}
	
	
	public User deleteUser(int id){
		Iterator<User> it= users.iterator();
		while(it.hasNext()){
			User u=  it.next();
			if(u.getId() == id){
				it.remove();
				return u;
			}
		}
		return null;
	}
	
	
}
