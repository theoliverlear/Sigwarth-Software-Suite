package com.sigwarthsoftware.changelog.version.models.module;

import lombok.Getter;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

@Getter
public class ModuleLibrary {
    public static List<ModuleLibrary> modules;
    private String name;
    
    public static void initializeModules(List<ModuleLibrary> modules) {
        ModuleLibrary.modules = modules;
    }
    
    public ModuleLibrary(String name) {
        this.name = name;
    }
    
    public static ModuleLibrary resolveFromPath(Path path) {
        if (path == null) {
            throw new IllegalArgumentException("Path must not be null");
        }
        if (modules == null || modules.isEmpty()) {
            throw new IllegalStateException("ModuleLibrary has not been initialized. Call ModuleLibrary.initializeModules(...) before resolving modules. Path=" + path);
        }
        String pathText = path.toString();
        String[] segments = pathText.split("[\\\\/]+");
        ModuleLibrary deepestSegmentMatch = null;
        int deepestIndex = -1;
        for (int i = 0; i < segments.length; i++) {
            String segment = segments[i];
            for (ModuleLibrary module : modules) {
                if (segment.equals(module.getName())) {
                    if (i > deepestIndex) {
                        deepestIndex = i;
                        deepestSegmentMatch = module;
                    }
                }
            }
        }
        if (deepestSegmentMatch != null) {
            return deepestSegmentMatch;
        }
        return modules.stream()
                .filter(module -> pathText.contains(module.getName()))
                .max(Comparator.comparingInt(module -> module.getName().length()))
                .orElseThrow(() -> new IllegalArgumentException("Unable to resolve module from path: " + path + ". Known modules=" + modules.stream().map(ModuleLibrary::getName).toList()));
    }
    
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object instanceof ModuleLibrary module) {
            return this.name.equals(module.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
