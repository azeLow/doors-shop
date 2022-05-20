package ru.shop.doors.service;

import org.springframework.stereotype.Service;
import ru.shop.doors.model.Color;
import ru.shop.doors.repository.ColorRepository;

@Service
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

    public Color getColorByName(String name) {
        Color color = colorRepository.getByName(name);
        return color;
    }

    public Color getColorById(Long id) {
        Color color = colorRepository.getById(id);
        return color;
    }


    public void deleteColor(Long id) {
        Color color = colorRepository.getById(id);
        color.setDeleted(true);
        colorRepository.save(color);
   }
}
