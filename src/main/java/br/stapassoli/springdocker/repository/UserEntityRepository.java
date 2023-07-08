package br.stapassoli.springdocker.repository;

import br.stapassoli.springdocker.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {

}
