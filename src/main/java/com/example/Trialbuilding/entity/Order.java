package com.example.Trialbuilding.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class Order {
    Long id;
    String client;
    Date date;
    String address;
}
