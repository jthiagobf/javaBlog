package com.spring.simpleblog.service;

import java.util.List;

import com.spring.simpleblog.model.Post;

public interface SimpleblogService {

	List<Post> findAll();
	Post findById(long id);
	Post save(Post post);
	
	
}
