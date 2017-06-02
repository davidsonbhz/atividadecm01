package cm.ufop.br.atividade01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class DadosAluno extends AppCompatActivity {

    public static int ACTIVITY_LIST = 1;
    public static int ACTIVITY_ADD = 2;
    public static int ACTIVITY_CALL = 3;
    public static int ACTIVITY_EDIT = 4;


    private ArrayList<Student> students;
    private int position = 0;
    private int action;
    private Student student;
    private int id, period;
    private double coefficient;
    private String phone, name, course;
    EditText et1, et2, et3, et4, et5, et6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_aluno);

        Intent it = getIntent();
        Bundle params = it.getExtras();
        students = (ArrayList<Student>) params.get("students");
        position = (int) params.get("position");
        action = (int) params.get("action");

        setContentView(R.layout.activity_dados_aluno);

        if(action==ACTIVITY_ADD) {
            student = new Student(id, name, course, period, coefficient, "");
        } else if(action==ACTIVITY_EDIT) {
            student = students.get(position);

        }

        //Fill fields with student's data
        et1 = (EditText) findViewById(R.id.editID);
        et1.setText("" + student.id);
        et2 = (EditText) findViewById(R.id.editNome);
        et2.setText(student.name);
        et3 = (EditText) findViewById(R.id.editCurso);
        et3.setText(student.course);
        et4 = (EditText) findViewById(R.id.editPeriodo);
        et4.setText("" + student.period);
        et5 = (EditText) findViewById(R.id.editCoeficiente);
        et5.setText("" + student.coefficient);
        et6 = (EditText) findViewById(R.id.editPhone);
        et6.setText("" + student.phone);
    }

    public void confirm(View v) {
        if(action==ACTIVITY_ADD) {
            //int id, String name, String course, int period, double coefficient, String phone
            id = Integer.valueOf(et1.getText().toString());
            name = et2.getText().toString();
            course = et3.getText().toString();
            period = Integer.valueOf(et4.getText().toString());
            coefficient= Double.parseDouble(et5.getText().toString());
            phone = et6.getText().toString();


            students.add(student);
            finish();
        }
    }

}
