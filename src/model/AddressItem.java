/**  * @author Gabriel Woodburn - gwoodburn  * CIS175 - Spring 2021  * Feb 23, 2021  */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class AddressItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "OWNER")
	private String owner;
	@Column(name = "ADDRESS")
	private String address;

	public AddressItem() {
		super();
	}

	public AddressItem(String owner, String address) {
		super();
		this.owner = owner;
		this.address = address;
	}

	public String returnAddressDetails() {
		return owner + ": " + address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
