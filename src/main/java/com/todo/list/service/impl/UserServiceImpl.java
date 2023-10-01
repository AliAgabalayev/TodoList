package com.todo.list.service.impl;

import com.todo.list.dao.entity.User;
import com.todo.list.dao.repository.UserRepository;
import com.todo.list.dto.request.RegisterRequest;
import com.todo.list.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User getByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public void save(User user){
       userRepository.save(user);
    }
}
