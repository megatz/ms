package com.evaluation.me.entity;

import com.evaluation.me.validators.ValidEmail;
import com.evaluation.me.validators.ValidPassword;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "useruuid")
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    private Long useruuid;
    private String name;
    @ValidEmail
    private String email;
    @ValidPassword
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phones;


}
