package tn.esprit.spring.mapper;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.dto.EmployeDTO;
import tn.esprit.spring.entities.Employe;


public class EmployeMapper {

	public static Employe toEntity(EmployeDTO employeDto) {
		
		if(employeDto == null) {
			return null;
		}
		Employe employe = new Employe();
			
		employe.setEmail(employeDto.getEmail());
		employe.setPassword(employeDto.getPassword());
		employe.setPrenom(employeDto.getPrenom());
		employe.setActif(employeDto.isActif());
				return employe;
	
	}
	
	
	public static EmployeDTO toDto(Employe employe) {
		
		if(employe == null) {
			return null;
		}
		return EmployeDTO.builder()
				.email(employe.getEmail())
				.password(employe.getPassword())
				.prenom(employe.getPrenom())
				.actif(employe.isActif())
				.build();
	
	}
	
	
}
