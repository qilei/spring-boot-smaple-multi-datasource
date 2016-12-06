package com.example.dao.db2;

import com.example.entity.T1;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by qilei on 16/11/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DB2T1MapperTest {

  @Autowired
  private DB2T1Mapper db2T1Mapper;

  @Test
  public void testGetAll() throws Exception {
    List<T1> all = db2T1Mapper.getAll();
    Assert.assertTrue(all.size() == 1);
  }
}