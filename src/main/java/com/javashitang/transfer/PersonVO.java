package com.javashitang.transfer;

import lombok.Builder;
import lombok.Data;

/**
 * @author lilimin
 * @since 2020-11-07
 */
@Data
@Builder
public class PersonVO {

    private int age;
    private GenderEnum gender;
}
