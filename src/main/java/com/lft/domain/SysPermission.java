package com.lft.domain;

public class SysPermission {
    private String id;

    private String permissionName;

    private String permissionCode;

    private String permissiomUrl;

    private String pid;

    private String resType;

    private String permissionDetail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    public String getPermissiomUrl() {
        return permissiomUrl;
    }

    public void setPermissiomUrl(String permissiomUrl) {
        this.permissiomUrl = permissiomUrl == null ? null : permissiomUrl.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType == null ? null : resType.trim();
    }

    public String getPermissionDetail() {
        return permissionDetail;
    }

    public void setPermissionDetail(String permissionDetail) {
        this.permissionDetail = permissionDetail == null ? null : permissionDetail.trim();
    }
}