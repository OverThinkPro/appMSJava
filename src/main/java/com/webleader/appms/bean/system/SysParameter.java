package com.webleader.appms.bean.system;

import java.util.Date;

public class SysParameter {
    private String id;

    private Date dataBackPar;

    private String sysInitUsername;

    private String sysInitPwd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getDataBackPar() {
        return dataBackPar;
    }

    public void setDataBackPar(Date dataBackPar) {
        this.dataBackPar = dataBackPar;
    }

    public String getSysInitUsername() {
        return sysInitUsername;
    }

    public void setSysInitUsername(String sysInitUsername) {
        this.sysInitUsername = sysInitUsername == null ? null : sysInitUsername.trim();
    }

    public String getSysInitPwd() {
        return sysInitPwd;
    }

    public void setSysInitPwd(String sysInitPwd) {
        this.sysInitPwd = sysInitPwd == null ? null : sysInitPwd.trim();
    }
}