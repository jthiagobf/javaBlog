package com.spring.simpleblog.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.simpleblog.model.Post;
import com.spring.simpleblog.repository.SimpleblogRepository;
import com.spring.simpleblog.service.SimpleblogService;

@Service
public class SimpleblogServiceImpl implements SimpleblogService {
	
	@Autowired
	SimpleblogRepository simpleblogRepository;

	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return simpleblogRepository.findAll();
	}

	@Override
	public Post findById(long id) {
		// TODO Auto-generated method stub
		return simpleblogRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		// TODO Auto-generated method stub
		return simpleblogRepository.save(post);
	}

}
