package ru.shop.doors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "door_type", schema = "public")
public class Type extends General{

    public BigDecimal subtract(Type type) {
        return null;
    }
}
