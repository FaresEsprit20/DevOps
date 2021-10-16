package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;


public class EmployeTestApp extends AbstractTest {

private static final Logger l = LogManager.getLogger(EmployeTestApp.class);
	
	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
   }
	
	
	 @Test
	   public void ajouterEmployer() throws Exception {
		// ContratDTO contrat = new ContratDTO(1,new Date)
	      String uri = "/ajouterEmployer";
	      Employe employeDto = new Employe();
	      employeDto.setId(2);;
	      employeDto.setNom("Bob");
	      employeDto.setPrenom("DART");
	      employeDto.setEmail("employe@esprit.tn");
	      employeDto.setPassword("bobbypassword");
	      employeDto.setRole(Role.INGENIEUR);
	   // employeDto.setContrat(contrat);
	      
	      String inputJson = super.mapToJson(employeDto);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("l'employe a été ajouté avec succés");
	      }else if(status == 201) {
	    	  l.info("l'employé a été ajouté avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	     
	   }
	
	 
	 @Test
	   public void ajouterContrat() throws Exception {
		// ContratDTO contrat = new ContratDTO(1,new Date)

		 String sDate1="31-12-2020";  
		  SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");  
		  Date dateDebut=formatter1.parse(sDate1);  
	      String uri = "/ajouterContrat";
	      Contrat contrat = new Contrat();
	      contrat.setDateDebut(dateDebut);
	      contrat.setReference(1);
	      contrat.setSalaire(500);
	      contrat.setTypeContrat("CDI");
	      
	      
	      
	      String inputJson = super.mapToJson(contrat);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("le contrat a été ajouté avec succés");
	      }else if(status == 201) {
	    	  l.info("le contrat a été ajouté avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	     
	   }
	 
	 
	 @Test
	   public void affecterContratAEmploye() throws Exception {
	      String uri = "/affecterContratAEmploye/1/2";
	   
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	        ).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("le contrat a été affecté à l'employé avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   } 

	 
	 @Test
	   public void getEmployePrenomById() throws Exception {
	      String uri = "/getEmployePrenomById/1";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	     
	      if(status == 200) {
	    	  l.info("lemployé a été recupéré avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   }
	 
	 @Test
	   public void deleteEmployeById() throws Exception {
	      String uri = "/deleteEmployeById/9";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("employé a été recupérée avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   }
	 
	 @Test
	   public void deleteContratById() throws Exception {
	      String uri = "/deleteContratById/2";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("contrat a été recupérée avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   }
	 

	 
	 
	 
	 
}

