package com.coolkids.coolKidsApp.security.services;

import com.coolkids.coolKidsApp.api.v1.mapper.UserMapper;
import com.coolkids.coolKidsApp.api.v1.model.UserDTO;
import com.coolkids.coolKidsApp.controllers.TestController;
import com.coolkids.coolKidsApp.domain.User;
import com.coolkids.coolKidsApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserServices {
	@Autowired
	UserRepository userRepository;


	private final UserMapper userMapper;

	@Autowired
	PasswordEncoder encoder;



	public UserDetailsServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;

	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}


	public UserDTO patchUser(Long id, UserDTO userDTO) {
		return userRepository.findById(id).map(user -> {

			if(userDTO.getFirstName() != null){
				user.setFirstName(userDTO.getFirstName());
			}

			if(userDTO.getLastName() != null){
				user.setLastName(userDTO.getLastName());
			}

			if(userDTO.getEmail() != null){
				user.setEmail(userDTO.getEmail());
			}

			if(userDTO.getPassword() != null){
				user.setPassword(encoder.encode(userDTO.getPassword()));
				//encoder.encode(signUpRequest.getPassword()));
			}

			if(userDTO.getRoles() != null){
				user.setRoles(userDTO.getRoles());
			}

			if(userDTO.getBirthdate() != null){
				user.setBirthdate(userDTO.getBirthdate());
			}

			if(userDTO.getAddress() != null){
				user.setAddress(userDTO.getAddress());
			}

			if(userDTO.getPhoneNumber() != null){
				user.setPhoneNumber(userDTO.getPhoneNumber());
			}

			if(userDTO.getAccountCreatedDate() != null){
				user.setAccountCreatedDate(userDTO.getAccountCreatedDate());
			}

			if(userDTO.getAccountUpdatedDate() != null){
				user.setAccountUpdatedDate(userDTO.getAccountUpdatedDate());
			}

			if(userDTO.getProfilePic() != null){
				user.setProfilePic(userDTO.getProfilePic());
			}

			UserDTO returnDTO = userMapper.userToUserDTO(userRepository.save(user));

			returnDTO.setUserUrl(userDTO.getUserUrl());

			return returnDTO;

		}).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		return userRepository
				.findAll()
				.stream()
				.map(user -> {
					UserDTO userDTO = userMapper.userToUserDTO(user);
					userDTO.setUserUrl(getUserUrl(user.getId()));
					return userDTO;
				})
				.collect(Collectors.toList());	}

	@Override
	public UserDTO getUserById(Long id) {
		return userRepository.findById(id)
				.map(userMapper::userToUserDTO)
				.map(userDTO -> {
					//set API URL
					userDTO.setUserUrl(getUserUrl(id));
					return userDTO;
				})
				.orElseThrow(ResourceNotFoundException::new);
	}

	public UserDTO saveUserByDTO(Long id, UserDTO userDTO) {
		User user = userMapper.userDTOtoUser(userDTO);
		user.setId(id);

		return saveAndReturnDTO(user);
	}

	private UserDTO saveAndReturnDTO(User user) {

		User savedUser = userRepository.save(user);

		UserDTO returnDto = userMapper.userToUserDTO(savedUser);

		returnDto.setUserUrl("/api/test/user/" + savedUser.getId());

		return returnDto;
	}

	private String getUserUrl(Long id) {
		return TestController.BASE_URL + "/" + id;
	}
}
