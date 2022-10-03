package com.evaluation.me.service;

import com.evaluation.me.entity.User;
import com.evaluation.me.exception.NoDataFoundException;
import com.evaluation.me.repository.PhoneRepository;
import com.evaluation.me.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private PhoneRepository phoneRepository;

    @Value("${error.message.email}")
    private String emailErrorMsg;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User addUser(User user) {

        userRepository.findByEmail(user.getEmail()).ifPresent(s -> {
            throw new NoDataFoundException(emailErrorMsg);
        });


        return userRepository.save(user);

    }

}
