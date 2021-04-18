package com.cargo.controller.model;

import com.cargo.dto.AccountDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class AccountModel extends RepresentationModel<AccountModel> {

    @JsonUnwrapped
    private AccountDto accountDto;

}
