package com.coolkids.coolKidsApp.security.services;

import com.coolkids.coolKidsApp.api.v1.model.UserDTO;

import java.util.List;

public interface UserServices {
    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);


    UserDTO saveUserByDTO(Long id, UserDTO userDTO);

    UserDTO patchUser(Long id, UserDTO userDTO);

    void deleteUserById(Long id);
}
