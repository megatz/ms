package com.evaluation.me.entity;

import com.evaluation.me.domain.City;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    private int id;
    private String number;
    //    private String cityCode;
    @Enumerated(EnumType.STRING)
    private City city;
}
