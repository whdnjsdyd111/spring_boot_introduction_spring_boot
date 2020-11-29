package com.example.spring_boot_introduction_spring_boot.chpater07;

import java.util.List;

public interface MsgDataDao<T> {

    public List<MsgData> getAll();
    public MsgData findById(long id);
}
