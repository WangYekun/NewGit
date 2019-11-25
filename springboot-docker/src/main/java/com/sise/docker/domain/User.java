package com.sise.docker.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author idea
 * @data 2019/11/23
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Integer id;

    private String username;
}
