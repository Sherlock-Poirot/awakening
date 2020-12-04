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
 * 用户 用户
 * </p>
 *
 * @author Detective Stone Create time 2020-11-24 16:51:00.476
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UserInput", description = "用户 用户")
public class UserInput implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "id")
  private Integer id;

  @ApiModelProperty(value = "创建人")
  private Integer creatorId;

  @ApiModelProperty(value = "创建时间")
  private LocalDateTime createdTime;

  @ApiModelProperty(value = "更新人")
  private Integer updaterId;

  @ApiModelProperty(value = "更新时间")
  private LocalDateTime updatedTime;

  @ApiModelProperty(value = "删除标记 0代表未删除1代表已删除")
  private Boolean cancelFlag;

  @ApiModelProperty(value = "用户姓名 用户姓名")
  private String name;

  @ApiModelProperty(value = "用户出生年月 用户出生年月")
  private LocalDateTime birthday;

  @ApiModelProperty(value = "入职时间 入职时间")
  private LocalDateTime registerTime;

  @ApiModelProperty(value = "是否是超级用户 是否是超级用户")
  private Boolean superman;

  private Integer organizationId;

  private String position;

  private String username;

}
