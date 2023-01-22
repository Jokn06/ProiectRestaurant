//package org.example.security;
//
//import lombok.RequiredArgsConstructor;
//import org.example.entity.User;
//import org.springframework.security.core.GrantedAuthority;
//
//import java.util.Collection;
//
//@RequiredArgsConstructor
//public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
//
//   private final User user;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getName();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
