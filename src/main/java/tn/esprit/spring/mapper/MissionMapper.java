package tn.esprit.spring.mapper;

import java.util.ArrayList;
import java.util.List;
import tn.esprit.spring.dto.DepartementDTO;
import tn.esprit.spring.dto.EmployeDTO;
import tn.esprit.spring.dto.EntrepriseDTO;
import tn.esprit.spring.dto.MissionDTO;
import tn.esprit.spring.dto.TimesheetDTO;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;


public class MissionMapper {
	
	
	public static Mission toEntity(MissionDTO missionDto) {
		
		 Departement departement = DepartementMapper.toEntity(missionDto.getDepartement());
		
		
		Mission mission = new Mission();
		
		mission.setId(missionDto.getId());
		mission.setName(missionDto.getName());
		mission.setDescription(missionDto.getDescription());
		mission.setDepartement(departement);
		
				return mission;
	
	}
	
	
	public static MissionDTO toDto(Mission mission) {
		 DepartementDTO departementDto = DepartementMapper.toDto(mission.getDepartement());
		
		 MissionDTO missionDTO = new MissionDTO();
			
		 missionDTO.setId(mission.getId());
		 missionDTO.setName(mission.getName());
		 missionDTO.setDescription(mission.getDescription());
		 missionDTO.setDepartement(departementDto);	
		       return missionDTO;
		
	
	}
	
	
	

}
