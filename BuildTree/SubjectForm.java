package com.pukka.cloud.metanlp.BuildTree;

import java.util.List;

public class SubjectForm {
    private String parentId;

    private String SubjectId;

    private String FormId;

    private List<SubjectForm> Children;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(String subjectId) {
        SubjectId = subjectId;
    }

    public String getFormId() {
        return FormId;
    }

    public void setFormId(String formId) {
        FormId = formId;
    }

    public List<SubjectForm> getChildren() {
        return Children;
    }

    public void setChildren(List<SubjectForm> children) {
        Children = children;
    }
}
