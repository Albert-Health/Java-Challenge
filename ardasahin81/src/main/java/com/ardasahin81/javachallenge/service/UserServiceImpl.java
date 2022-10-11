package com.ardasahin81.javachallenge.service;

import com.ardasahin81.javachallenge.domain.User;
import com.ardasahin81.javachallenge.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

}
