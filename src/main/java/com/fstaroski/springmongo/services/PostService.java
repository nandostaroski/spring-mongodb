package com.fstaroski.springmongo.services;

import com.fstaroski.springmongo.domain.Post;
import com.fstaroski.springmongo.repository.PostRepository;
import com.fstaroski.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		return repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. id: " + id));
	}

	public List<Post> findByTitle(String text) {
		return repository.findByTitle(text);
	}

	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repository.fullSearch(text, minDate, maxDate);
	}
}
