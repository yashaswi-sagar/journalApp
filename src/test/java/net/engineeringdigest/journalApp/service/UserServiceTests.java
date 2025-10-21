package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.Repository.UserRepository;
import net.engineeringdigest.journalApp.Service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    @Disabled
    public void findByUserName(){
        User user=userRepository.findByUserName("Ram");
        assertTrue(!user.getJournalEntries().isEmpty());
        assertNotNull(userRepository.findByUserName("Ram"));
    }
    @Disabled
    @ParameterizedTest
    @ValueSource(strings={
            "Ram",
            "Yash",
            "SHYAM"
    })
    public void test2(String name){
        assertNotNull(userRepository.findByUserName(name),"Failed for "+name);
    }
    //For custom source
    @ParameterizedTest
    @Disabled
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user){
        assertTrue(userService.saveNewUser(user));

    }
    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "4,2,2",
            "6,3,3"
    })
    public void test(int expected, int a,int b){
        assertEquals(expected,a+b);
    }


}
