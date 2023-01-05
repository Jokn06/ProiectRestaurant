package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.table.TableRequest;
import org.example.model.table.TableResponse;
import org.example.service.TableService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("table")
@RequiredArgsConstructor
@Validated
public class TableController {

    private final TableService tableService;

    @PostMapping("create")
    public TableResponse createTable(@RequestBody @Valid TableRequest tableRequest) {
        return tableService.createTable(tableRequest);
    }

    @GetMapping("list")
    public List<TableResponse> getAllTables() {

        return tableService.getAllTables();
    }

    @GetMapping("{id}")
    public TableResponse findById(@PathVariable("id") Integer id) {

        return tableService.findById(id);
    }

    @PatchMapping("update/{id}")
    public void updateTableById(@PathVariable Integer id, @RequestBody @Valid TableRequest tableRequest) {
        tableService.update(id, tableRequest);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        tableService.deleteById(id);
    }

}
