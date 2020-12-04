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
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色用户关联表
 * </p>
 *
 * @author Detective Stone Create time 2020-12-03 14:34:05.862
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "RoleUserInput", description = "角色用户关联表 ")
public class RoleUserInput implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "用户id")
  private List<Integer> userIds;

  @ApiModelProperty(value = "角色id")
  private Integer roleId;


}
