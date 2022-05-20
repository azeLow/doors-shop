package ru.shop.doors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.doors.model.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {



    Color getById(Long id);

    Color getByName(String name);
}
