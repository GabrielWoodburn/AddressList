/**  * @author Gabriel Woodburn - gwoodburn  * CIS175 - Spring 2021  * Mar 3, 2021  */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="addresslist")
public class AddressList {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="LIST_ID")
	private ListDetails details;
	
	@ManyToOne
	@JoinColumn(name="ITEM_ID")
	private AddressItem item;
	//private List<ListItem> itemsOnList = new ArrayList<ListItem>();

	public AddressList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ListDetails getDetails() {
		return details;
	}

	public void setDetails(ListDetails details) {
		this.details = details;
	}

	public AddressItem getItem() {
		return item;
	}

	public void setItem(AddressItem item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "AddressList [id=" + id + ", details=" + details + ", item=" + item.toString() + "]";
	}
	
}
