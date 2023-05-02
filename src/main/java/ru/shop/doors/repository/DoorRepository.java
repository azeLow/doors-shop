package ru.shop.doors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.shop.doors.model.Door;

import java.util.List;

public interface DoorRepository extends JpaRepository<Door, Long> {


    Door getById(Long id);

    Door getDoorByName(String name);

    @Query("SELECT DISTINCT(d.color_id) FROM Door as d")
    List<String> select();

    @Query("SELECT d.color_id FROM Door as d GROUP BY d.color_id ORDER BY AVG(d.price)")
    String[] findAverageColor();
    @Query("SELECT d.material_id FROM Door as d GROUP BY  d.material_id ORDER BY AVG(d.price)")
    String[] findAverageMaterial();

    @Query("SELECT d.manufacturer_id FROM Door as d GROUP BY d.manufacturer_id ORDER BY AVG(d.price)")
    String[] findAverageManufacturer();
    @Query("SELECT d.type_id FROM Door as d GROUP BY d.type_id ORDER BY AVG(d.price)")
    String[] findAverageType();

    @Query("SELECT MAX(d.color_id) FROM Door as d")
    int getMaxColor();

    @Query("SELECT MIN(d.color_id) FROM Door as d")
    int getMinColor();

    @Query("SELECT MAX(d.material_id) FROM Door as d")
    int getMaxMaterial();

    @Query("SELECT MIN(d.material_id) FROM Door as d")
    int getMinMaterial();

    @Query("SELECT MAX(d.manufacturer_id) FROM Door as d")
    int getMaxManufacturer();

    @Query("SELECT MIN(d.manufacturer_id) FROM Door as d")
    int getMinManufacturer();

    @Query("SELECT MAX(d.type_id) FROM Door as d")
    int getMaxType();

    @Query("SELECT MAX(d.type_id) FROM Door as d")
    int getMinType();

    @Query("SELECT door FROM Door as door WHERE door.id = :id")
    Door findById(@Param("id") long id);
}
