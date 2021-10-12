package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;




public class EntrepriseTestApp extends AbstractTest {

	private static final Logger l = LogManager.getLogger(EntrepriseTestApp.class);
	
	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
   }
	
	 @Test
	   public void ajouterEntreprise() throws Exception {
	      String uri = "/ajouterEntreprise";
	      Entreprise entreprise = new Entreprise();
	      entreprise.setId(2);;
	      entreprise.setName("Ginger");
	      entreprise.setRaisonSocial("Lac 2");
	      String inputJson = super.mapToJson(entreprise);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("l'entreprise a été ajouté avec succés");
	      }else if(status == 201) {
	    	  l.info("l'entreprise a été ajouté avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	     
	   }
	   
	   
	   @Test
	   public void ajouterDepartement() throws Exception {
	      String uri = "/ajouterDepartement";
	      Departement departement = new Departement();
	      departement.setId(1);;
	      departement.setName("Ginger");
	 
	      String inputJson = super.mapToJson(departement);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("le departement a été ajouté avec succés");
		      }else if(status >= 400 && status <500) {
		    	  l.fatal("erreur coté client :  code reponse :  "+status);
		      }else if(status >= 500){
		    	  l.error("erreur coté serveur :  code reponse :  "+status);
		      }
	   }
	   
	   
	   @Test
	   public void getEntrepriseById() throws Exception {
	      String uri = "/getEntrepriseById/1";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Entreprise entreprise = super.mapFromJson(content, Entreprise.class);
	      assertTrue(entreprise != null);
	          if(status == 200) {
		    	  l.info("l'entreprise a été recupérée avec succés");
		      }else if(status >= 400 && status <500) {
		    	  l.fatal("erreur coté client :  code reponse :  "+status);
		      }else if(status >= 500){
		    	  l.error("erreur coté serveur :  code reponse :  "+status);
		      }
	   }
	   
	   
	   @Test
	   public void getAllDepartementsNamesByEntreprise() throws Exception {
	      String uri = "/getAllDepartementsNamesByEntreprise/1";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	     
	      if(status == 200) {
	    	  l.info("les deârtmenets de l'entreprise ont été recupérées avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   }
	
	
	   @Test
	   public void affecterDepartementAEntreprise() throws Exception {
	      String uri = "/affecterDepartementAEntreprise/6/10";
	   
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	        ).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("le département a été affecté à l'entreprise avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   }
	  
 
	   @Test
	   public void deleteEntreprise() throws Exception {
	      String uri = "/deleteEntrepriseById/13";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("l'entreprise a été supprimée avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   }
	   
	   
	   @Test
	   public void deleteDepartement() throws Exception {
	      String uri = "/deleteDepartementById/9";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("le département a été recupérée avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   }
	   
	   
	
	   
	   
	   
	   public class EmployePOJO  {
	    	

	    	private int id;
	    	
	    	private String prenom;
	    	
	    	private String nom;
	    	
	    	private String email;

	    	private String password;
	    	
	    	private boolean actif;
	    	
	    	private Role role;
	    	
	    	private List<DepartementPOJO> departements;
	    	
	    	private ContratPOJO contrat;
	    	
	    	private List<TimesheetPOJO> timesheets;
	    	
	    	
	    	public EmployePOJO() {
	    		super();
	    	}
	    	
	    		
	    	public EmployePOJO(int id, String prenom, String nom, String email, String password, boolean actif, Role role) {
	    		super();
	    		this.id = id;
	    		this.prenom = prenom;
	    		this.nom = nom;
	    		this.email = email;
	    		this.password = password;
	    		this.actif = actif;
	    		this.role = role;
	    	}



	    	public EmployePOJO(String nom, String prenom, String email, String password, boolean actif, Role role) {
	    		this.nom = nom;
	    		this.prenom = prenom;
	    		this.email = email;
	    		this.password = password;
	    		this.actif = actif;
	    		this.role = role;
	    	}
	    	
	    	public EmployePOJO(String nom, String prenom, String email, boolean actif, Role role) {
	    		this.nom = nom;
	    		this.prenom = prenom;
	    		this.email = email;
	    		this.actif = actif;
	    		this.role = role;
	    	}
	    	
	    	public int getId() {
	    		return id;
	    	}

	    	public void setId(int id) {
	    		this.id = id;
	    	}

	    	public String getPrenom() {
	    		return prenom;
	    	}

	    	public void setPrenom(String prenom) {
	    		this.prenom = prenom;
	    	}

	    	public String getNom() {
	    		return nom;
	    	}

	    	public void setNom(String nom) {
	    		this.nom = nom;
	    	}

	    	public String getEmail() {
	    		return email;
	    	}
	    	 
	    	public String getPassword() {
	    		return password;
	    	}
	     
	    	public void setPassword(String password) {
	    		this.password = password;
	    	}

	    	public void setEmail(String email) {
	    		this.email = email;
	    	}




	    	public boolean isActif() {
	    		return actif;
	    	}


	    	public void setActif(boolean actif) {
	    		this.actif = actif;
	    	}


	    	public Role getRole() {
	    		return role;
	    	}

	    	public void setRole(Role role) {
	    		this.role = role;
	    	}

	    	public List<DepartementPOJO> getDepartements() {
	    		return departements;
	    	}

	    	public void setDepartements(List<DepartementPOJO> departement) {
	    		this.departements = departement;
	    	}

	    	public ContratPOJO getContrat() {
	    		return contrat;
	    	}

	    	public void setContrat(ContratPOJO contrat) {
	    		this.contrat = contrat;
	    	}

	    	public List<TimesheetPOJO> getTimesheets() {
	    		return timesheets;
	    	}

	    	public void setTimesheets(List<TimesheetPOJO> timesheets) {
	    		this.timesheets = timesheets;
	    	}


	    	@Override
	    	public String toString() {
	    		return "Employe [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", password="
	    				+ password + ", actif=" + actif + ", role=" + role + "]";
	    	}
	    	
	    	
	    	
	    }


	    
	    
	    public class ContratPOJO {
	    	
	    	private int reference;

	    	private Date dateDebut;
	    	
	    	private String typeContrat;
	    	
	    	private float telephone;
	    	
	    	private EmployePOJO employe;

	    	private float salaire;

	    	public ContratPOJO() {
	    		super();
	    	}
	    	
	    	public ContratPOJO(Date dateDebut, String typeContrat, float salaire) {
	    		this.dateDebut = dateDebut;
	    		this.typeContrat = typeContrat;
	    		this.salaire = salaire;
	    	}


	    	public Date getDateDebut() {
	    		return dateDebut;
	    	}

	    	public void setDateDebut(Date dateDebut) {
	    		this.dateDebut = dateDebut;
	    	}

	    	public int getReference() {
	    		return reference;
	    	}

	    	public void setReference(int reference) {
	    		this.reference = reference;
	    	}

	    	public String getTypeContrat() {
	    		return typeContrat;
	    	}

	    	public void setTypeContrat(String typeContrat) {
	    		this.typeContrat = typeContrat;
	    	}

	    	public float getSalaire() {
	    		return salaire;
	    	}

	    	public void setSalaire(float salaire) {
	    		this.salaire = salaire;
	    	}

	    	public EmployePOJO getEmploye() {
	    		return employe;
	    	}

	    	public void setEmploye(EmployePOJO employe) {
	    		this.employe = employe;
	    	}
	    	
	    	
	    }
	    
	    

	    public class DepartementPOJO{

	    	private int id;
	    	
	    	private String name;
	    
	    	private List<EmployePOJO> employes;
	    	
	    	private List<MissionPOJO> missions;
	    	
	    	private EntreprisePOJO entreprise;

	    	public DepartementPOJO() {
	    		super();
	    	}
	    	
	    	public DepartementPOJO(String name) {
	    		this.name = name;
	    	}
	    	
	    	public int getId() {
	    		return id;
	    	}

	    	public void setId(int id) {
	    		this.id = id;
	    	}

	    	public String getName() {
	    		return name;
	    	}

	    	public void setName(String name) {
	    		this.name = name;
	    	}

	    	public List<EmployePOJO> getEmployes() {
	    		return employes;
	    	}

	    	public void setEmployes(List<EmployePOJO> employes) {
	    		this.employes = employes;
	    	}

	    	public List<MissionPOJO> getMissions() {
	    		return missions;
	    	}

	    	public void setMissions(List<MissionPOJO> missions) {
	    		this.missions = missions;
	    	}

	    	public EntreprisePOJO getEntreprise() {
	    		return entreprise;
	    	}

	    	public void setEntreprise(EntreprisePOJO entreprise) {
	    		this.entreprise = entreprise;
	    	}
	    	
	    	

	    }
	    
	    
	    
	    public class EntreprisePOJO{
	    	

	    	private int id;
	    	
	    	private String name;
	    
	    	private String raisonSocial;
	    	
	  
	    	private List<DepartementPOJO> departements = new ArrayList<>();

	    	public EntreprisePOJO() {
	    		super();
	    	}

	    	public EntreprisePOJO(String name, String raisonSocial) {
	    		this.name = name;
	    		this.raisonSocial = raisonSocial;
	    	}

	    	public int getId() {
	    		return id;
	    	}

	    	public void setId(int id) {
	    		this.id = id;
	    	}

	    	public String getName() {
	    		return name;
	    	}

	    	public void setName(String name) {
	    		this.name = name;
	    	}

	    	public String getRaisonSocial() {
	    		return raisonSocial;
	    	}

	    	public void setRaisonSocial(String raisonSocial) {
	    		this.raisonSocial = raisonSocial;
	    	}

	    	public List<DepartementPOJO> getDepartements() {
	    		return departements;
	    	}

	    	public void setDepartements(List<DepartementPOJO> departements) {
	    		this.departements = departements;
	    	}
	    	
	    	
	    	public void addDepartement(DepartementPOJO departement){
	    		departement.setEntreprise(this);
	    		this.departements.add(departement);
	    	}


	    }

	    
	    
	    public class MissionPOJO {

	    	private int id;
	    	
	    	private String name;
	    	
	    	private String description;
	    	
	    	private DepartementPOJO departement;
	    	
	    	
	    	private  List<TimesheetPOJO> timesheets;
	    	
	    	public MissionPOJO() {
	    		super();
	    	}

	    	public MissionPOJO(String name, String description){
	    		this.name = name;
	    		this.description = description;
	    	}
	    	

	    	public int getId() {
	    		return id;
	    	}

	    	public void setId(int id) {
	    		this.id = id;
	    	}

	    	public String getName() {
	    		return name;
	    	}

	    	public void setName(String name) {
	    		this.name = name;
	    	}

	    	public String getDescription() {
	    		return description;
	    	}

	    	public void setDescription(String description) {
	    		this.description = description;
	    	}

	    	public DepartementPOJO getDepartement() {
	    		return departement;
	    	}

	    	public void setDepartement(DepartementPOJO departement) {
	    		this.departement = departement;
	    	}

	    	public List<TimesheetPOJO> getTimesheets() {
	    		return timesheets;
	    	}

	    	public void setTimesheets(List<TimesheetPOJO> timesheets) {
	    		this.timesheets = timesheets;
	    	}
	    	
	    	

	    }

	    
	    public class MissionExternePOJO extends MissionPOJO {
	    	
	    
	    	private String emailFacturation;
	    	
	    	
	    	private float tauxJournalierMoyen;

	    	
	    	public MissionExternePOJO() {
	    		super();
	    	}


	    	public MissionExternePOJO(String name, String description, String emailFacturation, float tauxJournalierMoyen) {
	    		super(name, description);
	    		this.emailFacturation = emailFacturation;
	    		this.tauxJournalierMoyen = tauxJournalierMoyen;
	    	}


	    	public String getEmailFacturation() {
	    		return emailFacturation;
	    	}


	    	public void setEmailFacturation(String emailFacturation) {
	    		this.emailFacturation = emailFacturation;
	    	}


	    	public float getTauxJournalierMoyen() {
	    		return tauxJournalierMoyen;
	    	}


	    	public void setTauxJournalierMoyen(float tauxJournalierMoyen) {
	    		this.tauxJournalierMoyen = tauxJournalierMoyen;
	    	}
	    	
	    	
	    }

	    
	    public class TimesheetPOJO{

	    	private TimesheetPKPOJO timesheetPK;
	    	
	    	private MissionPOJO mission;
	    	

	    	private EmployePOJO employe;
	    	
	    	
	    	private boolean isValide;
	    	

	    	public boolean isValide() {
	    		return isValide;
	    	}

	    	public void setValide(boolean isValide) {
	    		this.isValide = isValide;
	    	}

	    	public TimesheetPKPOJO getTimesheetPK() {
	    		return timesheetPK;
	    	}

	    	public void setTimesheetPK(TimesheetPKPOJO timesheetPK) {
	    		this.timesheetPK = timesheetPK;
	    	}

	    	public MissionPOJO getMission() {
	    		return mission;
	    	}

	    	public void setMission(MissionPOJO mission) {
	    		this.mission = mission;
	    	}

	    	public EmployePOJO getEmploye() {
	    		return employe;
	    	}

	    	public void setEmploye(EmployePOJO employe) {
	    		this.employe = employe;
	    	}

	    	
	    	
	    }


	    
	    public class TimesheetPKPOJO {

	    	private int idMission;
	    	
	    	private int idEmploye;

	    	private Date dateDebut;
	    	
	    	private Date dateFin;
	    	
	    	public TimesheetPKPOJO() {
	    		super();
	    	}
	    	
	    	public TimesheetPKPOJO(int idMission, int idEmploye, Date dateDebut, Date dateFin) {
	    		super();
	    		this.idMission = idMission;
	    		this.idEmploye = idEmploye;
	    		this.dateDebut = dateDebut;
	    		this.dateFin = dateFin;
	    	}


	    	@Override
	    	public int hashCode() {
	    		final int prime = 31;
	    		int result = 1;
	    		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
	    		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
	    		result = prime * result + idEmploye;
	    		result = prime * result + idMission;
	    		return result;
	    	}

	    	@Override
	    	public boolean equals(Object obj) {
	    		if (this == obj)
	    			return true;
	    		if (obj == null)
	    			return false;
	    		if (getClass() != obj.getClass())
	    			return false;
	    		TimesheetPKPOJO other = (TimesheetPKPOJO) obj;
	    		if (dateDebut == null) {
	    			if (other.dateDebut != null)
	    				return false;
	    		} else if (!dateDebut.equals(other.dateDebut))
	    			return false;
	    		if (dateFin == null) {
	    			if (other.dateFin != null)
	    				return false;
	    		} else if (!dateFin.equals(other.dateFin))
	    			return false;
	    		if (idEmploye != other.idEmploye)
	    			return false;
	    		if (idMission != other.idMission)
	    			return false;
	    		return true;
	    	}

	    	public void setIdMission(int idMission) {
	    		this.idMission = idMission;
	    	}

	    	public int getIdEmploye() {
	    		return idEmploye;
	    	}

	    	public void setIdEmploye(int idEmploye) {
	    		this.idEmploye = idEmploye;
	    	}

	    	public Date getDateDebut() {
	    		return dateDebut;
	    	}

	    	public void setDateDebut(Date dateDebut) {
	    		this.dateDebut = dateDebut;
	    	}

	    	public Date getDateFin() {
	    		return dateFin;
	    	}

	    	public void setDateFin(Date dateFin) {
	    		this.dateFin = dateFin;
	    	}

	    	public int getIdMission() {
	    		return idMission;
	    	}

	    }
	   
	   
	
}
