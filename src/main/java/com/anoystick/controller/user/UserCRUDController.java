package com.anoystick.controller.user;


import com.anoystick.entity.user.UserEntity;
import com.anoystick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserCRUDController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userService.createUser(userEntity);
    }

    @GetMapping("/search")
    public UserEntity searchUser(@RequestParam String userName,@RequestParam String userEmail) {
        return userService.findByUserNameAndUserEmail(userName, userEmail);
    }

    @GetMapping("/getAll")
    public Page<UserEntity> getAll(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction) {

        Sort.Direction d = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(d, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return userService.findAllUsers(pageable);
    }

    @GetMapping("/searchPage")
    public Page<UserEntity> searchPageUserName(

            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction,
            @RequestParam String userName
    ) {
        Sort.Direction d = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(d, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return userService.findByUserName(userName, pageable);
    }

}
