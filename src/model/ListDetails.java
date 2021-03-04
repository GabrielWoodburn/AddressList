/**  * @author Gabriel Woodburn - gwoodburn  * CIS175 - Spring 2021  * Mar 3, 2021  */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="list_details")
public class ListDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@Column(name="LIST_DATE")
	private LocalDate listDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="COMMENT_ID")
	private Comment comment;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(name="items_on_list", joinColumns= {@JoinColumn(name="list_id", referencedColumnName="list_id")}, inverseJoinColumns= {@JoinColumn(name="id", referencedColumnName="ID", unique=true)})
	private List<AddressItem> listOfItems;

	public ListDetails() {
		
	}

	public ListDetails(int id, String listName, LocalDate listDate, Comment comment, List<AddressItem> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.listDate = listDate;
		this.comment = comment;
		this.listOfItems = listOfItems;
	}

	public ListDetails(String listName, LocalDate listDate, Comment comment, List<AddressItem> listOfItems) {
		super();
		this.listName = listName;
		this.listDate = listDate;
		this.comment = comment;
		this.listOfItems = listOfItems;
	}

	public ListDetails(String listName, LocalDate listDate, Comment comment) {
		super();
		this.listName = listName;
		this.listDate = listDate;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getListDate() {
		return listDate;
	}

	public void setListDate(LocalDate listDate) {
		this.listDate = listDate;
	}

	public Comment getComment() {
		return comment;
	}


	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public List<AddressItem> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<AddressItem> listOfItems) {
		this.listOfItems = listOfItems;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", listDate=" + listDate + ", comment=" + comment
				+ ", listOfItems=" + listOfItems + "]";
	}
	
}
