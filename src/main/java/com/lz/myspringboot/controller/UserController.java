package com.lz.myspringboot.controller;

import com.battcn.swagger.properties.ApiDataType;
import com.battcn.swagger.properties.ApiParamType;
import com.lz.myspringboot.bean.PageResultBean;
import com.lz.myspringboot.bean.ResultBean;
import com.lz.myspringboot.model.User;
import com.lz.myspringboot.service.IUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: LZ
 * @Date: 2018/11/23 14: 13
 */
@RestController
@RequestMapping("/user")
@Api(tags = "1.0", description = "user management")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "添加用户")
    //@RequestMapping(value = "/api", method = RequestMethod.POST)
    @PostMapping(value = "/api")
    public Integer addUser(@RequestParam("id")Integer id, @RequestParam("name")String name, @RequestParam("password")String password) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        return userService.addUser(user);
    }

    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "id", value = "用户id", dataType = ApiDataType.INT, paramType = ApiParamType.PATH)
    //@RequestMapping(value = "/api/{id}", method = RequestMethod.DELETE)
    @DeleteMapping(value = "/api/{id}")
    public ResultBean<String> deleteUser(@PathVariable("id")Integer id) {
        return new ResultBean<>(userService.deleteUserById(id));
    }

    @ApiOperation(value = "更新用户")
    //@RequestMapping(value = "/api/{id}", method = RequestMethod.PUT)
    @PutMapping(value = "/api/{id}")
    public ResultBean<Integer> updateUser(@PathVariable("id")Integer id, @RequestBody User user) {
        user.setId(id);
        return new ResultBean<>(userService.updateUser(user));
    }

    @ApiOperation(value = "根据id查询用户")
    @ApiImplicitParam(name = "id", value = "用户id", dataType = ApiDataType.INT, paramType = ApiParamType.PATH)
    //@RequestMapping(value = "/api/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/api/{id}")
    public ResultBean<User> findUserById(@PathVariable("id")Integer id) {
        return new ResultBean<>(userService.findUserById(id));
    }

    //@RequestMapping(value = "/api/list", method = RequestMethod.GET)
    @GetMapping(value = "/api/list")
    public PageResultBean<List<User>> findAll(PageResultBean page) {
        return new PageResultBean<>(userService.findAll(page.getPageNumber(), page.getPageSize()));
    }

    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    @ResponseBody
    public Integer checkLogin(@RequestBody Map<String, String> map) {
        User user = userService.findUserByName(map.get("userName"));
        if (user.getPassword().equals(map.get("password"))) {
            return 1;
        } else {
            return 0;
        }
    }

}
