package com.articleSpringBoot.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.articleSpringBoot.demo.entity.Article;
import com.articleSpringBoot.demo.repository.ArticleDAO;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.articleSpringBoot.demo.ArticleSpringBootApplication.class)
public class ArticleSpringBoootApplicationTests {

	@Autowired
	ArticleDAO dao;
	
	@Test
	public void myRepo(){
		List<Article> list = new ArrayList<>();
   		list = dao.getAllArticles();
   		assertEquals(list.get(0).getStatus(), 0);
	}

}
