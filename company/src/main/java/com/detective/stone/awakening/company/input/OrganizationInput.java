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
 * 组织架构
 * </p>
 *
 * @author Detective Stone Create time 2020-11-24 16:51:00.462
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "OrganizationInput", description = "组织架构")
public class OrganizationInput implements Serializable {

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
  private Integer cancelFlag;

  @ApiModelProperty(value = "组织架构名称 组织架构名称")
  private String name;

  @ApiModelProperty(value = "组织架构序号 组织架构序号")
  private String serial;

  @ApiModelProperty(value = "上级组织架构id 上级组织架构id")
  private Integer parentId;

  @ApiModelProperty(value = "排序序号 排序序号")
  private Integer sort;

  @ApiModelProperty(value = "备注说明 备注说明")
  private String remark;


}
