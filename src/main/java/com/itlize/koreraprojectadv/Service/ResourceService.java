package com.itlize.koreraprojectadv.Service;

import com.itlize.koreraprojectadv.Entity.Resource;

import java.util.List;

public interface ResourceService {

    Resource saveResource(Resource resource);

    Resource findOneResourceById(Long resourceID);

    List<Resource> findAll();

    Resource updateResourceName(Resource resource,String name);

    Resource updateResourceCode(Resource resource, Integer resourceCode);

    void deleteResource(Resource resource);
}
