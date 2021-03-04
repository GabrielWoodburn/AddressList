package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Comment;

public class AddressHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressList");

	public void insertComment(Comment li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<Comment> showAllComments() {
		EntityManager em = emfactory.createEntityManager();
		List<Comment> allComments = em.createQuery("SELECT c FROM Comment c").getResultList();
		return allComments;
	}

	public Comment findComment(String commentToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Comment> typedQuery = em.createQuery("select co from Comment co where co.comment = :selectedComment",
				Comment.class);
		typedQuery.setParameter("selectedComment", commentToLookUp);
		Comment foundComment;
		try {
			foundComment = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundComment = new Comment(commentToLookUp);
		}
		em.close();

		return foundComment;
	}
}