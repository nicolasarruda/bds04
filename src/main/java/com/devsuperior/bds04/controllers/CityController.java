package com.devsuperior.bds04.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.services.CityService;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

	@Autowired
	private CityService service;
	
	public ResponseEntity<List<CityDTO>> findAll(){
		List<CityDTO> listDto = service.findAll();
		return ResponseEntity.ok().body(listDto);
	}
	
	public ResponseEntity<CityDTO> insert(@Valid @RequestBody CityDTO dto){
		dto = service.insert(dto);
		return ResponseEntity.created(null).body(dto);
	}
}
