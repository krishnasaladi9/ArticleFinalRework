package com.article.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.article.admin.entity.Article;
import com.article.admin.entity.User;
import com.article.admin.entity.UserLogin;
import com.article.admin.repo.IUserRepo;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserRepo articleRep;
	
	 @PostMapping(path = "/login")
	    public User login(@RequestBody UserLogin userlogin){
		 User u = new User();
		 System.out.println(userlogin.getUsername());
		 System.out.println(userlogin.getPassword());
	     if(userlogin.getUsername().equalsIgnoreCase("admin") && userlogin.getPassword().equalsIgnoreCase("admin")) {
	    	 System.out.println("in");
	    	u.setStatus(1);
	    	return u;
	     }
	     else {
	    	 u.setStatus(0);
	      return u;
	     }
	    }
	@PostMapping("/block")
	public void blockArticle(@RequestParam("articleId") String id){
		System.out.println("heeleel");
		System.out.println("Id is: "+id);
		if(!id.equals(null)) {
		articleRep.blockArticle(1, id);
		}
	}
	@PostMapping("/unblock")
	public void unblockArticle(@RequestParam("articleId") String id){
		System.out.println("Id is: "+id);
		if(!id.equals(null)) {
		articleRep.unBlockArticle(0, id);
		}
	}
	@GetMapping("unblocked")
	public ResponseEntity<List<Article>> getUnblockedArticles() {
		List<Article> alist = articleRep.getUnblockedArticles();
		for(Article f: alist) {
		System.out.println(f);
		}
		return new ResponseEntity<List<Article>>(alist, HttpStatus.OK);
		
	}
	@GetMapping("blocked")
	public ResponseEntity<List<Article>> getArticles() {
		List<Article> blist = articleRep.getBlockedArticles();
		for(Article f: blist) {
			System.out.println(f);
			}
		return new ResponseEntity<List<Article>>(blist, HttpStatus.OK);
	}
	
}
