package businessLogic;

import java.awt.Color;
import java.net.URL;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataAccess.DataAccess;

public class BLFactory {

	public BLFacade getBusinessLogicFactory(int num) {
		ConfigXML c=ConfigXML.getInstance(); 
		try{
			BLFacade appFacadeInterface;
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		
			
			if (num==1) {
			
				DataAccess da= new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
				appFacadeInterface=new BLFacadeImplementation(da);
				return appFacadeInterface;

			}else {
			
				String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";
				URL url = new URL(serviceName);
				QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
				Service service = Service.create(url, qname);
				appFacadeInterface = service.getPort(BLFacade.class);
				return appFacadeInterface;
			}
		
		}catch (Exception e) {
		
			System.out.println("Error in BLFactory: "+e.toString());
			return null;
		}
	}
}
