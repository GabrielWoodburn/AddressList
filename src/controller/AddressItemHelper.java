/**  * @author Gabriel Woodburn - gwoodburn  * CIS175 - Spring 2021  * Feb 24, 2021  */
package controller;


	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;
	import javax.persistence.TypedQuery;

	import model.AddressItem;

	public class AddressItemHelper {
		static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressList");

		public void insertItem(AddressItem li) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(li);
			em.getTransaction().commit();
			em.close();
		}

		public List<AddressItem> showAllItems() {
			EntityManager em = emfactory.createEntityManager();
			List<AddressItem> allItems = em.createQuery("SELECT i FROM AddressItem i").getResultList();
			return allItems;
		}

		public void deleteItem(AddressItem toDelete) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<AddressItem> typedQuery = em.createQuery(
					"select li from AddressItem li where li.owner = :selectedOwner and li.address = :selectedAddress",
					AddressItem.class);
			// Substitute parameter with actual data from the toDelete item
			typedQuery.setParameter("selectedOwner", toDelete.getOwner());
			typedQuery.setParameter("selectedAddress", toDelete.getAddress());

			// we only want one result
			typedQuery.setMaxResults(1);

			// get the result and save it into a new list item
			AddressItem result = typedQuery.getSingleResult();

			// remove it
			em.remove(result);
			em.getTransaction().commit();
			em.close();

		}

		public AddressItem searchForItemById(int idToEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			AddressItem found = em.find(AddressItem.class, idToEdit);
			em.close();
			return found;
		}

		public void updateItem(AddressItem toEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
		}

		public List<AddressItem> searchForItemByStore(String ownerName) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<AddressItem> typedQuery = em.createQuery("select li from AddressItem li where li.owner = :selectedOwner", AddressItem.class);
			typedQuery.setParameter("selectedOwner", ownerName);

			List<AddressItem> foundItems = typedQuery.getResultList();
			em.close();
			return foundItems;
		}

		public List<AddressItem> searchForItemByItem(String itemName) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<AddressItem> typedQuery = em.createQuery("select li from AddressItem li where li.item = :selectedItem", AddressItem.class);
			typedQuery.setParameter("selectedItem", itemName);

			List<AddressItem> foundItems = typedQuery.getResultList();
			em.close();
			return foundItems;
		}
		
		public void cleanUp(){
			emfactory.close();
		}

	}
