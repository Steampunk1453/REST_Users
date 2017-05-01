package com.rest.users.services.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.rest.users.controllers.UserController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.rest.users.models.User;
import com.rest.users.repositories.UserRepository;
import com.rest.users.services.UserService;

public abstract class UserServiceImpl implements UserService {

    final static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User entity) {
        User user = userRepository.save(entity);
        checkSave(user);
        return user;
    }

	@Override
	public User getById(Serializable id) {
		return userRepository.findOne((Long) id);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(Serializable id) {
		userRepository.delete((Long) id);

	}

    public void checkSave(User user) {
	    if(user != null) {
	        User checkUser = new User();
            checkUser.setName(user.getName());
            checkUser.setBirthday(new Date());
            userRepository.save(checkUser);
        }
	    else {
            logger.error("Error save User");
        }
    }

}
