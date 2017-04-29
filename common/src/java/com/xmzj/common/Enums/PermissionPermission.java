package com.xmzj.common.Enums;

/**
 * 菜单相关变量
 * @author 
 *
 */
public enum PermissionPermission {

//    type_sys_permission("0","-1","系统菜单功能类型"),  
//    type_sys_button("1","-1","系统按钮功能类型"),
//    type_op_permission("2","-1","运营商菜单功能类型"),  
//    type_op_button("3",null,"运营商按钮功能类型"),
    
    code_sysmanage("1000","-1","系统管理"),
    
    code_rolemanage("1010","1000","角色管理"),
    code_rolemanage_query("1011","1010","查询"),
    code_rolemanage_add("1012","1010","新增"),
    code_rolemanage_update("1013","1010","修改"),
    code_rolemanage_del("1014","1010","删除"),
    code_rolemanage_set("1015","1010","分配权限"),
    
    
    code_sys_usermanage("1030","1000","用户管理"),
    code_sys_usermanage_query("1031","1030","查询"),
    code_sys_usermanage_add("1032","1030","新增"),
    code_sys_usermanage_update("1033","1030","修改"),
    code_sys_usermanage_del("1034","1030","删除"),
    code_sys_usermanage_reset("1035","1030","修改密码"),
    
    code_user_manage("10400","-1","用户管理"),
    code_user_manage_rider("10410","10400","骑手管理(hub或餐馆)"),
    code_user_manage_rider_query("10411","10410","查询"),
    code_user_manage_rider_pass("10412","10410","审核通过"),
    code_user_manage_rider_nopass("10413","10410","审核不通过"),
    code_user_manage_rider_del("10414","10410","删除"),
    
    code_user_manage_chef("10420","10400","厨师管理"),
    code_user_manage_chef_query("10421","10420","查询"),
    code_user_manage_chef_add("10422","10420","新增"),
    code_user_manage_chef_edit("10423","10420","修改"),
    code_user_manage_chef_del("10424","10420","删除"),
    code_user_manage_chef_frozen("10425","10420","冻结/解冻"),
    
    code_user_manage_riderlist("10430","10400","骑手列表(平台)"),
    code_user_manage_riderlist_query("10431","10430","查询"),
    code_user_manage_riderlist_pass("10432","10430","通过"),
    code_user_manage_riderlist_nopass("10433","10430","未通过"),
    code_user_manage_riderlist_fulltime("10434","10430","全/兼职"),
    code_user_manage_riderlist_frozen("10435","10430","冻结/解冻"),
    code_user_manage_riderlis_del("10436","10430","删除"),
    
    
    code_team_manage_sys("10500","-1","团队管理"),
    code_team_manage("10510","10500","团队管理"),
    code_team_manage_query("10511","10510","查询"),
    code_team_manage_add("10512","10510","新增"),
    code_team_manage_edit("10513","10510","修改"),
    code_team_manage_del("10514","10510","删除"),
    code_team_manage_frozen("10515","10510","冻结/解冻"),
    
    code_team_dishmenu("10520","10500","团队菜单管理"),
    code_team_dishmenu_query("10521","10520","查询"),
    code_team_dishmenu_add("10522","10520","新增"),
    code_team_dishmenu_edit("10523","10520","修改"),
    code_team_dishmenu_del("10524","10520","删除"),
    
    code_discount_sys("10530","10500","折扣管理"),
    code_discount_query("10531","10530","查询"),
    code_discount_add("10532","10530","新增"),
    code_discount_edit("10533","10530","修改"),
    code_discount_del("10534","10530","删除"),
    
    code_ad_manage("10600","-1","广告管理"),
    code_ad_query("10601","10600","查询"),
    code_ad_add("10602","10600","新增"),
    code_ad_edit("10603","10600","修改"),
    code_ad_del("10604","10600","删除"),
  
    //订单
    code_order_manage_sys("10700","-1","订单管理"),
    code_order_manage("10710","10700","订单管理"),
    code_order_query("10711","10710","查询"),
    code_order_send("10712","10710","派单"),
    code_order_del("10713","10710","删除"),
    
    //餐厅
    code_restaurant_manage_sys("10800","-1","餐厅管理"),
    code_restaurant_join("10810","10800","加盟餐厅"),
    code_restaurant_join_query("10811","10810","查询"),
    code_restaurant_join_add("10812","10810","新增"),
    code_restaurant_join_edit("10813","10810","修改"),
    code_restaurant_join_del("10814","10810","删除"),
    code_restaurant_join_frozen("10815","10810","冻结/解冻"),
    
    
    code_restaurant_nomnom("10820","10800","nom-nom"),
    code_restaurant_nomnom_query("10821","10820","查看"),
    code_restaurant_nomnom_save("10822","10820","保存"),
    
    code_restaurant_join_self("10830","10800","餐厅"),
    code_restaurant_join_self_query("10831","10830","查看"),
    code_restaurant_join_self_save("10832","10830","保存"),
    
    
    //配送中心
    code_dc_manage_sys("10900","-1","配送中心"),
    code_dc("10910","10900","配送中心"),
    code_dc_query("10911","10910","查询"),
    code_dc_add("10912","10910","新增"),
    code_dc_edit("10913","10910","修改"),
    code_dc_del("10914","10910","删除"),
    code_dc_frozen("10915","10910","冻结/解冻"),
    
    //商品管理
    code_goods_manage_sys("11000","-1","商品管理"),
    code_dish("11100","11000","菜品管理"),
    code_dish_query("11101","11100","查询"),
    code_dish_add("11102","11100","新增"),
    code_dish_edit("11103","11100","修改"),
    code_dish_del("11104","11100","删除"),
    code_dish_putaway("11105","11100","上/下架"),
    code_dish_meterial("11106","11100","编辑食材"),
    
    code_material("11200","11000","食材管理"),
    code_material_query("11201","11200","查询"),
    code_material_add("11202","11200","新增"),
    code_material_edit("11203","11200","修改"),
    code_material_del("11204","11200","删除"),
    code_material_putaway("11205","11200","上/下架"),
    
    code_dish_store("11300","11000","菜品库存"),
    code_dish_store_query("11301","11300","查询"),
    code_dish_store_add("11302","11300","新增"),
    code_dish_store_edit("11303","11300","修改"),
    code_dish_store_del("11304","11300","删除"),
    
    code_material_store("11400","11000","食材库存"),
    code_material_store_query("11401","11400","查询"),
    code_material_store_add("11402","11400","新增"),
    code_material_store_edit("11403","11400","修改"),
    code_material_store_del("11404","11400","删除"),
    
    //分类管理
    code_tags_manage_sys("12000","-1","分类管理"),
    
    code_dish_type("12100","12000","菜品分类"),
    code_dish_type_query("12101","12100","查询"),
    code_dish_type_add("12102","12100","新增"),
    code_dish_type_edit("12103","12100","修改"),
    code_dish_type_del("12104","12100","删除"),
    
    code_material_type("12200","12000","食材分类"),
    code_material_type_query("12201","12200","查询"),
    code_material_type_add("12202","12200","新增"),
    code_material_type_edit("12203","12200","修改"),
    code_material_type_del("12204","12200","删除"),
    
    code_restaurant_type("12300","12000","餐厅分类"),
    code_restaurant_type_query("12301","12300","查询"),
    code_restaurant_type_add("12302","12300","新增"),
    code_restaurant_type_edit("12303","12300","修改"),
    code_restaurant_type_del("12304","12300","删除"),
    
    code_like_type("12400","12000","偏好分类"),
    code_like_type_query("12401","12400","查询"),
    code_like_type_add("12402","12400","新增"),
    code_like_type_edit("12403","12400","修改"),
    code_like_type_del("12404","12400","删除"),
    
    code_member_sys("13000","-1","会员管理"),
    code_member("13100","13000","会员管理"),
    code_member_query("13101","13100","查询"),
    code_member_frozen("13102","13100","冻结/解冻"),
    code_member_giftcard("13200","13000","礼品卡"),
    code_member_giftcard_query("13201","13200","查询"),
    
    code_daliy_menu_sys("14000","-1","每日菜单"),
    code_daliy_menu("14100","14000","每日菜单管理"),
    code_daliy_menu_query("14101","14100","查询"),
    code_daliy_menu_add("14102","14100","新增"),
    code_daliy_menu_edit("14103","14100","编辑"),
    code_daliy_menu_del("14104","14100","删除"),
    
    
    code_message_sys("15000","-1","消息推送"),
    code_message("15100","15000","消息推送"),
    code_message_query("15101","15100","查询"),
    code_message_add("15102","15100","新增"),
    code_message_edit("15103","15100","编辑"),
    code_message_del("15104","15100","删除"),
    
    ;
	
	private String pkid;
	private String parent;
	private String desc;
	
	
	private PermissionPermission(String value,String parent,String desc) {
		this.pkid = value;
		this.desc=desc;
		this.parent=parent;
	}

	public String getDesc() {
		return desc;
	}
	
	
		
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	
	
	
	
	public String getPkid() {
		return pkid;
	}

	public void setPkid(String pkid) {
		this.pkid = pkid;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	public static PermissionPermission setValue(String str) {
		for (PermissionPermission e:PermissionPermission.values()) {
			if(e.getPkid().equals(str)){
				return e;
			}
		}
		return null;
	}
	
	
	
	
}
