package com.hkprogrammer.myposts.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkprogrammer.myposts.domain.User;
import com.hkprogrammer.myposts.dto.UserDTO;
import com.hkprogrammer.myposts.repository.UserRepository;
import com.hkprogrammer.myposts.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		User user = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		return user;
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User objSaved = findById(obj.getId());
		BeanUtils.copyProperties(obj, objSaved, "id");
		
		return repo.save(objSaved);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
	
}
