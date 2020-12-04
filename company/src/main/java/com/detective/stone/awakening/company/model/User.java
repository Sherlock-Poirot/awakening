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
 * 用户
 * </p>
 *
 * @author Detective Stone
 * @since 2020-11-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
@ApiModel(value = "User对象", description = "用户 用户")
public class User implements Serializable {

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

  @ApiModelProperty(value = "用户姓名 用户姓名")
  @TableField("name")
  private String name;

  @ApiModelProperty(value = "用户出生年月 用户出生年月")
  @TableField("birthday")
  private LocalDateTime birthday;

  @ApiModelProperty(value = "入职时间 入职时间")
  @TableField("register_time")
  private LocalDateTime registerTime;

  @ApiModelProperty(value = "是否是超级用户 是否是超级用户")
  @TableField("superman")
  private Boolean superman;

  @ApiModelProperty(value = "是否是超级用户 是否是超级用户")
  @TableField("username")
  private String username;

  @ApiModelProperty(value = "是否是超级用户 是否是超级用户")
  @TableField("password")
  private String password;


}
