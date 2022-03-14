package com.iudigital.rentacar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.rentacar.data.UserRepository;
import com.iudigital.rentacar.domain.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void createUser(User user) {
		userRepository.save(user);
	}

	public List<User> getUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		return users;
	}

	public User getUserById(int idUser) {

		// Optional<User> user= userRepository.findById(idUser);
		// return user.orElse(new User());

		User user = userRepository.findById(idUser).orElse(new User());
		return user;

	}

	public void editUser(int idUser, User user) {

		User userUpdate = userRepository.findById(idUser).orElse(null);
		if (userUpdate != null) {
			userUpdate.setNombre(user.getNombre());
			userUpdate.setApellido(user.getApellido());
			userUpdate.setBarrio(user.getBarrio());
			userUpdate.setCedula(user.getCedula());
			userUpdate.setCiudad(user.getCiudad());
			userUpdate.setDireccion(user.getDireccion());
			userUpdate.setFoto(user.getFoto());
			userRepository.save(userUpdate);
		}

	}
	
	public void deleteUser(int idUser) {
		
		userRepository.deleteById(idUser);
		
	}
		
		
	

}
	
//AGREGAR METODO TIPO VOID QUE RECIBE COMO PARAMETRO IDUSUARIO Y SI EXISTE USUARIO LO ELIMINA
