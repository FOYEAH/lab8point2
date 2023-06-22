package com.example.lab8point2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModuleEngine {
    @Autowired
    private Lab8Point2Application application;

    public List<IModuleFile> getSupportedModules(String path) {
        ApplicationContext context = application.getContext();
        List<IModuleFile> result = new ArrayList<>();

        for (String name : context.getBeanDefinitionNames()) {
            Object bean = context.getBean(name);
            IModuleFile module;
            try {
                module = (IModuleFile) bean;
            } catch (Exception e) {
                continue;
            }
            if(module.isSupported(path))
                result.add(module);
        }

        return result;
    }
}