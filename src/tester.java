import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.AddressDetailsHelper;
import model.ListDetails;
import model.AddressItem;
import model.Comment;

/**  * @author Gabriel Woodburn - gwoodburn  * CIS175 - Spring 2021  * Mar 2, 2021  */

public class tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Comment bill = new Comment("Bill");
		
		AddressDetailsHelper ldh = new AddressDetailsHelper();
		
		AddressItem deoderant = new AddressItem("Target", "Deoderant");
		AddressItem chips = new AddressItem("Target", "Chips");
		
		List<AddressItem> billItems = new ArrayList<AddressItem>();
		billItems.add(deoderant);
		billItems.add(chips);
		
		ListDetails billList = new ListDetails("Bill's ShoppingList", LocalDate.now(), bill);
		
		ldh.insertNewListDetails(billList);
		
		List<ListDetails>  allLists = ldh.getLists();
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}
	}

}
