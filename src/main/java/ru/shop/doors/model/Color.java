package ru.shop.doors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "color", schema = "public")
public class Color extends General{

    public BigDecimal subtract(Color color) {
        return null;
    }
}
