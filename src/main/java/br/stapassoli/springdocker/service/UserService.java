package br.stapassoli.springdocker.service;

import br.stapassoli.springdocker.entity.UserEntity;
import br.stapassoli.springdocker.repository.UserEntityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserEntityRepository repository;

    public UserEntity save(UserEntity user){
        return this.repository.save(user);
    }
    public void delete(Long id){
        this.repository.deleteById(id);
    }
    public UserEntity select(Long id){
        return this.repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Not possible to find user"));
    }
    public UserEntity update(Long id, UserEntity user){
        UserEntity userToUpdate = this.select(id);
        userToUpdate.setLogin(user.getLogin());
        userToUpdate.setPassword(user.getPassword());

        return this.save(userToUpdate);
    }
    public Page<UserEntity> getAll(Pageable pageable){
        return this.repository.findAll(pageable);
    }

}
