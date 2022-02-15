package com.cpc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpc.repository.RMaterialGroup;
import com.cpc.model.MATERIAL_GROUP_TABLE;

/**
 * マテリアルグループテーブル Service
 */
@Service
public class SMaterialGroup {

    private final RMaterialGroup repos;

    @Autowired
    public SMaterialGroup(RMaterialGroup repos) {
     this.repos = repos;
    }

    public boolean insert(MATERIAL_GROUP_TABLE model) {
     return repos.insert(model) > 0;
    }

    public boolean update(MATERIAL_GROUP_TABLE model) {
     return repos.update(model) > 0;
    }

    public boolean delete(MATERIAL_GROUP_TABLE model) {
     return repos.delete(model) > 0;
    }

    public List<MATERIAL_GROUP_TABLE> select(MATERIAL_GROUP_TABLE model) {
     return repos.select(model);
    }

}
