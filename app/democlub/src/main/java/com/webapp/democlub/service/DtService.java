package com.webapp.democlub.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.democlub.domain.Dt;
import com.webapp.democlub.repository.DtRepository;

@Service
public class DtService {

	@Autowired
	private DtRepository dtRepository;
	
	
	public Dt findById(Long id) {
		Dt dt = new Dt(id, null);
		return dt;
	}

	
	public List<Dt> findAll() {
		List<Dt> dts = new ArrayList<>();
		return dts ;
	}

	
	public void save(Dt dt) {
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
