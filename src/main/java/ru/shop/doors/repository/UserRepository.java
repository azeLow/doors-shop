package ru.shop.doors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.doors.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User getById(Long id);
}



