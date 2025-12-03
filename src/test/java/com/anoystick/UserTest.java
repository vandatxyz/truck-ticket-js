package com.anoystick;

import com.anoystick.entity.feed.FeedEntity;
import com.anoystick.entity.user.UserEntity;
import com.anoystick.repository.FeedRepository;
import com.anoystick.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedRepository feedRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void oneToManyTest() {
        UserEntity  userEntity = new UserEntity();
        FeedEntity feedEntity = new FeedEntity();

        userEntity.setUserName("Tip");
        userEntity.setUserEmail("tip" + System.currentTimeMillis() + ".com");

        feedEntity.setFeedTitle("Feed 01");
        feedEntity.setDescription("Feed Description");
        feedEntity.setUser(userEntity);

        userEntity.setFeedList(List.of(feedEntity));

        userEntity = userRepository.save(userEntity);
        //feedEntity = feedRepository.save(feedEntity);
    }
}
