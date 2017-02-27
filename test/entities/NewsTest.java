package entities;

import main.db.JPAUtil;
import main.entities.News;

import javax.persistence.EntityManager;

public class NewsTest {
    public static void main(String[] args) {
        EntityManager em= JPAUtil.getEmf().createEntityManager();
        em.getTransaction().begin();
        for (int i=0;i<10;i++){
            News news = new News("header"+i,"body"+i);
            news.setImage(new byte[100]);
            em.persist(news);
        }
        em.getTransaction().commit();
        JPAUtil.getEmf().close();
    }
}
