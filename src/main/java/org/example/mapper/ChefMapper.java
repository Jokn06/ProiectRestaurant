package org.example.mapper;

import org.example.entity.Chef;
import org.example.model.chef.ChefRequest;
import org.example.model.chef.ChefResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@Mapper(componentModel = "spring")
@ComponentScan
public interface ChefMapper {

    ChefResponse map(Chef chef);

    Chef map(ChefRequest chefRequest);

    List<ChefResponse> map(List<Chef>all);


}
