package org.example.service;


import lombok.RequiredArgsConstructor;
import org.example.entity.Chef;
import org.example.exception.BusinessException;
import org.example.mapper.ChefMapper;
import org.example.model.chef.ChefRequest;
import org.example.model.chef.ChefResponse;
import org.example.repository.ChefRepository;
import org.example.repository.MyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ChefService {

    private final ChefRepository chefRepository;

    private final ChefMapper chefMapper;
    private final MyRepository myRepository;

    public ChefResponse createChef(ChefRequest chefRequest) {
        checkDuplicate(chefRequest);
        Chef chef = chefMapper.map(chefRequest);
        return chefMapper.map(chefRepository.save(chef));
    }

    private void checkDuplicate(ChefRequest chefRequest) {
        for (Chef chef : chefRepository.findAll()) {
            if (chef.getFirstName().equals(chefRequest.getFirstName())
                    && chef.getLastName().equals(chefRequest.getLastName())) {
                throw new BusinessException("This chef already exist! ");
            }
        }
    }

    public List<ChefResponse> allChefs() {
        return chefMapper.map(chefRepository.findAll());
    }

    public ChefResponse findById(Integer id) {
        Chef chef = chefRepository.findById(id).orElseThrow(
                () -> new BusinessException(
                        String.format("The chef with id: %s not exist", id))
        );
        return chefMapper.map(chef);
    }

    public List<ChefResponse> findByName(String name) {
        List<Chef> listFromDB = myRepository.findByChefName(name);
        return createChefList(listFromDB);
    }

    static List<ChefResponse> createChefList(List<Chef> chefListFromDB) {
        List<ChefResponse> chefListForResponse = new ArrayList<>();
        for (Chef chef : chefListFromDB) {
            ChefResponse chefResponse = new ChefResponse();
            chefResponse.setId(chef.getId());
            chefResponse.setFirstName(chef.getFirstName());
            chefResponse.setLastName(chef.getLastName());
            chefResponse.setHireDate(chef.getHireDate());
            chefResponse.setPhoneNumber(chef.getPhoneNumber());
        }
        return chefListForResponse;
    }

    public void update(ChefRequest chefRequest) {
        checkDuplicate(chefRequest);
        validatePhoneNumber(chefRequest.getPhoneNumber());
        Chef chefToUpdate = chefRepository.findById(chefRequest.getId()).orElseThrow(
                () -> new BusinessException(
                        String.format("The chef with id: %s not exist", chefRequest.getId())
                )
        );
        chefToUpdate.setFirstName(chefRequest.getFirstName());
        chefToUpdate.setLastName(chefRequest.getLastName());
        chefToUpdate.setPhoneNumber(chefRequest.getPhoneNumber());
        chefToUpdate.setHireDate(chefRequest.getHireDate());
    }

    public void validatePhoneNumber(String string) {
        if (string.isBlank() ||
                !string.matches("[0-9]+") ||
                string.length() < 10) {
            throw new BusinessException("Invalid phone number. Try again -> only with digits and minimum 10");
        }
    }

    public void delete(Integer id) {
        Chef chefToDelete = chefRepository.findById(id).orElseThrow(
                () -> new BusinessException(
                        String.format("The chef with id: %s not exist", id))
        );
        chefRepository.delete(chefToDelete);
    }

}
