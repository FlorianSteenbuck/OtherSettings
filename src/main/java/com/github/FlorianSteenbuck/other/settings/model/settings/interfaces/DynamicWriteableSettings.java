package com.github.FlorianSteenbuck.other.settings.model.settings.interfaces;

import java.io.IOException;

public interface DynamicWriteableSettings extends WriteableSettings {
    void refresh() throws IOException;
}
