package org.example.controller.web;

import lombok.RequiredArgsConstructor;
import org.example.model.chef.ChefRequest;
import org.example.model.chef.CreateChefRequest;
import org.example.model.chef.UpdateChefRequest;
import org.example.service.ChefService;
import org.example.utils.IdRequest;
import org.example.utils.UpdateRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AdminChefPageController {

    private final ChefService chefService;


    @GetMapping("/adminChefPage")
    public String gotoAdminChefPage() {
        return "adminChefPage";
    }


    @GetMapping("/chef/goToCreateChefPage")
    public String goToCreateChefPage() {
        return "createChef";
    }


    @PostMapping("/chef/createNewChef")
    public String createChef(@ModelAttribute(value = "createChefRequest")
                             CreateChefRequest request,
                             Model model) {
        ChefRequest chefRequest = ChefRequest.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .hireDate(request.getHireDate())
                .build();
        chefService.createChef(chefRequest);

        model.addAttribute("chefs", chefService.allChefs());
        return "adminChefPage";
    }

    @GetMapping("/adminChefPage/allChefs")
    public String goToAllChefAdminList(Model model) {
        model.addAttribute("chefs", chefService.allAdminChef());
        return "/adminChefPage";
    }

    @PostMapping("/adminChefPage/delete")
    public String deleteChef(@ModelAttribute(value = "deleteRequest") IdRequest request, Model model) {
        chefService.delete(request.getId());
        model.addAttribute("chefs", chefService.allChefs());
        return "/adminChefPage";
    }

    @PostMapping("/adminChefPageChef/update-chef")
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
        return "/adminChefPage";
    }

    @GetMapping("/adminChefPage/goToUpdateChefPage")
    public String goToUpdateChefPage(@ModelAttribute(value = "deleteRequest") UpdateRequest request, Model model) {
        model.addAttribute("chefId", request.getId());
        return "updateChefPage";
    }
}
