package com.detective.stone.awakening.company;

import com.detective.stone.awakening.company.dto.OrganizationTreeDTO;
import com.detective.stone.awakening.company.service.OrganizationService;
import com.github.pagehelper.PageHelper;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompanyApplicationTests {

  @Autowired
  private OrganizationService organizationService;

  @Test
  void contextLoads() {
    PageHelper.startPage(1, 10).doSelectPageInfo(() -> organizationService.list());
    System.out.println(1);
  }

}
