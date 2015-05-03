package fr.istic.master1.SIR.tp.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.istic.master1.SIR.tp.shared.Address;
import fr.istic.master1.SIR.tp.shared.House;
import fr.istic.master1.SIR.tp.shared.SmartDevice;

public interface HouseServiceAsync {

	void createHouse(House h, AsyncCallback<Void> callback);
	
	void getAllHouse(AsyncCallback<List<House>> callback);
	
	void getAllSmartDevice(House h, AsyncCallback<List<SmartDevice>> callback);

	void getSmartDeviceById(long id, AsyncCallback<SmartDevice> callback);

	void getAddress(House h, AsyncCallback<Address> callback);

	void deleteSmartDevice(House h, long idSmartDevice, AsyncCallback<Void> callback);

	void addSmartDevice(House h, SmartDevice s, AsyncCallback<Void> callback);

	void addAddress(House h, String address, AsyncCallback<Void> callback);

}
