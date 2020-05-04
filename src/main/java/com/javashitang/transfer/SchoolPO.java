package com.javashitang.transfer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SchoolPO {

    private String name;
    private String location;
}
