package com.example.Trialbuilding.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class Goods {
    Long id;
    String name;
    Integer price;
}
