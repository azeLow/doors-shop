package ru.shop.doors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.doors.model.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
