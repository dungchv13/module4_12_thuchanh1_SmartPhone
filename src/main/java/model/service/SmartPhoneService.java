package model.service;

import model.entities.Smartphone;

import java.util.List;

public interface SmartPhoneService {
    List<Smartphone> findAll();
    Smartphone findById(Integer id);
    Smartphone save(Smartphone phone);
    Smartphone remove(Integer id);
}
