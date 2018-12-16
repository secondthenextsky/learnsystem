package com.learnsystem.dao;


import com.learnsystem.bean.Privilege;
import com.learnsystem.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleDao {
    public int add(Role role);
    public int delete(@Param("id") int id);
    public int update(Role role);
    public List<Role> get(Role role);

    /**
     * 给角色添加权限
     * @param roleId 角色id
     * @param privilegeId 权限id
     * @return
     */
    public int addRolePrivileges(@Param("roleId")int roleId,@Param("privilegeId")int privilegeId);

    /**
     * 清空角色的权限
     * @param roleId
     * @return
     */
    public int deleteRolePrivileges(@Param("roleId") int roleId);

    /**
     * 给用户赋予角色
     * @param userId 用户id
     * @param roleId 角色id
     * @return
     */
    public int addUserRoles(@Param("userId")String userId,@Param("roleId")int roleId);

    /**
     * 删除该用户的某个角色
     * @param userId
     * @param roleId
     * @return
     */
    public int deleteUserRoles(@Param("userId")String userId,@Param("roleId")int roleId);

    /**
     * 删除所有用户的某个角色
     * @param roleId
     * @return
     */
    public int deleteUsersRoles(@Param("roleId")int roleId);

    /**
     *
     * @param role
     * @return
     */
    public List<Privilege> getPrivileges(Role role);
}
