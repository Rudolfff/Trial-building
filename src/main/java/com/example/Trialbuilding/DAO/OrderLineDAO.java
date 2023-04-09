//package com.example.Trialbuilding.DAO;
//
//import com.example.Trialbuilding.entity.OrderLine;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class OrderLineDAO implements Dao<OrderLine> {
//
//    List<OrderLine> orders = new ArrayList<>();
//
//    public OrderLineDAO() {
//        orders.add(new OrderLine(-1L, -1, -1L, -1L));
//    }
//
//    @Override
//    public Optional<OrderLine> get(long id) {
//        return Optional.ofNullable(orders.get((int) id));
//    }
//
//    @Override
//    public List<OrderLine> getAll() {
//        return orders;
//    }
//
//    @Override
//    public void save(OrderLine order) {
//        orders.add(order);
//    }
//
//    @Override
//    public void update(Object x1, Object x2, Object x3, Object x4) {
//
//    }
//
//    @Override
//    public void delete(OrderLine order) {
//        orders.remove((order));
//    }
//}
