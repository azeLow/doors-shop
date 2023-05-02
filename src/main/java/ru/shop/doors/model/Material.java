package ru.shop.doors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "material", schema = "public")
public class Material extends General{

    public BigDecimal subtract(Material material) {
        return null;
    }
}
