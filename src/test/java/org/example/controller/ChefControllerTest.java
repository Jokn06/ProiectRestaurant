//package org.example.controller;
//
//import org.example.model.chef.ChefRequest;
//import org.example.service.ChefService;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//class ChefControllerTest {
//
//    @Test
//    void createChef() {
//        ChefService chefService = Mockito.mock(ChefService.class);
//        ChefController chefController = new ChefController(chefService);
//        ChefRequest chef = new ChefRequest();
//        chef.setFirstName("Primul");
//        chef.setLastName("Secundul");
//        chef.setPhoneNumber("02222");
//        chef.setHireDate(LocalDateTime.of(2022,6,16,12,52));
//        chefController.createChef(chef);
//    }
//
//}