package org.example.mapper;

import org.example.entity.Table;
import org.example.model.table.TableRequest;
import org.example.model.table.TableResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@Mapper(componentModel = "spring")
@ComponentScan
public interface TableMapper {
    Table map(TableRequest tableRequest);

    TableResponse map(Table table);

    List<TableResponse> map(List<Table> all);

}
