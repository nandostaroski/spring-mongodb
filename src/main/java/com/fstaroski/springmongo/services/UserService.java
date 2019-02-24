package com.fstaroski.springmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstaroski.springmongo.domain.User;
import com.fstaroski.springmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll () {
		return repository.findAll();
	}
}
