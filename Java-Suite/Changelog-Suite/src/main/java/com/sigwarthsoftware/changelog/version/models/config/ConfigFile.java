package com.sigwarthsoftware.changelog.version.models.config;

import com.sigwarthsoftware.changelog.version.models.dependency.Dependency;
import lombok.Getter;
import lombok.Setter;

import java.nio.file.Path;

@Getter
@Setter
public class ConfigFile {
    private ConfigFileType type;
    private Path filePath;
    private Dependency dependency;
}
