package Main.Panels.Auth;

public interface IBtnEventHandler {
    void switchView();

    void handleSubmit();
    boolean validateInputs();
    void debounceValidateInputs(int time);
}
