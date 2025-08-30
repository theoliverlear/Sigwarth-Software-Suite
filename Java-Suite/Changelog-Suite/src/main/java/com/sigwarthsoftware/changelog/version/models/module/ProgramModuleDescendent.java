package com.sigwarthsoftware.changelog.version.models.module;

import com.sigwarthsoftware.changelog.version.models.config.ConfigFileType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.nio.file.Path;

@NoArgsConstructor
@Getter
public class ProgramModuleDescendent extends ProgramModule {
    private ProgramModule parent;
    private ProgramModule child;

    public ProgramModuleDescendent(ModuleLibrary moduleType,
                                   Path modulePath,
                                   ConfigFileType configFileType) {
        super(moduleType, modulePath, configFileType);
        this.parent = null;
        this.child = null;
    }
    
    public ProgramModuleDescendent(ModuleLibrary moduleType,
                                   Path modulePath,
                                   ConfigFileType configFileType,
                                   ProgramModule parent,
                                   ProgramModule child) {
        super(moduleType, modulePath, configFileType);
        this.parent = parent;
        this.child = child;
    }
}
