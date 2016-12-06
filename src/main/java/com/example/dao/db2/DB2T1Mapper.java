package com.example.dao.db2;

import com.example.entity.T1;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by qilei on 16/11/16.
 */
//@Mapper
public interface DB2T1Mapper {
  List<T1> getAll();
}
