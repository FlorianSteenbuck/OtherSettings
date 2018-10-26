package com.github.FlorianSteenbuck.other.settings.model.provider.single;

import com.github.FlorianSteenbuck.other.settings.SettingsOrganisator;
import com.github.FlorianSteenbuck.other.settings.exceptions.WrongSettingsDataException;
import com.github.FlorianSteenbuck.other.settings.model.provider.abstracts.SettingProviderBase;
import com.github.FlorianSteenbuck.other.settings.model.settings.interfaces.Settings;
import com.github.FlorianSteenbuck.other.settings.typ.SettingsTyp;

public class SettingsEmbedProvider extends SettingProviderBase<Settings> {
    public SettingsEmbedProvider(Integer defaultData, SettingsOrganisator organisator) throws WrongSettingsDataException {
        super(organisator.getSettings(defaultData), SettingsTyp.EMBED_SETTINGS);
    }
    public SettingsEmbedProvider(Settings settings) throws WrongSettingsDataException {
        super(settings, SettingsTyp.EMBED_SETTINGS);
    }
}
