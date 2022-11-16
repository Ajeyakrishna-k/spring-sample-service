package com.example.demo.service.impl;

import com.example.demo.entity.dao.UserEntity;
import com.example.demo.entity.dto.UserDTO;
import com.example.demo.exceptions.CustomException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.interf.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO save(UserDTO userDTO) {
        UserEntity userEntity = userRepository.save(userDTO.convertToEntity());
        return new UserDTO(userEntity);
    }

    @Override
    public UserDTO findUser(Long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if(userEntityOptional.isEmpty()){
            throw new CustomException("User Not Found");
        }
        return new UserDTO(userEntityOptional.get());
    }

    @Override
    public List<UserDTO> findAllUser() {
        Iterable<UserEntity> userEntities = userRepository.findAll();

        List<UserDTO> userDTOList = new ArrayList<>();

        userEntities.forEach(e  -> userDTOList.add(new UserDTO(e)));

        return userDTOList;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long id) {
        UserEntity userEntity = userDTO.convertToEntity();
        userEntity.setId(id);
        UserEntity userEntityResponse = userRepository.save(userEntity);
        return new UserDTO(userEntityResponse);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
