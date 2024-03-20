package com.UserService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name ="User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String userId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private  String mobile;
    @Transient
    private List<Rating>ratings;
}
