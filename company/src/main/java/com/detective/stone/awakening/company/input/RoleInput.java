package com.detective.stone.awakening.company.input;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author Detective Stone Create time 2020-12-03 14:34:05.851
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "RoleInput", description = "角色 ")
public class RoleInput implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "角色名称")
  private String name;

  @ApiModelProperty(value = "角色描述")
  private String remark;

}
