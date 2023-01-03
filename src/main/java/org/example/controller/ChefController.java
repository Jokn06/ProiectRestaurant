package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.chef.ChefRequest;
import org.example.model.chef.ChefResponse;
import org.example.service.ChefService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("chef")
@RequiredArgsConstructor
@Validated
public class ChefController {

    private final ChefService chefService;

    @PostMapping("/create")
    public ChefResponse createChef(@RequestBody @Valid ChefRequest chefRequest) {
        return chefService.createChef(chefRequest);
    }


    @GetMapping("/list")
    public List<ChefResponse> showAllChefs() {
        return chefService.allChefs();
    }

    @GetMapping("/findById/{id}")
    public ChefResponse findChefById(@PathVariable Integer id) {
        return chefService.findById(id);
    }

    @GetMapping("find/firstName/{firstName}")
    public List<ChefResponse> findByName(@PathVariable String firstName) {
        return chefService.findByName(firstName);
    }

    @PatchMapping("/update")
    public void updateChef(@RequestBody @Valid ChefRequest chefRequest) {
        chefService.update(chefRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChef(@PathVariable Integer id) {
        chefService.delete(id);
    }

}
