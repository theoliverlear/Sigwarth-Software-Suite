package com.sigwarthsoftware.changelog.version;


import com.sigwarthsoftware.changelog.version.models.element.PomElement;
import com.sigwarthsoftware.changelog.version.models.element.PomPair;
import com.sigwarthsoftware.changelog.version.models.module.ModuleLibrary;
import com.sigwarthsoftware.changelog.version.models.module.type.Pom;

import java.util.List;

public class PomValidator {
    private static final List<PomElement> allPoms = PomParser.getAllPoms();
    public static boolean parentMatches(List<PomPair> pomPairs) {
        boolean allMatch = pomPairs.stream().allMatch(pomPair -> {
            boolean parentMatches = parentMatches(pomPair.element(), pomPair.module());
            System.out.println(pomPair.module() + " parent matches: " + parentMatches);
            return parentMatches;
        });
        return allMatch;
    }

    private static PomElement getByModule(ModuleLibrary module) {
        PomElement element = allPoms.stream()
                .filter(pomElement -> pomElement.getPom().getModuleType().equals(module))
                .filter(pomElement -> "pom".equalsIgnoreCase(pomElement.getPackaging()))
                .findFirst()
                .orElseGet(() -> allPoms.stream()
                        .filter(pomElement -> pomElement.getPom().getModuleType().equals(module))
                        .findFirst()
                        .orElse(null));
        return element;
    }

    public static boolean parentMatches(PomElement topPom, ModuleLibrary module) {
        if (topPom == null) {
            return false;
        }
        String topVersion = topPom.getVersion();
        System.out.println("Expected version: " + topVersion + " for " + module);
        boolean allMatch = true;
        for (PomElement pomElement : allPoms) {
            Pom parentPom = pomElement.getParentPomModel();
            if (parentPom != null) {
                if (parentPom.getModuleType().equals(module)) {
                    String parentVersion = parentPom.getModuleDependency().getVersion();
                    if (!nullToEmpty(parentVersion).equals(nullToEmpty(topVersion))) {
                        System.out.println("Found version: " + parentVersion);
                        return false;
                    }
                }
            }
        }
        return allMatch;
    }
    
    private static String nullToEmpty(String text) {
        return text == null ? "" : text;
    }
}
