package com.sigwarthsoftware.changelog.version.models.module;

import com.sigwarthsoftware.changelog.version.models.config.ConfigFileType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.file.Path;

@Getter
@Setter
@Data
@NoArgsConstructor
public class ProgramModule {
    private ModuleLibrary moduleType;
    private Path modulePath;
    private ConfigFileType configFileType;
    private String name;
    private String version;

    public ProgramModule(ModuleLibrary moduleType,
                         Path modulePath,
                         ConfigFileType configFileType) {
        this.moduleType = moduleType;
        this.modulePath = modulePath;
        this.configFileType = configFileType;
    }
}
