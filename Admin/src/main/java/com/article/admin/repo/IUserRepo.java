package com.article.admin.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.article.admin.entity.Article;

@Transactional
@Repository
public class IUserRepo implements UserRepo{
	@PersistenceContext	
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getUnblockedArticles() {
		String hql = "FROM Article as atcl where atcl.status!=1";
		return (List<Article>) entityManager.createQuery(hql).getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getBlockedArticles() {
		String hql = "FROM Article as atcl where atcl.status!=0";
		return (List<Article>) entityManager.createQuery(hql).getResultList();
	}
	@Override
	public void blockArticle(int status, String id) {
		Query query = entityManager.createQuery("update Article as atcl set atcl.status =: status where articleId =: articleId");
		query.setParameter("status", status);
		query.setParameter("articleId", Integer.parseInt(id));
		query.executeUpdate();
		
	}
	@Override
	public void unBlockArticle(int status, String id) {
		Query query = entityManager.createQuery("update Article as atcl set atcl.status =: status where articleId =: articleId");
		query.setParameter("status", status);
		query.setParameter("articleId", Integer.parseInt(id));
		query.executeUpdate();
		
	}

}
