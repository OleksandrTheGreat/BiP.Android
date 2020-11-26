package com.otg.bip.mvp.login;

import com.otg.bip.data.db.entities.User;
import com.otg.bip.data.repositories.contracts.IUserRepository;
import com.otg.bip.infrastructure.ServiceLocator;

import java.util.UUID;

public class LoginPresenter {

    private IUserRepository _userRepository;
    private ILoginView _view;
    private int _pinLength;
    private User _user;

    public LoginPresenter(ILoginView view, int pinLength) {

        _view = view;
        _pinLength = pinLength;

        _userRepository = ServiceLocator.getInstance().getUserRepositoryInstance();
    }

    public void onInit() {
        _view.showLoginFragment();
    }

    public void onPinEnter(String pinInput) {

        if (!isPinEntered(pinInput)) {
            return;
        }

        int pin = parsePin(pinInput);

        if (isFirstEntrance()) {
            _view.showRegisterUserFragment(pin);
            return;
        }

        if (isCorrectPinEntered(pin)) {
            _view.gotoHomePage(getUser().id);
            return;
        }
    }

    public void onPinReEnter(String pinInput, int enteredPin) {

        if (!isPinEntered(pinInput)) {
            return;
        }

        int reEnteredPin = parsePin(pinInput);

        if (enteredPin == reEnteredPin) {
            registerUser(enteredPin);
            return;
        }
    }

    private void registerUser(int pin) {

        _user = null;

        String id = UUID.randomUUID().toString(); //TODO: consider device UUID
        _userRepository.insert(new User(id, pin));

        _view.gotoHomePage(getUser().id);
    }

    private boolean isPinEntered(String pinInput) {
        return pinInput.length() == _pinLength;
    }

    private int parsePin(String pinInput) {
        return Integer.parseInt(pinInput);
    }

    private boolean isFirstEntrance() {
        return getUser().id.equals(User.TABLE.COLUMNS.ID.NULL_VALUE);
    }

    private boolean isCorrectPinEntered(int pin) {
        return getUser().pin == pin;
    }

    private User getUser() {

        if (_user != null) {
            return _user;
        }

        User[] users = _userRepository.getAll();

        _user = users.length == 0 ? new User(User.TABLE.COLUMNS.ID.NULL_VALUE, User.TABLE.COLUMNS.PIN.NULL_VALUE) : users[0];

        return _user;
    }
}
