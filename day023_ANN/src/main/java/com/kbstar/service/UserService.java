package com.kbstar.service;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyDao;
import com.kbstar.frame.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("uservice")
public class UserService implements MyService<String, UserDTO> {
    @Autowired
    @Qualifier("udao")//            자동으로 찾아서 주입시켜준다
    MyDao<String, UserDTO> dao;
    //    UserDAO dao; 이렇게 하는 방법도 있다.
    @Override
    public void register(UserDTO userDTO) {
        dao.insert(userDTO);
        System.out.println("SEND EMAIL");

    }

    @Override
    public void remove(String s) {
        dao.delete(s);
    }

    @Override
    public UserDTO get(String s) {
        return dao.select(s);
    }

    @Override
    public List<UserDTO> get() {
        return dao.select();
    }
}
