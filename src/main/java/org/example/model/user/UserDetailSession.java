package org.example.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SessionScope
@Component(value = "userDetailsSession")
public class UserDetailSession {

    private User user;

    private Integer id;
    private String name;
    private String password;
}
