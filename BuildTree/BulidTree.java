package com.pukka.cloud.metanlp.BuildTree;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BulidTree {

    public static void main(String[] args) {

    }
    public List<SubjectForm> selectAllRoleGroup(List<SubjectForm> list) {
        List<SubjectForm> groupDtos = list.stream().map(l -> {
            SubjectForm dto = new SubjectForm();
            BeanUtils.copyProperties(l, dto);
            return dto;
        }).collect(Collectors.toList());

        for (SubjectForm f : groupDtos) {
            if (!"0".equals(f.getParentId())) {
                for (SubjectForm c : groupDtos) {
                    if (f.getParentId().equals(String.valueOf(c.getSubjectId()))) {
                        List<SubjectForm> child = c.getChildren() == null ? new ArrayList<>() : c.getChildren();
                        child.add(f);
                        c.setChildren( child);
                    }
                }
            }

        }
        return groupDtos;
    }
}
