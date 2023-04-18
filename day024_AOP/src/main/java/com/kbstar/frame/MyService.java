package com.kbstar.frame;


import com.kbstar.dto.UserDTO;

import java.util.List;

public interface MyService<K,V> {
    public void register(V v);
    public void remove(K k);

    void modify(UserDTO userDTO);

    public V get(K k);
    public List<V> get();
}
