package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Menu;
import org.example.exception.BusinessException;
import org.example.mapper.MenuMapper;
import org.example.model.menu.MenuRequest;
import org.example.model.menu.MenuResponse;
import org.example.repository.MenuRepository;
import org.example.repository.MyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MenuService {

    private final MenuRepository menuRepository;

    private final MenuMapper menuMapper;

    private final MyRepository myRepository;

    public MenuResponse createMenu(MenuRequest menuRequest) {
        Menu menu = menuMapper.map(menuRequest);
        return menuMapper.map(menuRepository.save(menu));
    }

    public List<MenuResponse> allMenu() {
        return menuMapper.map(menuRepository.findAll());
    }

    public MenuResponse findById(Integer id) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new BusinessException(String.format("The product with id: %s not exist", id)));
        return menuMapper.map(menu);
    }

    public List<MenuResponse> findByName(String name) {
        List<Menu> listFromDB = myRepository.findByProductName(name);
        return createMenuList(listFromDB);
    }

    static List<MenuResponse> createMenuList(List<Menu> menuListFromDB) {
        List<MenuResponse> menuListForResponse = new ArrayList<>();
        for (Menu menu : menuListFromDB) {
            MenuResponse menuResponse = new MenuResponse();
            menuResponse.setId(menu.getId());
            menuResponse.setPrice(menu.getPrice());
            menuResponse.setProductName(menu.getProductName());
            menuResponse.setWeight(menu.getWeight());
            menuListForResponse.add(menuResponse);
        }
        return menuListForResponse;
    }



}


