package dev.ctrlneo.registrar;

import dev.ctrlneo.registrar.tool.RegistrarTool;
import net.fabricmc.api.ModInitializer;

public class Registrar implements ModInitializer {
    public static RegistrarTool REGISTRAR = RegistrarTool.create("registrar");
    @Override
    public void onInitialize() {
        REGISTRAR.register();
    }
}
