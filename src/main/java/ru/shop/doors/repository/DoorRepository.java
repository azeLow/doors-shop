package ru.shop.doors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.doors.model.Door;

public interface DoorRepository extends JpaRepository<Door, Long> {


    Door getById(Long id);

    Door getDoorByName(String name);
}
