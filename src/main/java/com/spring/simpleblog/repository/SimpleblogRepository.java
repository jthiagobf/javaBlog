package com.spring.simpleblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.simpleblog.model.Post;

public interface SimpleblogRepository extends JpaRepository<Post, Long> {

}
