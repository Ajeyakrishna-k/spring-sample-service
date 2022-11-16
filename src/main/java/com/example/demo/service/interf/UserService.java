package com.example.demo.service.interf;

import com.example.demo.entity.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO save(UserDTO userDTO);

    UserDTO findUser(Long id);

    List<UserDTO> findAllUser();

    UserDTO updateUser(UserDTO userDTO, Long id);

    void deleteUser(Long id);
}
