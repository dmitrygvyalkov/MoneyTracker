package guru.vdg.moneytracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Boolean nameCharEmpty = true;
    private Boolean sumCharEmpty = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        String title = getString(R.string.new_title);
        setTitle(title);

        final EditText editTextName = findViewById(R.id.name);
        final EditText editTextSum = findViewById(R.id.sum);
        final ImageButton btnAdd = findViewById(R.id.add);

        btnAdd.setEnabled(false);

        editTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                nameCharEmpty = TextUtils.isEmpty(charSequence);
                btnAdd.setEnabled(!nameCharEmpty && !sumCharEmpty);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editTextSum.addTextChangedListener(new TextWatcher() {
            private Boolean changed = false;
            private CharSequence sum;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                changed = !changed;
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sumCharEmpty = TextUtils.isEmpty(charSequence);
                btnAdd.setEnabled(!nameCharEmpty && !sumCharEmpty);

                if (changed) {
                    if (charSequence.length() < 3) {
                        sum = charSequence;
                    } else {
                        sum = charSequence.subSequence(0, charSequence.length()-2);
                    }
                    editTextSum.setText(sum + " " + getString(R.string.ruble));
                    editTextSum.setSelection(sum.length());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
