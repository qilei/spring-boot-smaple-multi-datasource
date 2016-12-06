package com.example.dao.db1;

import com.example.entity.T1;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by qilei on 16/11/16.
 */
//@Mapper
public interface DB1T1Mapper {
  List<T1> getAll();
}
