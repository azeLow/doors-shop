package ru.shop.doors.service;

import org.springframework.stereotype.Service;
import ru.shop.doors.model.Type;
import ru.shop.doors.repository.TypeRepository;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public void createType(Type typeFromFronted){
        Type type = new Type();
        type.setName(typeFromFronted.getName());
        type.setDeleted(false);
        typeRepository.save(type);
    }

    public Type getTypeByName(String name) {
        Type type = typeRepository.getTypeByName(name);
        return type;
    }

    public void deleteType(Long id){
        Type type = typeRepository.getById(id);
        type.setDeleted(true);
        typeRepository.save(type);
    }

    public Type getTypeById(Long id) {
        Type type = typeRepository.getById(id);
        return type;
    }
}
