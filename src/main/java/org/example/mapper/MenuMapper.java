package org.example.mapper;

import org.example.entity.Menu;
import org.example.model.menu.MenuRequest;
import org.example.model.menu.MenuResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@Mapper(componentModel = "spring")
public interface MenuMapper {

    Menu map(MenuRequest menuRequest);

    MenuResponse map(Menu menu);

    List<MenuResponse> map(List<Menu> all);


}
