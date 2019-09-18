package com.pixogram.user;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.article.admin.entity.Article;
import com.article.admin.repo.IUserRepo;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.article.admin.UserApplication.class)
public class UserApplicationTests {

	
	@Autowired
	IUserRepo repo;
	
	
	 @Test		
	    public void myRepo(){	
	       		List<Article> list = new ArrayList<>();
	       		list = repo.getBlockedArticles();
	       		assertEquals(list.get(0).getStatus(), 1);
	    }
	 @Test		
	    public void myRepo1(){	
		 List<Article> list = new ArrayList<>();
    		list = repo.getUnblockedArticles();
    		assertEquals(list.get(0).getStatus(), 0);		 		
	    }
	
	
	
	
	

}
