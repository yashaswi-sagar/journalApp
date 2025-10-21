package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repository.UserRepository;
import net.engineeringdigest.journalApp.Service.UserDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.engineeringdigest.journalApp.Entity.User;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import static org.mockito.Mockito.*;



public class UserDetailsServiceImplTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;
    @Mock
    private UserRepository userRepository;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Disabled
    @Test
    void loadUserByUsernameTest(){
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("Ram").password("ashgcgi").build());
        UserDetails user=userDetailsService.loadUserByUsername("Ram");
        Assertions.assertNotNull(user);
    }
}
//@SpringBootTest
//public class UserDetailsServiceImplTests {
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//    @MockBean
//    private UserRepository userRepository;
//    @Test
//    void loadUserByUsernameTest(){
//        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("Ram").password("ashgcgi").build());
//        UserDetails user=userDetailsService.loadUserByUsername("Ram");
//        Assertions.assertNotNull(user);
//    }
//}