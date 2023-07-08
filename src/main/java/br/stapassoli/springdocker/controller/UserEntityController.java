package br.stapassoli.springdocker.controller;

import br.stapassoli.springdocker.entity.UserEntity;
import br.stapassoli.springdocker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserEntityController {

    @Autowired
    private UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity save(@RequestBody UserEntity user) {
        return this.service.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(@PathVariable Long id) {
        this.service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public UserEntity select(@PathVariable Long id) {
        return this.service.select(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public UserEntity select(@PathVariable Long id, @RequestBody UserEntity user) {
        return this.service.update(id, user);
    }

    @GetMapping
    public Page<UserEntity> selectAll (@PageableDefault(size = 20,page = 0,direction = Direction.ASC,sort = {"id"}) Pageable pageable) {
        return this.service.getAll(pageable);
    }

}
