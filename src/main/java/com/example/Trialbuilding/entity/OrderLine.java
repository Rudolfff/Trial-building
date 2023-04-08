package com.example.Trialbuilding.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class OrderLine {
    Long id;
    Integer count;
    Long goods_id;
    Long order_id;
}
