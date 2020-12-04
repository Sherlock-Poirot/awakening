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
 * 组织架构
 * </p>
 *
 * @author Detective Stone
 * @since 2020-11-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("organization")
@ApiModel(value = "Organization对象", description = "组织架构")
public class Organization implements Serializable {

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
  private Integer cancelFlag;

  @ApiModelProperty(value = "组织架构名称 组织架构名称")
  @TableField("name")
  private String name;

  @ApiModelProperty(value = "组织架构序号 组织架构序号")
  @TableField("serial")
  private String serial;

  @ApiModelProperty(value = "上级组织架构id 上级组织架构id")
  @TableField("parent_id")
  private Integer parentId;

  @ApiModelProperty(value = "排序序号 排序序号")
  @TableField("sort")
  private Integer sort;

  @ApiModelProperty(value = "备注说明 备注说明")
  @TableField("remark")
  private String remark;


  public static final String ID = "id";

  public static final String CREATOR_ID = "creator_id";

  public static final String CREATED_TIME = "created_time";

  public static final String UPDATER_ID = "updater_id";

  public static final String UPDATED_TIME = "updated_time";

  public static final String CANCEL_FLAG = "cancel_flag";

  public static final String NAME = "name";

  public static final String SERIAL = "serial";

  public static final String PARENT_ID = "parent_id";

  public static final String SORT = "sort";

  public static final String REMARK = "remark";

}
