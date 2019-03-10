package com.fstaroski.springmongo.resources;

import com.fstaroski.springmongo.domain.Post;
import com.fstaroski.springmongo.resources.util.URL;
import com.fstaroski.springmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

	@RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "mindate", defaultValue = "") String minDate,
			@RequestParam(value = "maxdate", defaultValue = "") String maxDate) {

		List<Post> posts = service.fullSearch(
				URL.decodeParam(text),
				URL.convertDate(minDate, new Date(0)),
				URL.convertDate(maxDate, new Date())
		);
		return ResponseEntity.ok().body(posts);
	}
}
