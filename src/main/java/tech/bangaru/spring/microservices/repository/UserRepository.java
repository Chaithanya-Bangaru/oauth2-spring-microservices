package tech.bangaru.spring.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.bangaru.spring.microservices.domain.Users;

public interface UserRepository extends JpaRepository<Users, Object>{

}
