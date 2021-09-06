package mm.com.fairway.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    EditText mInput;
    TextView mOutput;
    Dictionary mDic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         try {
             InputStream in = getAssets().open("Ornagai.tsv");
            mDic = new Dictionary(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_main);
    }
    public void search(View v) {
        mInput = findViewById(R.id.editText1);
        mOutput = findViewById(R.id.textView1);
        String keyword = mInput.getText().toString();
        String result = Dictionary.search(keyword);
        mOutput.setText(result);
    }
}