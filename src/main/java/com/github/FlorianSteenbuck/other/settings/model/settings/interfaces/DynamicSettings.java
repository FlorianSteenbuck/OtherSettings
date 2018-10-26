package com.github.FlorianSteenbuck.other.settings.model.settings.interfaces;

import java.io.IOException;

public interface DynamicSettings extends Settings {
    void refresh() throws IOException;
}
