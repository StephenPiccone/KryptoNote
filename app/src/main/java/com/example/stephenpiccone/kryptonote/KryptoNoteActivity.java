package com.example.stephenpiccone.kryptonote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;

public class KryptoNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kryptonote_layout);
    }

    public void onEncrypt(View v)
    {
        try
        {
            EditText key = (EditText) findViewById(R.id.key);
            String k = key.getText().toString();
            EditText file = (EditText) findViewById(R.id.data);
            String d = file.getText().toString();

            KryptoNoteModel myModel = new KryptoNoteModel(k,d);
            String encrypt = myModel.encrypt();

            ((TextView) findViewById(R.id.data)).setText(encrypt);
        }
        catch(Exception e)
        {
            Toast label = Toast.makeText(this, e.getMessage(),Toast.LENGTH_SHORT);
            label.show();
        }
    }
    public void onDecrypt(View v)
    {
        try
        {
            EditText key = (EditText) findViewById(R.id.key);
            String k = key.getText().toString();
            EditText file = (EditText) findViewById(R.id.data);
            String d = file.getText().toString();

            KryptoNoteModel myModel = new KryptoNoteModel(k,d);
            String decrypt = myModel.decrypt();

            ((TextView) findViewById(R.id.data)).setText(decrypt);
        }
        catch(Exception e)
        {
            Toast label = Toast.makeText(this, e.getMessage(),Toast.LENGTH_SHORT);
            label.show();
        }
    }
    public void onSave(View v)
    {
        try
        {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileWriter fw = new FileWriter(file);
            fw.write(((EditText) findViewById(R.id.data)).getText().toString());
            fw.close();
            Toast label = Toast.makeText(this, "Note Saved.", Toast.LENGTH_LONG);
            label.show();
        }
        catch(Exception e)
        {
            Toast label = Toast.makeText(this, e.getMessage(),Toast.LENGTH_LONG);
            label.show();
        }
    }
    public void onLoad(View v)
    {
        try
        {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileReader fr = new FileReader(file);
            String show = "";
            for (int c = fr.read(); c != -1; c = fr.read()) {
                show += (char) c;
            }
            fr.close();
            ((EditText) findViewById(R.id.data)).setText(show);
            Toast label = Toast.makeText(this, "Note Loaded.", Toast.LENGTH_LONG);
            label.show();
        }
        catch(Exception e)
        {
            Toast label = Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG);
            label.show();
        }
    }
}
