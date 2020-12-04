package com.detective.stone.awakening.company.model;

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
 * 角色用户关联表
 * </p>
 *
 * @author Detective Stone
 * @since 2020-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("role_user")
@ApiModel(value = "RoleUser对象", description = "角色用户关联表 ")
public class RoleUser implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "id")
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  @ApiModelProperty(value = "创建人")
  @TableField("creator_id")
  private Integer creatorId;

  @ApiModelProperty(value = "创建时间")
  @TableField("created_time")
  private LocalDateTime createdTime;

  @ApiModelProperty(value = "更新人")
  @TableField("updater_id")
  private Integer updaterId;

  @ApiModelProperty(value = "更新时间")
  @TableField("updated_time")
  private LocalDateTime updatedTime;

  @ApiModelProperty(value = "删除标记 0代表未删除1代表已删除")
  @TableField("cancel_flag")
  @TableLogic
  private Boolean cancelFlag;

  @ApiModelProperty(value = "用户id")
  @TableField("user_id")
  private Integer userId;

  @ApiModelProperty(value = "角色id")
  @TableField("role_id")
  private Integer roleId;

}
