package main.controllers;

import main.db.JPAUtil;
import main.entities.News;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;


public class NewsController implements Serializable {

	//get news from the database
 	public List<News> getAllNews(int amount) {
		EntityManager em=JPAUtil.getEmf().createEntityManager();
		TypedQuery<News> query = em.createNamedQuery("FIND_ALL",News.class);
		List<News> result =query.getResultList();
		if (result.size()<amount){
			return result;
		}else {
			return result.subList(0,amount);
		}
	}
	//write the news database
	public void createNews(News news){
		EntityManager em= JPAUtil.getEmf().createEntityManager();
		em.getTransaction().begin();
	    em.persist(news);
	    em.getTransaction().commit();
	}
}

