package model.service;

import model.entities.Smartphone;
import model.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SmartPhoneServiceImpl implements SmartPhoneService{
    @Autowired
    private SmartphoneRepository smartphoneRepository;
    @Override
    public List<Smartphone> findAll() {
        return (List<Smartphone>) smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Integer id) {
        Smartphone smartphone = smartphoneRepository.findOne(id);
        if(smartphone == null){
            return null;
        }
        return smartphone;
    }

    @Override
    public Smartphone save(Smartphone phone) {
        return smartphoneRepository.save(phone);
    }

    @Override
    public Smartphone remove(Integer id) {
        Smartphone smartphone = smartphoneRepository.findOne(id);
        smartphoneRepository.delete(id);
        return smartphone;
    }
}
