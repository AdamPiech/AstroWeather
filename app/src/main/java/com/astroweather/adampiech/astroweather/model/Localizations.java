package com.astroweather.adampiech.astroweather.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Localizations implements Serializable {

    private List<Localization> localizations = null;

    public Localizations() {
        this.localizations = new ArrayList<>();
    }

    public Localizations(List<Localization> localizations) {
        this.localizations = localizations;
    }

    public void addLocalization(Localization localization) {
        if (localizations == null) {
            localizations = new ArrayList<>();
        }
        localizations.add(localization);
    }

    public List<Localization> getLocalizations() {
        return localizations;
    }

    public void setLocalizations(List<Localization> localizations) {
        this.localizations = localizations;
    }

    public String[] getArray() {
        String[] strings = new String[localizations.size()];
        for (int i = 0; i < localizations.size(); i++) {
            strings[i] = localizations.get(i).toString();
        }
        return strings;
    }

    public boolean isContain(String string) {
        if (string == null || localizations.size() == 0) {
            return false;
        }
        for (String s : getArray()) {
            if (s.equals(string)) {
                return true;
            }
        }
        return false;
    }
}
