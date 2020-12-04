package com.detective.stone.awakening.company.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationTreeDTO {

  private Integer id;

  private String name;

  private String serial;

  private Integer parentId;

  private List<OrganizationTreeDTO> children;
}
