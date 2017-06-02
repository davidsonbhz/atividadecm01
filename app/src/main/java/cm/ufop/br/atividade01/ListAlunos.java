package cm.ufop.br.atividade01;

import android.Manifest;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListAlunos extends ListActivity {

    private ArrayList<Student> students;
    private int position = 0;
    private int action;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_alunos);

        Intent it = getIntent();
        Bundle params = it.getExtras();
        students = (ArrayList<Student>) params.get("students");
        position = (int) params.get("position");
        action = (int) params.get("action");

        setListAdapter(new StudentAdapter(this, students));

    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Student student = (Student) this.getListAdapter().getItem(position);
        Toast.makeText(this, "Student selected: " + student.name, Toast.LENGTH_SHORT).show();

        if (action == DadosAluno.ACTIVITY_EDIT) {
            //Call StudentEdit activity passing info about the selected student
            Intent it = new Intent(this, DadosAluno.class);
            it.putExtra("students", students);
            it.putExtra("position", position);
            it.putExtra("student", student);
            startActivityForResult(it, DadosAluno.ACTIVITY_EDIT);
        } else if (action == DadosAluno.ACTIVITY_CALL) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE}, 1);

            //Enviar alunos e posicao para activity ALunoCall
            Uri uri = Uri.parse("tel:" + String.valueOf(student.phone));
            Intent it = new Intent(Intent.ACTION_CALL, uri);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(it);
            }



        }
    }

    @Override
    protected  void onActivityResult(int code, int result, Intent it) {
        if(code == DadosAluno.ACTIVITY_ADD) {
            if (it != null) {
                //Receive parameter(s) from called Activity
                students = it.getParcelableArrayListExtra("students");
                //Update list of students
                setListAdapter(new StudentAdapter(this, students));
            }
        }
    }


}
