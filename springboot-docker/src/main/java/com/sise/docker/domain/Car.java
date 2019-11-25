package com.sise.docker.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * @author idea
 * @data 2019/11/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    private Integer id;

    private String number;
}
