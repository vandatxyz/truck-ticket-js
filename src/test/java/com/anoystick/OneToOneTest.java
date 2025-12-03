package com.anoystick;

import com.anoystick.entity.user.CCCDEntity;
import com.anoystick.entity.user.UserEntity;
import com.anoystick.repository.CCCDRepository;
import com.anoystick.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class OneToOneTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CCCDRepository ccdRepository;

    @Test
    @Transactional
    @Rollback(false)
    void oneToOneTest() {
        UserEntity user = new UserEntity();
        CCCDEntity cccd = new CCCDEntity();

        user.setUserName("Tip cccd");
        user.setUserEmail("cccd11@gmail.com");

        cccd.setNumberCCCD("1111222333");
        user.setCccd(cccd);

        userRepository.save(user);
    }

}
