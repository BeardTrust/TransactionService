/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beardtrust.webapp.transactionservice.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.beardtrust.webapp.transactionservice.entities.CurrencyValue;
import com.beardtrust.webapp.transactionservice.entities.UserEntity;
import lombok.Data;

/**
 *
 * @author Nathanael <Nathanael.Grier at your.org>
 */
@Data
public class AccountDTO implements Serializable {

    private UserEntity user;
    private String id;
    private boolean activeStatus;
    private CurrencyValue balance;
    private Integer interest;
    private String nickname;
    private LocalDate createDate;
    private String type;

}
