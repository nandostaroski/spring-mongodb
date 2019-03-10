package com.fstaroski.springmongo.resources;

import com.fstaroski.springmongo.resources.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fstaroski.springmongo.domain.Post;
import com.fstaroski.springmongo.services.PostService;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;

	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="/titlesearch",method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text) {

		List<Post> posts = service.findByTitle(URL.decodeParam(text));
		return ResponseEntity.ok().body(posts);
	}
	
}
