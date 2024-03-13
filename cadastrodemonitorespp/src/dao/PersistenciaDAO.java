package dao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

/**
 * Classe que salva e recupera as informacoes da central
 */
public class PersistenciaDAO {
	
   private XStream xStream; 
   
   public PersistenciaDAO() {
	   xStream = new XStream(new DomDriver("UTF-8"));
	   xStream.addPermission(AnyTypePermission.ANY); 
   } 
}
