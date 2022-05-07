package ru.shop.doors.service;

import ru.shop.doors.model.Color;
import ru.shop.doors.repository.ColorRepository;

public class ColorService {

    private final ColorRepository colorRepository;

    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    public void createColor(Color colorFromFronted){
        Color color = new Color();
        color.setName(colorFromFronted.getName());
        color.setDeleted(false);
        colorRepository.save(color);
    }
}
