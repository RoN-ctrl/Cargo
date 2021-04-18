package com.cargo.api;

import com.cargo.controller.model.AccountModel;
import com.cargo.dto.AccountDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Account management API")
@RequestMapping("/api/v1/accounts")
public interface AccountApi {

    @ApiOperation("Create account")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    AccountModel createAccount(@Valid @RequestBody AccountDto accountDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Account id")
    })
    @ApiOperation("Get account from database by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    AccountModel getAccountById(@PathVariable long id);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", paramType = "value", required = true, value = "Account email")
    })
    @ApiOperation("Get account from database by email")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    AccountModel getAccountByEmail(@RequestParam(value = "email") String email);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "lastName", paramType = "path", required = true, value = "Account last name")
    })
    @ApiOperation("Get accounts from database by last name")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/lastName/{lastName}")
    List<AccountModel> getAccountsByLastName(@PathVariable String lastName);

    @ApiOperation("Update account")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    AccountModel updateAccount(@Valid @RequestBody AccountDto accountDto);

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Account id")
    })
    @ApiOperation("Delete account by id")
    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteAccountById(@PathVariable long id);
}
