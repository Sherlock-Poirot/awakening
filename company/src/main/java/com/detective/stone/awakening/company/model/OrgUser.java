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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 组织机构用户关联表 组织机构用户关联表
 * </p>
 *
 * @author Detective Stone
 * @since 2020-11-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("org_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "OrgUser对象", description = "组织机构用户关联表 组织机构用户关联表")
public class OrgUser implements Serializable {

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

  @ApiModelProperty(value = "组织机构id 组织机构id")
  @TableField("organization_id")
  private Integer organizationId;

  @ApiModelProperty(value = "用户id 用户id")
  @TableField("user_id")
  private Integer userId;

  @ApiModelProperty(value = "职务 职务")
  @TableField("position")
  private String position;


  public static final String ID = "id";

  public static final String CREATOR_ID = "creator_id";

  public static final String CREATED_TIME = "created_time";

  public static final String UPDATER_ID = "updater_id";

  public static final String UPDATED_TIME = "updated_time";

  public static final String CANCEL_FLAG = "cancel_flag";

  public static final String ORGANIZATION_ID = "organization_id";

  public static final String USER_ID = "user_id";

  public static final String POSITION = "position";

}
