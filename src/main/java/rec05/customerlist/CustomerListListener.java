package rec05.customerlist;

import rec05.customerlist.gui.CustomerManagementPanel;

public class CustomerListListener implements CustomerEventHandler {

	private final CustomerManagementPanel panel;

	public CustomerListListener(CustomerManagementPanel panel) {
		this.panel = panel;
	}

	@Override
	public void customerAdded(Customer customer) {
		panel.addCustomerNameToList(customer.getName());
	}

	@Override
	public void customerUpdated(Customer customer) {
		// Do nothing
	}

	@Override
	public void customerDeleted(Customer customer) {
		// Do nothing
	}

}
