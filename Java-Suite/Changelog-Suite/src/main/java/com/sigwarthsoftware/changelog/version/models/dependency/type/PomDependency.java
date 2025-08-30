package com.sigwarthsoftware.changelog.version.models.dependency.type;


import com.sigwarthsoftware.changelog.version.models.dependency.Dependency;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
public class PomDependency extends Dependency {
    private String groupId;
    private String artifactId;
    
    public PomDependency(String name, String version,
                         String groupId, String artifactId) {
        super(name, version);
        this.groupId = groupId;
        this.artifactId = artifactId;
    }
}
