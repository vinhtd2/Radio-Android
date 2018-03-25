package org.o7planning.radio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupCharacter;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;

    private RadioGroup radioGroupDiffLevel;
    private RadioButton radioButtonEasy;
    private RadioButton radioButtonMedium;
    private RadioButton radioButtonHard;

    private Button buttonSave;

    private String LOGTAG = "AndroidRadioDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.radioGroupCharacter = (RadioGroup) this.findViewById(R.id.radioGroup_character);
        this.radioButtonMale = (RadioButton) this.findViewById(R.id.radioButton_male);
        this.radioButtonFemale = (RadioButton) this.findViewById(R.id.radioButton_female);

        this.radioGroupDiffLevel = (RadioGroup) this.findViewById(R.id.radioGroup_diffLevel);
        this.radioButtonEasy = (RadioButton) this.findViewById(R.id.radioButton_easy);
        this.radioButtonMedium = (RadioButton) this.findViewById(R.id.radioButton_medium);
        this.radioButtonHard = (RadioButton) this.findViewById(R.id.radioButton_hard);

        this.buttonSave = (Button) this.findViewById(R.id.button_save);

        // Set up when RadioGroup_diffLevel changed
        this.radioGroupDiffLevel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                doOnDifficultyLevelChanged(radioGroup, i);
            }
        });

        // when radio button Male changed
        this.radioButtonMale.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                doOnGameCharacterChanged(compoundButton, b);
            }
        });

        // when radio button Female changed
        this.radioButtonFemale.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                doOnGameCharacterChanged(compoundButton, b);
            }
        });

        // when button Save is clicked
        this.buttonSave.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSave();
            }
        });
    }

    // When radio group "Difficulty level" changed

    private void doOnDifficultyLevelChanged(RadioGroup group, int checkedId) {
        int checkedRadioId = group.getCheckedRadioButtonId();

        if(checkedRadioId == R.id.radioButton_easy) {
            Toast.makeText(this, "You choose the level of difficulty: Easy", Toast.LENGTH_SHORT).show();
        } else if(checkedRadioId == R.id.radioButton_medium) {
            Toast.makeText(this, "You choose the level of difficulty: Medium", Toast.LENGTH_SHORT).show();
        } else if(checkedRadioId == R.id.radioButton_hard) {
            Toast.makeText(this, "You choose the level of difficulty: Hard", Toast.LENGTH_SHORT).show();
        }
    }

    // When radio button changed
    private void doOnGameCharacterChanged(CompoundButton buttonView, boolean isChecked) {
        RadioButton radio = (RadioButton) buttonView;

        Log.i(LOGTAG, "RadioButton" + radio.getText() + ":" + isChecked);
    }

    // When button "Save" is clicked
    private void doSave() {
        int difficultyLevel = this.radioGroupDiffLevel.getCheckedRadioButtonId();
        int gameCharacter = this.radioGroupCharacter.getCheckedRadioButtonId();

        RadioButton radioButtonDiffLevel = (RadioButton) this.findViewById(difficultyLevel);
        RadioButton radioButtonGameCharacter = (RadioButton) this.findViewById(gameCharacter);

        String message = "Difficulty Level" + radioButtonDiffLevel.getText() + ", Game Character: " + radioButtonGameCharacter.getText();

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}