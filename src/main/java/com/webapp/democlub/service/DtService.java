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
		Dt dt = dtRepository.findById(id).orElse(null);
		return dt;
	}
	
	public List<Dt> findAll() {
		List<Dt> dts = new ArrayList<>();
		Iterator<Dt> iteratorDts = dtRepository.findAll().iterator();
		while (iteratorDts.hasNext()) {
			dts.add(iteratorDts.next());
		}
		return dts ;
	}
	
	public void save(Dt dt) {
		dtRepository.save(dt);
	}

	public void delete(Long id) {
		dtRepository.deleteById(id);
	}

}
