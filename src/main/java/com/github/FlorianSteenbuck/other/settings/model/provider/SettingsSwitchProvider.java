package com.github.FlorianSteenbuck.other.settings.model.provider;

import com.github.FlorianSteenbuck.other.settings.SettingsOrganisator;
import com.github.FlorianSteenbuck.other.settings.exceptions.WrongSettingsDataException;
import com.github.FlorianSteenbuck.other.settings.model.provider.abstracts.SettingsProviderWithValidValues;
import com.github.FlorianSteenbuck.other.settings.model.settings.interfaces.Settings;
import com.github.FlorianSteenbuck.other.settings.typ.SettingsTyp;

import java.util.Collection;
import java.util.LinkedList;

public class SettingsSwitchProvider extends SettingsProviderWithValidValues<Settings> {
    protected SettingsOrganisator organisator = null;

    public SettingsSwitchProvider(int defaultData, SettingsOrganisator organisator) throws WrongSettingsDataException {
        this(organisator.getSettings(defaultData), organisator);
    }

    public SettingsSwitchProvider(Settings defaultData, SettingsOrganisator organisator) throws WrongSettingsDataException {
        this(defaultData, new LinkedList<Settings>());
        this.organisator = organisator;
    }

    public SettingsSwitchProvider(Settings defaultData, Collection<Settings> validValues) throws WrongSettingsDataException {
        super(defaultData, validValues, SettingsTyp.SWITCH_SETTINGS);
    }

    @Override
    public boolean valid(Object data) {
        Settings settData = (Settings) data;
        if (organisator == null) {
            return super.valid(data);
        }

        try {
            return organisator.getSettings();
        }
    }
}
