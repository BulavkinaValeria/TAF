package models;

import java.util.Objects;

public class Project {
    private String name;
    public String description;
    private int type;
    private boolean showAnon;
    private boolean access;
    private boolean deleted;

    /*public Project(String name, String description, int type, boolean showAnon, boolean access, boolean deleted) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.showAnon = showAnon;
        this.access = access;
        this.deleted = deleted;
    }*/

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isShowAnon() {
        return showAnon;
    }

    public void setShowAnon(boolean showAnon) {
        this.showAnon = showAnon;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return getType() == project.getType() && isShowAnon() == project.isShowAnon() && isAccess() == project.isAccess() && isDeleted() == project.isDeleted() && Objects.equals(getName(), project.getName()) && Objects.equals(getDescription(), project.getDescription());
    }

}