package fr.istic.master1.SIR.tp.client;

import java.util.List;

import javax.ws.rs.PathParam;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.istic.master1.SIR.tp.shared.Address;
import fr.istic.master1.SIR.tp.shared.House;
import fr.istic.master1.SIR.tp.shared.SmartDevice;

@RemoteServiceRelativePath("house")
public interface HouseService extends RemoteService{
	public void createHouse(House h);
	public List<House> getAllHouse();
	public List<SmartDevice> getAllSmartDevice(House h);
	public SmartDevice getSmartDeviceById(long id);
	public Address getAddress(House h);
	public void deleteSmartDevice(House h, long idSmartDevice);
	public void addSmartDevice(House h, SmartDevice s);
	public void addAddress(House h, String address);
}
