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
 * 权限
 * </p>
 *
 * @author Detective Stone
 * @since 2020-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("permission")
@ApiModel(value = "Permission对象", description = "权限 ")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Permission implements Serializable {

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

    @ApiModelProperty(value = "菜单id")
    @TableField("menu_id")
    private Integer menuId;

    @ApiModelProperty(value = "权限名称perms[xxxx]")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "权限接口")
    @TableField("mapping")
    private String mapping;

    @ApiModelProperty(value = "展示名称")
    @TableField("display")
    private String display;

    @ApiModelProperty(value = "是否是get请求")
    @TableField("get_request")
    private Boolean getRequest;

    @ApiModelProperty(value = "是否必须")
    @TableField("must_have")
    private Boolean mustHave;


    public static final String ID = "id";

    public static final String CREATOR_ID = "creator_id";

    public static final String CREATED_TIME = "created_time";

    public static final String UPDATER_ID = "updater_id";

    public static final String UPDATED_TIME = "updated_time";

    public static final String CANCEL_FLAG = "cancel_flag";

    public static final String MENU_ID = "menu_id";

    public static final String NAME = "name";

    public static final String MAPPING = "mapping";

    public static final String DISPLAY = "display";

    public static final String GETREQUEST = "getRequest";

    public static final String MUSTHAVE = "mustHave";

}
