package ru.kashtanov.mail_service.model;

import jakarta.persistence.*;

//@Entity(name = "Order")
//@Table
//public class Order {
//    @Id
//    @SequenceGenerator(
//            name = "answer_sequence",
//            sequenceName = "answer_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "answer_sequence"
//    )
//    @Column(name = "id")
//    private Integer id;
//    @Column(name ="order_number")
//    private String orderNumber;
//
//    public Order() {
//    }
//
//    public Order(Integer id, String orderNumber) {
//        this.id = id;
//        this.orderNumber = orderNumber;
//    }
//
//    public Order(String orderNumber) {
//        this.orderNumber = orderNumber;
//    }
//
//    public String getOrderNumber() {
//        return orderNumber;
//    }
//
//    public void setOrderNumber(String orderNumber) {
//        this.orderNumber = orderNumber;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//}

//@Entity(name = "LALAL") А ЕСЛИ ТАК ТО ВСЕ НОРМАЛЬНО , ПОЧЕМУ ??
@Entity
@Table(name = "Orders")// bro если пишу сюда "Order" программа дает ошибку
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String answerName;

    public Order() {
    }

    public Order(String answerName) {
        this.answerName = answerName;

    }



    public Order(Long id, String answerName) {
        this.id = id;
        this.answerName = answerName;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }




}