package com.spring.simpleblog.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.simpleblog.model.Post;
import com.spring.simpleblog.service.SimpleblogService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SimpleblogController {
	
	@Autowired
	SimpleblogService simpleblogService;
	
	 @RequestMapping(value = "/posts", method = RequestMethod.GET)
	    
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = simpleblogService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
	 
	 
	 
	 @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	    
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
			ModelAndView mv = new ModelAndView("postDetails");
			Post post = simpleblogService.findById(id);
			mv.addObject("post", post);
			return mv;
	}

	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public String getPostForm() {
		 return "postForm";
	}

	@RequestMapping(value = "/newpost", method = RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "verifique se todos os campos obrigatórios foram preenchidos corretamente");
			return "redirect:/newpost";
		}
		post.setData(LocalDate.now());
		simpleblogService.save(post);
		return "redirect:/posts";
	}

}
