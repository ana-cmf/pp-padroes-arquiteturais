package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import BD.CentralDeInformacoes;

public class PersistenciaDAO {
<<<<<<< HEAD
	
   private XStream xStream; 
   
   public PersistenciaDAO() {
	   xStream = new XStream(new DomDriver("UTF-8"));
	   xStream.addPermission(AnyTypePermission.ANY); 
   } 
   public void salvarCentral(CentralDeInformacoes central, String nomeDoArquivo) throws Exception {
       File arquivo = new File(nomeDoArquivo);
       arquivo.createNewFile();
       PrintWriter pw = new PrintWriter(arquivo);
       String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
       xml += xStream.toXML(central);
       pw.print(xml);
       pw.close();
   }
   
   public CentralDeInformacoes recuperarCentral(String nomeDoArquivo) throws Exception {
	   File arquivo = new File(nomeDoArquivo);
	   if(arquivo.exists()) {
		   FileInputStream fis = new FileInputStream(arquivo);
		   return (CentralDeInformacoes) xStream.fromXML(fis);
	   }
	   return new CentralDeInformacoes();
   }
   
=======
	 private XStream xStream; 
	   
	   public PersistenciaDAO() {
		   xStream = new XStream(new DomDriver("UTF-8"));
		   xStream.addPermission(AnyTypePermission.ANY); 
	   } 
	   public void salvarCentral(CentralDeInformacoes central, String nomeDoArquivo) throws Exception {
	       File arquivo = new File(nomeDoArquivo);
	       arquivo.createNewFile();
	       PrintWriter pw = new PrintWriter(arquivo);
	       String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	       xml += xStream.toXML(central);
	       pw.print(xml);
	       pw.close();
	   }
	   public CentralDeInformacoes recuperarCentral(String nomeDoArquivo) throws Exception {
	       File arquivo = new File(nomeDoArquivo);
	       if (arquivo.exists()) {
	           FileInputStream fis = new FileInputStream(arquivo);
	           return (CentralDeInformacoes) xStream.fromXML(fis);
	       }
	       
	       CentralDeInformacoes central = new CentralDeInformacoes();
	     	return  central; 	   }
>>>>>>> 6be7e16abdffe353b1ad8787b1d66ce6101f5484
}

