package com.churchsystem.entity;

import javax.persistence.*;

/**
 * Created by hungmcse61561-admin on 7/28/2017.
 */
@Entity
@Table(name = "setting", schema = "churchsys", catalog = "")
public class SettingEntity {
    private int settingId;
    private Integer churchId;
    private Integer isSync;

    @Id
    @Column(name = "settingId")
    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }

    @Basic
    @Column(name = "churchId")
    public Integer getChurchId() {
        return churchId;
    }

    public void setChurchId(Integer churchId) {
        this.churchId = churchId;
    }

    @Basic
    @Column(name = "isSync")
    public Integer getIsSync() {
        return isSync;
    }

    public void setIsSync(Integer isSync) {
        this.isSync = isSync;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SettingEntity that = (SettingEntity) o;

        if (settingId != that.settingId) return false;
        if (churchId != null ? !churchId.equals(that.churchId) : that.churchId != null) return false;
        if (isSync != null ? !isSync.equals(that.isSync) : that.isSync != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = settingId;
        result = 31 * result + (churchId != null ? churchId.hashCode() : 0);
        result = 31 * result + (isSync != null ? isSync.hashCode() : 0);
        return result;
    }
}
