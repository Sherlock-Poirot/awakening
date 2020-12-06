package com.detective.stone.awakening.company.dto;

import java.util.List;
import lombok.Data;

@Data
public class MenuTreeDTO {

  private Integer id;

  private String name;

  private String routing;

  private List<MenuTreeDTO> children;
}
