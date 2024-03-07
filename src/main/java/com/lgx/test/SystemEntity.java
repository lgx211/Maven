package com.lgx.test;

import lombok.Data;

import java.util.List;

@Data
class SystemEntity {
    private String treeId;
    private String systemName;
    private String parentId;
    private List<SystemEntity> childSystems;

    public SystemEntity() {
    }

    public SystemEntity(String treeId, String systemName, String parentId, List<SystemEntity> childSystems) {
        this.treeId = treeId;
        this.systemName = systemName;
        this.parentId = parentId;
        this.childSystems = childSystems;
    }

    // getters and setters
    // ...

    @Override
    public String toString() {
        return "SystemEntity{" +
                "treeId='" + treeId + '\'' +
                ", systemName='" + systemName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", childSystems=" + childSystems +
                '}';
    }
}
