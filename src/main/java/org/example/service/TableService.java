package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Order;
import org.example.entity.Table;
import org.example.exception.BusinessException;
import org.example.mapper.TableMapper;
import org.example.model.order.OrderRequest;
import org.example.model.order.OrderResponse;
import org.example.model.table.TableRequest;
import org.example.model.table.TableResponse;
import org.example.repository.TableRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TableService {

    private final TableRepository tableRepository;

    private final TableMapper tableMapper;

    public TableResponse createTable(TableRequest tableRequest) {
        Table table = tableMapper.map(tableRequest);
        return tableMapper.map(tableRepository.save(table));
    }

    public List<TableResponse> getAllTables() {
        return tableMapper.map(tableRepository.findAll());
    }

    public TableResponse findById(Integer id) {
        Table table = tableRepository.findById(id).orElseThrow(() -> new BusinessException("Cannot find the table with ID" + id));
        return tableMapper.map(table);
    }

    public void update(Integer id, TableRequest tableRequest) {
        Table tableToUpdate = tableRepository.findById(tableRequest.getId()).orElseThrow(
                () -> new BusinessException(String.format("Table with id: %s is not found", id))
        );
        tableToUpdate.setId(tableRequest.getId());
        tableToUpdate.setNumber(tableRequest.getNumber());
        tableToUpdate.setSeat(tableRequest.getSeat());
    }

    public void deleteById(Integer id) {
        Table table = tableRepository.findById(id).orElseThrow(() -> new BusinessException("Cannot find the table with ID" + id));
        tableRepository.delete(table);
    }


}
