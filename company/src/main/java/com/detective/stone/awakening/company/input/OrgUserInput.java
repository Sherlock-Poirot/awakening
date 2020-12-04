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
 * 组织机构用户关联表 组织机构用户关联表
 * </p>
 *
 * @author Detective Stone Create time 2020-11-24 16:51:00.428
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "OrgUserInput", description = "组织机构用户关联表 组织机构用户关联表")
public class OrgUserInput implements Serializable {

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

  @ApiModelProperty(value = "组织机构id 组织机构id")
  private Integer organizationId;

  @ApiModelProperty(value = "用户id 用户id")
  private Integer userId;

  @ApiModelProperty(value = "职务 职务")
  private String position;


}
