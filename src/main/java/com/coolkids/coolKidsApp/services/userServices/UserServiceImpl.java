//package com.coolkids.coolKidsApp.services.userServices;
//
//import com.coolkids.coolKidsApp.api.v1.mapper.UserMapper;
//import com.coolkids.coolKidsApp.api.v1.model.UserDTO;
//import com.coolkids.coolKidsApp.domain.User;
//import com.coolkids.coolKidsApp.repository.UserRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@AllArgsConstructor
//public class UserServiceImpl implements UserDetailsService,UserService {
//
//    private final static String USER_NOT_FOUND = "user with email %s not found";
//    private  final UserRepository userRepository;
//    private final UserMapper userMapper;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        return userRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
//    }
//    @Override
//    public String signUpUser(User user){
//       boolean userExists = userRepository.
//               findByEmail(user.getEmail())
//               .isPresent();
//       if(userExists){
//           throw new IllegalStateException("email already taken");
//       }
//
//       String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
//
//       user.setPassword(encodedPassword);
//
//       userRepository.save(user);
//
//       //TODO: Send confirmation token
//        return "register_success";
//    }
//
//    @Override
//    public List<UserDTO> getAllUsers() {
//        return userRepository.findAll()
//                .stream()
//                .map(userMapper::userToUserDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public UserDTO getUserByLastName(String name) {
//        return userMapper.userToUserDTO(userRepository.findUserByLastName(name));
//    }
//
//
//    public UserDTO getUserById(String id) {
//        return userMapper.userToUserDTO(userRepository.findUserById(id));
//    }
//}
