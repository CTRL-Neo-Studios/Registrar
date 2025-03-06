package dev.ctrlneo.registrar.tool;

import dev.ctrlneo.registrar.entry.RegistrarEntry;

import java.util.ArrayList;

public class RegistrationHandler {
    private final ArrayList<RegistrarEntry<?>> entries = new ArrayList<>();
    protected boolean hasRegisteredEntries = false;

    public void register() {
        entries.forEach(RegistrarEntry::get);
        hasRegisteredEntries = true;
    }

    public <T extends RegistrarEntry<?>> void addEntry(T entry) {
        entries.add(entry);
    }

    public ArrayList<RegistrarEntry<?>> getEntries() {
        return entries;
    }

    public boolean hasRegistered() {
        return hasRegisteredEntries;
    }
}
