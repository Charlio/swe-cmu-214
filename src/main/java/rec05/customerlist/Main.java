package rec05.customerlist;

import javax.swing.SwingUtilities;

import rec05.customerlist.gui.CustomerManagementUI;

/**
 * The main point of entry into our customer management system.
 */
public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Main().createAndShowCustomerList());
	}

	public void createAndShowCustomerList() {
		CustomerList customerList = new CustomerList();
		CustomerManagementUI ui = new CustomerManagementUI(customerList);

		CustomerEventHandler marketingHandler = new MarketingLetters();
		CustomerEventHandler uiHandler = new CustomerListListener(ui.getManagementPanel());
		customerList.addHandler(marketingHandler);
		customerList.addHandler(uiHandler);

		ui.show();
	}
}
