package com.cargo.controller.assembler;

import com.cargo.controller.AccountController;
import com.cargo.controller.model.AccountModel;
import com.cargo.dto.AccountDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AccountAssembler extends RepresentationModelAssemblerSupport<AccountDto, AccountModel> {

    public AccountAssembler() {
        super(AccountController.class, AccountModel.class);
    }

    @Override
    public AccountModel toModel(AccountDto entity) {
        AccountModel accountModel = new AccountModel(entity);

        Link create = linkTo(methodOn(AccountController.class).createAccount(entity)).withRel("crete");
        Link getById = linkTo(methodOn(AccountController.class).getAccountById(entity.getId())).withRel("get");
        Link getByEmail = linkTo(methodOn(AccountController.class).getAccountByEmail(entity.getEmail())).withRel("get");
        Link getByLastName = linkTo(methodOn(AccountController.class).createAccount(entity)).withRel("get");
        Link update = linkTo(methodOn(AccountController.class).updateAccount(entity)).withRel("update");
        Link deleteById = linkTo(methodOn(AccountController.class).deleteAccountById(entity.getId())).withRel("delete");

        accountModel.add(create, getById, getByEmail, getByLastName, update, deleteById);

        return accountModel;
    }
}
