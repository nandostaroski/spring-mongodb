package com.fstaroski.springmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstaroski.springmongo.domain.Post;
import com.fstaroski.springmongo.repository.PostRepository;
import com.fstaroski.springmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. id: " + id));
	}
}
