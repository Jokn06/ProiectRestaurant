//package org.example.security;
//
//import org.example.entity.User;
//import org.example.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//@Service
//public class UserDetailService implements UserDetailsService{
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        User user = userRepository.findByName(name);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found !");
//        }
//        return new org.example.security.UserDetails(user);
//    }
//}
