package com.example.sivmeimei_homework;

import android.content.Context;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.sivmeimei_homework.databinding.FragmentRegisterBinding;

import org.jspecify.annotations.Nullable;

public class RegisterFragment extends Fragment {
    FragmentRegisterBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);

        binding.rootLayout.setOnClickListener(view -> {
            hideKeyboard();
        });

        // Handle register btn click event
        binding.btnRegister.setOnClickListener(view -> {
            hideKeyboard();
            var message = "";

            message += "Email: " + binding.etEmail.getText().toString();
            message += ", Username: " + binding.etUsername.getText().toString();
            message += ", Password: " + binding.etPassword.getText().toString();

            Toast.makeText(requireContext().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        });

        // Handle google btn click event
        binding.btnGoogle.setOnClickListener(view -> {
            Toast.makeText(requireContext().getApplicationContext(), "Register with Google", Toast.LENGTH_SHORT).show();
        });

        // Handle facebook btn click event
        binding.btnFacebook.setOnClickListener(view -> {
            Toast.makeText(requireContext().getApplicationContext(), "Register with Facebook", Toast.LENGTH_SHORT).show();
        });

        // Handle GitHub btn click event
        binding.btnGithub.setOnClickListener(view -> {
            Toast.makeText(requireContext().getApplicationContext(), "Register with Github", Toast.LENGTH_SHORT).show();
        });

        Button btn = binding.btnLogin;
        String text = getString(R.string.already_have_account);

        SpannableString spannableString = new SpannableString(text);
        int primaryColor = ContextCompat.getColor(requireContext().getApplicationContext(), R.color.primary);
        spannableString.setSpan(new ForegroundColorSpan(primaryColor), 25, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        btn.setText(spannableString);

        // Handle login btn click event
        btn.setOnClickListener(view -> {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_register_to_login);
        });

        addTextInputListener();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            // WindowInsetsCompat.Type.ime() will make everything scrollable even when keyboard is open
            // scrollable that the last element will be above keyboard
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.ime());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void validateRegisterBtn() {
        if(binding.etEmail.getText().toString().isEmpty() ||
            binding.etUsername.getText().toString().isEmpty() ||
            binding.etPassword.getText().toString().isEmpty() ||
            binding.etConfirmPassword.getText().toString().isEmpty()) {
            binding.btnRegister.setEnabled(false);
        } else {
            binding.btnRegister.setEnabled(true);
        }

        // Validate password and confirm password, must match
        if (binding.etPassword.getText().toString().equals(binding.etConfirmPassword.getText().toString())) {
            binding.etConfirmPasswordLayout.setError(null);
        } else {
            binding.etConfirmPasswordLayout.setError("Password does not match.");
        }
    }

    private void addTextInputListener() {
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateRegisterBtn();
            }
        };

        binding.etEmail.addTextChangedListener(textWatcher);
        binding.etUsername.addTextChangedListener(textWatcher);
        binding.etPassword.addTextChangedListener(textWatcher);
        binding.etConfirmPassword.addTextChangedListener(textWatcher);
    }

    private void hideKeyboard() {
        // Find the currently focused view, so we can grab the correct window token from it.
        View view = requireActivity().getCurrentFocus();

        // If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = getView();
        }

        InputMethodManager imm = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}