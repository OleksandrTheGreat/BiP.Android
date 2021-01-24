package com.otg.bip.mvp.login;

import com.otg.bip.data.db.entities.User;
import com.otg.bip.data.repositories.contracts.IUserRepository;
import com.otg.bip.infrastructure.Security;
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

    public void onPinEnter(String pin) {

        if (!isPinEntered(pin)) {
            return;
        }

        if (isFirstEntrance()) {
            _view.showRegisterUserFragment(pin);
            return;
        }

        if (isCorrectPinEntered(pin)) {
            _view.gotoHomePage(getUser().id);
            return;
        }
    }

    public void onPinReEnter(String pinInput, String enteredPin) {

        if (!isPinEntered(pinInput)) {
            return;
        }

        if (enteredPin.equals(pinInput)) {
            registerUser(enteredPin);
            return;
        }
    }

    private void registerUser(String pin) {

        _user = null;

        String id = UUID.randomUUID().toString(); //TODO: consider device UUID
        _userRepository.insert(new User(id, hashPin(id, pin)));

        _view.gotoHomePage(getUser().id);
    }

    private boolean isPinEntered(String pinInput) {
        return pinInput.length() == _pinLength;
    }

    private boolean isFirstEntrance() {
        return getUser().id.equals(User.TABLE.COLUMNS.ID.NULL_VALUE);
    }

    private boolean isCorrectPinEntered(String pin) {

        User user = getUser();

        return user.pin.equals(hashPin(user.id, pin));
    }

    private User getUser() {

        if (_user != null) {
            return _user;
        }

        User[] users = _userRepository.getAll();

        _user = users.length == 0 ? new User(User.TABLE.COLUMNS.ID.NULL_VALUE, User.TABLE.COLUMNS.PIN.NULL_VALUE) : users[0];

        return _user;
    }

    private static String hashPin(String id, String pin) {
        return Security.md5(id + pin);
    }
}
