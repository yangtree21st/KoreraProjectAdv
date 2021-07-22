package com.itlize.koreraprojectadv.Service.ServiceImpl;

import com.itlize.koreraprojectadv.Entity.Resource;
import com.itlize.koreraprojectadv.Repository.ResourceRepository;
import com.itlize.koreraprojectadv.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResouceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;




    @Override
    public Resource saveResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    @Override
    public Resource findOneResourceById(Long resourceID) {
        return resourceRepository.findById(resourceID).orElse(null);
    }

    @Override
    public List<Resource> findAll() {
        return resourceRepository.findAll();
    }

    @Override
    public Resource updateResourceName(Resource resource, String name) {
       resource.setResourceName(name);
        return resourceRepository.save(resource);

    }

    @Override
    public Resource updateResourceCode(Resource resource, Integer resourceCode) {
        resource.setResourceCode(resourceCode);
        return resourceRepository.save(resource);
    }

    @Override
    public void deleteResource(Resource resource) {
        resourceRepository.delete(resource);
    }



    public void setResourceRepository(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }
}
