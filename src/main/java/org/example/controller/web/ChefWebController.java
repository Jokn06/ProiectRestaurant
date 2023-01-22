package org.example.controller.web;

import lombok.RequiredArgsConstructor;
import org.example.model.chef.ChefRequest;
import org.example.model.chef.CreateChefRequest;
import org.example.model.chef.UpdateChefRequest;
import org.example.service.ChefService;
import org.example.utils.IdRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ChefWebController {

    private final ChefService chefService;

    @GetMapping("/chef")
    public String gotoChefPage() {
        return "chef";
    }

    @GetMapping("chef/allChefs")
    public String goToAllChefList(Model model) {
        model.addAttribute("chefs", chefService.allChefs());
        return "chef";
    }
    @PostMapping("/chef/delete")
    public String deleteChef(@ModelAttribute(value = "deleteRequest") IdRequest request, Model model) {
        chefService.delete(request.getId());
        model.addAttribute("chefs", chefService.allChefs());
        return "/chef";
    }

    @PostMapping("/chef/update-chef")
    public String updateChef(@ModelAttribute(value = "updateChefRequest") UpdateChefRequest request,
                                   Model model) {
        ChefRequest chefRequest = org.example.model.chef.ChefRequest.builder()
                .id(request.getId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .hireDate(request.getHireDate())
                .build();
        chefService.update(chefRequest);

        model.addAttribute("chefs", chefService.allChefs());
        return "chef";
    }


}
