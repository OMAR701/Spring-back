package com.example.springangularbackend.security;
//
//import com.example.gestionfinanciere.Repository.PersonRepository;
//import com.example.gestionfinanciere.models.Person;
//import com.example.gestionfinanciere.models.Role;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class CustomUserDetailsService  implements UserDetailsService {
//
//    private PersonRepository personRepository;
//
//    @Autowired
//    public CustomUserDetailsService(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Person person = personRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Email not found"));
//        return new User(person.getEmail(), person.getPassword(), mapRolesToAuthorities(person.getRoles()));
//    }
//
//    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }
//}