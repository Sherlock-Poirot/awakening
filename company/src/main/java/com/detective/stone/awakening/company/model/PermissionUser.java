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
 * 权限用户关联表
 * </p>
 *
 * @author Detective Stone
 * @since 2020-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("permission_user")
@ApiModel(value = "PermissionUser对象", description = "权限用户关联表 ")
public class PermissionUser implements Serializable {

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

  @ApiModelProperty(value = "权限id")
  @TableField("permission_id")
  private Integer permissionId;


  public static final String ID = "id";

  public static final String CREATOR_ID = "creator_id";

  public static final String CREATED_TIME = "created_time";

  public static final String UPDATER_ID = "updater_id";

  public static final String UPDATED_TIME = "updated_time";

  public static final String CANCEL_FLAG = "cancel_flag";

  public static final String USER_ID = "user_id";

  public static final String PERMISSION_ID = "permission_id";

}
