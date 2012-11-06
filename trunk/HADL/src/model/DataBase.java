package model;

import java.util.ArrayList;

import composant.Composant;

import metamodel.port.Port;
import metamodel.port.PortF;
import metamodel.port.PortR;
import metamodel.propiete.Propriete;
import metamodel.propiete.ProprieteFonc;
import metamodel.service.Service;
import metamodel.service.ServiceF;

public class DataBase extends Composant {

	//private ProprieteNonFonc mPropNonFonC;
	private ProprieteFonc mPropFonc;
	private ArrayList<Port> mPorts= new ArrayList<Port>();
	private ArrayList<Service> mServices =new ArrayList<Service>();
	
//	public DataBase(/*ProprieteNonFonc mPropNonFonC,*/ ProprieteFonc mPropFonc,
//			ArrayList<Port> mPorts, ArrayList<Service> mServices) {
//		super();
//		this.mPorts.add(new PortR("PortRExecuteSQL"));
//		this.mPorts.add(new PortF("PortFFxecuteSQL"));
//		this.mServices.add(new ServiceF("ServiceFExecuteSQL"));	
//		this.mPorts.add(new PortR("PortRSecurityManagement"));
//		this.mPorts.add(new PortF("PortFSecurityManagement"));
//		this.mServices.add(new ServiceF("ServiceFExecuteSQL"));	
//		}


}
