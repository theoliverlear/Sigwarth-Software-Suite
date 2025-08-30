package com.sigwarthsoftware.changelog.version.models.module.type;

import com.sigwarthsoftware.changelog.version.models.config.ConfigFileType;
import com.sigwarthsoftware.changelog.version.models.dependency.type.PomDependency;
import com.sigwarthsoftware.changelog.version.models.module.ModuleLibrary;
import com.sigwarthsoftware.changelog.version.models.module.ProgramModule;
import com.sigwarthsoftware.changelog.version.models.module.ProgramModuleDescendent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.nio.file.Path;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
public class Pom extends ProgramModuleDescendent {
    private PomDependency moduleDependency;
    public Pom(ModuleLibrary moduleType,
               Path modulePath,
               ConfigFileType configFileType,
               PomDependency moduleDependency) {
        super(moduleType, modulePath, configFileType);
        this.moduleDependency = moduleDependency;
    }
    public Pom(ModuleLibrary moduleType,
               Path modulePath,
               ConfigFileType configFileType,
               PomDependency moduleDependency,
               ProgramModule parent,
               ProgramModule child) {
        super(moduleType, modulePath, configFileType, parent, child);
        this.moduleDependency = moduleDependency;
    }
}
