package com.github.FlorianSteenbuck.other.settings.typ;

import com.github.FlorianSteenbuck.other.settings.model.settings.interfaces.Settings;

public enum SettingsTyp {
    EMBED_SETTINGS(new SettingsOutput(Settings.class)),
    SWITCH_SETTINGS(new SettingsOutput(Settings.class)),
    MULTI_SETTINGS(new SettingsOutput(Settings.class, SettingsOutput.Typ.LIST)),
    TEXT_LINE(new SettingsOutput(String.class)),
    TEXT_AREA(new SettingsOutput(String.class)),
    INPUT_NUMBER(new SettingsOutput(Number.class)),
    INPUT_INT(new SettingsOutput(Integer.class)),
    INPUT_DOUBLE(new SettingsOutput(Double.class)),
    GROUP_DOUBLE(new SettingsOutput(Double.class, SettingsOutput.Typ.LIST)),
    GROUP_INT(new SettingsOutput(Integer.class, SettingsOutput.Typ.LIST)),
    SELECT(new SettingsOutput(String.class), new SettingsOutput(Integer.class)),
    CHECKBOXES(new SettingsOutput(Boolean.class, SettingsOutput.Typ.LIST), new SettingsOutput(String.class, SettingsOutput.Typ.LIST), new SettingsOutput(Integer.class, SettingsOutput.Typ.LIST)),
    LIST(new SettingsOutput(String.class, SettingsOutput.Typ.LIST)),
    CHECKBOX(new SettingsOutput(Boolean.class));

    SettingsOutput[] validOutputs = new SettingsOutput[0];

    SettingsTyp(SettingsOutput...validOutputs) {
        if (validOutputs == null || validOutputs.length <= 0) {
            return;
        }
        this.validOutputs = validOutputs;
    }

    public SettingsOutput[] getValidOutputs() {
        return validOutputs;
    }
}
