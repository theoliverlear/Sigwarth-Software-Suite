package com.sigwarthsoftware.changelog.version.models.element;

import com.sigwarthsoftware.changelog.version.models.module.ModuleLibrary;

public record PomPair(PomElement element, ModuleLibrary module) { }