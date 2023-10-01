package com.todo.list.service;

import com.todo.list.dao.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
User getByUsername(String username);
void save(User user);
}
