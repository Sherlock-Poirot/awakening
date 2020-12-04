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
 * 权限
 * </p>
 *
 * @author Detective Stone Create time 2020-12-03 23:32:48.566
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "PermissionInput", description = "权限 ")
public class PermissionInput implements Serializable {

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

  @ApiModelProperty(value = "菜单id")
  private Integer menuId;

  @ApiModelProperty(value = "权限名称perms[xxxx]")
  private String name;

  @ApiModelProperty(value = "权限接口")
  private String mapping;

  @ApiModelProperty(value = "展示名称")
  private String display;

  @ApiModelProperty(value = "是否是get请求")
  private Boolean getRequest;

  @ApiModelProperty(value = "是否必须")
  private Boolean mustHave;


}
