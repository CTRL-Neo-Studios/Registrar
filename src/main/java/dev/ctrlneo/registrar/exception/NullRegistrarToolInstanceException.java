package dev.ctrlneo.registrar.exception;

public class NullRegistrarToolInstanceException extends RuntimeException {
    public NullRegistrarToolInstanceException() {
        super("RegistrarTool instance is null, please create it via RegistrarTool.create(yourmodid)");
    }
}
