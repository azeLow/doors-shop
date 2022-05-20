package ru.shop.doors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.doors.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type getById(Long id);

    Type getTypeByName(String name);
}
