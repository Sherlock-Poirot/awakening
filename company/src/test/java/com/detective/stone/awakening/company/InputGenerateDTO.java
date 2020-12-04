package com.detective.stone.awakening.company;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import lombok.Data;

/**
 * @author Detective Stone Create time 2018/12/21 14:06
 */
@Data
public class InputGenerateDTO {

  private boolean swagger2;

  private TableInfo table;

  private boolean entityLombokModel;

  private String author;

  private String date;
}
